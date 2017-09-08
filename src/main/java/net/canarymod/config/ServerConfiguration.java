package net.canarymod.config;

import net.visualillusionsent.utils.BooleanUtils;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.logging.log4j.Level;

import java.io.File;

import static net.canarymod.Canary.log;

/**
 * Server Configuration Container
 *
 * @author Jos Kuijpers
 * @author Jason (darkdiplomat)
 */
public class ServerConfiguration implements ConfigurationContainer {
    private final PropertiesFile cfg;
    private final PropertiesFile servCfg; // Panel support
    private final boolean panelSupport = BooleanUtils.parseBoolean(System.getProperty("panel.support", "off"));

    public ServerConfiguration(String path) {
        File test = new File(path);

        if (!test.exists()) {
            log.info("Could not find the server configuration at " + path + ", creating default.");
        }
        this.cfg = new PropertiesFile("config" + File.separatorChar + "server.cfg");

        // For control panels still tweaking the server.properties file only...
        PropertiesFile servCfgTemp = null;
        if (panelSupport) {
            // Only initialize the file if we need to read from it
            servCfgTemp = new PropertiesFile("server.properties");
        }
        servCfg = servCfgTemp;
        //

        verifyConfig();
    }

    /**
     * Reloads the configuration file
     */
    @Override
    public void reload() {
        cfg.reload();
        verifyConfig();
    }

    /**
     * Get the configuration file
     */
    @Override
    public PropertiesFile getFile() {
        return cfg;
    }

