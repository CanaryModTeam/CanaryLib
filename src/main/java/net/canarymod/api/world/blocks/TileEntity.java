package net.canarymod.api.world.blocks;

import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.world.World;

/**
 * TileEntity wrapper
 *
 * @author Chris Ksoll
 * @author Jason Jones
 */
public interface TileEntity {

    /**
     * Returns the Block representation for the TileEntity
     *
     * @return block
     */
    Block getBlock();

    /**
     * Gets the X location
     *
     * @return x
     */
    int getX();

    /**
     * Gets the Y location
     *
     * @return y
     */
    int getY();

    /**
     * Gets the Z
     *
     * @return z
     */
    int getZ();

    /**
     * Gets the dimension
     *
     * @return dimension
     */
    World getWorld();

    /**
     * Updates this TileEntity
     */
    void update();

    /**
     * Gets the NBTTagCompound for the TileEntity (null if not a tile entity)
     *
     * @return data tag
     */
    CompoundTag getDataTag();

    /**
     * Gets the MetaTag for the TileEntity (null if not a tile entity)
     *
     * @return meta tag
     */
    CompoundTag getMetaTag();

    /**
     * Writes to the NBTTagCompound for the TileEntity (null if not a tile entity)
     *
     * @param tag
     *         the {@link CompoundTag} to have entity data written to
     *
     * @return the written {@link CompoundTag}
     */
    CompoundTag writeToTag(CompoundTag tag);

    /**
     * Reads from NBTTagCompound for the TileEntity (null if not a tile entity)
     *
     * @param tag
     *         the {@link CompoundTag} of data
     */
    void readFromTag(CompoundTag tag);
}
