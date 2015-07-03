package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.Cake;

/**
 * Cake properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class CakeProperties extends BlockProperties {
    /**
     * Cake bites property, Values: 0 - 6
     */
    public static final BlockIntegerProperty bites = getInstanceFor(Cake, "bites");

    /**
     * Applies bites to the {@code Cake}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code int} value to apply (0 - 6)
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyBites(Block block, int value) {
        return apply(block, bites, value);
    }
}
