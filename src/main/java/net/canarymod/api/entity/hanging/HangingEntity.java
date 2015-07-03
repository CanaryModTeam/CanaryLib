package net.canarymod.api.entity.hanging;

import net.canarymod.api.entity.Entity;

/**
 * HangingEntity wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface HangingEntity extends Entity {

    /**
     * Gets the hanging direction of the HangingEntity
     *
     * @return {@code 0} for SOUTH; {@code 1} for WEST; {@code 2} for NORTH; {@code 3} for EAST
     */
    int getHangingDirection();

    /**
     * Sets the hanging direction of the HangingEntity
     *
     * @param direction
     *         {@code 0} for SOUTH; {@code 1} for WEST; {@code 2} for NORTH; {@code 3} for EAST
     */
    void setHangingDirection(int direction);

    /**
     * Checks whether the HangingEntity is on a valid surface
     *
     * @return {@code true} if valid; {@code false} if not
     */
    boolean isOnValidSurface();

    /**
     * Gets the current ticks the counter is at.<br>
     * When the counter reaches 100, validity checks are run.
     *
     * @return the current counter tick
     */
    int getTickCounter();

    /**
     * Sets the current ticks the counter is at.
     *
     * @param ticks
     *         the current ticks
     */
    void setTickCounter(int ticks);
}