    /**
     * Creates the default configuration
     */
    private void verifyConfig() {
        cfg.getBoolean("announce-player-achievements", true);
        cfg.setComments("announce-player-achievements", "Sets whether to inform all of a Player's Achievement");
        cfg.getBoolean("allow-enchantment-stacking", false);
        cfg.setComments("allow-enchantment-stacking", "Sets whether to allow items with enchantments to stack with non-enchanted items");
        cfg.getString("ban-default-message", "You are banned from this server.");
        cfg.setComments("ban-default-message", "The default message to use for user bans");
        cfg.getString("ban-expiration-date-message", "Your Ban will be lifted at ");
        cfg.setComments("ban-expiration-date-message", "The message to prefix to the timestamp of a tempban expiration");
        cfg.getString("chat-format", "<%prefix%name&f> %message");
        cfg.setComments("chat-format", "Valid default placeholders are:",
                        "%prefix (player prefix), %name (player name), %group (main group)",
                        "You can use standard color codes at all times. Use & as identifier if you miss a § key",
                        "Plugins may extend the list of available placeholders"
                       );
        cfg.getBoolean("command-block-enabled", false);
        cfg.setComments("command-block-enabled", "Sets whether the Command Block is allowed or not");
        cfg.getString("command-block-group", "admins");
        cfg.setComments("command-block-group", "This groups permissions will determine what Command Block can and can not do!");
        cfg.getBoolean("command-block-op", false);
        cfg.setComments("command-block-op", "Sets whether the Command Block is considered Operator or not (Vanilla command use)");
        cfg.getBoolean("command-block-silent", false);
        cfg.setComments("command-block-silent", "Sets whether the Command Block logs command output (set to true to 'silence' CommandBlocks)");
        cfg.getString("data-source", "xml");
        cfg.setComments("data-source", "The Datasource type to use (Default available: xml, mysql, sqlite");
        cfg.getString("date-format", "yyyy.MM.dd, hh:mm:ss");
        cfg.setComments("date-format", "A formatting to display timestamps");
        cfg.getBoolean("death-messages", true);
        cfg.setComments("death-messages", "Sets whether to send player death message or not");
        //cfg.getBoolean("debug-enabled", false); //REMOVED
        //cfg.setComments("debug-enabled", "Sets whether to enable debug logging or not"); // REMOVED
        if (cfg.containsKey("debug-enabled")) { // Remove old key
            cfg.removeKey("debug-enabled");
        }
        cfg.getString("default-world-name", "default");
        cfg.setComments("default-world-name", "Name of the default loaded world");
        cfg.getInt("default-world-size", 29999984);
        cfg.setComments("default-world-size", "This sets the maximum possible size in blocks, expressed as a radius, that the world border can obtain.");
        cfg.getBoolean("flight-kick", true);
        cfg.setComments("flight-kick", "Enables kicking players who are floating too long.");
        cfg.getInt("flight-detect-ticks", 80);
        cfg.setComments("flight-detect-ticks", "The number of ticks a player may float before triggering flight-kick or flight-alert.");
        //cfg.getBoolean("logging", false); //REMOVED
        if (cfg.containsKey("logging")) { // Remove old key
            cfg.removeKey("logging");
        }
        cfg.getString("logger-level", "INFO");
        cfg.setComments("logger-level", "Sets the level of logging.", "Acceptable Values: OFF FATAL ERROR WARN INFO DEBUG TRACE ALL");

        // RESERVED SPACE
        cfg.getInt("max-players", 20);
        cfg.setComments("max-players", "The maximum allowed players online (Does not count ReserveList users connecting after server is full)");
        cfg.getInt("max-tick-time", 60000);
        cfg.setComments("max-tick-time", "The maximum number of milliseconds a single tick may take before the server watchdog stops the server. Setting to -1 disables WatchDog.");
        cfg.getString("motd", "CanaryMod Minecraft Server");
        cfg.setComments("motd", "The Server list Message of the Day");
        cfg.getInt("network-compression-threshold", 256);
        cfg.setComments("network-compression-threshold", "By default it allows packets that are n-1 bytes big to go normally, but a packet that n bytes or more will be compressed down.");
        cfg.getBoolean("online-mode", true);
        cfg.setComments("online-mode", "Sets whether to authenticate connecting users.",
                        "WARNING: Setting to false is INSECURE and should not be done in a production environment."
                       );
        cfg.getInt("player-idle-timeout", 1);
        cfg.setComments("player-idle-timeout", "Timeout in minutes before kicking an idle player");
        cfg.getBoolean("playerlist-enabled", true);
        cfg.setComments("playerlist-enabled", "Sets whether to send data to clients for the Player List");
        cfg.getBoolean("playerlist-autoupdate", true);
        cfg.setComments("playerlist-autoupdate", "Sets whether the Player List should automatically be refreshed for every player or not");
        cfg.getBoolean("playerlist-usecolors", false);
        cfg.setComments("playerlist-usecolors", "Sets whether the Player List should include colors and player prefixes");
        cfg.getInt("playerlist-ticks", 500);
        cfg.getBoolean("plugin-dev-mode", false);
        cfg.setComments("plugin-dev-mode", "Setting this to true will enable loading plugins from folders; intended for Lua plugin developers");
        // RESERVED SPACE
        cfg.getBoolean("query-enabled", false);
        cfg.setComments("query-enabled", "Enables GameSpy4 protocol server listener. Used to get information about server.");
        cfg.getInt("query-port", 25565);
        cfg.setComments("query-port", "Set the port for the query server");
        cfg.getBoolean("rcon-enabled", false);
        cfg.setComments("rcon-enabled", "Whether to allow remote access or not");
        cfg.getInt("rcon-port", 25575);
        cfg.setComments("rcon-port", "The port you want remote access to listen on (1-65534), DEFAULT: 25575");
        cfg.getString("rcon-password", "");
        cfg.setComments("rcon-password", "Password for remote access");
        cfg.getBoolean("reservelist-enabled", false);
        cfg.setComments("reservelist-enabled", "Sets whether the ReserveList (join after full) is enabled or not");
        cfg.getString("reservelist-message", "Not on reserve list."); //This seems redundant
        cfg.getBoolean("save-homes", true);
        cfg.setComments("save-homes", "Sets whether to save homes or not");
        cfg.getString("server-full-message", "The server is full.");
        cfg.setComments("server-full-message", "Message to send if the server is full");
        cfg.getString("server-ip", "");
        cfg.setComments("server-ip", "Set to the IP address that you want your server to listen on, or leave blank for automatic detection.");
        cfg.getInt("server-port", 25565);
        cfg.setComments("server-port", "The Port you want your server to listen on (1-65534), DEFAULT: 25565");
        cfg.getString("server-locale", "en_US");
        cfg.setComments("server-locale", "Sets the default server language to use for messages. Default supported Languages can be found in the lang/languages.txt");
        cfg.getBoolean("show-unknown-command", true);
        cfg.setComments("show-unknown-command", "Sets whether to inform players of unknown commands");
        cfg.getBoolean("snooper-enabled", true);
        cfg.setComments("snooper-enabled", "Sets whether Mojang may snoop or not");
        cfg.getString("spam-protection", "default");
        cfg.setComments("spam-protection", "Level of protection against Spam. Options: default - on for all but ignorerestiction users; off - no protections; all - on for all");
        cfg.getBoolean("strict-sign-characters", true);
        cfg.setComments("strict-sign-characters", "Sets whether to strictly check characters on signs for invalid chat characters. Set to false to disable (and allow more characters)");
        cfg.getString("texture-pack", "");
        cfg.setComments("texture-pack", "The name of the Server's texture/resource pack");
        cfg.getBoolean("update-lang-files", true);
        cfg.setComments("Whether to verify and update lang files or not, disable if you intend to make changes to those files");
        cfg.getInt("view-distance", 10);
        cfg.setComments("view-distance", "Sets the maximum radius of loaded chunks around a player (3-15)");
        cfg.getBoolean("whitelist-enabled", false);
        cfg.setComments("whitelist-enabled", "Whether the whitelist is enabled or not");
        cfg.getString("whitelist-message", "Not on whitelist.");
        cfg.setComments("whitelist-message", "The message to send to non-whitelisted players");
        cfg.getBoolean("world-cache-timer-enabled", true);
        cfg.setComments("world-cache-timer-enabled", "Enable automatic unloading of unused worlds.");
        cfg.getLong("world-cache-timeout", 60);
        cfg.setComments("world-cache-timeout", "The number of minutes a world should be empty before it will be unloaded (if use-world-cache is enabled)");
        cfg.getBoolean("bungeecord", false);
        cfg.setComments("bungeecord", "If you want to enable Bungeecord support. REQUIRES THAT ONLINE MODE IS DISABLED (false)");
        cfg.getBoolean("verifyUserSessionIP", true);
        cfg.setComments("verifyUserSessionIP", "Enables if the server will do IP verification on connecting users session");
        cfg.save();
    }

