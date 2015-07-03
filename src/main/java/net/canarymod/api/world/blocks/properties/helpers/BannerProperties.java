package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockFace;
import net.canarymod.api.world.blocks.properties.BlockDirectionProperty;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;

import static net.canarymod.api.world.blocks.BlockType.StandingBanner;
import static net.canarymod.api.world.blocks.BlockType.WallBanner;

/**
 * Banner properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class BannerProperties extends BlockProperties {

    /**
     * Banner rotation property, Value: 0 - 15
     */
    public static final BlockIntegerProperty rotation = getInstanceFor(StandingBanner, "rotation");

    /**
     * Anvil facing property, Values: {@link net.canarymod.api.world.blocks.BlockFace} (Excluding TOP & BOTTOM)
     */
    public static final BlockDirectionProperty facing = getInstanceFor(WallBanner, "facing");

    /**
     * Applies a {@link net.canarymod.api.world.blocks.BlockFace} facing to the {@code Banner (Wall Banner)}
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
     * Applies rotation to the {@code Banner (Standing Banner)}
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
    public static Block applyRotation(Block block, int value) {
        return apply(block, rotation, value);
    }

    /**
     * Applies rotation to the {@code Banner (Standing Banner)}
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@link net.canarymod.api.world.blocks.properties.helpers.BlockProperties.Rotation} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyRotation(Block block, Rotation value) {
        return applyRotation(block, value.ordinal());
    }
}
