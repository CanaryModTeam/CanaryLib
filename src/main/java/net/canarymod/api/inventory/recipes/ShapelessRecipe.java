package net.canarymod.api.inventory.recipes;

import net.canarymod.api.inventory.Item;

import java.util.List;

/**
 * ShapelessRecipes wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface ShapelessRecipe extends Recipe {

    /**
     * Gets a list of {@link Item} that make up this recipe
     *
     * @return a list of {@link Item}
     */
    List<Item> getRecipeItems();
}
