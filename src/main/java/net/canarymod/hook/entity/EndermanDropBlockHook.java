package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.monster.Enderman;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Enderman drop block hook. Contains information about an Enderman dropping a block.
 *
 * @author Jason (darkdiplomat)
 */
public final class EndermanDropBlockHook extends CancelableHook {

    private Enderman enderman;
    private Block block;

    /**
     * Constructs a new EndermanDropBlockHook
     *
     * @param enderman
     *         the {@link Enderman} dropping a block
     * @param block
     *         the {@link Block} being dropped on
     */
    public EndermanDropBlockHook(Enderman enderman, Block block) {
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
