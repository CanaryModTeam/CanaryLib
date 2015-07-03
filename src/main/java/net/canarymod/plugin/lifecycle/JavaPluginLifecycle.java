package net.canarymod.plugin.lifecycle;

import net.canarymod.CanaryClassLoader;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginDescriptor;

import java.io.File;

/**
 * Lifecycle manager for a java plugin
 *
 * @author Pwootage
 */
public class JavaPluginLifecycle extends PluginLifecycleBase {
    private CanaryClassLoader ploader;

    public JavaPluginLifecycle(PluginDescriptor desc) {
        super(desc);
    }

    @Override
    protected void _load() throws PluginLoadFailedException {
        try {
            ploader = new CanaryClassLoader(new File(desc.getPath()).toURI().toURL(), getClass().getClassLoader());
            Class<?> cls = ploader.loadClass(desc.getCanaryInf().getString("main-class"));
            //A hacky way of getting the name in during the constructor/initializer
            Plugin.threadLocalName.set(desc.getName());
            Plugin p = (Plugin)cls.newInstance();
            //If it isn't called in initializer, gotta set it here.
            p.setName(desc.getName());
            p.setPriority(desc.getPriority());
            desc.setPlugin(p);
        }
        catch (Throwable thrown) {
            throw new PluginLoadFailedException("Failed to load plugin", thrown);
        }
    }

    @Override
    protected void _unload() {
        if (ploader != null) {
            ploader.close();
        }
    }
}
