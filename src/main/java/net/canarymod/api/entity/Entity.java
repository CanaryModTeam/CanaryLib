package net.canarymod.api.entity;

import net.canarymod.api.BoundingBox;
import net.canarymod.api.entity.living.Golem;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.nbt.BaseTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.world.World;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Position;
import net.canarymod.api.world.position.Vector3D;

import java.util.List;
import java.util.UUID;

/**
 * This defines an entity in the world
 * Everything that is not a block inherits from Entity in a way.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 * @author Larry1123
 */
public interface Entity {

    /**
     * Get X position
     *
     * @return x position
     */
    double getX();

    /**
     * Get Y position
     *
     * @return y position
     */
    double getY();

    /**
     * Get Z position
     *
     * @return z position
     */
    double getZ();

    /**
     * Get X Motion (movement speed)
     *
     * @return x motion
     */
    double getMotionX();

    /**
     * Get Y Motion (movement speed)
     *
     * @return y motion
     */
    double getMotionY();

    /**
     * Get Z Motion (movement speed)
     *
     * @return z motion
     */
    double getMotionZ();

    /**
     * Get this Entities pitch (up or down looking) (Rotation around X axis)
     *
     * @return pitch
     */
    float getPitch();

    /**
     * Get this entities look direction (Rotation around Y axis)
     *
     * @return rotation
     */
    float getRotation();

    /**
     * Returns this entities coordinates in a Vector3D object
     *
     * @return {@link Position}
     */
    Position getPosition();

    /**
     * Get this entities location, including world, dimension, pitch and rotation and coordinates
     *
     * @return {@link Location}
     */
    Location getLocation();

    /**
     * Gets the height from the feet at which the eyes are
     *
     * @return eye height
     */
    float getEyeHeight();

    /**
     * Get the assigned unique ID for this entity
     *
     * @return id
     */
    int getID();

    /**
     * Gets the assigned UUID for this entity
     *
     * @return {@link UUID}
     */
    UUID getUUID();

    /**
     * Set X coordinate
     *
     * @param x
     *         the X coordinate to set
     */
    void setX(double x);

    /**
     * Set X coordinate
     *
     * @param x
     *         the X coordinate to set
     */
    void setX(int x);

    /**
     * Set Y coordinate
     *
     * @param y
     *         the Y coordinate to set
     */
    void setY(double y);

    /**
     * Set Y coordinate
     *
     * @param y
     *         the Y coordinate to set
     */
    void setY(int y);

    /**
     * Set Z coordinate
     *
     * @param z
     *         the Z coordinate to set
     */
    void setZ(double z);

    /**
     * Set Z coordinate
     *
     * @param z
     *         the Z coordinate to set
     */
    void setZ(int z);

    /**
     * Set X Motion (movement speed)
     *
     * @param motionX
     *         the X-wise motion
     */
    void setMotionX(double motionX);

    /**
     * Set Y Motion (movement speed)
     *
     * @param motionY
     *         the Y-wise motion
     */
    void setMotionY(double motionY);

    /**
     * Set Z Motion (movement speed)
     *
     * @param motionZ
     *         the Z-wise motion
     */
    void setMotionZ(double motionZ);

    /**
     * Set this entities pitch (up / down looking)
     *
     * @param pitch
     *         the Y rotation to set
     */
    void setPitch(float pitch);

    /**
     * Set this entities rotation
     *
     * @param rotation
     *         the X rotation to set
     */
    void setRotation(float rotation);

    /**
     * Get the motion vector of this entity.
     * This is a convenience for position calculations
     *
     * @return {@link Vector3D}
     */
    Vector3D getMotion();

    /**
     * Returns the forward direction of this entity.
     * Convenience for position calculations
     *
     * @return {@link Vector3D}
     */
    Vector3D getForwardVector();

    /**
     * Translates this entity in its position by the given Vector3D.
     *
     * @param factor
     *         the {@link Vector3D} factor
     */
    void translate(Vector3D factor);

    /**
     * Move this entity with the forces given. Note that those are not the
     * coordinates to move to! It does also not translate the entity on a vector.
     * This simply adds force to this entity
     *
     * @param motionX
     *         the X-wise motion
     * @param motionY
     *         the Y-wise motion
     * @param motionZ
     *         the Z-wise motion
     */
    void moveEntity(double motionX, double motionY, double motionZ);

    /**
     * Teleport this entity to the given coordinates
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     */
    void teleportTo(double x, double y, double z);

    /**
     * Teleport to this coords in the given dimension
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     * @param world
     *         the {@link World}
     */
    void teleportTo(double x, double y, double z, World world);

