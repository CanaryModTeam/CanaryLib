package net.canarymod.api;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.Block;

import java.util.List;

/**
 * PlayerManager wrapper
 *
 * @author Chris (damagefilter)
 */
public interface PlayerManager {

    /**
     * Update a mounted moving {@link Player}
     *
     * @param player
     *         the {@link Player} to update
     */
    void updateMountedMovingPlayer(Player player);

    /**
     * Add the given {@link Player} to this PlayerManager
     *
     * @param player
     *         the {@link Player} to be added
     */
    void addPlayer(Player player);

    /**
     * Remove the given {@link Player} from this PlayerManager
     *
     * @param player
     *         the {@link Player} to be removed
     */
    void removePlayer(Player player);

    /**
     * Get a list of all {@link Player}s that are managed by this PlayerManager
     *
     * @return an {@link List} of {@link Player}s
     */
    List<Player> getManagedPlayers();

    /**
     * Marks a {@link Block} at this position for updating for this PlayerManager
     *
     * @param x
     *         the x coordinate
     * @param y
     *         the y coordinate
     * @param z
     *         the z coordinate
     */
    void markBlockNeedsUpdate(int x, int y, int z);

    /**
     * Get the maximum tracking distance for this PlayerManager
     *
     * @return the maximum tracking distance
     */
    int getMaxTrackingDistance();

    /**
     * Get the dimension this PlayerManager is in charge of
     *
     * @return the {@link World} dimension
     */
    World getAttachedDimension();
}
