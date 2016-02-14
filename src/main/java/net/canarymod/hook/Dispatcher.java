package net.canarymod.hook;

import net.canarymod.plugin.PluginListener;

/**
 * This class invokes a method on a listener.
 * It is inline-implemented in HookExecutor.registerHook, for each hook separately
 *
 * @author Chris (damagefilter)
 */
public abstract class Dispatcher {
    public boolean ignoreCanceled;

    public abstract void execute(PluginListener listener, Hook hook);
}
