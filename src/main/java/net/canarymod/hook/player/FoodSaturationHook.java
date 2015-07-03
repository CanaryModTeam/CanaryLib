package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Food saturation change hook. Contains information about a player's food saturation changes
 *
 * @author Jason (darkdiplomat)
 */
public final class FoodSaturationHook extends Hook {

    private Player player;
    private float oldval, newval;

    /**
     * Constructs a new FoodSaturationHook
     *
     * @param player
     *         the {@link Player} who's Food Level is changing
     * @param oldval
     *         the old (current) value
     * @param newval
     *         the new value
     */
    public FoodSaturationHook(Player player, float oldval, float newval) {
        this.player = player;
        this.oldval = oldval;
        this.newval = newval;
    }

    /**
     * Gets the {@link Player} who's food saturation is changing
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
    public float getOldValue() {
        return oldval;
    }

    /**
     * Gets the new level
     *
     * @return the new level
     */
    public float getNewValue() {
        return newval;
    }

    /**
     * Sets the new value to actually be set
     *
     * @param value
     *         the level to set
     */
    public void setNewValue(float value) {
        this.newval = value;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Old Saturation=%s, New Saturation=%s]", getHookName(), player, oldval, newval);
    }
}
