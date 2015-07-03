package net.canarymod.config;

import net.canarymod.api.world.World;
import net.canarymod.plugin.Plugin;
import net.visualillusionsent.utils.PropertiesFile;

import java.io.File;
import java.util.HashMap;

/**
 * A caching configuration provider.
 * This class performs file lookup and caching. Use this class to get access to
 * a configuration file.
 *
 * @author Jos Kuijpers
 */
public class Configuration {

    private static HashMap<Plugin, HashMap<String, PropertiesFile>> plugin_cfg_cache = new HashMap<Plugin, HashMap<String, PropertiesFile>>();
    private static ServerConfiguration serverConfig = new ServerConfiguration("config" + File.separatorChar + "server.cfg");
    private static DatabaseConfiguration dbConfig = new DatabaseConfiguration("config" + File.separatorChar + "db.cfg");
    private static HashMap<String, WorldConfiguration> worldConfigs = new HashMap<String, WorldConfiguration>();

    /**
     * Reload all configuration from disk
     */
    public static void reload() {
        serverConfig.reload();
        dbConfig.reload();

        // Reload world configurations
        for (WorldConfiguration wc : worldConfigs.values()) {
            wc.reload();
        }

        // Clear the cache
        plugin_cfg_cache.clear();
    }

    private static PropertiesFile getPluginCachedConfig(Plugin plugin, String filepath) {
        if (!plugin_cfg_cache.containsKey(plugin)) {
            plugin_cfg_cache.put(plugin, new HashMap<String, PropertiesFile>());
        }
        if (!plugin_cfg_cache.get(plugin).containsKey(filepath)) {
            PropertiesFile file = new PropertiesFile(filepath);
            file.save();

            plugin_cfg_cache.get(plugin).put(filepath, file);
        }
        return plugin_cfg_cache.get(plugin).get(filepath);
    }

    /**
     * Gets the server configuration
     *
     * @return server configuration file
     */
    public static ServerConfiguration getServerConfig() {
        return serverConfig;
    }

    /**
     * Gets the net configuration
     *
     * @return networking configuration file
     */
    public static DatabaseConfiguration getDbConfig() {
        return dbConfig;
    }

    /**
     * Get the world configuration for the specified world
     *
     * @param world
     *         the getFqName of a world
     *
     * @return world configuration
     */
    public static WorldConfiguration getWorldConfig(String world) {
        WorldConfiguration r = worldConfigs.get(world);
        if (r != null) {
            return r;
        }
        String[] split = world.split("_");
        WorldConfiguration config = new WorldConfiguration("config" + File.separatorChar + "worlds" + File.separatorChar + split[0], world);

        worldConfigs.put(world, config);
        return config;
    }

    /**
     * Gets the server-wide configuration of a plugin
     *
     * @param plugin
     *         the {@link Plugin} to get configuration for
     *
     * @return configuration of a {@link Plugin}
     */
    public static PropertiesFile getPluginConfig(Plugin plugin) {
        return Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + plugin.getName() + ".cfg");
    }

    /**
     * Gets the server-wide configuration of a {@link Plugin}
     *
     * @param plugin
     *         the {@link Plugin} to get configuration for
     * @param module
     *         Used to create multiple configurations for a single {@link Plugin}.
     *
     * @return configuration of a {@link Plugin}
     */
    public static PropertiesFile getPluginConfig(Plugin plugin, String module) {
        return Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + plugin.getName() + "." + module + ".cfg");
    }

    /**
     * Gets the world-specific configuration of a {@link Plugin} If there is no world-specific configuration, it will take the server-wide
     * configuration
     *
     * @param plugin
     *         the {@link Plugin} to get configuration for
     * @param world
     *         the world
     *
     * @return configuration of a {@link Plugin}
     */
    public static PropertiesFile getPluginConfig(Plugin plugin, World world) {
        PropertiesFile file = Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + "worlds" + File.separatorChar + world.getFqName() + File.separatorChar + plugin.getName() + ".cfg");

        if (file == null) {
            file = Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + plugin.getName() + ".cfg");
        }
        return file;
    }

    /**
     * Gets the world-specific configuration of a {@link Plugin} If there is no world-specific configuration, it will take the server-wide
     * configuration
     *
     * @param plugin
     *         the {@link Plugin}
     * @param module
     *         Used to create multiple configurations for a single {@link Plugin}.
     * @param world
     *         the world
     *
     * @return configuration of a {@link Plugin}
     */
    public static PropertiesFile getPluginConfig(Plugin plugin, String module, World world) {
        PropertiesFile file = Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + "worlds" + File.separatorChar + world.getFqName() + File.separatorChar + plugin.getName() + "." + module + ".cfg");

        if (file == null) {
            file = Configuration.getPluginCachedConfig(plugin, "config" + File.separatorChar + plugin.getName() + File.separatorChar + plugin.getName() + "." + module + ".cfg");
        }
        return file;
    }

    /**
     * Clears the configuration files of a {@link Plugin} from the cache
     *
     * @param plugin
     *         the {@link Plugin} to remove configuration for
     */
    public static void clearPluginCachedConfigs(Plugin plugin) {
        if (plugin != null && plugin.isDisabled()) { // Make sure the plugin really needs a clean up
            Configuration.plugin_cfg_cache.remove(plugin);
        }
    }

    static boolean hasWorldConfig(String name) {
        return worldConfigs.containsKey(name);
    }
}
