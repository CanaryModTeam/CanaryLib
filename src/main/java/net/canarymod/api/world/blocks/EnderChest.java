package net.canarymod.api.world.blocks;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Inventory;

/**
 * An EnderChest is not treated as a regular chest by extending Container<T>
 * as one block does not have an inventory attached. The inventory visible
 * to the player is attached to the player instead.
 *
 * @author Jos Kuijpers
 */
public interface EnderChest extends TileEntity {

    /**
     * Get this chests inventory
     *
     * @param player
     *         The player to get the ender inventory from
     *
     * @return EnderChest inventory
     */
    Inventory getInventory(Player player);
}
