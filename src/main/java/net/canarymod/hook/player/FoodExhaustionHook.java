package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Food exhaustion change hook. Contains information about a player's food exhaustion changes
 *
 * @author Jason (darkdiplomat)
 */
public final class FoodExhaustionHook extends Hook {

    private Player player;
    private float oldval, newval;

    /**
     * Constructs a new FoodExhaustionHook
     *
     * @param player
     *         the {@link Player} who's Food Exhaustion is changing
     * @param oldval
     *         the old (current) value
     * @param newval
     *         the new value
     */
    public FoodExhaustionHook(Player player, float oldval, float newval) {
        this.player = player;
        this.oldval = oldval;
        this.newval = newval;
    }

    /**
     * Gets the {@link Player} who's food exhaustion is changing
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the old (current) exhaustion level
     *
     * @return the old exhaustion level
     */
    public float getOldValue() {
        return oldval;
    }

    /**
     * Gets the new exhaustion level
     *
     * @return the new exhaustion level
     */
    public float getNewValue() {
        return newval;
    }

    /**
     * Sets the new value to actually be set
     *
     * @param value
     *         the Exhaustion level to set
     */
    public void setNewValue(float value) {
        this.newval = value;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Old Exhaustoin=%s, New Exhaustion=%s]", getHookName(), player, oldval, newval);
    }
}
