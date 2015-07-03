package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.DyeColor;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.WhiteWool;

/**
 * Colored Block properties helper<br/>
 * Applies to<br/>
 * <ul>Stained Hardened Clay</ul>
 * <ul>Wool</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class ColoredBlockProperties extends BlockProperties {

    /**
     * Colored Block color property, Values: {@link net.canarymod.api.DyeColor} (excluding CUSTOM)
     */
    public static final BlockEnumProperty color = getInstanceFor(WhiteWool, "color");

    /**
     * Applies color to the {@code Colored Block}
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