    public boolean getAnnounceAchievements() {
        return cfg.getBoolean("announce-player-achievements", true);
    }

    /**
     * Checks if items are allowed to be stack with enchantments applied
     *
     * @return {@code true} if allowed; {@code false} if not
     */
    public boolean allowEnchantmentStacking() {
        return cfg.getBoolean("alllow-enchantment-stacking", false);
    }

    /**
     * Gets the ban default message
     *
     * @return ban default message
     */
    public String getDefaultBannedMessage() {
        return cfg.getString("ban-default-message", "You are banned from this server.");
    }

    /**
     * Gets the ban expiration date message
     *
     * @return ban expiration date message
     */
    public String getBanExpireDateMessage() {
        return cfg.getString("ban-expiration-date-message", "Your ban will be lifted at ");
    }

    /**
     * Gets the chat format placeholder
     *
     * @return chat format
     */
    public String getChatFormat() {
        return cfg.getString("chat-format", "<%prefix%name&f> %message");
    }

    /**
     * Checks if the Command Block is enabled or not
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean isCommandBlockEnabled() {
        return cfg.getBoolean("command-block-enabled", false);
    }

    /**
     * Gets the group name to apply to the Command Block for permissions
     *
     * @return command block group name
     */
    public String getCommandBlockGroupName() {
        return cfg.getString("command-block-group", "admins");
    }

    /**
     * Gets whether the Command Block is considered Operator
     *
     * @return {@code true} if opped; {@code false} otherwise
     */
    public boolean isCommandBlockOpped() {
        return cfg.getBoolean("command-block-op", false);
    }

    /**
     * Gets whether the Command Block is silent
     *
     * @return {@code true} if silent; {@code false} otherwise
     */
    public boolean isCommandBlockSilent() {
        return cfg.getBoolean("command-block-silent", false);
    }

    /**
     * Get datasource type
     *
     * @return datasource type
     */
    public String getDatasourceType() {
        return cfg.getString("data-source", "xml");
    }

    /**
     * Gets the date format to use with timestamps
     *
     * @return timestamp date format
     */
    public String getDateFormat() {
        return cfg.getString("date-format", "yyyy.MM.dd, hh:mm:ss");
    }

    /**
     * Get the default world name defined in the config
     *
     * @return default world name
     */
    public String getDefaultWorldName() {
        return cfg.getString("default-world-name", "default");
    }

    /**
     * Get whether the death message is enabled
     *
     * @return true when enabled; false otherwise
     */
    public boolean isDeathMessageEnabled() {
        return cfg.getBoolean("death-messages", true);
    }

    /**
     * Whether this server is in debug mode.
     * Use debug mode when developing plugins, CanaryLib or CanaryMod.
     *
     * @return {@code true} if debug mode enabled; {@code false} if not
     */
    public boolean isDebugMode() { // Retaining this for quicker DebugMode checking access
        return getLoggerLevel().intLevel() >= 5;
    }

