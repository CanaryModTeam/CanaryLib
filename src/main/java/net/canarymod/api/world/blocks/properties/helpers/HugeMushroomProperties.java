package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.HugeBrownMushroom;

/**
 * Huge Mushroom properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class HugeMushroomProperties extends BlockProperties {

    /**
     * Huge Mushroom variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.HugeMushroomProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(HugeBrownMushroom, "variant");

    /**
     * Huge Mushroom variants
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Variant {
        NORTH_WEST,
        NORTH,
        NORTH_EAST,
        WEST,
        CENTER,
        EAST,
        SOUTH_WEST,
        SOUTH,
        SOUTH_EAST,
        STEM,
        ALL_INSIDE,
        ALL_OUTSIDE,
        ALL_STEM;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies variant to the {@code Huge Mushroom}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.HugeMushroomProperties.Variant} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyVariant(Block block, Variant value) {
        return apply(block, variant, value);
    }
}
