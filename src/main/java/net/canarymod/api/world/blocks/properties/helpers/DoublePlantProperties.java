package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.DoubleGrass;

/**
 * Double Plant properties helper<br/>
 * Applies to<br/>
 * <ul>SUNFLOWER</ul>
 * <ul>SYRINGA</ul>
 * <ul>GRASS</ul>
 * <ul>FERN</ul>
 * <ul>ROSE</ul>
 * <ul>PAEONIA</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class DoublePlantProperties extends BlockProperties {

    /**
     * Double Plant variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.DoublePlantProperties.Variant}
     */
    public static final BlockEnumProperty variant = getInstanceFor(DoubleGrass, "variant");

    /**
     * Double Plant half property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.DoublePlantProperties.Half}
     */
    public static final BlockEnumProperty half = getInstanceFor(DoubleGrass, "half");

    /**
     * Double Plant halves
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Half {
        UPPER,
        LOWER;

        public static Half valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Double Plant variants
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Variant {
        SUNFLOWER,
        SYRINGA,
        GRASS,
        FERN,
        ROSE,
        PAEONIA;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies variant to the {@code Double Plant}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.DoublePlantProperties.Variant} value to apply
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
     * Applies half to the {@code Double Plant}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.DoublePlantProperties.Half} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyHalf(Block block, Half value) {
        return apply(block, half, value);
    }
}