    /**
     * Checks if players will be kicked when floating too long.
     *
     * @return {@code true} if kick enabled; {@code false} if not
     */
    public boolean isFlightKickEnabled() {
        return cfg.getBoolean("flight-kick", true);
    }

    /**
     * Gets the number of ticks a Player is allowed to float before triggering the anti-flying
     *
     * @return the number of ticks
     */
    public int getFlightDetectTicks() {
        return cfg.getInt("flight-detect-ticks", 80);
    }

    /**
     * Gets the Level of message to log
     *
     * @return logger level
     */
    public Level getLoggerLevel() {
        return Level.toLevel(cfg.getString("logger-level", "INFO"), Level.INFO);
    }

    /**
     * Get maximum amount of player allowed online
     *
     * @return max players
     */
    public int getMaxPlayers() {
        if (panelSupport) {
            return servCfg.getInt("max-players", 20);
        }
        return cfg.getInt("max-players", 20);
    }

    /**
     * Get the message of the day, the message shown in the server list.
     *
     * @return A string containing the message
     */
    public String getMotd() {
        return cfg.getString("motd", "Canary Minecraft Server");
    }

    /**
     * Whether the server is in online mode.
     * When a server is in online mode, all players are verificated
     * against the servers of Mojang. This will ensure all players have paid.
     * When allowing unpaid users, the server is vulnerable to griefing and attacks.
     *
     * @return {@code true} if online mode is enabled; {@code false} if not
     */
    public boolean isOnlineMode() {
        if (panelSupport) {
            return servCfg.getBoolean("online-mode", true);
        }
        return cfg.getBoolean("online-mode", true);
    }

    /**
     * Gets the time in minutes before a player is kicked for idling
     *
     * @return player idle timeout
     */
    public int getPlayerIdleTimeout() {
        return cfg.getInt("player-idle-timeout", 1);
    }

    /**
     * Sets the time in minutes before a player is kicked for idling
     *
     * @param timeout
     *         the idle timeout
     */
    public void setPlayerIdleTimeout(int timeout) {
        cfg.setInt("player-idle-timeout", timeout);
    }

    /**
     * Get whether the player list is enabled.
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isPlayerListEnabled() {
        return cfg.getBoolean("playerlist-enabled", true);
    }

    /**
     * Get whether the player list is auto-updated
     *
     * @return true if auto-updated, false otherwise. Default is false.
     */
    public boolean getPlayerlistAutoUpdate() {
        return cfg.getBoolean("playerlist-autoupdate", false);
    }

    /**
     * Get whether playerlist colors are enabled.
     * Note that using colors in the playerlist breaks usage of playername-completion in chat.
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isPlayerlistColorsEnabled() {
        return cfg.getBoolean("playerlist-usecolors", true);
    }

    /**
     * Get the number of ticks between playerlist updates
     *
     * @return playerlist ticks
     */
    public int getPlayerlistTicks() {
        return cfg.getInt("playerlist-ticks", 500);
    }

    /**
     * Get whether server query-ing is enabled
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean isQueryEnabled() {
        if (panelSupport) {
            return servCfg.getBoolean("enable-query", false);
        }
        return cfg.getBoolean("query-enabled", false);
    }

    /**
     * Get the port used for query
     *
     * @return query port
     */
    public int getQueryPort() {
        if (panelSupport) {
            return servCfg.getInt("query.port", 25570);
        }
        return cfg.getInt("query-port", 25565);
    }

    /**
     * Whether Remote Control (RCON) is enabled.
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean isRconEnabled() {
        return cfg.getBoolean("enable-rcon", false);
    }

    /**
     * Get the port used for remote control
     *
     * @return RCON port
     */
    public int getRconPort() {
        return cfg.getInt("rcon-port", 0);
    }

    /**
     * Get the password used for remote control
     *
     * @return RCON password
     */
    public String getRconPassword() {
        return cfg.getString("rcon-password", "");
    }

    /**
     * Get whether the reservelist is enabled
     *
     * @return true when enabled, false otherwise. Default is false.
     */
    public boolean isReservelistEnabled() {
        return cfg.getBoolean("reservelist-enabled", false);
    }

    /**
     * Get the message to be displayed when someone is not on the reserve list.
     *
     * @return A string containing the message.
     */
    public String getReservelistMessage() {
        return cfg.getString("reservelist-message", "Not on reserve list.");
    }

