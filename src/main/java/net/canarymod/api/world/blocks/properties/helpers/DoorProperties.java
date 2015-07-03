package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.WoodenDoor;

/**
 * Door properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class DoorProperties extends BlockProperties {

    /**
     * Door facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace} (Excluding TOP & BOTTOM)
     */
    public static final BlockDirectionProperty facing = getInstanceFor(WoodenDoor, "facing");

    /**
     * Door hinge position property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.DoorProperties.HingePosition}
     */
    public static final BlockEnumProperty hinge = getInstanceFor(WoodenDoor, "hinge");

    /**
     * Door half property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.DoorProperties.Half}
     */
    public static final BlockEnumProperty half = getInstanceFor(WoodenDoor, "half");

    /**
     * Door open property, Values: true, false
     */
    public static final BlockBooleanProperty open = getInstanceFor(WoodenDoor, "open");

    /**
     * Door powered property, Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(WoodenDoor, "powered");

    /**
     * Door halves
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
     * Hinge positions
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum HingePosition {
        LEFT,
        RIGHT;

        public static HingePosition valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies a {@link net.canarymod.api.world.blocks.BlockFace} facing property to the {@code Door}
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

    /**
     * Applies open to the {@code Door}
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
    public static Block applyOpen(Block block, boolean value) {
        return apply(block, open, value);
    }

    /**
     * Applies hinge to the {@code Door}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.DoorProperties.HingePosition} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyHinge(Block block, HingePosition value) {
        return apply(block, hinge, value);
    }

    /**
     * Applies powered to the {@code Door}
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
     * Applies open to the {@code Door}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.DoorProperties.Half} value to apply
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
