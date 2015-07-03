package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Food level hook. Contains information about a player's food level changes
 *
 * @author Jason (darkdiplomat)
 */
public final class FoodLevelHook extends Hook {

    private Player player;
    private int oldval, newval;

    /**
     * Constructs a new FoodLevelHook
     *
     * @param player
     *         the {@link Player} who's Food Level is changing
     * @param oldval
     *         the old (current) value
     * @param newval
     *         the new value
     */
    public FoodLevelHook(Player player, int oldval, int newval) {
        this.player = player;
        this.oldval = oldval;
        this.newval = newval;
    }

    /**
     * Gets the {@link Player} who's food level is changing
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the old (current) level
     *
     * @return the old level
     */
    public int getOldValue() {
        return oldval;
    }

    /**
     * Gets the new level
     *
     * @return the new level
     */
    public int getNewValue() {
        return newval;
    }

    /**
     * Sets the new value to actually be set
     *
     * @param value
     *         the level to set
     */
    public void setNewValue(int value) {
        this.newval = value;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Old Food Level=%s, New Food Level=%s]", getHookName(), player, oldval, newval);
    }
}
