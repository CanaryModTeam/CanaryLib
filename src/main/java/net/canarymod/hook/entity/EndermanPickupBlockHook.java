package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.monster.Enderman;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Enderman pick up block hook. Contains information about an Enderman picking up a block
 *
 * @author Jason (darkdiplomat)
 */
public final class EndermanPickupBlockHook extends CancelableHook {

    private Enderman enderman;
    private Block block;

    /**
     * Constructs a new EndermanPickUpBlockHook
     *
     * @param enderman
     *         the {@link Enderman} picking up a block
     * @param block
     *         the {@link Block} being picked up
     */
    public EndermanPickupBlockHook(Enderman enderman, Block block) {
        this.enderman = enderman;
        this.block = block;
    }

    /**
     * Gets the {@link Enderman}
     *
     * @return the {@link Enderman}
     */
    public Enderman getEnderman() {
        return enderman;
    }

    /**
     * Gets the {@link Block}
     *
     * @return the {@link Block}
     */
    public Block getBlock() {
        return block;
    }

    @Override
    public final String toString() {
        return String.format("%s[Enderman=%s, Block=%s]", getHookName(), enderman, block);
    }
}
