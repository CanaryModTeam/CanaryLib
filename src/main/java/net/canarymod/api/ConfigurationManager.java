package net.canarymod.api;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.packet.Packet;
import net.canarymod.api.world.DimensionType;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.Block;

import java.util.List;

/**
 * Interface for the server configuration manager.
 * It's important to note that this has nothing to do with the CanaryMod configurations!
 *
 * @author Chris (damagefilter)
 */
public interface ConfigurationManager {

    /**
     * Sends a packet to all people in the given world (retrieved by its name)
     *
     * @param world
     *         the {@link World} name
     * @param packet
     *         the {@link net.canarymod.api.packet.Packet} to be sent
     */
    void sendPacketToAllInWorld(String world, Packet packet);

    /**
     * Get the numbers of online players
     *
     * @return number of online players
     */
    int getNumPlayersOnline();

    /**
     * Get a player by this name.
     * Note: This method does not match player names.
     * You need to provide the exact player name
     *
     * @param name
     *         the name of the {@link Player} to get
     *
     * @return the {@link Player} if online; {@code null} if not found
     */
    Player getPlayerByName(String name);

    /**
     * Get a list of all players that are currently online
     *
     * @return an {@link List} of all {@link Player}s online
     */
    List<Player> getAllPlayers();

    /**
     * Get the maximum number of allowed {@link Player}s on the server
     *
     * @return the maximum
     */
    int getMaxPlayers();

    /**
     * Marks a {@link Block} to be updated with the next tick
     *
     * @param x
     *         the x coordinate
     * @param y
     *         the y coordinate
     * @param z
     *         the z coordinate
     * @param dimension
     *         the {@link DimensionType}
     * @param world
     *         the {@link World} name
     */
    void markBlockNeedsUpdate(int x, int y, int z, DimensionType dimension, String world);

    /**
     * This will put the {@link Player} into the given {@link World}
     *
     * @param player
     *         the {@link Player}
     * @param world
     *         the {@link World}
     * @param createPortal
     *         {@code true} to create a Portal; {@code false} if not
     */
    void switchDimension(Player player, World world, boolean createPortal);
}
