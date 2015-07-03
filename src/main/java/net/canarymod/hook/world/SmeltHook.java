package net.canarymod.hook.world;

import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.blocks.Furnace;
import net.canarymod.hook.CancelableHook;

/**
 * SmeltHook
 * <p/>
 * Called when a {@link Furnace} smelts an Item
 *
 * @author Jason (darkdiplomat)
 */
public final class SmeltHook extends CancelableHook {
    private Furnace furnace;
    private Item smelted, result;

    /**
     * Constructs a new SmeltHook
     *
     * @param furnace
     *         the {@link Furnace} doing the smelting
     * @param smelted
     *         the {@link Item} that was smelted
     * @param result
     *         the {@link Item} result
     */
    public SmeltHook(Furnace furnace, Item smelted, Item result) {
        this.furnace = furnace;
        this.smelted = smelted;
        this.result = result;
    }

    /**
     * Gets the {@link Furnace} doing the smelting
     *
     * @return the {@link Furnace}
     */
    public Furnace getFurnace() {
        return furnace;
    }

    /**
     * Gets the {@link Item} that was smelted
     *
     * @return the {@link Item} smelted
     */
    public Item getSmelted() {
        return smelted;
    }

    /**
     * Gets the {@link Item} result
     *
     * @return the {@link Item}
     */
    public Item getResult() {
        return result;
    }

    @Override
    public final String toString() {
        return String.format("%s[Furnace=%s, Smelted=%s, Result=%s]", getHookName(), furnace, smelted, result);
    }
}
