package net.canarymod.api;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.humanoid.Villager;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.nbt.CompoundTag;

/**
 * VillagerTrade wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface VillagerTrade {

    /**
     * Returns the first {@link Item} the {@link Player} must give to the {@link Villager}.
     *
     * @return the {@link Item} in slot 1
     */
    Item getBuyingOne();

    /**
     * Sets the first {@link Item} the {@link Player} must give to the {@link Villager}.
     *
     * @param item
     *         The {@link Item} to set
     */
    void setBuyingOne(Item item);

    /**
     * Returns the second {@link Item} the {@link Player} must give to the {@link Villager}.
     *
     * @return the {@link Item} in slot 2
     */
    Item getBuyingTwo();

    /**
     * Sets the second {@link Item} the {@link Player} must give to the {@link Villager}.
     *
     * @param item
     *         The {@link Item} to set
     */
    void setBuyingTwo(Item item);

    /**
     * Returns whether or not this trade requires the {@link Player} to give the {@link Villager} two items.
     *
     * @return {@code true} if the {@link Player} must give two items, {@code false} if the {@link Player} must give only one
     */
    boolean requiresTwoItems();

    /**
     * Returns the {@link Item} the {@link Player} receives from the trade.
     *
     * @return the {@link Item} selling
     */
    Item getSelling();

    /**
     * Sets the {@link Item} the {@link Player} receives from the trade.
     *
     * @param item
     *         the {@link Item} to set for selling
     */
    void setSelling(Item item);

    /**
     * Increase the number of times this was used by one.
     */
    void use();

    /**
     * Increases the maximum amount of times this trade can be used.
     * The default max is 7
     *
     * @param increase
     *         the amount to increase it buy
     */
    void increaseMaxUses(int increase);

    /**
     * Returns whether or not this recipe has exceeded its max usages and can no longer be used.
     *
     * @return {@code true} if used up; {@code false} if not
     */
    boolean isUsedUp();

    /**
     * Returns the data for this trade in an {@link CompoundTag}.
     *
     * @return the {@link CompoundTag}
     */
    CompoundTag getDataAsTag();

    /**
     * Reads the data from an {@link CompoundTag} into this trade
     *
     * @param tag
     *         the tag to read the data from
     */
    void readFromTag(CompoundTag tag);
}
