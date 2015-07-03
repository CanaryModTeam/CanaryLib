package net.canarymod.api.entity.living.monster;

/**
 * Silverfish wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Silverfish extends EntityMob {

    /**
     * Gets the ticks before calling allies
     *
     * @return the ticks before calling allies
     */
    int getAllySummonCooldown();

    /**
     * Sets the ticks before calling allies
     *
     * @param cooldown
     *         the ticks before calling allies
     */
    void setAllySummonCooldown(int cooldown);
}
