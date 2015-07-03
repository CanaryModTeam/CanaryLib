package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.QuartzBlock;

/**
 * Quartz properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class QuartzProperties extends BlockProperties {

    /**
     * Quartz variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.QuartzProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(QuartzBlock, "variant");

    /**
     * Quartz variants
     */
    public enum Variant {
        DEFAULT,
        CHISELED,
        LINES_Y,
        LINES_X,
        LINES_Z;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies variant to the {@code Quartz}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.QuartzProperties.Variant} value to apply
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
