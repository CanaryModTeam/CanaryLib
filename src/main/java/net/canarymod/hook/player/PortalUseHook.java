package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.hook.CancelableHook;

/**
 * PortalUse Hook
 *
 * @author Jason (darkdiplomat)
 */
public class PortalUseHook extends CancelableHook {
    private Player player;
    private Location to;

    /**
     * Constructs a new PortalUseHook
     *
     * @param player
     *         the {@link Player} using the Portal
     * @param to
     *         the {@link Location} the portal goes to
     */
    public PortalUseHook(Player player, Location to) {
        this.player = player;
        this.to = to;
    }

    /**
     * Gets the {@link Player} using a portal
     *
     * @return the {@link Player} using a portal
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Location} the portal goes to
     *
     * @return the {@link Location} the portal goes to
     */
    public Location getTo() {
        return to;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, To Location=%s]", getHookName(), player, to);
    }
}
