package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.OakWoodSlab;

/**
 * Wood Slab properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class WoodSlabProperties extends SlabProperties implements WoodProperties {

    /**
     * Wood Slab variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(OakWoodSlab, "variant");

    /**
     * Applies variant to the {@code Wood Slab}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyVariant(Block block, Variant value) {
        return apply(block, variant, value);
    }
}
