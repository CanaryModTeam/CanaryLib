package net.canarymod.api;

import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.gui.GUIControl;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.Recipe;
import net.canarymod.api.inventory.recipes.ShapedRecipe;
import net.canarymod.api.inventory.recipes.ShapelessRecipe;
import net.canarymod.api.inventory.recipes.SmeltRecipe;
import net.canarymod.api.world.World;
import net.canarymod.api.world.WorldManager;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.CommandOwner;
import net.canarymod.motd.MOTDOwner;
import net.canarymod.tasks.ServerTask;
import net.canarymod.tasks.TaskOwner;

import java.util.List;
import java.util.UUID;

/**
 * CanaryMod Server.<br />
 * This handles communication to the server and provides a couple of useful
 * information
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 * @author Jos Kuijpers
 */
public interface Server extends MessageReceiver, CommandOwner, TaskOwner, MOTDOwner {

    /**
     * Get the current host name for this server
     *
     * @return the host name
     */
    String getHostname();

    /**
     * Get the amount of players that are online
     *
     * @return the number of {@link Player}s online
     */
    int getNumPlayersOnline();

    /**
     * Get the number of maximum allowed {@link Player}s online
     *
     * @return the mximum
     */
    int getMaxPlayers();

    /**
     * Get a list of names from {@link Player}s that are currently online
     *
     * @return string array of {@link Player} names
     */
    String[] getPlayerNameList();

    /**
     * Gets a {@code String[]} of known {@link Player} names, including {@link net.canarymod.api.OfflinePlayer} names
     *
     * @return {@code String[]} of known player names
     */
    String[] getKnownPlayerNames();

    /**
     * Get a list of online {@link Player}s
     *
     * @return an {@link List} of {@link Player}s
     */
    List<Player> getPlayerList();

    /**
     * Get the default world name
     *
     * @return the name of the default world
     */
    String getDefaultWorldName();

    /**
     * Get the world container
     *
     * @return the {@link WorldManager}
     */
    WorldManager getWorldManager();

    /**
     * Use a MC vanilla console command
     *
     * @param command
     *         the command
     *
     * @return {@code true} if command has been parsed by CanaryMod; {@code false} otherwise
     */
    boolean consoleCommand(String command);

    /**
     * Use a MC vanilla console command as the given player (Ingame vanilla
     * commands)
     *
     * @param command
     *         the command
     * @param player
     *         the {@link Player} to act as
     *
     * @return {@code true} if command has been parsed by CanaryMod; {@code false} otherwise
     */
    boolean consoleCommand(String command, Player player);

    /**
     * Use a MC vanilla console command as the given player (Ingame vanilla
     * commands)
     *
     * @param command
     *         the command
     * @param cmdBlockLogic
     *         the {@link CommandBlockLogic} to act as
     *
     * @return {@code true} if command has been parsed by CanaryMod; {@code false} otherwise
     */
    boolean consoleCommand(String command, CommandBlockLogic cmdBlockLogic);

    /**
     * Passes a pre-processed Vanilla Command into the the Vanilla Command System
     * NOTE: Does not trigger a ConsoleCommandHook call
     *
     * @param caller
     *         the MessageReceiver executing the command
     * @param command
     *         the command being executed
     */
    void executeVanillaCommand(MessageReceiver caller, String command);

    /**
     * Set a timer in the built-in vanilla Timer System.
     *
     * @param uniqueName
     *         Name to identify your timer
     * @param time
     *         Time in milliseconds.
     */
    void setTimer(String uniqueName, int time);

    /**
     * Check if a registered Timer has expired already
     *
     * @param uniqueName
     *         The unique name of the timer you're looking for
     *
     * @return {@code true} if expired; {@code false} if not
     */
    boolean isTimerExpired(String uniqueName);

    /**
     * Matches a {@link Player} name or a partial name of a {@link Player} name to an existing online {@link Player}
     *
     * @param player
     *         the partial name of the {@link Player} to find a match for
     *
     * @return a reference to an online {@link Player} or {@code null} if no match was found
     */
    Player matchPlayer(String player);

    /**
     * Get an {@link OfflinePlayer}. This will only return an {@link OfflinePlayer} instance
     * if the playername resolves into a valid UUID via the Mojang API.
     * if you try to get a player that never joined it will return an OfflinePlayer
     * with the given name and default values
     *
     * @param player
     *         the name of the player
     *
     * @return the {@link OfflinePlayer} instance or null if the playername/uuid doesn't exist.
     */
    OfflinePlayer getOfflinePlayer(String player);

