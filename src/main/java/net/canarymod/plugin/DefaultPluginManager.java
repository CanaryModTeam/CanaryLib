package net.canarymod.plugin;

import net.canarymod.Canary;
import net.canarymod.config.Configuration;
import net.canarymod.exceptions.InvalidPluginException;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.hook.system.PluginDisableHook;
import net.canarymod.hook.system.PluginEnableHook;
import net.canarymod.logger.Logman;
import net.canarymod.plugin.dependencies.DependencyGraph;
import net.visualillusionsent.utils.PropertiesFile;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.canarymod.Canary.log;

/**
 * {@inheritDoc}
 *
 * @author Jason (darkdiplomat)
 * @author Chris (damagefilter)
 * @author Jos
 * @author Pwootage
 */
public final class DefaultPluginManager implements PluginManager {
    private static final Object lock = new Object();
    private final Map<String, PluginDescriptor> plugins; // This is keyed to set Plugin name
    private final DependencyGraph dependencies;
    private final PropertiesFile pluginPriorities;

    public DefaultPluginManager() {
        plugins = new LinkedHashMap<String, PluginDescriptor>();
        dependencies = new DependencyGraph();
        this.pluginPriorities = new PropertiesFile("config" + File.separator + "plugin_priorities.cfg");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean enablePlugin(String name) throws PluginLoadFailedException {
        PluginDescriptor descriptor = getPluginDescriptor(name);
        if (descriptor == null) {
            return false;
        }
        if (descriptor.getCurrentState() == PluginState.ENABLED) {
            return true;
        }
        Set<String> deps = dependencies.getDependencies(descriptor.getName());
        for (String s : deps) {
            PluginDescriptor dep = getPluginDescriptor(s);
            if (dep == null) {
                log.warn("Dependency " + s + " of " + descriptor.getName() + " is unsatisfied; cannot enable.");
                return false;
            }
            if (dep.getCurrentState() == PluginState.ENABLED) {
                continue;
            }
            if (!enablePlugin(s)) {
                log.warn("Dependency " + s + " of " + descriptor.getName() + " cannot be enabled; cannot enable.");
                return false;
            }
        }
        if (descriptor.getCurrentState() == PluginState.KNOWN) {
            descriptor.getPluginLifecycle().load();
        }
        log.info("Enabling plugin " + name);
        boolean enabled = descriptor.getPluginLifecycle().enable();
        if (!enabled) {
            log.warn("Unable to enable plugin " + descriptor.getName() + ". Will disable it.");
            disablePlugin(name);
            return false;
        }
        Canary.hooks().callHook(new PluginEnableHook(descriptor.getPlugin()));
        Set<String> rdeps = dependencies.getDependants(descriptor.getName());
        for (String s : rdeps) {
            PluginDescriptor dep = getPluginDescriptor(s);
            if (dep == null) {
                //Don't really care... although, shouldn't be possible
                continue;
            }
            if (dep.getCurrentState() == PluginState.ENABLED) {
                continue;
            }
            if (!enablePlugin(s)) {
                log.warn(s + " (dependent on " + descriptor.getName() + ") could not be enabled");
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enableLatePlugins() {
        synchronized (lock) {
            for (String plugin : plugins.keySet()) {
                PluginDescriptor descriptor = plugins.get(plugin);
                if (!descriptor.enableEarly()) {
                    try {
                        if (!enablePlugin(plugin)) {
                            log.error("Failed to enable plugin: " + plugin);
                        }
                    }
                    catch (Exception e) {
                        log.error("Exception while enabling plugin: " + plugin, e);
                    }
                }
            }
        }
    }

    @Override
    public void enableEarlyPlugins() {
        synchronized (lock) {
            for (String plugin : plugins.keySet()) {
                PluginDescriptor descriptor = plugins.get(plugin);
                if (descriptor.enableEarly()) {
                    try {
                        if (!enablePlugin(plugin)) {
                            log.error("Failed to enable plugin: " + plugin);
                        }
                    }
                    catch (Exception e) {
                        log.error("Exception while enabling plugin: " + plugin, e);
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean disablePlugin(String name) {
        PluginDescriptor descriptor = getPluginDescriptor(name);
        if (descriptor == null) {
            return false;
        }
        if (descriptor.getCurrentState() == PluginState.DISABLED) {
            return true;
        }
        if (descriptor.getCurrentState() == PluginState.KNOWN) {
            return true;
        }
        Set<String> dependants = dependencies.getDependants(descriptor.getName());
        for (String s : dependants) {
            disablePlugin(s);
        }
        log.info("Disabling plugin " + name);
        boolean disabled = descriptor.getPluginLifecycle().disable();
        if (disabled) {
            Canary.hooks().callHook(new PluginDisableHook(descriptor.getPlugin()));
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disableAllPlugins() {
        disableAllPlugins(log);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disableAllPlugins(Logman log) {
        synchronized (lock) {
            for (String plugin : plugins.keySet()) {
                try {
                    if (!disablePlugin(plugin)) {
                        log.error("Failed to disable plugin: " + plugin);
                    }
                }
                catch (Exception e) {
                    log.error("Exception while disabling plugin: " + plugin, e);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean reloadPlugin(String name) throws PluginLoadFailedException, InvalidPluginException {
        PluginDescriptor descriptor = getPluginDescriptor(name);
        if (descriptor != null) {
            disablePlugin(name);
            log.info("Unloading plugin " + name);
            descriptor.getPluginLifecycle().unload();
            descriptor.reloadInf();
            updateDependencies(descriptor);
            //Call enable directly instead of enable() to avoid recursing
            log.info("Loading plugin " + name);
            descriptor.getPluginLifecycle().load();
            log.info("Enabling plugin " + name);
            boolean enabled = descriptor.getPluginLifecycle().enable();
            if (!enabled) {
                log.warn("Failed to enable " + name + " after reloading");
                return false;
            }
            Set<String> rdeps = dependencies.getDependants(descriptor.getName());
            for (String s : rdeps) {
                PluginDescriptor dep = getPluginDescriptor(s);
                if (dep == null) {
                    //Don't really care... although, shouldn't be possible
                    continue;
                }
                if (dep.getCurrentState() == PluginState.KNOWN) {
                    continue;
                }
                if (!reloadPlugin(s)) {
                    log.warn(s + " (dependent on " + descriptor.getName() + ") could not be reloaded...");
                }
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Plugin getPlugin(String name) {
        PluginDescriptor desc = getPluginDescriptor(name);
        if (desc != null) {
            return desc.getPlugin();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Plugin> getPlugins() {
        List<Plugin> res = new ArrayList<Plugin>();
        for (PluginDescriptor desc : getPluginDescriptors()) {
            Plugin p = desc.getPlugin();
            if (p != null) {
                res.add(p);
            }
        }
        return Collections.unmodifiableCollection(res);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> getPluginNames() {
        List<String> res = new ArrayList<String>();
        for (PluginDescriptor desc : getPluginDescriptors()) {
            res.add(desc.getName());
        }
        return Collections.unmodifiableCollection(res);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<PluginDescriptor> getPluginDescriptors() {
        synchronized (lock) {
            //Returns a copy of the collection to avoid concurrentModificationExceptions
            return Collections.unmodifiableCollection(new ArrayList<PluginDescriptor>(plugins.values()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginDescriptor getPluginDescriptor(Plugin plugin) {
        return plugins.get(plugin.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PluginDescriptor getPluginDescriptor(String plugin) {
        PluginDescriptor desc = plugins.get(plugin);
        if (desc == null) {
            //Try to find this plugin (and perhaps others)
            scanForPlugins();
            desc = plugins.get(plugin);
        }
        return desc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void scanForPlugins() {
        File pluginDir = new File("plugins/");
        if (!pluginDir.exists()) {
            log.warn("Failed to scan for plugins. 'plugins/' is not a directory. Creating...");
            pluginDir.mkdir();
            return;
        }
        if (!pluginDir.isDirectory()) {
            log.error("Failed to scan for plugins. 'plugins/' is not a directory but a file...");
            return;
        }
        File[] pluginFiles = pluginDir.listFiles(new PluginFilter());
        int loadedDescriptors = 0;
        for (File pluginFile : pluginFiles) {
            try {
                if (!loadPluginDescriptorAndInsertInGraph(pluginFile)) {
                    continue;
                }
                ++loadedDescriptors;
            }
            catch (InvalidPluginException e) {
                log.warn("Found invalid plugin at " + pluginFile.getName() + ", moving on.", e);
            }
        }
        pluginPriorities.save();
        synchronized (lock) {
            log.info("Found " + loadedDescriptors + " plugins; total: " + plugins.size());
        }
    }

    private boolean loadPluginDescriptorAndInsertInGraph(File pluginFile) throws InvalidPluginException {
        PluginDescriptor desc = new PluginDescriptor(pluginFile.getAbsolutePath());
        if (plugins.containsKey(desc.getName())) {
            return false;
        }
        int priority = pluginPriorities.getInt(desc.getName(), 10);
        if (priority < 0) {
            // Negative priorities should not load at all
            return false;
        }
        desc.setPriority(priority);
        synchronized (lock) {
            plugins.put(desc.getName(), desc);
        }
        updateDependencies(desc);
        return true;
    }

    private void updateDependencies(PluginDescriptor desc) {
        dependencies.removeNode(desc.getName());
        dependencies.addDependencies(desc.getName(), desc.getDependencies());
    }

    /**
     * Plugin Filtering
     * So we don't attempt to load garbage
     *
     * @author Jason (darkdiplomat)
     */
    private final class PluginFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            /*     Directory and Plugin Dev Mode Enabled? ACCEPTED                                             Jar/Zip? ACCEPTED */
            return (pathname.isDirectory() && Configuration.getServerConfig().getPluginDevModeEnabled()) || pathname.getName().matches(".+\\.(jar|zip)");
            // All others REJECTED (It's like getting into haven here)
        }
    }
}
