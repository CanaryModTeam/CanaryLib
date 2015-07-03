package net.canarymod.hook.world;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.hook.CancelableHook;

/**
 * Block update hook. Contains information about a block updating.
 *
 * @author Jason (darkdiplomat)
 */
public final class BlockUpdateHook extends CancelableHook {

    private Block block;
    private int newBlockId;
    private BlockType newBlockType;

    /**
     * @deprecated Use the other constructor instead
     */
    @Deprecated
    public BlockUpdateHook(Block block, int newBlockId) {
        this.block = block;
        this.newBlockId = newBlockId;
        this.newBlockType = BlockType.fromId(newBlockId);
    }

    public BlockUpdateHook(Block block, BlockType newBlockType) {
        this.block = block;
        this.newBlockType = newBlockType;
        this.newBlockId = newBlockType.getId();
    }

    /**
     * Gets {@link Block} updating
     *
     * @return The {@link Block} updated.
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Gets the block id of the new {@link Block}
     *
     * @return {@link Block} ID value.
     */
    public int getNewBlockId() {
        return newBlockId;
    }

    /**
     * Gets the block type of the new {@link Block}
     *
     * @return {@link net.canarymod.api.world.blocks.BlockType} type
     */
    public BlockType getNewBlockType() {
        return newBlockType;
    }

    @Override
    public final String toString() {
        return String.format("%s[Block=%s, New Block ID=%s]", getHookName(), block, newBlockId);
    }
}
