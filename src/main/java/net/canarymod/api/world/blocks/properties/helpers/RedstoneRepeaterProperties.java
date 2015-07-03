package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.RedstoneRepeaterOff;

/**
 * Redstone Repeater properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class RedstoneRepeaterProperties extends DirectionalBlockProperties {

    /**
     * Redstone Repeater locked property, Values: true, false
     */
    public static final BlockBooleanProperty locked = getInstanceFor(RedstoneRepeaterOff, "locked");

    /**
     * Redstone Repeater delay property, Values: 1 - 4
     */
    public static final BlockIntegerProperty delay = getInstanceFor(RedstoneRepeaterOff, "delay");

    /**
     * Applies whether the {@code Redstone Repeater} is locked or not
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
    public static Block applyLocked(Block block, boolean value) {
        return apply(block, locked, value);
    }

    /**
     * Applies delay to the {@code Redstone Repeater}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code int} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyDelay(Block block, int value) {
        return apply(block, delay, value);
    }
}
