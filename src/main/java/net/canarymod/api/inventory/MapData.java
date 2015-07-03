package net.canarymod.api.inventory;

import net.canarymod.api.nbt.CompoundTag;

/**
 * Map Data API
 *
 * @author Jason (darkdiplomat)
 */
public interface MapData {

    /**
     * Gets the name of the Map (map_[id])
     *
     * @return the name of the Map
     */
    String getMapName();

    /**
     * Gets the X-wise (Block Coordinates) center for the Map
     *
     * @return center x
     */
    int getXCenter();

    /**
     * Gets the Z-wise (Block Coordinates) center for the Map
     *
     * @return center z
     */
    int getZCenter();

    /**
     * Sets the X-wise (Block Coordinates) center for the Map
     *
     * @param xCenter
     *         the new x-wise center
     */
    void setXCenter(int xCenter);

    /**
     * Sets the Z-wise (Block Coordinates) center for the Map
     *
     * @param zCenter
     *         the new z-wise center
     */
    void setZCenter(int zCenter);

    /**
     * Gets the scale of the map (1 to 4)
     *
     * @return map scale
     */
    byte getScale();

    /**
     * Sets the scale of the map (1 to 4)
     *
     * @param scale
     *         the new map scale
     */
    void setScale(byte scale);

    /**
     * Gets the colors on the map
     *
     * @return the map colors
     */
    byte[] getColors();

    /**
     * Sets the colors on the map
     *
     * @param colors
     *         the map colors
     */
    void setColors(byte[] colors);

    /**
     * Sets whether the map should auto update
     * <p/>
     * NOTE: Setting the colors will disable auto update, <br/>
     * turning auto update on will cause the map to output the terrain data
     *
     * @param updating
     *         {@code true} to auto update; {@code false} to stop auto update
     */
    void setMapUpdating(boolean updating);

    /**
     * Gets whether the map is auto updating
     *
     * @return {@code true} if auto updating; {@code false} if not
     */
    boolean isMapUpdating();

    /**
     * Sends an update to holders of the Map
     */
    void update();

    /**
     * Marks a vertical range of pixels as being modified so they will be resent to clients.
     * <p/>
     * NOTE: Coordinates are specific to the Map itself, not the world.
     *
     * @param x
     *         the X-wise point (column) on the map (0 to 127)
     * @param yLowest
     *         the lowest Y-wise point (row) on the map
     * @param yHighest
     *         the highest Y-wise point (row) on the map
     */
    void setColumnDirty(int x, int yLowest, int yHighest);

    /**
     * Sets the data values of this map from the NBTData
     *
     * @param compoundTag
     *         the NBT Data to set to the Map
     */
    void setNBTData(CompoundTag compoundTag);

    /**
     * Gets the data values of this map and stores them in the given NBTData
     *
     * @param compoundTag
     *         the CompoundTag to store the Map data into
     */
    void getNBTData(CompoundTag compoundTag);
}
