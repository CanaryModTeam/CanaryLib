package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.FenceGate;

/**
 * Fence Gate properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class FenceGateProperties extends DirectionalBlockProperties {

    /**
     * Fence Gate open property, Values: true, false
     */
    public static final BlockBooleanProperty open = getInstanceFor(FenceGate, "open");

    /**
     * Fence Gate powered property, Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(FenceGate, "powered");

    /**
     * Fence Gate in_wall property, Values: true, false
     */
    public static final BlockBooleanProperty inWall = getInstanceFor(FenceGate, "in_wall");

    /**
     * Applies whether the {@code Fence Gate} is open or not
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
     * Applies whether the {@code Fence Gate} is powered or not
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
     * Applies whether the {@code Fence Gate} is in wall or not
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
    public static Block applyInWall(Block block, boolean value) {
        return apply(block, inWall, value);
    }
}
