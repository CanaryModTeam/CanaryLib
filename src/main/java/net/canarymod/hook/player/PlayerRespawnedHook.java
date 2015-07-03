package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.hook.Hook;

/**
 * Player respawned hook. Contains the reference to the freshly spawned player entity
 * and the location it spawned in. The location can not be overridden at this point.
 * If you need the player to go somewhere else, use {@link Player#teleportTo(Location)} etc
 *
 * @author Jason (darkdiplomat)
 * @author Chris (damagefilter)
 */
public final class PlayerRespawnedHook extends Hook {

    private Player player;
    private Location location;

    public PlayerRespawnedHook(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    /**
     * Gets the {@link Player}
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Location} where this player will finally spawn
     *
     * @return spawn location
     */
    public Location getLocation() {
        return location;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Location=%s]", getHookName(), player.getName(), location);
    }
}
