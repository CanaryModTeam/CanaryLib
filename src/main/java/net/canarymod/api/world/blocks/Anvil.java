package net.canarymod.api.world.blocks;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.Item;

/**
 * Interface for Anvil Wrapper
 *
 * @author Somners
 */
public interface Anvil extends TileEntity, Inventory {

    /**
     * Get the name this tool will be set to.
     *
     * @return The tool name.
     */
    String getToolName();

    /**
     * Set the name this tool will be set to.
     *
     * @param name
     *         The name to set.
     */
    void setToolName(String name);

    /**
     * Get the item that is to be produced.
     *
     * @return The Item
     */
    Item getResult();

    /**
     * Set the item that is to be produced.
     *
     * @param item
     *         Item to set.
     */
    void setResult(Item item);

    /**
     * Returns the cost of the repair/rename in XP levels.
     *
     * @return xp cost
     */
    int getXPCost();

    /**
     * Sets the cost of the repair/rename in XP levels.
     *
     * @param level
     *         The XP level the repair/rename should cost.
     */
    void setXPCost(int level);

    /**
     * Get the player who has this Anvil open.
     *
     * @return The player using this Anvil.
     */
    Player getPlayer();
}
