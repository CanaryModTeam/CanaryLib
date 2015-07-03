package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.Poppy;

/**
 * Flower properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class FlowerProperties extends BlockProperties {

    /**
     * Flower type property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.FlowerProperties.Type} (Excludes DANDELION)
     */
    public static final BlockEnumProperty type = getInstanceFor(Poppy, "type");

    /**
     * Flower types
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Type {
        /**
         * Dandelion can't actually be applied, its included for consistence with native enumerations
         */
        DANDELION,
        POPPY,
        BLUE_ORCHID,
        ALLIUM,
        HOUSTONIA,
        RED_TULIP,
        ORANGE_TULIP,
        WHITE_TULIP,
        PINK_TULIP,
        OXEYE_DAISY;

        public static Type valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies type to the {@code Flower}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.FlowerProperties.Type} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyType(Block block, Type value) {
        return apply(block, type, value);
    }
}
