package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;
import net.visualillusionsent.utils.Verify;

import static net.canarymod.api.world.blocks.BlockType.AcaciaLog;
import static net.canarymod.api.world.blocks.BlockType.DarkOakLog;
import static net.canarymod.api.world.blocks.BlockType.OakLog;

/**
 * Log properties helper<p/>
 * NOTE: There are potentially 2 different axis properties for Log
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class LogProperties extends RotatedPillarProperties implements WoodProperties {

    /**
     * Log axis property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.LogProperties.Axis}
     */
    public static final BlockEnumProperty axis = getInstanceFor(OakLog, "axis");

    /**
     * (Old) Log variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}<br/>
     * Applies to:<br/>
     * <ul>Oak</ul>
     * <ul>Spruce</ul>
     * <ul>Birch</ul>
     * <ul>Jungle</ul>
     */
    public static final BlockEnumProperty variantOld = getInstanceFor(OakLog, "variant");

    /**
     * (New) Log variant property, Values: {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}<br/>
     * Applies to:<br/>
     * <ul>Acacia</ul>
     * <ul>Dark Oak</ul>
     */
    public static final BlockEnumProperty variantNew = getInstanceFor(AcaciaLog, "variant");

    /**
     * Log Axis
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Axis {
        X,
        Y,
        Z,
        NONE;

        public static Axis valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }

    /**
     * Applies axis to the {@code Log}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.LogProperties.Axis} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyAxis(Block block, Axis value) {
        return apply(block, axis, value);
    }

    /**
     * Applies variant to the {@code Log}
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
    public static Block applyVariant(Block block, Variant value) {
        Verify.notNull(block, "Block block");
        if (block.getType().matches(AcaciaLog, DarkOakLog)) {
            return apply(block, variantNew, value);
        }
        return apply(block, variantOld, value);
    }
}
