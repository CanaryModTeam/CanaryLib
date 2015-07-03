package net.canarymod.api.entity.living.humanoid;

/**
 * HumanCapabilities wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface HumanCapabilities {

    /**
     * Checks if the {@link Human} is invulnerable
     *
     * @return {@code true} if invulnerable; {@code false} if not
     */
    boolean isInvulnerable();

    /**
     * Sets if the {@link Human} is invulnerable
     *
     * @param invulnerable
     *         {@code true} if invulnerable; {@code false} if not
     */
    void setInvulnerable(boolean invulnerable);

    /**
     * Checks if the {@link Human} is flying
     *
     * @return {@code true} if flying; {@code false} if not
     */
    boolean isFlying();

    /**
     * Sets if the {@link Human} is flying
     *
     * @param flying
     *         {@code true} if flying; {@code false} if not
     */
    void setFlying(boolean flying);

    /**
     * Checks if the {@link Human} may fly
     *
     * @return {@code true} if may fly; {@code false} if not
     */
    boolean mayFly();

    /**
     * Sets if the {@link Human} may fly
     *
     * @param mayfly
     *         {@code true} if may fly; {@code false} if not
     */
    void setMayFly(boolean mayfly);

    /**
     * Checks if the {@link Human} can instant build
     *
     * @return {@code true} if can instant build; {@code false} if not
     */
    boolean instantBuild();

    /**
     * Sets if the {@link Human} can instant build
     *
     * @param instant
     *         {@code true} if can instant build; {@code false} if not
     */
    void setInstantBuild(boolean instant);

    /**
     * Gets the flying speed of the {@link Human}
     *
     * @return flying speed
     */
    float getFlySpeed();

    /**
     * Sets the walking speed of the {@link Human}
     *
     * @param speed
     *         the flying speed to set
     */
    void setFlySpeed(float speed);

    /**
     * Gets the walking speed of the {@link Human}
     *
     * @return walking speed
     */
    float getWalkSpeed();

    /**
     * Sets the walking speed of the {@link Human}
     *
     * @param speed
     *         the walking speed to set
     */
    void setWalkSpeed(float speed);
}
