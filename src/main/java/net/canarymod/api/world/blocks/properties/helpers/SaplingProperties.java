package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.OakSapling;

/**
 * Sapling properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class SaplingProperties extends BlockProperties implements WoodProperties {

    /**
     * Sapling type property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}
     */
    public static final BlockEnumProperty type = getInstanceFor(OakSapling, "type");

    /**
     * Sapling stage property, Values: 0, 1
     */
    public static final BlockIntegerProperty stage = getInstanceFor(OakSapling, "stage");

    /**
     * Applies type to the {@code Sapling}
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
    public static Block applyType(Block block, Variant value) {
        return apply(block, type, value);
    }

    /**
     * Applies stage to the {@code Sapling}
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
    public static Block applyStage(Block block, int value) {
        return apply(block, stage, value);
    }
}
