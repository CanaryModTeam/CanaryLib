package net.canarymod.api.entity;

/**
 * Interface for manipulating Explosive devices
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public interface Explosive {

    /**
     * Sets whether the explosion can damage the world: blocks
     *
     * @param canDamage
     *         {@code true} if can damage entities; {@code false} if not
     */
    void setCanDamageWorld(boolean canDamage);

    /**
     * Gets whether the explosion can damage the world
     *
     * @return {@code true} if can damage world; {@code false} if not
     */
    boolean canDamageWorld();

    /**
     * Sets whether the explosion can damage entities
     *
     * @param canDamage
     *         {@code true} if can damage entities; {@code false} if not
     */
    void setCanDamageEntities(boolean canDamage);

    /**
     * Gets whether the explosion can damage entities
     *
     * @return {@code true} if can damage entities; {@code false} if not
     */
    boolean canDamageEntities();

    /**
     * Gets the power level of the explosion
     *
     * @return power level
     */
    float getPower();

    /**
     * Sets the power level of the explosion
     *
     * @param power
     *         the power level of the explosion
     */
    void setPower(float power);

    /**
     * Gets the 'length' of the fuse
     *
     * @return the ticks before the fuse is expired
     */
    int getFuse();

    /**
     * Sets the 'length' of the fuse
     *
     * @param fuse
     *         the amount of ticks to set the fuse to
     */
    void setFuse(int fuse);

    /**
     * Increases the fuse length
     *
     * @param increase
     *         the amount of ticks to increase the fuse by
     */
    void increaseFuse(int increase);

    /**
     * Decreases the fuse length
     *
     * @param decrease
     *         the amount of ticks to decrease the fuse by
     */
    void decreaseFuse(int decrease);

    /**
     * Detonates this entity
     */
    void detonate();
}
