package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.StandingSign;

/**
 * Standing Sign properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class StandingSignProperties extends BlockProperties {

    /**
     * Standing Sign rotation property, Values: 0 - 15
     */
    public static final BlockIntegerProperty rotation = getInstanceFor(StandingSign, "rotation");

    /**
     * Applies rotation to the {@code Standing Sign}
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
    public static Block applyRotation(Block block, int value) {
        return apply(block, rotation, value);
    }

    /**
     * Applies rotation to the {@code Standing Sign}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.BlockProperties.Rotation} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyRotation(Block block, Rotation value) {
        return applyRotation(block, value.ordinal());
    }
}
