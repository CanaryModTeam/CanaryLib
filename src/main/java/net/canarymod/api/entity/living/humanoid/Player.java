package net.canarymod.api.entity.living.humanoid;

import com.mojang.authlib.GameProfile;
import net.canarymod.api.NetServerHandler;
import net.canarymod.api.PlayerListAction;
import net.canarymod.api.PlayerListData;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.packet.Packet;
import net.canarymod.api.world.blocks.Sign;
import net.canarymod.api.world.position.Direction;
import net.canarymod.api.world.position.Location;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.hook.player.TeleportHook.TeleportCause;

/**
 * Player wrapper
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public interface Player extends Human, MessageReceiver, PlayerReference {

    /**
     * Initializes or re-initializes the permissions, groups and prefix data for this player
     */
    void initPlayerData();

    /**
     * Sends a message as the Player
     *
     * @param message
     *         the message to send as the Player
     */
    void chat(String message);

    /**
     * Get the spawn position for the player
     *
     * @return spawn position
     */
    Location getSpawnPosition();

    /**
     * Sets the spawn position
     *
     * @param spawn
     *         the {@link Location} to spawn at
     */
    void setSpawnPosition(Location spawn);

    /**
     * Make this player execute the given command
     *
     * @param command
     *         the String array arguments
     *
     * @return true if the command executed successfully, false otherwise
     */
    boolean executeCommand(String[] command);

    /**
     * Send player a packet. This will throw exception if packet is invalid!
     *
     * @param packet
     *         the {@link Packet} to send
     */
    void sendPacket(Packet packet);

    /**
     * Get the NetServerHandler for this player
     *
     * @return {@link NetServerHandler}
     */
    NetServerHandler getNetServerHandler();

    /**
     * Teleport to this location with specified cause
     * <p/>
     * If other Teleport methods are called, cause default to PLUGIN
     *
     * @param location
     *         the {@link Location} to teleport to
     * @param cause
     *         the {@link TeleportCause}]
     */
    void teleportTo(Location location, TeleportCause cause);

    /**
     * Kick this player
     *
     * @param reason
     *         the string reasoning
     */
    void kick(String reason);

    /**
     * Kick this player without a hook call
     *
     * @param reason
     *         the string reasoning
     */
    void kickNoHook(String reason);

    /**
     * Get the cardinal direction this player is looking at
     *
     * @return direction
     */
    Direction getCardinalDirection();

    /**
     * Gets the Player's ping
     *
     * @return the ping
     */
    int getPing();

    /**
     * Gets a {@link net.canarymod.api.PlayerListData} for the Player
     * <p/>
     * The initially set name is {@link Player#getDisplayName()}
     *
     * @return {@link net.canarymod.api.PlayerListData} for the Player
     *
     * @see net.canarymod.api.PlayerListData
     * @see net.canarymod.api.PlayerListAction
     */
    PlayerListData getPlayerListData(PlayerListAction action);

    /**
     * Sends a {@link net.canarymod.api.PlayerListData} to the Player
     * <p/>
     * NOTE: The server needs to have PlayerList enabled in the configuration
     *
     * @param data
     *         the {@link net.canarymod.api.PlayerListData} to send
     *
     * @see net.canarymod.api.PlayerListData
     */
    void sendPlayerListData(PlayerListData data);

    /**
     * Checks if the player is asleep
     *
     * @return true if player is in bed, false otherwise
     */
    boolean isSleeping();

    /**
     * Check if this player is deeply sleeping,
     * that is: Player is in bed and the screen has fully faded out.
     *
     * @return true if fully asleep, false otherwise
     */
    boolean isDeeplySleeping();

    /**
     * Refreshes mode
     */
    void refreshCreativeMode();

    /**
     * Sends update of PlayerCapabilities to player
     */
    void updateCapabilities();

    /**
     * Sends the WindowOpenPacket to the Player with the specified Inventory
     * <p/>
     * NOTE: Some inventories may not work remotely
     *
     * @param inventory
     *         the {@link Inventory} to have opened
     */
    void openInventory(Inventory inventory);

    /**
     * Creates a fake Workbench and sends the WindowOpenPacket to the Player
     */
    void createAndOpenWorkbench();

    /**
     * Creates a fake Anvil and sends the WindowOpenPacket to the Player
     */
    void createAndOpenAnvil();

    /**
     * Creates a fake EnchantmentTable and then sends the WindowOpenPacket to the Player
     *
     * @param bookshelves
     *         Sets the number of bookshelves to fake around the enchantment table
     */
    void createAndOpenEnchantmentTable(int bookshelves);

    /**
     * Opens the {@link Sign} edit window.
     * <p/>
     * NOTE: For changes to take effect, the {@link Sign} needs to be editable, or the Player set as owner
     *
     * @param sign
     *         the {@link Sign} to edit
     */
    void openSignEditWindow(Sign sign);

    /**
     * Opens a given Written Book dynamically
     *
     * @param writtenbook
     *         the Written Book to be opened
     */
    void openBook(Item writtenbook);

    /**
     * Closes an open Inventory GUI if one is presently open.<br/>
     * This should also call the close method for that inventory.
     */
    void closeWindow();

    /**
     * Sends a {@link net.canarymod.api.chat.ChatComponent} to the {@code Player}
     *
     * @param chatComponent
     *         the {@link net.canarymod.api.chat.ChatComponent} to send
     */
    void sendChatComponent(ChatComponent chatComponent);

    /**
     * Gets the previously known IP of the {@code Player} if found
     *
     * @return previous IP if found
     */
    String getPreviousIP();

    /**
     * Make this {@link Player} hidden to the given {@link Player}.
     *
     * @param player
     *         the {@link Player} to hide this {@link Player} from.
     *
     * @deprecated use {@link net.canarymod.api.entity.living.humanoid.Player#hideFrom(Player)} instead
     */
    @Deprecated
    void hidePlayer(Player player);

    /**
     * Make this {@link Player} hidden to the given {@link Player}.
     *
     * @param player
     *         the {@link Player} to hide this {@link Player} from.
     */
    void hideFrom(Player player);

    /**
     * Make this {@link Player} hidden to all {@link Player}s.
     *
     * @deprecated use {@link net.canarymod.api.entity.living.humanoid.Player#hideFromAll} instead
     */
    @Deprecated
    void hidePlayerGlobal();

    /**
     * Make this {@link Player} hidden to all {@link Player}s.
     */
    void hideFromAll();

    /**
     * Make this {@link Player} shown to the given {@link Player}.
     *
     * @param player
     *         The {@link Player} to show this {@link Player} to.
     *
     * @deprecated use {@link net.canarymod.api.entity.living.humanoid.Player#showTo(Player)} instead
     */
    @Deprecated
    void showPlayer(Player player);

    /**
     * Make this {@link Player} shown to the given {@link Player}.
     *
     * @param player
     *         The {@link Player} to show this {@link Player} to.
     */
    void showTo(Player player);

    /**
     * Make this {@link Player} shown to all {@link Player}s.
     *
     * @deprecated use {@link Player#showToAll} instead
     */
    @Deprecated
    void showPlayerGlobal();

    /**
     * Make this {@link Player} shown to all {@link Player}s.
     */
    void showToAll();

    /**
     * Checks if a {@link Player} is hidden to another {@link Player}.
     *
     * @param player
     *         Target Player
     * @param isHidden
     *         Player to check if is hidden to Target Player.
     *
     * @return true if isHidden is hidden to player; false otherwise.
     *
     * @deprecated use {@link net.canarymod.api.entity.living.humanoid.Player#isHiddenFrom(Player)} instead
     */
    @Deprecated
    boolean isPlayerHidden(Player player, Player isHidden);

    /**
     * Checks if a this {@link Player} is hidden to another {@link Player}.
     *
     * @param player
     *         Target Player
     *
     * @return true if is hidden to the other player; false otherwise.
     */
    boolean isHiddenFrom(Player player);

    /**
     * Checks if a this {@link Player} is hidden to all other {@link Player}s.
     *
     * @return true if is hidden from other players; false otherwise.
     */
    boolean isHiddenFromAll();

    /**
     * Set the compass target to a {@link Player}
     *
     * @param x
     * @param y
     * @param z
     */
    void setCompassTarget(int x, int y, int z);

    /**
     * Gets the {@link Player} Mojang {@link com.mojang.authlib.GameProfile}
     *
     * @return game profile
     */
    GameProfile getGameProfile();

    /**
     * Gets the {@link net.canarymod.api.chat.ChatComponent} the makes up the DisplayName
     *
     * @return display name {@link net.canarymod.api.chat.ChatComponent} or {@code null} if one isn't set
     */
    ChatComponent getDisplayNameComponent();

    /**
     * Sets the {@link net.canarymod.api.chat.ChatComponent} that makes up the DisplayName
     *
     * @param component
     *         display name {@link net.canarymod.api.chat.ChatComponent}; passing null will clear the display name
     */
    void setDisplayNameComponent(ChatComponent component);

    /**
     * Gets the second {@link Inventory} the player is watching currently
     *
     * @return the top {@link Inventory} on the player's window. {@code null} will be returned if there isn't one.
     */
    Inventory getSecondInventory();

    /**
     * Shows a Title to the Player
     *
     * @param title
     *         the text of the title to show
     */
    void showTitle(ChatComponent title);

    /**
     * Shows a Title (and possible sub title) to the Player
     *
     * @param title
     *         the text of the title to show
     * @param subtitle
     *         the text of the subtile to show; may be {@code null}
     */
    void showTitle(ChatComponent title, ChatComponent subtitle);
}
