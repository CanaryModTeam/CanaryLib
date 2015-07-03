package net.canarymod.hook.player;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.CraftingMatrix;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.recipes.Recipe;
import net.canarymod.hook.CancelableHook;

/**
 * Craft Hook
 * <p/>
 * Called when a matching crafting recipe if found for a {@link Player} crafting
 *
 * @author Jason (darkdiplomat)
 */
public final class CraftHook extends CancelableHook {
    private Player player;
    private CraftingMatrix craftingMatrix;
    private Item recipeResult;
    private Recipe match;

    /**
     * Creates a new CraftHook.
     *
     * @param player
     *         The crafting player.
     * @param craftingMatrix
     *         The crafting inventory used.
     * @param recipeResult
     *         The recipe's result.
     */
    public CraftHook(Player player, CraftingMatrix craftingMatrix, Item recipeResult) {
        this.player = player;
        this.craftingMatrix = craftingMatrix;
        this.recipeResult = recipeResult;
        for (Recipe recipe : Canary.getServer().getServerRecipes()) {
            if (recipe.matchesMatrix(craftingMatrix)) {
                match = recipe;
                break;
            }
        }
    }

    /**
     * Gets the crafting player.
     *
     * @return The crafting player.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the crafting inventory the player is working on.
     *
     * @return The crafting inventory the player is working on.
     */
    public CraftingMatrix getCraftingMatrix() {
        return this.craftingMatrix;
    }

    /**
     * Returns the recipe's result item.
     *
     * @return The recipe's result item.
     */
    public Item getRecipeResult() {
        return this.recipeResult;
    }

    /**
     * Sets the recipe's result.
     *
     * @param recipeResult
     *         The recipe's result.
     */
    public void setRecipeResult(Item recipeResult) {
        this.recipeResult = recipeResult;
    }

    /**
     * Gets the recipe that matches the matrix
     *
     * @return the matching {@link Recipe}
     */
    public Recipe getMatchingRecipe() {
        return match;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Matrix=%s, Recipe=%s, Result=%s]", getHookName(), player, craftingMatrix, match, recipeResult);
    }
}
