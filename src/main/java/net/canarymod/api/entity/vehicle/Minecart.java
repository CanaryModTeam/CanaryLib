package net.canarymod.api.entity.vehicle;

/**
 * Minecart wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Minecart extends Vehicle {

    /**
     * Says whether this Minecart is in reverse or not
     *
     * @return {@code true} if this Minecart is in Reverse; {@code false} if not
     */
    boolean isInReverse();

    /**
     * Sets the rolling amplitude the cart rolls while being attacked.
     *
     * @param amp
     *         the amplitude in which the cart rolls
     */
    void setRollingAmplitude(int amp);

    /**
     * Gets the rolling amplitude the cart rolls while being attacked.
     *
     * @return the rolling amplitude
     */
    int getRollingAmplitude();

    /**
     * Sets the rolling direction the cart rolls while being attacked. Can be 1 or -1.
     *
     * @param direction
     *         the direction in which the cart rolls
     */
    void setRollingDirection(int direction);

    /**
     * Gets the rolling direction the cart rolls while being attacked. Can be 1 or -1.
     *
     * @return the direction the cart rolls
     */
    int getRollingDirection();
}
