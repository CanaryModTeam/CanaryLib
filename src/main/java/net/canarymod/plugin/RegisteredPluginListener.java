package net.canarymod.plugin;

import net.canarymod.hook.CancelableHook;
import net.canarymod.hook.Dispatcher;
import net.canarymod.hook.Hook;

/**
 * Container for registered plugin listeners
 *
 * @author Chris (damagefilter)
 */
public class RegisteredPluginListener {
    private PluginListener listener;
    private Plugin plugin;
    private Priority methodPriority;
    private int basePriority;
    private Dispatcher executor;

    public RegisteredPluginListener(PluginListener l, Plugin plugin, Dispatcher executor, Priority priority) {
        this.listener = l;
        this.plugin = plugin;
        this.basePriority = plugin.getPriority();
        this.executor = executor;
        methodPriority = priority;
    }

    public PluginListener getListener() {
        return listener;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public int getPluginPriority() {
        return basePriority;
    }

    /**
     * Execute the event on the listener registered
     *
     * @param hook The {@link Hook} to execute
     */
    public void execute(Hook hook) {
        if (hook instanceof CancelableHook) {
            if (((CancelableHook)hook).isCanceled()) {
                if (!executor.ignoreCanceled) {
                    return;
                }
            }
        }
        executor.execute(listener, hook);
    }

    public Priority getMethodPriority() {
        return methodPriority;
    }
}
