package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;

import static net.canarymod.api.world.blocks.BlockType.WoodenButton;

/**
 * Button properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class ButtonProperties extends BlockProperties {
    /**
     * Button facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace} (Excluding TOP)
     */
    public static final BlockDirectionProperty facing = getInstanceFor(WoodenButton, "facing");

    /**
     * Button powered property (which could mean pressed in), Values: true, false
     */
    public static final BlockBooleanProperty powered = getInstanceFor(WoodenButton, "powered");

    /**
     * Applies {@link net.canarymod.api.world.blocks.BlockFace} facing to the {@code Button}
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
     * Applies whether the {@code Button} is supplying power
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
