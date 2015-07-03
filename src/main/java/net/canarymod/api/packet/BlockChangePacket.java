package net.canarymod.api.packet;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.position.Position;

/**
 * Packet #53 BlockChange
 *
 * @author Jason (darkdiplomat)
 */
public interface BlockChangePacket extends Packet {

    /**
     * Gets the X coordinate
     *
     * @return X coordinate
     */
    int getX();

    /**
     * Sets the X coordinate
     *
     * @param x
     *         the X coordinate
     */
    void setX(int x);

    /**
     * Gets the Y coordinate
     *
     * @return Y coordinate
     */
    int getY();

    /**
     * Sets the Y coordinate
     *
     * @param y
     *         the Y coordinate
     */
    void setY(int y);

    /**
     * Gets the Z coordinate
     *
     * @return Z coordinate
     */
    int getZ();

    /**
     * Sets the Z coordinate
     *
     * @param z
     *         the Z coordinate
     */
    void setZ(int z);

    /**
     * Gets the {@link Position}
     *
     * @return the {@link Position}
     */
    Position getPosition();

    /**
     * Sets the {@link Position}
     *
     * @param position
     *         the {@link Position} to set
     */
    void setPosition(Position position);

    /**
     * Gets the {@link BlockType}
     *
     * @return the {@link BlockType}
     */
    BlockType getType();

    /**
     * Sets the {@link BlockType} (id and data)
     *
     * @param type
     *         the {@link BlockType} to set
     */
    void setType(BlockType type);

    /**
     * Gets the Type ID
     *
     * @return the Type ID
     */
    int getTypeId();

    /**
     * Sets the Type Id
     *
     * @param id
     *         the Type ID
     */
    void setTypeId(int id);

    /**
     * Gets the Block Data value
     *
     * @return the data
     */
    int getData();

    /**
     * Sets the Block data value
     *
     * @param data
     *         the Block data
     */
    void setData(int data);

    /**
     * Gets the {@link Block}
     *
     * @return the {@link Block}
     */
    Block getBlock();

    /**
     * Sets the {@link Block}
     *
     * @param block
     *         the {@link Block}
     */
    void setBlock(Block block);
}
