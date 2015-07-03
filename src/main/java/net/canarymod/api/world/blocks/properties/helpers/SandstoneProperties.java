package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.Sandstone;

/**
 * Sandstone (Not Red) properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class SandstoneProperties extends BlockProperties {

    /**
     * Sandstone type property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.SandstoneProperties.Type}
     */
    public static final BlockEnumProperty type = getInstanceFor(Sandstone, "type");

    /**
     * Sandstone types
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Type {
        DEFAULT,
        CHISELED,
        SMOOTH;

        public static Type valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies level to the {@code Sandstone}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.SandstoneProperties.Type} value to apply
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
