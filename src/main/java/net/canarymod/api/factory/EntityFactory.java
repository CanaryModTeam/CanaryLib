package net.canarymod.api.factory;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.living.animal.EntityAnimal;
import net.canarymod.api.entity.living.humanoid.NonPlayableCharacter;
import net.canarymod.api.entity.living.monster.EntityMob;
import net.canarymod.api.entity.throwable.EntityThrowable;
import net.canarymod.api.entity.vehicle.Vehicle;
import net.canarymod.api.world.World;
import net.canarymod.api.world.position.Location;

/**
 * Entity Manufacturing Factory<br>
 * NOTE: Entities created are not spawned.
 *
 * @author Jason (darkdiplomat)
 */
public interface EntityFactory {

    /**
     * Creates a new Entity of the specified name initialized in the default World
     *
     * @param name
     *         the name of the Entity to create
     *
     * @return the new Entity if of a valid EnityType; {@code null} otherwise
     */
    Entity newEntity(String name);

    /**
     * Creates a new Entity of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the Entity to create
     * @param world
     *         the World to initialize the Entity in
     *
     * @return the new Entity if of a valid EnityType; {@code null} otherwise
     */
    Entity newEntity(String name, World world);

    /**
     * Creates a new Entity of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the Entity to create
     * @param location
     *         the location to initialize the Entity
     *
     * @return the new Entity if of a valid EnityType; {@code null} otherwise
     */
    Entity newEntity(String name, Location location);

    /**
     * Creates a new Entity of the specified type initialized in the default World
     *
     * @param type
     *         the type of the Entity to create
     *
     * @return the new Entity
     */
    Entity newEntity(EntityType type);

    /**
     * Creates a new Entity of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the Entity to create
     * @param world
     *         the World to initialize the Entity in
     *
     * @return the new Entity
     */
    Entity newEntity(EntityType type, World world);

    /**
     * Creates a new Entity of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the Entity to create
     * @param location
     *         the location to initialize the Entity
     *
     * @return the new Entity
     */
    Entity newEntity(EntityType type, Location location);

    /**
     * Creates a new EntityThrowable of the specified name initialized in the default World
     *
     * @param name
     *         the name of the EntityThrowable to create
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(String name);

    /**
     * Creates a new EntityThrowable of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the EntityThrowable to create
     * @param world
     *         the World to initialize the EntityThrowable in
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(String name, World world);

    /**
     * Creates a new EntityThrowable of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the EntityThrowable to create
     * @param location
     *         the location to initialize the EntityThrowable
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(String name, Location location);

    /**
     * Creates a new EntityThrowable of the specified type initialized in the default World
     *
     * @param type
     *         the type of the EntityThrowable to create
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(EntityType type);

    /**
     * Creates a new EntityThrowable of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the EntityThrowable to create
     * @param world
     *         the World to initialize the EntityThrowable in
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(EntityType type, World world);

    /**
     * Creates a new EntityThrowable of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the EntityThrowable to create
     * @param location
     *         the location to initialize the EntityThrowable
     *
     * @return the new EntityThrowable if is a valid EntityThrowable; {@code null} otherwise
     */
    EntityThrowable newThrowable(EntityType type, Location location);

    /**
     * Creates a new Vehicle of the specified name initialized in the default World
     *
     * @param name
     *         the name of the Vehicle to create
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(String name);

    /**
     * Creates a new Vehicle of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the Vehicle to create
     * @param world
     *         the World to initialize the Vehicle in
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(String name, World world);

    /**
     * Creates a new Vehicle of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the Vehicle to create
     * @param location
     *         the location to initialize the Vehicle
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(String name, Location location);

    /**
     * Creates a new Vehicle of the specified type initialized in the default World
     *
     * @param type
     *         the type of the Vehicle to create
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(EntityType type);

    /**
     * Creates a new Vehicle of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the Vehicle to create
     * @param world
     *         the World to initialize the Vehicle in
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(EntityType type, World world);

    /**
     * Creates a new Vehicle of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the Vehicle to create
     * @param location
     *         the location to initialize the Vehicle
     *
     * @return the new Vehicle if is a valid Vehicle; {@code null} otherwise
     */
    Vehicle newVehicle(EntityType type, Location location);

