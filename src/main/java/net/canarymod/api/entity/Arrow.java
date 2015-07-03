package net.canarymod.api.entity;

/**
 * Arrow wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Arrow extends Entity, Projectile {

    /**
     * Returns true if this Arrow can be retrieved by a Player
     *
     * @return {@code true} if it can be retrieved; {@code false} if not
     */
    boolean canPickUp();

    /**
     * Sets whether this Arrow can be retrieved by a Player
     *
     * @param canPickUp
     *         {@code true} if it can be retrieved; {@code false} if not
     */
    void setCanPickUp(boolean canPickUp);

    /**
     * Gets the amount of damage the Arrow can do
     *
     * @return the damage, default of 2.0
     */
    double getDamage();

    /**
     * Sets the amount of damage the Arrow can do
     *
     * @param damage
     *         the amount of damage
     */
    void setDamage(double damage);

    /**
     * Gets if this Arrow is to cause Critical damage or not
     *
     * @return {@code true} if critical; {@code false} if not
     */
    boolean isCritical();

    /**
     * Sets whether this Arrow will be critical or not
     *
     * @param critical
     *         {@code true} if critical; {@code false} if not
     */
    void setIsCritical(boolean critical);

    /**
     * Gets the Entity that owns the Arrow
     *
     * @return the Entity that owns the Arrow
     */
    Entity getOwner();

    /**
     * Gets if the Arrow is in the ground or in the air
     *
     * @return {@code true} if in ground; {@code false} if in air
     */
    boolean isInGround();

    /**
     * Gets the number of ticks the Arrow has been in the air
     *
     * @return the tick in air
     */
    int getTicksInAir();

    /**
     * Gets the number of ticks the Arrow has been in the ground
     *
     * @return the tick in ground
     */
    int getTicksInGround();

    int getKnockbackStrength();

    void setKnockbackStrenth(int knockback);
}
