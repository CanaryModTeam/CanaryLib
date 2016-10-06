package net.canarymod.plugin;

import static net.canarymod.Canary.log;

import com.google.common.collect.Maps;
import net.canarymod.Canary;
import net.canarymod.CanaryClassLoader;
import net.canarymod.plugin.lifecycle.InvalidPluginLifecycleException;
import net.canarymod.plugin.lifecycle.PluginLifecycleFactory;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.UtilityException;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Map;

/**
 * Plugin Language Library Loader
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class PluginLangLoader {
    private static boolean loaded;

    /**
     * Scans pluginlangs folder, loads all valid Plugin Language Libraries and registers with {@link PluginLifecycleFactory}
     */
    public static void load() {
        if (loaded) {
            return;
        }
        loaded = true;

        File pldir = new File("pluginlangs/");
        if (!pldir.exists()) {
            if (!pldir.mkdirs()) {
                Canary.log.debug("Failed to create directory for Plugin Language Libraries");
                return;
            }
        }

        File[] plFiles = pldir.listFiles(new PluginLangFilter());
        if (plFiles != null) { // Make sure there are files
            Map<File, PropertiesFile> knownLangs = Maps.newHashMap();

            for (File plFile : plFiles) {
                log.debug("Loading Plugin Language Library Jar: " + plFile.getName());
                try {
                    PropertiesFile inf = new PropertiesFile(plFile.getAbsolutePath(), "Canary.inf");
                    inf.getString("lib-name", plFile.getName().replace(".jar", ""));
                    inf.getString("lang-name");
                    inf.getString("lifecycle-class");
                    knownLangs.put(plFile, inf);
                }
                catch (UtilityException uex) {
                    log.warn("Could not find or load the Plugin Language Library Canary.inf for jarFile: " + plFile.getName(), uex);
                }
            }

            for (Map.Entry<File, PropertiesFile> lang : knownLangs.entrySet()) {
                log.debug("Initializing Plugin Language Library Jar: " + lang.getValue().getString("lib-name"));
                try {
                    String langName = lang.getValue().getString("lang-name");
                    String lifeCycle = lang.getValue().getString("lifecycle-class");
                    log.debug(langName);

                    CanaryClassLoader ploader = new CanaryClassLoader(lang.getKey().toURI().toURL(), PluginLangLoader.class.getClassLoader());
                    if (!langName.equals("java")) { // If it can load as a java plugin, skip next part
                        Class<?> lcClass = ploader.loadClass(lifeCycle);
                        PluginLifecycle lcycle = (PluginLifecycle)lcClass.getConstructor(PluginDescriptor.class).newInstance(new PluginDescriptor());
                        PluginLifecycleFactory.registerLifecycle(langName, lcycle.getClass()); // Need an actual class reference
                    }
                    log.debug("Success!");
                }
                catch (UtilityException uex) {
                    log.error("Could not find Plugin Language Library LifeCycle Class", uex);
                    return;
                }
                catch (ClassNotFoundException cnfex) {
                    log.error("Could not find Plugin Language Library LifeCycle Class", cnfex);
                }
                catch (NoClassDefFoundError ncdferr) {
                    log.error("Could not initialize Plugin Language Library LifeCycle Class", ncdferr);
                }
                catch (IllegalAccessException iaex) {
                    log.error("Could not create database", iaex);
                }
                catch (InvalidPluginLifecycleException iplex) {
                    log.error(iplex.getMessage(), iplex);
                }
                catch (SecurityException sex) {
                    log.error(sex.getMessage(), sex);
                }
                catch (InstantiationException iex) {
                    log.error(iex.getMessage(), iex);
                }
                catch (MalformedURLException murlex) {
                    log.error(murlex.getMessage(), murlex);
                }
                catch (NoSuchMethodException nsmex) {
                    log.error(nsmex.getMessage(), nsmex);
                }
                catch (InvocationTargetException itex) {
                    log.error(itex.getMessage(), itex);
                }
            }
        }
    }

    private static class PluginLangFilter implements FileFilter {

        @Override
        public boolean accept(File file) {
            return file.getName().endsWith(".jar");
        }
    }
}
