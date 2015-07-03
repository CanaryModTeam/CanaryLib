package net.canarymod.api.inventory.recipes;

import net.canarymod.api.inventory.Item;

/**
 * ShapedRecipes wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface ShapedRecipe extends Recipe {

    /**
     * Gets the width of the Recipe
     *
     * @return the recipe width
     */
    int getWidth();

    /**
     * Gets the height of the Recipe
     *
     * @return the recipe height
     */
    int getHeight();

    /**
     * Gets the {@link Item}s that make up the recipe.<br>
     * Index are left to right, top to bottom and do not specify actual shape of the recipe
     *
     * @return an array of {@link Item}
     */
    Item[] getRecipeItems();
}
