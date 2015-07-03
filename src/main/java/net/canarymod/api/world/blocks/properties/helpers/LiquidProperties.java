package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.Water;

/**
 * Liquid properties helper<br/>
 * Applies to:<br/>
 * <ul>Water</ul>
 * <ul>Lava</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class LiquidProperties extends BlockProperties {

    /**
     * Liquid level property, Values: 0 - 15
     */
    public static final BlockIntegerProperty level = getInstanceFor(Water, "level");

    /**
     * Applies level to the {@code Liquid}
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
    public static Block applyLevel(Block block, int value) {
        return apply(block, level, value);
    }
}
