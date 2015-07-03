package net.canarymod.api.world.blocks;

import com.google.common.collect.ImmutableMap;
import net.canarymod.api.entity.EntityItem;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.packet.BlockChangePacket;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.canarymod.api.world.blocks.properties.BlockIntegerProperty;
import net.canarymod.api.world.blocks.properties.BlockProperty;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Position;

import java.util.Collection;

/**
 * IBlockAccess wrapper with added position and world information.
 *
 * @author Chris (damagefitler)
 * @author Jason (darkdiplomat)
 */
public interface Block {

    /**
     * Get this blocks type
     *
     * @return type id
     */
    short getTypeId();

    /**
     * Set this blocks type
     *
     * @param type
     *         the type id
     */
    void setTypeId(short type);

    /**
     * Get this blocks meta data based on its current properties
     * NOTE: This method should only be used in cases where BlockProperties aren't viable options (such as serialization)
     *
     * @return meta data
     */
    int getData();

    /**
     * Sets the block's BlockProperties based on data value
     * NOTE: This method should only be used in cases where BlockProperties aren't viable options (such as deserialization)
     *
     * @param data
     *         the data to set
     */
    void setData(int data);

    /**
     * Gets the block's BlockType
     *
     * @return {@link BlockType}
     */
    BlockType getType();

    /**
     * Set this blocks type
     *
     * @param type
     *         the {@link BlockType} to set
     */
    void setType(BlockType type);

    /**
     * Get the current dimension for this block
     *
     * @return world
     */
    World getWorld();

    /**
     * Set this block dimension
     *
     * @param world
     *         the {@link World} to set
     */
    void setWorld(World world);

    /**
     * Get the face that was clicked.
     *
     * @return {@link BlockFace}
     */
    BlockFace getFaceClicked();

    /**
     * Set the clicked BlockFace
     *
     * @param face
     *         the {@link BlockFace}
     */
    void setFaceClicked(BlockFace face);

    /**
     * Get the block that is next to this block on the given face
     * That means the block north or south east etc from this block
     *
     * @param face
     *         the {@link BlockFace} to check
     *
     * @return the adjacent block
     */
    Block getFacingBlock(BlockFace face);

    /**
     * Get the block relative from this block
     *
     * @param x
     *         the block x
     * @param y
     *         the block y
     * @param z
     *         the block z
     *
     * @return the relative block
     */
    Block getRelative(int x, int y, int z);

    /**
     * Send update packet for this block
     */
    void update();

    /**
     * Get this blocks position on the X axis
     *
     * @return x coordinate
     */
    int getX();

    /**
     * Get this blocks position on the Y axis
     *
     * @return y coordinate
     */
    int getY();

    /**
     * Get this blocks position on the Z axis
     *
     * @return z coordinate
     */
    int getZ();

    /**
     * Set this blocks position on the X axis
     *
     * @param x
     *         x coordinate
     *
     * @deprecated Position is read-only as of mc 1.8. Feed the world with coordinates and data instead
     */
    @Deprecated
    void setX(int x);

    /**
     * Set this blocks position on the Y axis
     *
     * @param y
     *         y coordinate
     *
     * @deprecated Position is read-only as of mc 1.8. Feed the world with coordinates and data instead
     */
    @Deprecated
    void setY(int y);

    /**
     * Set this blocks position on the Z axis
     *
     * @param z
     *         z coordinate
     *
     * @deprecated Position is read-only as of mc 1.8. Feed the world with coordinates and data instead
     */
    @Deprecated
    void setZ(int z);

    /**
     * Gets this blocks location, with world info
     *
     * @return the {@link Location}
     */
    Location getLocation();

    /**
     * Gets this blocks position.
     *
     * @return the {@link Position}
     */
    Position getPosition();

    /**
     * Sets the status of this block.
     * The meaning of a specific number can vary.
     * For detailed information see the javadocs of the respective hook.
     *
     * @param status
     *         the block status
     */
    void setStatus(byte status);

    /**
     * Gets the status of this block.
     * The meaning of a specific number can vary.
     * For detailed information see the javadocs of the respective hook.
     *
     * @return status
     */
    byte getStatus();

    /**
     * Checks if the block is air
     *
     * @return {@code true} if air; {@code false} otherwise
     */
    boolean isAir();

    /**
     * Gets the {@link BlockMaterial} this Block is made of
     *
     * @return the {@link BlockMaterial}
     */
    BlockMaterial getBlockMaterial();

    /**
     * Gets the Id of the Block as it would be dropped as an {@link Item}
     *
     * @return the id
     *
     * @deprecated moving to {@link net.canarymod.api.world.blocks.BlockBase}
     */
    @Deprecated
    int getIdDropped();

