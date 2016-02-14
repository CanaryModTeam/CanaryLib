package net.canarymod.hook;

import net.canarymod.plugin.Plugin;
import net.canarymod.plugin.PluginListener;
import net.canarymod.plugin.Priority;

/**
 * This class invokes a method on a listener.
 * It is inline-implemented in {@link HookExecutor#registerHook(PluginListener, Plugin, Class, Dispatcher, Priority)},
 * for each hook separately.
 *
 * @author Chris (damagefilter)
 */
public abstract class Dispatcher {
    public boolean ignoreCanceled;

    public abstract void execute(PluginListener listener, Hook hook);
}
