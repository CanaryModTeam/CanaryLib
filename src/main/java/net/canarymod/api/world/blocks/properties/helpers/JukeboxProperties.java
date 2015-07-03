package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;

import static net.canarymod.api.world.blocks.BlockType.Jukebox;

/**
 * Jukebox properties helper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class JukeboxProperties extends BlockProperties {

    /**
     * Jukebox has_record property, Values: true, false
     */
    public final static BlockBooleanProperty hasRecord = getInstanceFor(Jukebox, "has_record");

    /**
     * Applies whether the {@code Jukebox} has a record or not. The TileEntity should be used to set the record ID.
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
    public static Block applyRecord(Block block, boolean value) {
        return apply(block, hasRecord, value);
    }
}