    /**
     * Get an {@link OfflinePlayer}. This will only return an {@link OfflinePlayer} instance
     * if the playername resolves into a valid UUID via the Mojang API.
     * if you try to get a player that never joined it will return an OfflinePlayer
     * with the given name and default values
     *
     * @param uuid
     *         the UUID of the player
     *
     * @return the {@link OfflinePlayer} instance or null if the playername/uuid doesn't exist.
     */
    OfflinePlayer getOfflinePlayer(UUID uuid);

    /**
     * Gets a {@link PlayerReference} of a known player
     *
     * @param player
     *         the name of the player to get a reference for
     *
     * @return the {@link PlayerReference} if found; {@code null} if no player found
     */
    PlayerReference matchKnownPlayer(String player);

    /**
     * Gets a {@link PlayerReference} of a known player
     *
     * @param uuid
     *         the UUID of the player to get a reference for
     *
     * @return the {@link PlayerReference} if found; {@code null} if no player found
     */
    PlayerReference matchKnownPlayer(UUID uuid);

    /**
     * Like matchPlayer, this returns a player according to a name String.
     * However, no matching is performed here so you need to pass the exact
     * player name
     *
     * @param player
     *         the name of the {@link Player} to get
     *
     * @return a reference to an online {@link Player}; {@code null} if there is no {@link Player} with the given name
     */
    Player getPlayer(String player);

    /**
     * This returns a player with the given uuid.
     *
     * @param uuid
     *         the uuid of {@link Player} to get
     *
     * @return a reference to an online {@link Player}; {@code null} if there is no {@link Player} with the given uuid
     */
    Player getPlayerFromUUID(String uuid);

    /**
     * This returns a player with the given uuid.
     *
     * @param uuid
     *         the uuid of {@link Player} to get
     *
     * @return a reference to an online {@link Player}; {@code null} if there is no {@link Player} with the given uuid
     */
    Player getPlayerFromUUID(UUID uuid);

    /**
     * Send (broadcast) the given message to ALL players on the server,
     * in all worlds.
     *
     * @param message
     *         the message to be broadcasted
     */
    void broadcastMessage(String message);

    /**
     * Send (broadcast) the given message to ALL Operators on the server,
     * in all worlds.
     *
     * @param message
     *         the message to be broadcasted
     */
    void broadcastMessageToOps(String message);

    /**
     * Send (broadcast) the given message to ALL Administrators on the server,
     * in all worlds.
     *
     * @param message
     *         the message to be broadcasted
     */
    void broadcastMessageToAdmins(String message);

    /**
     * Load a {@link World} with the given name from file.
     *
     * @param name
     *         the name of the {@link World}
     * @param seed
     *         the {@code long} seed
     *
     * @return true on success, false if the world didn't exist
     */
    boolean loadWorld(String name, long seed);

    /**
     * Get a {@link World} that already is loaded.
     * If the {@link World} isn't loaded, it'll be loaded,
     * if it didn't exist, this will return null
     *
     * @param name
     *         the name of the {@link World}
     *
     * @return {@link World} if found; {@code null} if not
     */
    World getWorld(String name);

    /**
     * Get the {@link World} that is defined as default per config
     *
     * @return the default {@link World}
     */
    World getDefaultWorld();

    /**
     * Get the servers configuration manager.
     *
     * @return the {@link ConfigurationManager}
     */
    ConfigurationManager getConfigurationManager();

    /**
     * Signal the server to shut down and exit.
     *
     * @param message
     *         The shutdown message, or {@code null} for the default
     *         message.
     */
    void initiateShutdown(String message);

    /**
     * Restart the server by shutting it down and
     * creating a new server instance, without actually killing the running JVM
     *
     * @param reloadCanary
     *         Set true if CanaryMod should reload its data too
     */
    void restart(boolean reloadCanary);

    /**
     * Check if the server is running. This is rarely useful
     * and you should probably not bother using it.
     *
     * @return {@code true} if running; {@code false} if not
     */
    boolean isRunning();

    /**
     * Adds a CraftingRecipe to the Server
     *
     * @param recipe
     *         the {@link CraftingRecipe} to add
     *
     * @return a {@link Recipe} object from the created Recipe
     *
     * @see CraftingRecipe
     * @see Recipe
     * @see ShapedRecipe
     * @see ShapelessRecipe
     */
    Recipe addRecipe(CraftingRecipe recipe);

