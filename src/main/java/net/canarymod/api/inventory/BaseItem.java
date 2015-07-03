package net.canarymod.api.inventory;

/**
 * Base Item to retrieve Item statistics
 *
 * @author Chris (damagefilter)
 */
public interface BaseItem {

    /**
     * Get the maximum Stack size for this item
     *
     * @return max stack size
     */
    int getMaxStackSize();

    /**
     * Return the amount of damage this item can take before it breaks
     *
     * @return max damage
     */
    int getMaxDamage();

    /**
     * Set the max amount of damage this item can take before it breaks
     *
     * @param damage
     *         the damage max to set
     */
    void setMaxDamage(int damage);

    /**
     * Check if this item is damageable
     *
     * @return {@code true} if damageable; {@code false} if not
     */
    boolean isDamageable();
}
