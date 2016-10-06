package net.canarymod.plugin;

import net.canarymod.exceptions.PluginLoadFailedException;

/**
 * Defines lifecycle methods for a plugin - load, enable, disable. Implemented by individual {@link PluginManager}s
 *
 * @author Pwootage
 */
public interface PluginLifecycle {
    /**
     * Enables the plugin.
     *
     * @return {@code true} if successfully enabled, {@code false} otherwise.
     */
    boolean enable();

    /**
     * Disables the plugin.
     *
     * @return {@code true} if successfully disabled, {@code false} otherwise.
     */
    boolean disable();

    /**
     * Loads the {@link Plugin}.
     *
     * @return Newly loaded plugin.
     *
     * @throws PluginLoadFailedException
     *         If an error occurred loading the plugin.
     */
    Plugin load() throws PluginLoadFailedException;

    /**
     * Unloads the plugin.
     */
    void unload();
}
