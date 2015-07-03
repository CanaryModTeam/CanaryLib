package net.canarymod.api.entity.living.animal;

import net.canarymod.api.entity.living.Ageable;
import net.canarymod.api.entity.vehicle.AnimalVehicle;

/**
 * Pig wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Pig extends AnimalVehicle, Ageable {

    /**
     * Gets whether the Pig has a saddle or not
     *
     * @return {@code true} if saddled; {@code false} if not
     */
    boolean isSaddled();

    /**
     * Sets whether the Pig has a saddle or not
     *
     * @param saddle
     *         {@code true} for saddled; {@code false} for not saddled
     */
    void setSaddled(boolean saddle);
}
