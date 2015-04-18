package net.canarymod.plugin;

import net.canarymod.exceptions.InvalidPluginException;
import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.logger.Logman;

import java.util.Collection;

/**
 * Main interface for the Canary Plugin Manager - responsible for enabling/disabling/loading plugins.
 *
 * @author Pwootage
 */
public interface PluginManager {
    /**
     * Enables the given plugin. Loads the plugin if not loaded (and available)
     *
     * @param name
     *         the name of the {@link net.canarymod.plugin.Plugin}
     *
     * @return {@code true} on success, {@code false} on failure
     *
     * @throws net.canarymod.exceptions.PluginLoadFailedException
     *         If an error occurred when attempting to load the plugin.
     */
    boolean enablePlugin(String name) throws PluginLoadFailedException;

    /**
     * Enables all plugins, after loading worlds and subsystems.
     * Most plugins will be loaded here.
     */
    void enableLatePlugins();

    /**
     * Enables all plugins that require to be loaded before sub systems and worlds.
     * For instance, if they want to replace any of them.
     */
    void enableEarlyPlugins();

    /**
     * Disables the given plugin
     *
     * @param name
     *         the name of the {@link net.canarymod.plugin.Plugin}
     *
     * @return {@code true} on success, {@code false} on failure
     */
    boolean disablePlugin(String name);

    /**
     * Disables all plugins, used when shutting down the server.
     */
    void disableAllPlugins();

    /**
     * Disables all plugins, used when shutting down the server.
     *
     * @param log
     *         The {@link org.apache.logging.log4j.Logger} to use when shutting down. This is
     *         necessary when in the shutdown hook, since we can't rely on external
     *         libraries there (see the javadoc at
     *         {@link Runtime#addShutdownHook(Thread)})
     */
    void disableAllPlugins(Logman log);

    /**
     * Reload the specified plugin
     *
     * @param name
     *
     * @return true on success, false on failure which probably means the plugin is now not enabled nor loaded
     */
    boolean reloadPlugin(String name) throws PluginLoadFailedException, InvalidPluginException;

    /**
     * Get the Plugin with specified name.
     *
     * @param name
     *
     * @return The plugin for the given name, or null on failure.
     */
    Plugin getPlugin(String name);

    /**
     * Gets an unmodifiable collection of currently loaded Plugins
     *
     * @return unmodifiable collection of Plugins
     */
    Collection<Plugin> getPlugins();

    /**
     * Gets an unmodifiable collection of currently known PluginDescriptions
     *
     * @return unmodifiable collection of PluginDescriptions
     */
    Collection<PluginDescriptor> getPluginDescriptors();

    /**
     * Gets the plugin descriptor for a plugin.
     *
     * @param plugin
     *         Plugin to get descriptor for
     *
     * @return Descriptor for plugin
     */
    PluginDescriptor getPluginDescriptor(Plugin plugin);

    /**
     * Gets the plugin descriptor for a plugin by name, loading it if not loaded.
     *
     * @param plugin
     *         Plugin to get descriptor for
     *
     * @return Descriptor for plugin
     */
    PluginDescriptor getPluginDescriptor(String plugin);

    /**
     * Scans the plugin folder for any new plugins. Will ignore any already-known plugins.
     */
    void scanForPlugins();

    /**
     * Gets a list of all currently known plugin names
     *
     * @return List of known plugin names
     */
    Collection<String> getPluginNames();
}
