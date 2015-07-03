package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.DoubleRedSandstoneSlab;

/**
 * New Double Stone Slab properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class DoubleStoneSlabNewProperties extends StoneSlabNewProperties {

    /**
     * New Double Stone Slab seamless property, Values: true, false
     */
    public static final BlockBooleanProperty seamless = getInstanceFor(DoubleRedSandstoneSlab, "seamless");

    /**
     * Applies whether the {@code Stone Slab} is seamless or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applySeamless(Block block, boolean value) {
        return apply(block, seamless, value);
    }
}
