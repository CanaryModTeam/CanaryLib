package net.canarymod.hook.entity;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.vehicle.Vehicle;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a vehicle collides with a LivingEntity
 *
 * @author Chris (damagefilter)
 */
public final class VehicleCollisionHook extends CancelableHook {
    private Vehicle vehicle;
    private Entity collisioner;

    /**
     * Constructs a Collision hook.
     *
     * @param vehicle
     * @param entity
     *         entity that got hit by a vehicle
     */
    public VehicleCollisionHook(Vehicle vehicle, Entity entity) {
        this.vehicle = vehicle;
        this.collisioner = entity;
    }

    /**
     * Get the {@link Vehicle} that caused the collision
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Get the {@link EntityLiving} that got hit by the vehicle
     *
     * @return the enteringEntity
     */
    public Entity getEntity() {
        return collisioner;
    }

    @Override
    public final String toString() {
        return String.format("%s[Vehicle=%s, Entity=%s]", getHookName(), vehicle, collisioner);
    }
}
