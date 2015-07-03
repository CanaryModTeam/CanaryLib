package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.Snow;

/**
 * Snow properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class SnowProperties extends BlockProperties {

    /**
     * Snow layers property, Values: 1 - 8
     */
    public static final BlockIntegerProperty layers = getInstanceFor(Snow, "layers");

    /**
     * Applies layer to the {@code Snow}
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
    public static Block applyLayers(Block block, int value) {
        return apply(block, layers, value);
    }
}
