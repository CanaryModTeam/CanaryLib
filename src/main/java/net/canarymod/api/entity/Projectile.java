package net.canarymod.api.entity;

/**
 * Projectile wrapper
 *
 * @author Larry (Larry1123)
 */
public interface Projectile extends Entity {

    /**
     * Sets the Motion of a Projectile and Rotation
     *
     * @param motionX
     *         the X-wise motion
     * @param motionY
     *         the Y-wise motion
     * @param motionZ
     *         the Z-wise motion
     * @param rotationYaw
     *         the Y-rotation
     * @param rotationPitch
     *         the X-rotation
     */
    void setProjectileHeading(double motionX, double motionY, double motionZ, float rotationYaw, float rotationPitch);
}
