package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;

/**
 * Health Change hook
 *
 * @author Jason (darkdiplomat)
 */
public final class HealthChangeHook extends CancelableHook {
    private Player player;
    private float oldVal, newVal;

    /**
     * Constructs a new HealthChange hook
     *
     * @param player
     *         the {@link Player} who's health is changing
     * @param oldVal
     *         the old health value
     * @param newVal
     *         the new health value
     */
    public HealthChangeHook(Player player, float oldVal, float newVal) {
        this.player = player;
        this.oldVal = oldVal;
        this.newVal = newVal;
    }

    /**
     * Gets the {@link Player} who's health is changing
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the old Health value
     *
     * @return old value
     */
    public float getOldValue() {
        return oldVal;
    }

    /**
     * Gets the new Health value
     *
     * @return new value
     */
    public float getNewValue() {
        return newVal;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Old Health=%s, New Health=%s]", getHookName(), player, oldVal, newVal);
    }
}
