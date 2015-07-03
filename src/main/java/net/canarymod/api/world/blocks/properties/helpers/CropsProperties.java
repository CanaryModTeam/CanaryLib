package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.Wheat;

/**
 * Crops properties helper<br/>
 * Applies to<br/>
 * <ul>Wheat</ul>
 * <ul>Carrots</ul>
 * <ul>Potatoes</ul>
 * <ul>Melon (Stem)</ul>
 * <ul>Pumpkin (Stem)</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class CropsProperties extends BlockProperties {

    /**
     * Crops age property, Values: 0 - 7
     */
    public static final BlockIntegerProperty age = getInstanceFor(Wheat, "age");

    /**
     * Applies age to the {@code Crops}
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
    public static Block applyAge(Block block, int value) {
        return apply(block, age, value);
    }
}
