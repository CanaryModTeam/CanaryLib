package net.canarymod.api.world.blocks;

/**
 * Skull wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Skull extends TileEntity {

    /**
     * Sets the Skull type, based on Entity Type id
     *
     * @return skull type
     */
    int getSkullType();

    /**
     * Sets the skull type
     *
     * @param type
     *         the skull type
     */
    void setSkullType(int type);

    /**
     * Gets the extra type of the Skull, typically a Player's name
     *
     * @return the extra type
     */
    String getExtraType();

    /**
     * Sets the extra type of the Skull.
     *
     * @param extra
     *         the extra type
     */
    void setExtraType(String extra);

    /**
     * Sets both the Skull and extra type data
     *
     * @param type
     *         the skull type
     * @param extra
     *         the extra type
     */
    void setSkullAndExtraType(int type, String extra);

    /**
     * Gets the rotation of the skull
     *
     * @return rotation
     */
    int getRotation();

    /**
     * Sets the rotatoin of the Skull
     *
     * @param rot
     *         the rotation
     */
    void setRotation(int rot);
}
