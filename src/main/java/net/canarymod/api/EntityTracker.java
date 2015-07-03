package net.canarymod.api;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.packet.Packet;
import net.canarymod.api.world.World;

import java.util.List;

/**
 * EntityTracker wrapper
 *
 * @author Chris (damagefilter)
 */
public interface EntityTracker {

    /**
     * Add an {@link Entity} to this entity tracker
     *
     * @param entity
     *         the {@link Entity} to be added
     */
    void trackEntity(Entity entity);

    /**
     * Untrack the {@link Entity} given.
     *
     * @param entity
     *         the {@link Entity} to stop tracking
     */
    void untrackEntity(Entity entity);

    /**
     * Make a {@link Player} hidden to another {@link Player}.
     *
     * @param player
     *         the target {@link Player}.
     * @param toHide
     *         The {@link Player} to make hidden for the target {@link Player}.
     */
    void hidePlayer(Player player, Player toHide);

    /**
     * Make a {@link Player} hidden to all {@link Player}s.
     *
     * @param toHide
     *         The Player to make hidden to all other
     */
    void hidePlayerGlobal(Player toHide);

    /**
     * Make a {@link Player} shown to another {@link Player}.
     *
     * @param player
     *         the target {@link Player}.
     * @param toShow
     *         The {@link Player} to make shown for the target {@link Player}.
     */
    void showPlayer(Player player, Player toShow);

    /**
     * Make a {@link Player} shown to all {@link Player}s.
     *
     * @param toShow
     *         The Player to make shown to all other
     */
    void showPlayerGlobal(Player toShow);

    /**
     * Untrack the player symmetrics for the given player.<br>
     * Call this after {@link EntityTracker#untrackEntity(Entity)} when you stop tracking a player!
     *
     * @param player
     *         the {@link Player} to stop tracking
     */
    void untrackPlayerSymmetrics(Player player);

    /**
     * Update all tracked entities inside this tracker.
     */
    void updateTrackedEntities();

    /**
     * Get the dimension this entity tracker is in charge for
     *
     * @return the {@link World}
     */
    World getAttachedDimension();

    /**
     * Send a {@link net.canarymod.api.packet.Packet} to a tracked {@link Player}
     *
     * @param player
     *         the {@link Player} to send the {@link net.canarymod.api.packet.Packet}
     * @param packet
     *         the {@link net.canarymod.api.packet.Packet} to be sent
     */
    void sendPacketToTrackedPlayer(Player player, Packet packet);

    /**
     * Get an {@link List} of all tracked entities in this EntityTracker
     *
     * @return the {@link List} of tracked entities
     */
    List<Entity> getTrackedEntities();

    /**
     * Checks if a {@link Player} is hidden to another {@link Player}.
     *
     * @param player
     *         Target Player
     * @param isHidden
     *         Player to check if is hidden to Target Player.
     *
     * @return true if isHidden is hidden to player; false otherwise.
     */
    boolean isPlayerHidden(Player player, Player isHidden);
}
