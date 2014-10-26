package net.canarymod.plugin.lifecycle;

import net.canarymod.CanaryClassLoader;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.plugin.IPluginManager;
import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginDescriptor;
import net.canarymod.plugin.impl.ClojurePlugin;
import net.canarymod.plugin.impl.LuaPlugin;

import java.io.File;

/**
 * Lifecycle manager for a clojure plugin
 *
 * @author DanThiffault
 */
public class ClojurePluginLifecycle extends PluginLifecycleBase {
    private CanaryClassLoader cl;

    public ClojurePluginLifecycle(PluginDescriptor desc) {
        super(desc);
    }

    @Override
    protected void _load(IPluginManager manager) throws PluginLoadFailedException {
        try {
            cl = new CanaryClassLoader(new File(desc.getPath()).toURI().toURL(), getClass().getClassLoader());
            //A hacky way of getting the name in during the constructor/initializer
            Plugin.threadLocalName.set(desc.getName());
            Plugin p = new ClojurePlugin(desc, cl);
            //If it isn't called in initializer, gotta set it here.
            p.setName(desc.getName());
            p.setPriority(desc.getPriority());
            desc.setPlugin(p);
        } catch (Exception e) {
            throw new PluginLoadFailedException("Failed to load plugin", e);
        }
    }

    @Override
    protected void _unload(IPluginManager manager) {
        if (cl != null) {
            cl.close();
        }
    }

}
