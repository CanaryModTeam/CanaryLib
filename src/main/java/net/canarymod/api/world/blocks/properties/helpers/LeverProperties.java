package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.Lever;

/**
 * Lever properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class LeverProperties extends BlockProperties {

    /**
     * Lever facing property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.LeverProperties.Orientation}
     */
    public static final BlockEnumProperty facing = getInstanceFor(Lever, "facing");

    /**
     * Lever powered property, Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(Lever, "powered");

    /**
     * Lever orientation
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Orientation {
        DOWN_X,
        EAST,
        WEST,
        SOUTH,
        NORTH,
        UP_Z,
        UP_X,
        DOWN_Z;

        public static Orientation valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies a {@link net.canarymod.api.world.blocks.properties.helpers.LeverProperties.Orientation} facing property to the {@code Lever}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.LeverProperties.Orientation} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyFacing(Block block, Orientation value) {
        return apply(block, facing, value);
    }

    /**
     * Applies whether the {@code Level} is powered or not (possibly referring to handle position)
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
}
