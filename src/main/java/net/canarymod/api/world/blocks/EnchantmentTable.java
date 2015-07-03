package net.canarymod.api.world.blocks;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Inventory;

/**
 * EnchantmentTable wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface EnchantmentTable extends TileEntity, Inventory {

    /**
     * Enchants the item and subtracts the XP from the player.
     *
     * @param player
     *         The {@link Player} to subract XP from
     * @param slot
     *         The slot the player would've clicked. Range: 0-2
     *
     * @return false when <tt>player</tt> doesn't have enough XP.
     *
     * @see #getEnchantLevels() to see which slot has which level.
     * @see Player#getExperience() For checking XP levels.
     */
    boolean enchantItem(Player player, int slot);

    /**
     * Gets the levels as displayed in the GUI.
     * The upper slot has index 0.
     *
     * @return an int[3] containing the levels of the slots
     */
    int[] getEnchantLevels();

    /**
     * Gets the number of Bookshelves that are validly in range of the Enchantment Table
     *
     * @return the number of nearby Bookshelves
     */
    int getNumBookshelves();

    /**
     * Gets the Bookshelves that are validly in range of the Enchantment Table
     *
     * @return an array of nearby Bookshelves
     */
    Block[] getBookshelves();
}
