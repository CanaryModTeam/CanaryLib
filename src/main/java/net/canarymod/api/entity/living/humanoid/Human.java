package net.canarymod.api.entity.living.humanoid;

import net.canarymod.api.entity.EntityItem;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.PlayerInventory;

/**
 * Human interface
 * Shared methods between Players and NPCs
 *
 * @author Jason (darkdiplomat)
 */
public interface Human extends LivingBase {

    /**
     * Gets the Player's name displayed to others
     *
     * @return Player's display name
     */
    String getDisplayName();

    /**
     * Sets the Player's name display name
     *
     * @param display
     *         the name to have the Player display
     */
    void setDisplayName(String display);

    /**
     * Destroys the current item in hand
     */
    void destroyItemHeld();

    /**
     * Returns the item that is currently in the players hands
     *
     * @return item held
     */
    Item getItemHeld();

    /**
     * Make this player drop an item.
     *
     * @param item
     *         the {@link Item} to drop
     */
    void dropItem(Item item);

    /**
     * Get player inventory
     *
     * @return inventory
     */
    PlayerInventory getInventory();

    /**
     * Drop all of this players inventory
     *
     * @return {@link EntityItem} array of dropped items
     */
    EntityItem[] dropInventory();

    /**
     * Give the player the item
     *
     * @param item
     *         the {@link Item} to give
     */
    void giveItem(Item item);

    /**
     * Return the color for this players name
     *
     * @return prefix
     */
    String getPrefix();

    /**
     * Set this players name color and prefix
     *
     * @param prefix
     *         the prefix string to set
     */
    void setPrefix(String prefix);

    /**
     * If this player is blocking (with a sword)
     *
     * @return {@code true} if blocking; {@code false} otherwise
     */
    boolean isBlocking();

    /**
     * If this player is shooting (with a bow)
     *
     * @return {@code true} if shooting; {@code false} otherwise
     */
    boolean isShooting();

    /**
     * Gets the Capabilities of the Human entity (such as flying and invulnerability)
     *
     * @return the {@link HumanCapabilities}
     */
    HumanCapabilities getCapabilities();

    /**
     * Checks if the Human is sleeping.
     *
     * @return {@code true} if sleeping; {@code false} if not
     */
    boolean isSleeping();

    /**
     * Checks if the Human is in a deep sleep.
     *
     * @return {@code true} if deeply sleeping; {@code false} if not
     */
    boolean isDeeplySleeping();

    /**
     * Checks if the Human has insomnia. (Sleep checks ignored)
     *
     * @return {@code true} if suffers from insomnia; {@code false} if not
     */
    boolean isSleepingIgnored();

    /**
     * Sets whether the Human has insomnia or not (Sleep checks ignored)
     *
     * @param ignored
     *         {@code true} for suffers from insomnia; {@code false} for not
     */
    void setSleepingIgnored(boolean ignored);

    /**
     * Gets whether the Human is using an Item (like Eating)
     *
     * @return {@code true} if using an {@link net.canarymod.api.inventory.Item}; {@code false} if not
     */
    boolean isUsingItem();

    /**
     * Gets the {@link net.canarymod.api.inventory.Item} currently in use
     *
     * @return item in use or {@code null} if not using an item
     */
    Item getItemInUse();
}
