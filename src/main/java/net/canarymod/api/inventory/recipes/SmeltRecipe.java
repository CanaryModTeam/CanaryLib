package net.canarymod.api.inventory.recipes;

import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;

/**
 * Smelting recipe helper
 *
 * @author Jason (darkdiplomat)
 */
public final class SmeltRecipe {
    private Item result;
    private int from;
    private float xp;

    /**
     * Constructs a new SmeltRecipe with no xp gain
     *
     * @param from
     *         the {@link Item} to smelt
     * @param result
     *         the {@link Item} result
     */
    public SmeltRecipe(Item from, Item result) {
        this(from, result, 0.0F);
    }

    /**
     * Constructs a new SmeltRecipe with no xp gain
     *
     * @param from
     *         the {@link ItemType} to smelt
     * @param result
     *         the {@link Item} result
     */
    public SmeltRecipe(ItemType from, Item result) {
        this(from.getId(), result, 0.0F);
    }

    /**
     * Constructs a new SmeltRecipe with no xp gain
     *
     * @param from
     *         the Item ID to smelt
     * @param result
     *         the {@link Item} result
     */
    public SmeltRecipe(int from, Item result) {
        this(from, result, 0.0F);
    }

    /**
     * Constructs a new SmeltRecipe
     *
     * @param from
     *         the {@link Item} to smelt
     * @param result
     *         the {@link Item} result
     * @param xp
     *         the xp to give for smelting
     */
    public SmeltRecipe(Item from, Item result, float xp) {
        this(from.getId(), result, xp);
    }

    /**
     * Constructs a new SmeltRecipe
     *
     * @param from
     *         the {@link ItemType} to smelt
     * @param result
     *         the {@link Item} result
     * @param xp
     *         the xp to give for smelting
     */
    public SmeltRecipe(ItemType from, Item result, float xp) {
        this(from.getId(), result, xp);
    }

    /**
     * Constructs a new SmeltRecipe
     *
     * @param id
     *         the Item ID to smelt
     * @param result
     *         the {@link Item} result
     * @param xp
     *         the xp to give for smelting
     */
    public SmeltRecipe(int id, Item result, float xp) {
        this.from = id;
        this.result = result;
        this.xp = xp;
    }

    /**
     * Gets the Item ID to smelt
     *
     * @return the Item ID to smelt
     */
    public int getItemIDFrom() {
        return from;
    }

    /**
     * Gets the {@link Item} result
     *
     * @return the {@link Item} result
     */
    public Item getResult() {
        return result;
    }

    /**
     * Gets the XP given for smelting
     *
     * @return the xp
     */
    public float getXP() {
        return xp;
    }
}