    /**
     * Creates a new EntityLiving of the specified name initialized in the default World
     *
     * @param name
     *         the name of the EntityLiving to create
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(String name);

    /**
     * Creates a new EntityLiving of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the EntityLiving to create
     * @param world
     *         the World to initialize the EntityLiving in
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(String name, World world);

    /**
     * Creates a new EntityLiving of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the EntityLiving to create
     * @param location
     *         the location to initialize the EntityLiving
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(String name, Location location);

    /**
     * Creates a new EntityLiving of the specified type initialized in the default World
     *
     * @param type
     *         the type of the EntityLiving to create
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(EntityType type);

    /**
     * Creates a new EntityLiving of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the EntityLiving to create
     * @param world
     *         the World to initialize the EntityLiving in
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(EntityType type, World world);

    /**
     * Creates a new EntityLiving of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the EntityLiving to create
     * @param location
     *         the location to initialize the EntityLiving
     *
     * @return the new EntityLiving if is a valid EntityLiving; {@code null} otherwise
     */
    EntityLiving newEntityLiving(EntityType type, Location location);

    /**
     * Creates a new EntityAnimal of the specified name initialized in the default World
     *
     * @param name
     *         the name of the EntityAnimal to create
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(String name);

    /**
     * Creates a new EntityAnimal of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the EntityAnimal to create
     * @param world
     *         the World to initialize the EntityAnimal in
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(String name, World world);

    /**
     * Creates a new EntityAnimal of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the EntityAnimal to create
     * @param location
     *         the location to initialize the EntityAnimal
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(String name, Location location);

    /**
     * Creates a new EntityAnimal of the specified type initialized in the default World
     *
     * @param type
     *         the type of the EntityAnimal to create
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(EntityType type);

    /**
     * Creates a new EntityAnimal of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the EntityAnimal to create
     * @param world
     *         the World to initialize the EntityAnimal in
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(EntityType type, World world);

    /**
     * Creates a new EntityAnimal of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the EntityAnimal to create
     * @param location
     *         the location to initialize the EntityAnimal
     *
     * @return the new EntityAnimal if is a valid EntityAnimal; {@code null} otherwise
     */
    EntityAnimal newEntityAnimal(EntityType type, Location location);

    /**
     * Creates a new EntityMob of the specified name initialized in the default World
     *
     * @param name
     *         the name of the EntityMob to create
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(String name);

    /**
     * Creates a new EntityMob of the specified name and initialized in the specified World
     *
     * @param name
     *         the name of the EntityMob to create
     * @param world
     *         the World to initialize the EntityMob in
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(String name, World world);

    /**
     * Creates a new EntityMob of the specified name and initialized at the specified Location
     *
     * @param name
     *         the name of the EntityMob to create
     * @param location
     *         the location to initialize the EntityMob
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(String name, Location location);

    /**
     * Creates a new EntityMob of the specified type initialized in the default World
     *
     * @param type
     *         the type of the EntityMob to create
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(EntityType type);

    /**
     * Creates a new EntityMob of the specified type and initialized in the specified World
     *
     * @param type
     *         the type of the EntityMob to create
     * @param world
     *         the World to initialize the EntityMob in
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(EntityType type, World world);

    /**
     * Creates a new EntityMob of the specified name and initialized at the specified Location
     *
     * @param type
     *         the type of the EntityMob to create
     * @param location
     *         the location to initialize the EntityMob
     *
     * @return the new EntityMob if is a valid EntityMob; {@code null} otherwise
     */
    EntityMob newEntityMob(EntityType type, Location location);

    /**
     * Creates a new NonPlayableCharacter
     *
     * @param name
     *         the name of the NonPlayableCharacter
     * @param location
     *         the location for the NonPlayableCharacter
     *
     * @return the new NonPlayableCharacter if all arguments are valid; {@code null} if an argument is not
     */
    NonPlayableCharacter newNPC(String name, Location location);
}
