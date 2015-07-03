package net.canarymod.api.entity;

import net.canarymod.api.inventory.Item;

/**
 * EntityItem wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface EntityItem extends Entity {

    /**
     * Set items age.<br>
     * When age is greater than or equal to 6000, the entity is destroyed.
     *
     * @param age
     *         the age to set
     */
    void setAge(short age);

    /**
     * Get item's age.<br>
     * When age is greater than or equal to 6000, the entity is destroyed.
     *
     * @return age
     * the age of the item.
     */
    short getAge();

    /**
     * Gets the ticks before allowing to be picked up.<br>
     * When this equals 0, it can be picked up.<br>
     * If below 0, it can never be picked up.
     *
     * @return the ticks before pickup
     */
    int getPickUpDelay();

    /**
     * Sets the ticks before allowing to be picked up.<br>
     * If set below 0, pick up is never allowed.<br>
     *
     * @param delay
     *         the ticks before allowing pickup or -1 for never pickup
     */
    void setPickUpDelay(int delay);

    /**
     * Gets the health of the Item.<br>
     * Used to specify what damages cause the item to be destroyed.<br>
     * Health is limited to a max of 255
     *
     * @return the health
     */
    short getHealth();

    /**
     * Sets the health of the Item.<br>
     * Health is limited to a max of 255
     *
     * @param health
     *         the item health
     */
    void setHealth(short health);

    /**
     * Get the Item attached to the EntityItem.
     *
     * @return {@link Item}
     */
    Item getItem();

    /**
     * Sets the Item attached to the EntityItem)
     *
     * @param item
     *         the Item to attach
     */
    void setItem(Item item);

    /**
     * Returns the owner of this item.
     * Only the owner of an item can pick it up.
     *
     * @return The name of the owner this item's owner
     */
    String getOwner();

    /**
     * Sets the owner of this item.
     * Only the owner of an item can pick it up.
     *
     * @param owner
     *         The name of this item's new owner, or {@code null} to unset
     *         the owner
     */
    void setOwner(String owner);

    /**
     * Returns the thrower of this item.
     * This is the name of the player who dropped this item.
     * Used for the "Diamonds to you!" achievement.
     *
     * @return The name of this item's thrower
     */
    String getThrower();

    /**
     * Sets the thrower of this item.
     * This is the name of the player who dropped this item.
     * Used for the "Diamonds to you!" achievement.
     *
     * @param thrower
     *         The name of this item's new thrower, or {@code null} to
     *         unset the thrower
     */
    void setThrower(String thrower);
}
