package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;

import static net.canarymod.api.world.blocks.BlockType.Dispenser;

/**
 * Dispenser/Dropper properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class DispenserProperties extends BlockProperties {

    /**
     * Dispenser/Dropper facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace}
     */
    public static final BlockDirectionProperty facing = getInstanceFor(Dispenser, "facing");

    /**
     * Dispenser/Dropper triggered property, Values: true, false
     */
    public static final BlockBooleanProperty triggered = getInstanceFor(Dispenser, "triggered");

    /**
     * Applies facing to the {@code Dispsener/Dropper}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.BlockFace} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyFacing(Block block, BlockFace value) {
        return apply(block, facing, value);
    }

    /**
     * Applies triggered to the {@code Dispenser/Dropper}
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
    public static Block applyTriggered(Block block, boolean value) {
        return apply(block, triggered, value);
    }
}
