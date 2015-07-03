package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.hook.CancelableHook;

/**
 * Teleport hook. Contains player who is teleporting and their destination
 *
 * @author Brian (WWOL)
 * @author Jason (darkdiplomat)
 */
public final class TeleportHook extends CancelableHook {
    private Player player;
    private Location destination;
    private TeleportCause cause;

    public TeleportHook(Player player, Location destination, TeleportCause cause) {
        this.player = player;
        this.destination = destination;
        this.cause = cause;
    }

    /**
     * Get the {@link Player} instance.
     *
     * @return the teleporting Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Player}'s current location
     *
     * @return the current {@link Location} of the Player
     */
    public Location getCurrentLocation() {
        return player.getLocation();
    }

    /**
     * Get the destination {@link Location} for the teleport.
     *
     * @return the {@link Location} of the destination
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Gets the {@link TeleportCause}
     *
     * @return the {@link TeleportCause}
     */
    public TeleportCause getTeleportReason() {
        return cause;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Destination=%s, TeleportCause=%s]", getHookName(), player, destination, cause);
    }

    /**
     * Teleport Reasoning enum
     *
     * @author Jason (darkdiplomat)
     */
    public enum TeleportCause {
        /**
         * Teleported by sleeping in/waking up from a bed
         */
        BED,
        //
        /**
         * Teleported by use of a command
         */
        COMMAND,
        //
        /**
         * Teleported by mounting/unmounting an {@link net.canarymod.api.entity.Entity}
         */
        MOUNT_CHANGE,
        //
        /**
         * Teleported by normal moving
         */
        MOVEMENT,
        //
        /**
         * Teleported by a plugin
         */
        PLUGIN,
        //
        /**
         * Teleported by a Portal
         */
        PORTAL,
        //
        /**
         * Teleported by respawn
         */
        RESPAWN,
        //
        /**
         * Generic Reasoning
         */
        UNDEFINED,
        //
        /**
         * WARP SYSTEM
         */
        WARP,
        //
        ;
    }
}
