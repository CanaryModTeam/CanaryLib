package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockEnumProperty;
import net.visualillusionsent.utils.Verify;

import static net.canarymod.api.world.blocks.BlockType.AcaciaLeaves;
import static net.canarymod.api.world.blocks.BlockType.DarkOakLeaves;
import static net.canarymod.api.world.blocks.BlockType.OakLeaves;

/**
 * Leaves properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class LeavesProperties extends BlockProperties implements WoodProperties {

    /**
     * Leaves decayable property, Values: true, false
     */
    public static final BlockBooleanProperty decayable = getInstanceFor(OakLeaves, "decayable");

    /**
     * Leaves check_decay property, Values: true, false
     */
    public static final BlockBooleanProperty checkDecay = getInstanceFor(OakLeaves, "check_decay");

    /**
     * (Old) Leaves variant property, Values {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}<br/>
     * Applies to:<br/>
     * <ul>Oak</ul>
     * <ul>Spruce</ul>
     * <ul>Birch</ul>
     * <ul>Jungle</ul>
     */
    public static final BlockEnumProperty variantOld = getInstanceFor(OakLeaves, "variant");

    /**
     * (New) Leaves variant property, Values {@link net.canarymod.api.world.blocks.properties.helpers.WoodProperties.Variant}<br/>
     * Applies to:<br/>
     * <ul>Acacia</ul>
     * <ul>Dark Oak</ul>
     */
    public static final BlockEnumProperty variantNew = getInstanceFor(AcaciaLeaves, "variant");

    /**
     * Applies whether the {@code Leaves} is decayable or not
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
    public static Block applyDecayable(Block block, boolean value) {
        return apply(block, decayable, value);
    }

    /**
     * Applies whether the {@code Leaves} should check decay or not
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
    public static Block applyCheckDecay(Block block, boolean value) {
        return apply(block, checkDecay, value);
    }

    /**
     * Applies variant to the {@code Leaves}
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
        if (block.getType().matches(AcaciaLeaves, DarkOakLeaves)) {
            return apply(block, variantNew, value);
        }
        return apply(block, variantOld, value);
    }
}
