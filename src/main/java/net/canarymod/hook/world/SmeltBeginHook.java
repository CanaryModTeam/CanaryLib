package net.canarymod.hook.world;

import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.blocks.Furnace;
import net.canarymod.hook.CancelableHook;

/**
 * SmeltBeginHook
 * <p/>
 * Called when a {@link net.canarymod.api.world.blocks.Furnace} begins to smelts an Item
 *
 * @author Jason (darkdiplomat)
 */
public final class SmeltBeginHook extends CancelableHook {
    private Furnace furnace;
    private Item smelting;

    /**
     * Constructs a new SmeltHook
     *
     * @param furnace
     *         the {@link net.canarymod.api.world.blocks.Furnace} doing the smelting
     * @param smelting
     *         the {@link net.canarymod.api.inventory.Item} being smelted
     */
    public SmeltBeginHook(Furnace furnace, Item smelting) {
        this.furnace = furnace;
        this.smelting = smelting;
    }

    /**
     * Gets the {@link net.canarymod.api.world.blocks.Furnace} doing the smelting
     *
     * @return the {@link net.canarymod.api.world.blocks.Furnace}
     */
    public Furnace getFurnace() {
        return furnace;
    }

    /**
     * Gets the {@link net.canarymod.api.inventory.Item} smelting
     *
     * @return the {@link net.canarymod.api.inventory.Item}
     */
    public Item getSmelting() {
        return smelting;
    }

    @Override
    public final String toString() {
        return String.format("%s[Furnace=%s, Item=%s]", getHookName(), furnace, smelting);
    }
}
