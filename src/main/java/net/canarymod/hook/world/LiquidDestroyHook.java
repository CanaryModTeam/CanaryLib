package net.canarymod.hook.world;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a liquid is about to destroy something (crops, popping off torches etc)
 *
 * @author Chris (damagefilter)
 */
public final class LiquidDestroyHook extends CancelableHook {

    private Block block;
    private final BlockType liquidType;
    private boolean forceDestroy = false;

    @Deprecated
    public LiquidDestroyHook(Block block) {
        this.block = block;
        this.liquidType = null;
    }

    public LiquidDestroyHook(BlockType liquidType, Block toDestroy) {
        this.liquidType = liquidType;
        this.block = toDestroy;
    }

    /**
     * Get the block that would be destroyed by the liquid flow
     *
     * @return the {@link Block}
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Returns the {@link BlockType} of the liquid.
     * Always returns the Flowing variant.
     *
     * @return The liquid's {@link BlockType}
     */
    public BlockType getLiquidType() {
        return liquidType;
    }

    /**
     * Check if the block in question will be destroyed regardless of what it is.
     *
     * @return {@code true} if force destroy
     */
    public boolean isForceDestroy() {
        return forceDestroy;
    }

    /**
     * Set this to true to force the block to be destroyed.
     * This will not work if the hook is canceled already!
     *
     * @param forceDestroy
     *         {@code true} for force destroy
     */
    public void setForceDestroy(boolean forceDestroy) {
        this.forceDestroy = forceDestroy;
    }

    @Override
    public final String toString() {
        return String.format("%s[Block=%s, Force Destroy=%s]", getHookName(), block, forceDestroy);
    }
}
