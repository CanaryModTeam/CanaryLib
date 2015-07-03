package net.canarymod.api.entity.vehicle;

import net.canarymod.api.entity.Entity;

/**
 * Vehicle wrapper
 *
 * @author Chris (damagefilter)
 */
public interface Vehicle extends Entity {

    /**
     * Gets the entity inside this vehicle
     *
     * @return entity
     */
    Entity getPassenger();

    /**
     * Says whether or not this vehicle is a boat
     *
     * @return {@code true} if boat; {@code false} if not
     */
    boolean isBoat();

    /**
     * Says whether or not this vehicle is a minecart
     *
     * @return {@code true} if minecart; {@code false} if not
     */
    boolean isMinecart();

    /**
     * Check if this vehicle is empty.
     *
     * @return {@code true} if empty; {@code false} if not
     */
    boolean isEmpty();
}
