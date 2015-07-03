package net.canarymod.api.entity.living.monster;

/**
 * Ghast wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface Ghast extends EntityMob {

    /**
     * Gets the ticks before the Ghast will change course
     *
     * @return the ticks before course change
     */
    int getCourseChangeCooldown();

    /**
     * Sets the ticks before the Ghast will change course
     *
     * @param cooldown
     *         the ticks before course change
     */
    void setCourseChangeCooldown(int cooldown);

    /**
     * Gets the x coordinate of the target waypoint
     *
     * @return the x coordinate of the target waypoint
     */
    double getWaypointX();

    /**
     * Sets the x coordinate of the target waypoint
     *
     * @param waypointX
     *         the x coordinate of the target waypoint
     */
    void setWaypointX(double waypointX);

    /**
     * Gets the y coordinate of the target waypoint
     *
     * @return the y coordinate of the target waypoint
     */
    double getWaypointY();

    /**
     * Sets the y coordinate of the target waypoint
     *
     * @param waypointY
     *         the y coordinate of the target waypoint
     */
    void setWaypointY(double waypointY);

    /**
     * Gets the z coordinate of the target waypoint
     *
     * @return the z coordinate of the target waypoint
     */
    double getWaypointZ();

    /**
     * Sets the z coordinate of the target waypoint
     *
     * @param waypointZ
     *         the z coordinate of the target waypoint
     */
    void setWaypointZ(double waypointZ);

    /**
     * Gets the ticks before looking for a new target
     *
     * @return the ticks before looking for a new target
     */
    int getArgoCooldown();

    /**
     * Sets the ticks before looking for a new target
     *
     * @param ticks
     *         the ticks before looking for a new target
     */
    void setArgoCooldown(int ticks);
}
