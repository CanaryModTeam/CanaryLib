package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.hook.Hook;

/**
 * Player pre-respawn hook.
 * This hook is called before the new location and repsawn point for a player is determined.
 * Use it to alter those information.
 *
 * @author Jason (darkdiplomat)
 * @author Chris (damagefilter)
 */
public final class PlayerRespawningHook extends Hook {

    private Player player;
    private Location respawn;
    private boolean bedSpawn;

    public PlayerRespawningHook(Player player, Location respawn, boolean bedSpawn) {
        this.player = player;
        this.respawn = respawn;
        this.bedSpawn = bedSpawn;
    }

    /**
     * Gets the {@link Player}
     *
     * @return {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the respawn {@link Location}
     *
     * @return respawn location
     */
    public Location getRespawnLocation() {
        return respawn;
    }

    /**
     * Sets the respawn {@link Location}
     *
     * @param respawn
     *         the respawn location
     */
    public void setRespawnLocation(Location respawn) {
        this.respawn = respawn;
    }

    /**
     * Returns true if the player is supposed to respawn at his bed
     *
     * @return {@code true} if bed spawn
     */
    public boolean isBedSpawn() {
        return bedSpawn;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Location=%s]", getHookName(), player, respawn);
    }
}
