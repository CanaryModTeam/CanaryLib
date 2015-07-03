package net.canarymod.hook.entity;

import net.canarymod.api.entity.vehicle.Vehicle;
import net.canarymod.api.world.position.Vector3D;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a LivingEntity moves a vehicle
 *
 * @author Chris (damagefilter)
 */
public final class VehicleMoveHook extends CancelableHook {
    private Vehicle vehicle;
    private Vector3D from, to;

    public VehicleMoveHook(Vehicle vehicle, Vector3D from, Vector3D to) {
        this.vehicle = vehicle;
        this.from = from;
        this.to = to;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @return the from
     */
    public Vector3D getFrom() {
        return from;
    }

    /**
     * @return the to
     */
    public Vector3D getTo() {
        return to;
    }

    /**
     * Override this vehicles target position
     *
     * @param to
     *         the to to set
     */
    public void setTo(Vector3D to) {
        this.to = to;
    }

    @Override
    public final String toString() {
        return String.format("%s[Vehicle=%s, VectorFrom=%s, VectorTo=%s]", getHookName(), vehicle, from, to);
    }
}
