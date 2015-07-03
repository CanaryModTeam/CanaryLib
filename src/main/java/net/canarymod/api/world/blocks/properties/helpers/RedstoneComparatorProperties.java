package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.RedstoneComparator;

/**
 * Redstone Comparator properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class RedstoneComparatorProperties extends DirectionalBlockProperties {

    /**
     * Redstone Comparator powered property, Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(RedstoneComparator, "powered");

    /**
     * Redstone Comparator mode property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.RedstoneComparatorProperties.Mode}
     */
    public static final BlockEnumProperty mode = getInstanceFor(RedstoneComparator, "mode");

    /**
     * Redstone Comparator modes
     */
    public enum Mode {
        COMPARE,
        SUBTRACT;

        public static Mode valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies whether the {@code Redstone Comparator} is powered or not
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
    public static Block applyPowered(Block block, boolean value) {
        return apply(block, powered, value);
    }

    /**
     * Applies mode to the {@code Redstone Comparator}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.RedstoneComparatorProperties.Mode} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyMode(Block block, Mode value) {
        return apply(block, mode, value);
    }
}