    /**
     * Teleport this entity to the given coordinates, with the given pitch and rotation to look at
     * this.entity.b(x, y, z, rotation, pitch);
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     * @param pitch
     *         the Y-wise rotation
     * @param rotation
     *         the X-wise rotation
     */
    void teleportTo(double x, double y, double z, float pitch, float rotation);

    /**
     * Teleport to this location in the given world
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     * @param pitch
     *         the Y-wise rotation
     * @param rotation
     *         the X-wise rotation
     * @param dim
     *         the {@link World}
     */
    void teleportTo(double x, double y, double z, float pitch, float rotation, World dim);

    /**
     * Teleport to the specified location
     *
     * @param location
     *         the {@link Location} to teleport to
     */
    void teleportTo(Location location);

    /**
     * Teleport this entity to the given position
     *
     * @param position
     *         the {@link Position} to teleport to
     */
    void teleportTo(Position position);

    /**
     * Get this entities world(dimension)
     *
     * @return {@link World}
     */
    World getWorld();

    /**
     * Checks if the player is sprinting
     *
     * @return {@code true} if sprinting; {@code false} otherwise
     */
    boolean isSprinting();

    /**
     * Mark this entity as spriting or not sprinting
     *
     * @param sprinting
     *         {@code true} for sprinting; {@code false} otherwise
     */
    void setSprinting(boolean sprinting);

    /**
     * Returns whether this entity is sneaking
     *
     * @return {@code true} if sneaking; {@code false} otherwise
     */
    boolean isSneaking();

    /**
     * Mark this entity as sneaking or not
     *
     * @param sneaking
     *         {@code true} for sneaking; {@code false} otherwise
     */
    void setSneaking(boolean sneaking);

    /**
     * Sets the number of ticks the entity will be on fire.<br/>
     * Setting to 0 or less will extinguish the entity.
     *
     * @param ticks
     *         the fire ticks to set
     */
    void setFireTicks(int ticks);

    /**
     * Gets the number of ticks the entity will be on fire.
     *
     * @return fire ticks
     */
    int getFireTicks();

    /**
     * Check if this entity is a living entity
     *
     * @return {@code true} if living; {@code false} otherwise
     */
    boolean isLiving();

    /**
     * Check if this entity is an item entity
     *
     * @return {@code true} if {@link EntityItem}; {@code false} otherwise
     */
    boolean isItem();

    /**
     * Check if this entity is a mob
     *
     * @return {@code true} when it is a mob
     */
    boolean isMob();

    /**
     * Check if this entity is an animal (implements the animal interface)
     *
     * @return {@code true} if animal; {@code false} otherwise
     */
    boolean isAnimal();

    /**
     * Check if this entity is a player entity
     *
     * @return {@code true} when it is a player
     */
    boolean isPlayer();

    /**
     * Checks if this entity is a {@link Golem}
     *
     * @return {@code true} if {@link Golem}; {@code false} if not
     */
    boolean isGolem();

    /**
     * Check if this entity is a {@link net.canarymod.api.entity.living.humanoid.NonPlayableCharacter}
     *
     * @return {@code true} if npc; {@code false} if not
     */
    boolean isNPC();

    /**
     * Make this entity drop the given item
     *
     * @param itemId
     *         the {@link Item} id to drop
     * @param amount
     *         the amount to be dropped
     *
     * @return the resulting {@link EntityItem}
     */
    EntityItem dropLoot(int itemId, int amount);

    /**
     * Make this entity drop the given item
     *
     * @param item
     *         the {@link Item} to be dropped
     *
     * @return the resulting {@link EntityItem}
     */
    EntityItem dropLoot(Item item);

    /**
     * Get this entity's name, can either be its qualified name or display name if present
     *
     * @return name
     */
    String getName();

    /**
     * Gets the Entity's qualified name (ie: Class Name)
     *
     * @return qualified name
     */
    String getFqName();

    /**
     * Check if this entity can spawn at its current specified position or not
     *
     * @return {@code true} if the entity can; {@code false} otherwise
     */
    boolean canSpawn();

    /**
     * Spawn this entity in the world.
     *
     * @return {@code true} if successful; {@code false} if not
     */
    boolean spawn();

    /**
     * Spawn this entity with a given rider entity
     *
     * @param rider
     *         the {@code Entity} rider
     *
     * @return {@code true} if successful; {@code false} otherwise
     */
    boolean spawn(Entity rider);

    /**
     * Check if this Entity is riding another entity.
     *
     * @return {@code true} if the entity is riding another entity; {@code false} otherwise
     */
    boolean isRiding();

    /**
     * Checks if the Entity is being ridden by another Entity.
     *
     * @return {@code true} if being ridden; {@code false} if not
     */
    boolean isRidden();

    /**
     * Gets the Entity the Entity is riding
     *
     * @return the Entity being ridden by the Entity; {@code null} if not riding
     */
    Entity getRiding();

