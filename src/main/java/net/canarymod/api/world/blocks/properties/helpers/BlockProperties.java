package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.Canary;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.blocks.properties.BlockProperty;
import net.visualillusionsent.utils.Verify;

/**
 * Block properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public abstract class BlockProperties {

    static <T extends BlockProperty> T getInstanceFor(BlockType type, String property) {
        return Canary.factory().getObjectFactory().getPropertyInstance(type, property);
    }

    public static Block apply(Block block, BlockProperty property, Comparable value) throws IllegalArgumentException {
        Verify.notNull(block, "Block block");
        Verify.notNull(property, "BlockProperty property");
        Verify.notNull(value, "Comparable value");
        block.setPropertyValue(property, value);
        return block;
    }

    /**
     * Rotation helper<br/>
     * Applies to<br/>
     * <ul>Banner</ul>
     * <ul>Standing Sign</ul>
     *
     * @author Jason Jones (darkdiplomat)
     */
    public enum Rotation {
        SOUTH,
        SOUTHBYSOUTHWEST,
        SOUTHWEST,
        WESTBYSOUTHWEST,
        WEST,
        WESTBYNORTHWEST,
        NORTHWEST,
        NORTHBYNORTHWEST,
        NORTH,
        NORTHBYNORTHEAST,
        NORTHEAST,
        EASTBYNORTHEAST,
        EAST,
        EASTBYSOUTHEAST,
        SOUTHEAST,
        SOUTHBYSOUTHEAST
    }
}
