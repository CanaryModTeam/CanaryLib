package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.WoodenPressurePlate;

/**
 * Pressure Plate properties helper<br/>
 * Applies to<br/>
 * <ul>Wooden Pressure Plate</ul>
 * <ul>Stone Pressure Plate</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class PressurePlateProperties extends BlockProperties {

    /**
     * Pressure Plate powered property, Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(WoodenPressurePlate, "powered");

    /**
     * Applies whether the {@code Pressure Plate} is powered or not
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
    public static Block applyPowered(Block block, boolean value) {
        return apply(block, powered, value);
    }
}
