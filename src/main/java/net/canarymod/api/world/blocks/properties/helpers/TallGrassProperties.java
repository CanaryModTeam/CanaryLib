package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.TallGrass;

/**
 * Tall Grass properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class TallGrassProperties extends BlockProperties {

    /**
     * Tall Grass type property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.TallGrassProperties.Variant}
     */
    public static final BlockEnumProperty type = getInstanceFor(TallGrass, "type");

    /**
     * Tall grass variants
     */
    public enum Variant {
        DEAD_BUSH,
        GRASS,
        FERN;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies type to the {@code Tall Grass}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.TallGrassProperties.Variant} value to apply
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
}
