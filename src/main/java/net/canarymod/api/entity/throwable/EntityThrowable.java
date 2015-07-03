package net.canarymod.api.entity.throwable;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.Projectile;
import net.canarymod.api.entity.living.LivingBase;

/**
 * Throwable interface
 *
 * @author Jason (darkdiplomat)
 */
public interface EntityThrowable extends Entity, Projectile {

    /**
     * Gets the LivingBase that threw the Throwable
     *
     * @return the LivingBase that threw the Throwable
     */
    LivingBase getThrower();

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     *
     * @return gravity
     * the amount of gravity applied
     */
    float getGravity();

    /**
     * Sets the amount of gravity to apply to the thrown entity with each tick.
     *
     * @param velocity
     *         the amount of gravity to apply
     */
    void setGravity(float velocity);
}
