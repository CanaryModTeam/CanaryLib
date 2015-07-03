package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;

import static net.canarymod.api.world.blocks.BlockType.Bed;

/**
 * Bed properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class BedProperties extends DirectionalBlockProperties {

    /**
     * Bed part property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.BedProperties.Half}
     */
    public static final BlockEnumProperty part = getInstanceFor(Bed, "part");

    /**
     * Bed occupied property, Values: true, false
     */
    public static final BlockBooleanProperty occupied = getInstanceFor(Bed, "occupied");

    /**
     * Bed half
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Half {
        HEAD,
        FOOT;

        public static Half valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies {@link net.canarymod.api.world.blocks.properties.helpers.BedProperties.Half} to the {@code Bed}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.BedProperties.Half} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyPart(Block block, Half value) {
        return apply(block, part, value);
    }

    /**
     * Applies whether the {@code Bed} is occupied or not
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
    public static Block applyOccupided(Block block, boolean value) {
        return apply(block, occupied, value);
    }
}
