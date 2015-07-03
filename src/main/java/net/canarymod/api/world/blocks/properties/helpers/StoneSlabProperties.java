package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.StoneSlab;

/**
 * Stone Slab properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public abstract class StoneSlabProperties extends SlabProperties {

    /**
     * Stone Slab variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.StoneSlabProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(StoneSlab, "variant");

    /**
     * Stone slab variants
     */
    public enum Variant {
        STONE,
        SAND,
        WOOD,
        COBBLESTONE,
        BRICK,
        SMOOTHBRICK,
        NETHERBRICK,
        QUARTZ;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies level to the {@code Stone Slab}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.StoneSlabProperties.Variant} value to apply
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
