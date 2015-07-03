package net.canarymod.api.inventory;

import net.canarymod.api.entity.living.humanoid.Human;

/**
 * Enderchest inventory interface
 *
 * @author Jos Kuijpers
 */
public interface EnderChestInventory extends Inventory {

    /**
     * Get the owner of this ender chest inventory
     *
     * @return {@link Human} owner (NPC or Player)
     */
    Human getInventoryOwner();
}