    /**
     * Gets the damage of the Block as it would be dropped as an {@link Item}
     *
     * @return the damage
     *
     * @deprecated moving to {@link net.canarymod.api.world.blocks.BlockBase}
     */
    @Deprecated
    int getDamageDropped();

    /**
     * Gets the amount that would be dropped when the Block is harvested.<br>
     * NOTE: Some blocks are random on the amount so returns may differ for those each call
     *
     * @return the quantity that would be dropped
     *
     * @deprecated moving to {@link net.canarymod.api.world.blocks.BlockBase}
     */
    @Deprecated
    int getQuantityDropped();

    /**
     * Drops the Block into the world as an {@link EntityItem}
     *
     * @param remove
     *         {@code true} to replace the block with air; {@code false} to leave the block as is
     */
    void dropBlockAsItem(boolean remove);

    /**
     * Gets a {@link TileEntity} at the same location as the Block
     *
     * @return {@link TileEntity} at the location or {@code null} if none
     */
    TileEntity getTileEntity();

    /**
     * Simulates a right click on the block.<br>
     * Useful for forcing changes to blocks like levers, buttons, doors, etc...
     *
     * @param player
     *         the {@link Player} to use with activation. Can be {@code null}
     *
     * @return {@code true} if the Block responded; {@code false} if not
     */
    boolean rightClick(Player player);

    /**
     * Sends the update packet to the specified {@link Player}(s) without modifying the world.<br>
     * Useful for displaying things like borders to a specific player(s)
     *
     * @param players
     *         the {@link Player}(s) to send info to
     */
    void sendUpdateToPlayers(Player... players);

    /**
     * Gets a {@link BlockChangePacket} of the Block that would be used in an update
     *
     * @return the {@link BlockChangePacket} of the Block
     */
    BlockChangePacket getBlockPacket();

    /**
     * Gets the collections of allowed {@link net.canarymod.api.world.blocks.properties.BlockProperty}
     *
     * @return allowed properties
     */
    Collection<BlockProperty> getPropertyKeys();

    /**
     * Gets the map of properties and values
     *
     * @return map of properties and values
     */
    ImmutableMap<BlockProperty, Comparable> getProperties();

    /**
     * Gets the {@link net.canarymod.api.world.blocks.properties.BlockProperty} for the given name
     *
     * @param name
     *         the name of the property
     *
     * @return the associated {@link net.canarymod.api.world.blocks.properties.BlockProperty} or {@code null} if no property found
     */
    BlockProperty getPropertyForName(String name);

    /**
     * Gets the value of a given {@link net.canarymod.api.world.blocks.properties.BlockProperty}
     *
     * @param property
     *         the {@link net.canarymod.api.world.blocks.properties.BlockProperty} to get value for
     *
     * @return the value of the property
     */
    Comparable getValue(BlockProperty property);

    /**
     * Sets a given property on a block. NOTE: New properties are not supported.
     *
     * @param property
     *         the property to set
     * @param value
     *         the value to set
     *
     * @throws java.lang.IllegalArgumentException
     *         should an invalid Property or value attempted to be set
     */
    void setPropertyValue(BlockProperty property, Comparable value);

    /**
     * Sets a given property on a block. NOTE: New properties are not supported.
     *
     * @param property
     *         the property to set
     * @param value
     *         the value to set
     *
     * @throws java.lang.IllegalArgumentException
     *         should an invalid Property or value attempted to be set
     */
    void setIntegerPropertyValue(BlockIntegerProperty property, int value);

    /**
     * Sets a given property on a block. NOTE: New properties are not supported.
     *
     * @param property
     *         the property to set
     * @param value
     *         the value to set
     *
     * @throws java.lang.IllegalArgumentException
     *         should an invalid Property or value attempted to be set
     */
    void setBooleanPropertyValue(BlockBooleanProperty property, boolean value);

    /**
     * Checks if a given {@link net.canarymod.api.world.blocks.properties.BlockProperty} can be applied to the block
     *
     * @param property
     *         the property to check
     */
    boolean canApply(BlockProperty property);

    /**
     * Gets the {@link net.canarymod.api.world.blocks.BlockBase} of the block
     *
     * @return {@link net.canarymod.api.world.blocks.BlockBase}
     */
    BlockBase getBlockBase();

    /**
     * Returns the Mojang string of the BlockState implementation<br/>
     * If any properties are applied to a state, they are serialized in the returned string
     *
     * @return state to String
     */
    String stateToString();
}
