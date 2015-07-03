package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.PistonHead;

/**
 * Piston Head properties<br/>
 * NOT TO BE CONFUSED WITH THE ACTUAL PISTON BASE
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class PistonHeadProperties extends BlockProperties {

    /**
     * Piston Head facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace}
     */
    public static final BlockDirectionProperty facing = getInstanceFor(PistonHead, "facing");

    /**
     * Piston Head type property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.PistonHeadProperties.Type}
     */
    public static final BlockEnumProperty type = getInstanceFor(PistonHead, "type");

    /**
     * Piston Head short property, Values: true, false
     */
    public static final BlockBooleanProperty short_ = getInstanceFor(PistonHead, "short");

    /**
     * Piston Head types
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Type {
        DEFAULT,
        STICKY;

        public static Type valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies a {@link net.canarymod.api.world.blocks.BlockFace} facing property to the {@code Piston Head}
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
     * Applies type to the {@code Piston Head}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.PistonHeadProperties.Type} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyType(Block block, Type value) {
        return apply(block, type, value);
    }

    /**
     * Applies whether the {@code Piston Head} arm is shorter than usual (by 4 pixels)
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
    public static Block applyShort(Block block, boolean value) {
        return apply(block, short_, value);
    }
}
