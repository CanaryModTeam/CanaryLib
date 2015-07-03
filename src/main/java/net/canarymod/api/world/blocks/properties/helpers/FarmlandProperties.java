package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.Farmland;

/**
 * Farmland properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class FarmlandProperties extends BlockProperties {

    /**
     * Farmland moisture property, Values: 0 - 7
     */
    public static final BlockIntegerProperty moisture = getInstanceFor(Farmland, "moisture");

    /**
     * Applies moisture to the {@code Farmland}
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
    public static Block applyMositure(Block block, int value) {
        return apply(block, moisture, value);
    }
}
