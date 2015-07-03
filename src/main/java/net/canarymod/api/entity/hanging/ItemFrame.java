package net.canarymod.api.entity.hanging;

import net.canarymod.api.inventory.Item;

/**
 * Wraps an ItemFrame
 *
 * @author Jason (darkdiplomat)
 */
public interface ItemFrame extends HangingEntity {

    /**
     * Returns the item currently on this frame.
     *
     * @return the Item on the frame
     */
    Item getItemInFrame();

    /**
     * Sets the Item in this frame
     *
     * @param item
     *         the {@link Item} to attach to the frame
     */
    void setItemInFrame(Item item);

    /**
     * Return the rotation of the item currently on this frame.
     *
     * @return integer between 0 and 3
     */
    int getItemRotation();

    /**
     * Sets the rotation of the item currently on this frame
     *
     * @param rot
     *         An integer between 0 and 3
     */
    void setItemRotation(int rot);

    /**
     * Gets the chance for this item frame's item to drop from the frame.
     *
     * @return drop chance
     */
    float getItemDropChance();

    /**
     * Gets the chance for this item frame's item to drop from the frame.
     *
     * @param chance
     *         The chance for drop, float between 0.0 and 1.0
     */
    void setItemDropChance(float chance);
}
