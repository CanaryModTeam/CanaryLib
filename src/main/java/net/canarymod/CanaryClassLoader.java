package net.canarymod;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.jar.JarFile;

/**
 * Canary Class Loader
 * <p/>
 * Used to load and manage plugin jars/classes
 *
 * @author Jason (darkdiplomat)
 */
public final class CanaryClassLoader extends URLClassLoader {
    private final static CanaryClassWatcher ccw = new CanaryClassWatcher();

    /**
     * Constructs a new CanaryClassLoader
     *
     * @param url
     *         the {@link URL} to the jar file to be opened in this loader
     * @param loader
     *         the {@link ClassLoader} parent
     */
    public CanaryClassLoader(URL url, ClassLoader loader) {
        super(new URL[]{ url }, loader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class<?> findClass(String name) throws ClassNotFoundException {
        ClassNotFoundException rethrow = null;
        Class<?> toRet = null;

        try {
            toRet = super.findClass(name); // Look for the class normally
        }
        catch (ClassNotFoundException cnfex) {
            rethrow = cnfex; // And fail
        }
        catch (LinkageError lerr) {
            toRet = null; // And fail ignored
        }
        if (toRet != null) {
            ccw.addClass(this, toRet); //
            return toRet;
        }
        else {
            toRet = ccw.findLoadedClass(this, name);
            if (toRet != null) {
                return toRet;
            }
            else {
                rethrow = new ClassNotFoundException("The class " + name + " could not be found!", rethrow);
            }
        }
        throw rethrow;
    }

    /**
     * Closes the loader and jar file
     */
    public synchronized final void close() {
        if (System.getProperty("java.version").startsWith("1.6")) { // Java 6 doesn't have the URLClassLoader.close() method
            try { // Insert Reflection Magic
                Class<?> clazz = URLClassLoader.class;
                Field ucpField = clazz.getDeclaredField("ucp"); // get field for sun.misc.URLClassPath
                ucpField.setAccessible(true); // Allow access
                Object ucp = ucpField.get(this); // get URLClassPath instance
                Field loadersField = ucp.getClass().getDeclaredField("loaders"); // get the loaders collection
                loadersField.setAccessible(true); // Allow access
                Object loaders = loadersField.get(ucp); // get loaders
                for (Object jarLoader : ((Collection<?>)loaders)) { // iterate the loaders
                    try {
                        Field jarField = jarLoader.getClass().getDeclaredField("jar"); // Get the jarField
                        jarField.setAccessible(true); // Allow access
                        Object jarFile = jarField.get(jarLoader); // get the JarFile
                        ((JarFile)jarFile).close(); // Close jar
                    }
                    catch (Throwable t) {
                        // Not a loader, ignored...
                    }
                }
            }
            catch (Throwable t) {
                // probably not a SUN/Oracle VM
            }
        }
        else { // If running on Java 7 or above, call URLClassLoader.close(). Since we should be compiling with Java 6, lower versions shouldn't be a worry
            try {
                // We have to invoke the method since we compile with Java 6 (or should be)
                URLClassLoader.class.getDeclaredMethod("close").invoke(this);
            }
            catch (Exception ex) {
                // Probably IOException, ignore it.
            }
        }
        ccw.removeLoader(this); // And finally remove url and classes from the jar
    }
}