    /**
     * Get whether home-saving is enabled.
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isSaveHomesEnabled() {
        return cfg.getBoolean("save-homes", true);
    }

    /**
     * Gets the message to send to a connecting player when the Server is full
     *
     * @return server full message
     */
    public String getServerFullMessage() {
        return cfg.getString("server-full-message", "The server is full.");
    }

    /**
     * Get the IP address which to server binds to
     *
     * @return server ip
     */
    public String getBindIp() {
        if (panelSupport) {
            return servCfg.getString("server-ip", "");
        }
        return cfg.getString("server-ip", "");
    }

    /**
     * Get the port number used to receive player-connections
     *
     * @return port
     */
    public int getPort() {
        if (panelSupport) {
            return servCfg.getInt("server-port", 25565);
        }
        return cfg.getInt("server-port", 25565);
    }

    /**
     * Gets the server's default locale
     *
     * @return default server locale
     */
    public String getServerLocale() {
        return cfg.getString("server-locale", "en_US");
    }

    /**
     * Get whether 'Unknown Command' must be shown when an unknown command is used.
     *
     * @return True when enabled, false otherwise. Default is true.
     */
    public boolean getShowUnknownCommand() {
        return cfg.getBoolean("show-unknown-command", true);
    }

    /**
     * Gets whether the Mojang snooper is enabled or not
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean isSnooperEnabled() {
        return cfg.getBoolean("snooper-enabled", true);
    }

    /**
     * Gets the spam protection level<br/>
     * default - on for restricted users; off - totally off; all - on for all users
     *
     * @return the spam protection level
     */
    public String getSpamProtectionLevel() {
        return cfg.getString("spam-protection", "default");
    }

    /**
     * Gets whether characters on signs are checked for validity or not
     *
     * @return {@code true} if strict checks are preformed; {@code false} if not
     */
    public boolean getStrictSignCharacterChecks() {
        return cfg.getBoolean("strict-sign-characters");
    }

    /**
     * Server Texture/Resource Pack name
     *
     * @return the server texture/resource pack name
     */
    public String getTexturePack() {
        return cfg.getString("texture-pack", "");
    }

    /**
     * Gets whether to update the Server Lang files or not
     *
     * @return {@code true} to update; {@code false} if not
     */
    public boolean updateLang() {
        return cfg.getBoolean("update-lang-files", true);
    }

    /**
     * Get the view distance of clients: maximum radius of loaded chunks around a player
     *
     * @return view distance
     */
    public int getViewDistance() {
        return cfg.getInt("view-distance", 10);
    }

    /**
     * Get whether the whitelist is enabled.
     *
     * @return True when enabled, false otherwise. Default is false.
     */
    public boolean isWhitelistEnabled() {
        return cfg.getBoolean("whitelist-enabled", false);
    }

    /**
     * Get the message shown to players who are not whitelisted.
     *
     * @return A string containing the message.
     */
    public String getWhitelistMessage() {
        return cfg.getString("whitelist-message", "Not on whitelist.");
    }

    /**
     * Checks if the World Cache Timer is enabled
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean isWorldCacheTimerEnabled() {
        return cfg.getBoolean("world-cache-timer-enabled", true);
    }

    /**
     * Gets the World Cache timeout
     *
     * @return world cache timeout
     */
    public long getWorldCacheTimeout() {
        return cfg.getLong("world-cache-timeout", 60);
    }

    /**
     * Gets the Network Compression Threshold
     *
     * @return network compression threshold
     */
    public int getNetworkCompressionThreshold() {
        return cfg.getInt("network-compression-threshold", 256);
    }

    /**
     * Gets the default max world size
     *
     * @return default max world size
     */
    public int getDefaultMaxWorldSize() {
        return cfg.getInt("default-world-size", 29999984);
    }

    /**
     * Gets the max time a tick may take
     *
     * @return max tick time
     */
    public int getMaxTickTime() {
        return cfg.getInt("max-tick-time", 60000);
    }

    /**
     * Checks if bungeecord support is enabled
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean getBungeecordSupport() {
        return cfg.getBoolean("bungeecord", false);
    }

    /**
     * Gets the plugin dev mode state
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean getPluginDevModeEnabled() {
        return cfg.getBoolean("plugin-dev-mode", false);
    }

    /**
     * Enables if the server will do IP verification on connecting users session
     *
     * @return {@code true} if enabled; {@code false} if not
     */
    public boolean verifyUserSessionIP() {
        return cfg.getBoolean("verify-user-session-ip", true);
    }
}
