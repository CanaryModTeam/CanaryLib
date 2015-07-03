package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.Dirt;

/**
 * Dirt properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class DirtProperties extends BlockProperties {

    /**
     * Dirt variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.DirtProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(Dirt, "variant");

    /**
     * Dirt snowy property, Values: true, false
     */
    public static final BlockBooleanProperty snowy = getInstanceFor(Dirt, "snowy");

    /**
     * Dirt variants
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Variant {
        DIRT,
        COARSE_DIRT,
        PODZOL;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies variant to the {@code Dirt}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.DirtProperties.Variant} value to apply
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

    /**
     * Applies whether the {@code Dirt} is snowy
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applySnowy(Block block, boolean value) {
        return apply(block, snowy, value);
    }
}
