package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;
import net.visualillusionsent.utils.Verify;

import static net.canarymod.api.world.blocks.BlockType.ActivatorRail;
import static net.canarymod.api.world.blocks.BlockType.DetectorRail;
import static net.canarymod.api.world.blocks.BlockType.PoweredRail;
import static net.canarymod.api.world.blocks.BlockType.Rail;

/**
 * Rail properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public abstract class RailProperties extends BlockProperties {

    /**
     * Normal Rail shape property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.RailProperties.Direction}
     */
    public static final BlockEnumProperty shapeNormalRail = getInstanceFor(Rail, "shape");

    /**
     * Powered and Activator Rail shape property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.RailProperties.Direction}
     */
    public static final BlockEnumProperty shapePoweredRail = getInstanceFor(PoweredRail, "shape");

    /**
     * Detector Rail shape property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.RailProperties.Direction}
     */
    public static final BlockEnumProperty shapeDetectorRail = getInstanceFor(DetectorRail, "shape");

    /**
     * Rail directions
     */
    public enum Direction {
        NORTH_SOUTH,
        EAST_WEST,
        ASCENDING_EAST,
        ASCENDING_WEST,
        ASCENDING_NORTH,
        ASCENDING_SOUTH,
        SOUTH_EAST,
        SOUTH_WEST,
        NORTH_WEST,
        NORTH_EAST;

        public static Direction valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies shape to the {@code Rail}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.StairsProperties.Shape} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyShape(Block block, Direction value) {
        Verify.notNull(block, "Block block");
        if (block.getType().equals(PoweredRail) || block.getType().equals(ActivatorRail)) {
            return apply(block, shapePoweredRail, value);
        }
        else if (block.getType().equals(DetectorRail)) {
            return apply(block, shapeDetectorRail, value);
        }
        else {
            return apply(block, shapeNormalRail, value);
        }
    }
}
