package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.CommandBlock;

/**
 * Command Block properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class CommandBlockProperties extends BlockProperties {

    /**
     * Command Block triggered property, Values: true, false
     */
    public static final BlockBooleanProperty triggered = getInstanceFor(CommandBlock, "triggered");

    /**
     * Applies whether the {@code CommandBlock} has triggered or not
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
    public static Block applyTriggered(Block block, boolean value) {
        return apply(block, triggered, value);
    }
}
