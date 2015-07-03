package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Held item change hook. Contains information about a player's held slot changes
 *
 * @author ar56te876mis <ar56te876mis@yahoo.de>
 */
public class HeldItemChangeHook extends Hook {

    private Player player;
    private int oldval, newval;

    /**
     * Constructs a new HeldItemChangeHook
     *
     * @param player
     *         the {@link Player} whose hold slot is changing
     * @param oldval
     *         the old (current) value
     * @param newval
     *         the new value
     */
    public HeldItemChangeHook(Player player, int oldval, int newval) {
        this.player = player;
        this.oldval = oldval;
        this.newval = newval;
    }

    /**
     * Gets the {@link Player} whose held slot is changing
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the old (current) held slot
     *
     * @return the old held slot
     */
    public int getOldValue() {
        return oldval;
    }

    /**
     * Gets the new held slot
     *
     * @return the new held slot
     */
    public int getNewValue() {
        return newval;
    }

    /**
     * Sets the new value to actually be set
     *
     * @param value
     *         the held slot to set
     */
    public void setNewValue(int value) {
        this.newval = value;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Old held slot=%s, New held slot=%s]", getHookName(), player, oldval, newval);
    }
}
