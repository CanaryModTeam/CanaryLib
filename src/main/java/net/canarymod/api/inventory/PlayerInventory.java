package net.canarymod.api.inventory;

/**
 * Player and NPC Inventory wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface PlayerInventory extends Inventory {

    /**
     * Gets the {@link Item} in the Helmet slot
     *
     * @return the helmet {@link Item} or {@code null}
     */
    Item getHelmetSlot();

    /**
     * Sets the Helmet slot
     *
     * @param item
     *         the {@link Item} to set
     */
    void setHelmetSlot(Item item);

    /**
     * Gets the {@link Item} in the Chestplate slot
     *
     * @return the Chestplate {@link Item} or {@code null}
     */
    Item getChestplateSlot();

    /**
     * Sets the Chestplate slot
     *
     * @param item
     *         the {@link Item} to set
     */
    void setChestPlateSlot(Item item);

    /**
     * Gets the {@link Item} in the Leggings slot
     *
     * @return the Leggins {@link Item} or {@code null}
     */
    Item getLeggingsSlot();

    /**
     * Sets the Leggings slot
     *
     * @param item
     *         the {@link Item} to set
     */
    void setLeggingsSlot(Item item);

    /**
     * Gets the {@link Item} in the Boots slot
     *
     * @return the Boots {@link Item} or {@code null}
     */
    Item getBootsSlot();

    /**
     * Sets the Boots slot
     *
     * @param item
     *         the {@link Item} to set
     */
    void setBootsSlot(Item item);

    /**
     * Gets the selected hotbar slot's id
     *
     * @return the selected hotbar slot's id
     */
    int getSelectedHotbarSlotId();

    /**
     * Gets the current {@link Item} in hand
     *
     * @return the {@link Item} in hand
     */
    Item getItemInHand();

    /**
     * Gets the current {@link Item} in offhand
     *
     * @return the {@link Item} in offhand
     */
    Item getItemInOffhand();

    /**
     * Gets the current {@link Item} on the cursor
     *
     * @return the {@link Item} in hand
     */
    Item getItemOnCursor();

    /**
     * Sets the Item on cursor
     *
     * @param item
     *         the {@link Item} to set
     */
    void setItemOnCursor(Item item);
}