    /**
     * Gets the Entity the Entity is being ridden by
     *
     * @return the Entity that is riding the Entity; {@code null} if no rider
     */
    Entity getRider();

    /**
     * Set this entities rider.
     * The given EntityLiving will be attached as rider on this entity.
     *
     * @param rider
     *         the {@code Entity} rider
     */
    void setRider(Entity rider);

    /**
     * Mounts a specified {@code Entity}
     *
     * @param entity
     *         the {@code Entity} to mount
     */
    void mount(Entity entity);

    /**
     * Dismount ridden {@code Entity}
     */
    void dismount();

    /**
     * Destroys this entity
     */
    void destroy();

    /**
     * Gets whether this Entity is pending clean up
     *
     * @return {@code true} if dead; {@code false} otherwise
     */
    boolean isDead();

    /**
     * Get's the NBT Tag for this Entity.
     *
     * @return {@link CompoundTag}
     */
    CompoundTag getNBT();

    /**
     * Set this NBT Tag for this entity. Any missing values will be overridden
     * to the defaults.
     *
     * @param tag
     *         The tag to set
     *
     * @see #getNBT()
     */
    void setNBT(BaseTag tag);

    /**
     * Returns whether this entity is invisible
     *
     * @return {@code true} if invisible; {@code false} otherwise
     */
    boolean isInvisible();

    /**
     * Mark this entity as invisible or not
     *
     * @param invisible
     *         {@code true} for invisible; {@code false} for visible
     */
    void setInvisible(boolean invisible);

    /**
     * Gets the persistent MetaData tag for the Entity
     *
     * @return MetaData
     */
    CompoundTag getMetaData();

    /**
     * Gets the Type of the entity
     *
     * @return the {@link EntityType}
     */
    EntityType getEntityType();

    /**
     * Returns whether this entity is ambient (ie. a bat)
     *
     * @return {@code true} if ambient; {@code false} if not ambient
     */
    boolean isAmbient();

    /**
     * Returns whether this entity is on the ground
     *
     * @return {@code true} if on ground; {@code false} if not
     */
    boolean isOnGround();

    /**
     * Returns whether this entity is in a web
     *
     * @return {@code true} if in a web; {@code false} if not
     */
    boolean isInWeb();

    /**
     * Returns whether this entity is in water
     *
     * @return {@code true} if in water; {@code false} if not
     */
    boolean isInWater();

    /**
     * Returns whether this entity is in lava
     *
     * @return {@code true} if in lava; {@code false} if not
     */
    boolean isInLava();

    /**
     * Gets if the EntityLiving has a custom name
     *
     * @return {@code true} if custom; {@code false} if not
     */
    boolean hasDisplayName();

    /**
     * Gets the EntityLiving's name displayed to others
     *
     * @return EntityLiving's display name
     */
    String getDisplayName();

    /**
     * Sets the EntityLiving's name display name
     *
     * @param display
     *         the name to have the EntityLiving display
     */
    void setDisplayName(String display);

    /**
     * Gets if the Custom Display name should show
     *
     * @return {@code true} if show; {@code false} if not
     */
    boolean showingDisplayName();

    /**
     * Sets if the Custom Display name should show
     *
     * @param show
     *         {@code true} if show; {@code false} if not
     */
    void setShowDisplayName(boolean show);

    /**
     * Gets whether or not the Entity is eating
     *
     * @return {@code true} if eating; {@code false} if not
     */
    boolean isEating();

    /**
     * Gets a list of nearby entities within a given radius
     *
     * @param radius
     *         the radius to check for entities
     *
     * @return a list of nearby entities
     */
    List<Entity> getNearbyEntities(double radius);

    /**
     * Gets a list of nearby entities within a given vector
     *
     * @param vector
     *         the vector to check for entities
     *
     * @return a list of nearby entities
     */
    List<Entity> getNearbyEntities(Vector3D vector);

    /**
     * Gets a list of nearby entities within a given radius filtering out any that are not an instance of the given filtered types
     *
     * @param radius
     *         the radius to check for entities
     * @param filter
     *         an array of Entity types to select for return
     *
     * @return a list of nearby entities filtered by the given classes
     */
    List<Entity> getNearbyEntities(double radius, EntityType... filter);

    /**
     * Gets a list of nearby entities within a given vector filtering out any that are not an instance of the given filtered types
     *
     * @param vector
     *         the vector to check for entities
     * @param filter
     *         an array of Entity types to select for return
     *
     * @return a list of nearby entities filtered by the given classes
     */
    List<Entity> getNearbyEntities(Vector3D vector, EntityType... filter);

    BoundingBox getBoundingBox();
}
