package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.DyeColor;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.WhiteGlass;

/**
 * Stained Glass properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class StainedGlassProperties extends BlockProperties {

    /**
     * Stained Glass color property, Values: DyeColor (excluding CUSTOM)
     */
    public static final BlockEnumProperty color = getInstanceFor(WhiteGlass, "color");

    /**
     * Applies color to the {@code Stained Glass}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.DyeColor} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyColor(Block block, DyeColor value) {
        return apply(block, color, value);
    }
}
