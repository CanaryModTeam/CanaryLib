package net.canarymod.api.world.blocks;

import net.canarymod.api.entity.Entity;

/**
 * Dispenser interface
 *
 * @author Jason (darkdiplomat)
 */
public interface Dispenser extends LockableTileEntity {

    /**
     * Activate the dispenser: spawns an item from a random slot.
     *
     * @return the entity spawned
     */
    Entity activate();

    /**
     * Dispense the item from the given slot.
     *
     * @param slot
     *         the slot to dispend from
     *
     * @return the entity spawned
     */
    Entity dispenseFromSlot(int slot);
}