    /**
     * Gets a list of {@link Recipe} that the Server has
     *
     * @return the {@link Recipe} list
     */
    List<Recipe> getServerRecipes();

    /**
     * Attempts to remove a {@link Recipe}
     *
     * @param recipe
     *         the {@link Recipe} to be removed
     *
     * @return {@code true} if successful; {@code false} if not
     */
    boolean removeRecipe(Recipe recipe);

    /**
     * Adds a Smelting recipe to the Server
     *
     * @param recipe
     *         the {@link SmeltRecipe} to add
     *
     * @see SmeltRecipe
     */
    void addSmeltingRecipe(SmeltRecipe recipe);

    /**
     * Gets a list of {@link SmeltRecipe} that the Server has
     *
     * @return a list of {@link SmeltRecipe}
     */
    List<SmeltRecipe> getServerSmeltRecipes();

    /**
     * Attempts to remove a {@link SmeltRecipe} from the Server<br>
     * Note: There is no official native objects for smelting recipes so matching the item id from and item result is enough.
     *
     * @param recipe
     *         the {@link SmeltRecipe} to be removed
     *
     * @return {@code true} if successful; {@code false} if not
     */
    boolean removeSmeltRecipe(SmeltRecipe recipe);

    /**
     * Changes the current GUI to the given GUI
     *
     * @param gui
     *         the {@link GUIControl} to add
     */
    void addGUI(GUIControl gui);

    /**
     * Gets the array of Time Ticks
     *
     * @return array of Time ticks
     */
    long[] getTickTimeArray();

    /**
     * Get the version of the server mod that is currently running
     *
     * @return the internal implementation version
     * @deprecated As of 1.2.1 - {@link Canary#getImplementationVersion()} should be used
     */
    @Deprecated
    String getCanaryModVersion();

    /**
     * Get the version of the implemented Minecraft Server<br>
     *
     * @return the internal Minecraft Server version
     */
    String getServerVersion();

    /**
     * Gets the version of the implemented Minecraft Server's Packet Protocol
     *
     * @return packet protocol version
     */
    int getProtocolVersion();

    /**
     * Gets the log up to this point if the ServerGUI is running.
     *
     * @return log
     */
    String getServerGUILog();

    /**
     * Gets the current GUI's control interface
     * Will return null if no GUI is started
     *
     * @return current {@link GUIControl} or {@code null} if none set
     */
    GUIControl getCurrentGUI();

    /**
     * Gets if the Server is headless or not
     * Will return true if nogui is passed to the server on start
     *
     * @return {@code true} if headless (no gui); {@code false} if gui enabled
     */
    boolean isHeadless();

    /**
     * Add a task to the servers synchronous task queue.
     * This will be executed within the main server thread.
     *
     * @param task
     *         the {@link ServerTask} to add
     *
     * @return {@code true} if task was added successfully, {@code false} otherwise
     */
    boolean addSynchronousTask(ServerTask task);

    /**
     * Remove the given task from the task queue.
     *
     * @param task
     *         the {@link ServerTask} to remove
     *
     * @return {@code true} if task was removed successfully, {@code false} otherwise
     */
    boolean removeSynchronousTask(ServerTask task);

    /**
     * Sends a {@link net.canarymod.api.PlayerListData} to all {@link Player}s on the server.
     * <p/>
     * NOTE: The server needs to have PlayerList enabled in the configuration
     *
     * @param data
     *         the {@link net.canarymod.api.PlayerListData} to be sent
     */
    void sendPlayerListData(PlayerListData data);

    /**
     * Gets the currently tracked Tick count.<br>
     * You can use this number to later determine a rough Ticks Per Second (TPS) count
     *
     * @return the current tick
     */
    int getCurrentTick();

    /**
     * Gets the currently read TPS.<br>
     * Update is attempted once per second
     *
     * @return the current TPS
     */
    float getTicksPerSecond();

    /**
     * Shows a Title to all {@link Player}(s) on the Server
     *
     * @param title
     *         the text of the title to show
     */
    void showTitle(ChatComponent title);

    /**
     * Shows a Title (and possible sub title) to all {@link Player}(s) on the Server
     *
     * @param title
     *         the text of the title to show
     * @param subtitle
     *         the text of the subtile to show; may be {@code null}
     */
    void showTitle(ChatComponent title, ChatComponent subtitle);
}
