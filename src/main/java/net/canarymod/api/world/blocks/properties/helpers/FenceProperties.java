package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.Fence;

/**
 * Fence properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class FenceProperties extends BlockProperties {

    /**
     * Fence north property, Values: true, false
     */
    public static final BlockBooleanProperty north = getInstanceFor(Fence, "north");

    /**
     * Fence east property, Values: true, false
     */
    public static final BlockBooleanProperty east = getInstanceFor(Fence, "east");

    /**
     * Fence south property, Values: true, false
     */
    public static final BlockBooleanProperty south = getInstanceFor(Fence, "south");

    /**
     * Fence west property, Values: true, false
     */
    public static final BlockBooleanProperty west = getInstanceFor(Fence, "west");

    /**
     * Applies whether the {@code Fence} is connected north or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyNorth(Block block, boolean value) {
        return apply(block, north, value);
    }

    /**
     * Applies whether the {@code Fence} is connected east or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyEast(Block block, boolean value) {
        return apply(block, east, value);
    }

    /**
     * Applies whether the {@code Fence} is connected south or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applySouth(Block block, boolean value) {
        return apply(block, south, value);
    }

    /**
     * Applies whether the {@code Fence} is connected west or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyWest(Block block, boolean value) {
        return apply(block, west, value);
    }
}
