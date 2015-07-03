package net.canarymod.api.inventory;

import net.canarymod.api.entity.living.animal.EntityAnimal;

/**
 * Animal Inventory wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface AnimalInventory extends Inventory {

    /**
     * Gets the {@link EntityAnimal} that the inventory is for
     *
     * @return the {@link EntityAnimal} owner
     */
    EntityAnimal getOwner();
}
