package net.canarymod.api.entity.vehicle;

/**
 * Boat Wrapper
 *
 * @author Chris (damagefilter)
 */
public interface Boat extends Vehicle {

    /**
     * Gets the direction that the vehicle is moving
     *
     * @return forward direction
     */
    int getForwardDirection();

    /**
     * Sets the direction that the vehicle is moving
     *
     * @param direction
     *         the forward direction (0,1,2,3)
     */
    void setForwardDirection(int direction);
}
