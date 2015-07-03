package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;

import static net.canarymod.api.world.blocks.BlockType.Ladder;

/**
 * Ladder properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class LadderProperties extends BlockProperties {

    /**
     * Ladder facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace} (Excluding TOP & BOTTOM)
     */
    public static final BlockDirectionProperty facing = getInstanceFor(Ladder, "facing");

    /**
     * Applies a {@link net.canarymod.api.world.blocks.BlockFace} facing property to the {@code Ladder}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.BlockFace} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyFacing(Block block, BlockFace value) {
        return apply(block, facing, value);
    }
}
