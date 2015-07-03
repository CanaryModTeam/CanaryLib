package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.StoneSlab;

/**
 * Slab properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public abstract class SlabProperties extends BlockProperties {

    /**
     * Slab half property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.SlabProperties.Half}
     */
    public static final BlockEnumProperty half = getInstanceFor(StoneSlab, "half");

    /**
     * Slab halves
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Half {
        UPPER,
        LOWER;

        public static Half valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies half to the {@code Slab}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.SlabProperties.Half} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyHalf(Block block, Half value) {
        return apply(block, half, value);
    }
}
