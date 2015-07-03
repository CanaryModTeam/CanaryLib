package net.canarymod.api.world.blocks;

import net.canarymod.api.inventory.Inventory;

/**
 * Chest interface
 *
 * @author Chris (damagefilter)
 */
public interface Chest extends LockableTileEntity, Inventory {

    /**
     * Check if this chest has an attached chest (is a double chest)
     *
     * @return {@code true} if attached chest; {@code false} if not
     */
    boolean hasAttachedChest();

    /**
     * Gets the DoubleChest that results from this chest and its attached chest.
     * Returns null if there is no attached chest
     *
     * @return {@link DoubleChest} if found; {@code null} if not
     */
    DoubleChest getDoubleChest();
}
