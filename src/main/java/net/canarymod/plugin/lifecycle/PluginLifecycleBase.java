package net.canarymod.plugin.lifecycle;

import net.canarymod.Canary;
import net.canarymod.commandsys.commands.system.PlayerInformation;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginDescriptor;
import net.canarymod.plugin.PluginLifecycle;
import net.canarymod.plugin.PluginState;
import net.canarymod.tasks.ServerTaskManager;

/**
 * Base class for plugin lifecycles
 *
 * @author Pwootage
 */
public abstract class PluginLifecycleBase implements PluginLifecycle {
    protected PluginDescriptor desc;

    public PluginLifecycleBase(PluginDescriptor desc) {
        this.desc = desc;
    }

    /**
     * {@inheritDoc}
     */
    public boolean enable() {
        if (desc.getCurrentState() == PluginState.ENABLED) {
            return true;
        }
        if (desc.getCurrentState() == PluginState.DISABLED) {
            boolean en = desc.getPlugin().enable();
            if (en) {
                desc.setCurrentState(PluginState.ENABLED);
            }
            return en;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean disable() {
        if (desc.getCurrentState() == PluginState.DISABLED) {
            return true;
        }
        if (desc.getCurrentState() == PluginState.ENABLED) {
            desc.getPlugin().disable();
            desc.setCurrentState(PluginState.DISABLED);
            Plugin p = desc.getPlugin();
            Canary.hooks().unregisterPluginListeners(p);
            Canary.commands().unregisterCommands(p);
            Canary.motd().unregisterMOTDListener(p);
            PlayerInformation.removeInfoAdditions(p);
            ServerTaskManager.removeTasks(p);
            return true;
        }
        return false;
    }

    /**
     * Implement this method in order to do actual loading. Be sure to set the plugin object in
     * {@link net.canarymod.plugin.lifecycle.PluginLifecycleBase#desc}
     */
    protected abstract void _load() throws PluginLoadFailedException;

    /**
     * {@inheritDoc}
     */
    public Plugin load() throws PluginLoadFailedException {
        unload();
        _load();
        desc.setCurrentState(PluginState.DISABLED);
        return desc.getPlugin();
    }

    /**
     * Implement this method in order to do specific unloading code
     */
    protected abstract void _unload();

    /**
     * {@inheritDoc}
     */
    public void unload() {
        disable();
        _unload();
        desc.setPlugin(null);
        desc.setCurrentState(PluginState.KNOWN);
    }
}
