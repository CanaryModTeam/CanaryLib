package net.canarymod.api.entity.living;

import net.canarymod.api.DamageType;
import net.canarymod.api.attributes.AttributeMap;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.potion.Potion;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionEffectType;
import net.canarymod.api.world.position.Location;

import java.util.List;

/**
 * EntityLivingBase wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface LivingBase extends Entity {

    /**
     * Get this Entities health. May not work on entities that are not
     * LivingEntity
     *
     * @return health
     */
    float getHealth();

    /**
     * Set this entities health. May not work on entities that are not
     * LivingEntity
     *
     * @param health
     *         the health to be set
     */
    void setHealth(float health);

    /**
     * Increase this entities health. This does not set but add the amount of
     * health
     *
     * @param health
     *         to increase the health with (negative values decrease)
     */
    void increaseHealth(float health);

    /**
     * Gets the Maximum allowed health for the Entity
     *
     * @return maximum health
     */
    double getMaxHealth();

    /**
     * Sets the Maximum allowed health for the Entity
     *
     * @param maxHealth
     *         the maximum health
     */
    void setMaxHealth(double maxHealth);

    /**
     * Check if this entity can see the provided entity.
     *
     * @param entity
     *         the {@link LivingBase} to check sight of
     *
     * @return {@code true} if the entity can see the provided entity (provided is not
     * hidden); {@code false} otherwise
     */
    boolean canSee(LivingBase entity);

    /**
     * Get the amount of ticks this entity is dead.
     *
     * @return death ticks
     */
    int getDeathTicks();

    /**
     * Set how many ticks this entity is dead
     *
     * @param ticks
     *         the amount of death ticks to set
     */
    void setDeathTicks(int ticks);

    /**
     * Get the amount of ticks this entity remains invincible
     *
     * @return invulnerability ticks
     */
    int getInvulnerabilityTicks();

    /**
     * Set the amount of ticks this entity remains invincible
     *
     * @param ticks
     *         the amount of invulnerability ticks to set
     */
    void setInvulnerabilityTicks(int ticks);

    /**
     * Get this entities age. (Has nothing to do with the breeding stuff!! Use {@link Ageable#getGrowingAge()} instead!)
     *
     * @return age of the entity
     */
    int getAge();

    /**
     * Set how long this entity exists already. (Has nothing to do with the
     * breeding stuff!! Use {@link Ageable#setGrowingAge(int)} instead!)
     *
     * @param age
     *         the age to be set
     */
    void setAge(int age);

    /**
     * Murder this entity
     */
    void kill();

    /**
     * Inflict the given damage to this entity
     *
     * @param type
     *         the {@link DamageType}
     * @param damage
     *         the amount of damage
     */
    void dealDamage(DamageType type, float damage);

    /**
     * Knock back this entity with the given forces on x and z axis
     *
     * @param xForce
     *         the X-wise force
     * @param zForce
     *         the Z-wise force
     */
    void knockBack(double xForce, double zForce);

    /**
     * Add a {@link PotionEffect} to this entity
     *
     * @param effect
     *         the {@link PotionEffect} to add
     */
    void addPotionEffect(PotionEffect effect);

    /**
     * Add a {@link PotionEffect} to this entity using custom values
     *
     * @param type
     *         the {@link PotionEffectType}
     * @param duration
     *         the duration of the effect
     * @param amplifier
     *         the amplifier of the effect
     */
    void addPotionEffect(PotionEffectType type, int duration, int amplifier);

    /**
     * Removes a specified {@link PotionEffectType} from this entity.
     *
     * @param type
     *         the {@link PotionEffectType} to remove
     */
    void removePotionEffect(PotionEffectType type);

    /**
     * Removes all potion effects from this entity
     */
    void removeAllPotionEffects();

    /**
     * Is this potion active on this entity
     *
     * @param potion
     *         the {@link Potion} to check activity
     *
     * @return {code true} if potion is active; {@code false} otherwise
     */
    boolean isPotionActive(Potion potion);

    /**
     * Gets the supplied potions {@link PotionEffect} if it is active, else null
     *
     * @param potion
     *         the {@link Potion} to check effects for
     *
     * @return {@link PotionEffect} or null
     */
    PotionEffect getActivePotionEffect(Potion potion);

    /**
     * Get a list of all active {@link PotionEffect}s.
     *
     * @return a List<PotionEffect>
     */
    List<PotionEffect> getAllActivePotionEffects();

    /**
     * Set this Entities revenge target entity. Depending on entity type this must not
     * necessarily be an attack target. Null to remove target
     *
     * @param target
     *         the {@link LivingBase} target or {@code null} to remove target
     */
    void setRevengeTarget(LivingBase target);

    /**
     * Get the current revenge target of this entity
     *
     * @return the revenge target or {@code null} if no target
     */
    LivingBase getRevengeTarget();

    /**
     * Set the last entity to have attacked this entity.
     * Not sure why this would be used. Null to remove.
     *
     * @param entity
     *         the {@link LivingBase} to set as last assailant
     */
    void setLastAssailant(LivingBase entity);

    /**
     * Get the last living entity to attack this entity
     *
     * @return last assailant
     */
    LivingBase getLastAssailant();

    /**
     * Look at the specified x, y, z coordinates
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     */
    void lookAt(double x, double y, double z);

    /**
     * Look at the specified location
     *
     * @param location
     *         the {@link Location} to look at
     */
    void lookAt(Location location);

    /**
     * Look at the specified {@link Entity}
     *
     * @param entity
     *         the {@link Entity} to look at
     */
    void lookAt(Entity entity);

    /**
     * Gets how many Arrows are stuck in an Entity
     *
     * @return arrow count
     */
    int getArrowCountInEntity();

    /**
     * Sets how many Arrows are stuck in an Entity
     *
     * @param arrows
     *         the count of arrows to set
     */
    void setArrowCountInEntity(int arrows);

    /**
     * Swings the Item holding arm
     */
    void swingArm();

    /**
     * Attacks the {@link LivingBase} target and causes the specified damage.
     *
     * @param target
     *         {@link LivingBase} to attack.
     * @param damage
     *         The amount of damage to do.
     */
    void attackEntity(LivingBase target, float damage);

    /**
     * Gets the head rotation
     *
     * @return head rotation
     */
    float getHeadRotation();

    /**
     * Sets the head rotation
     *
     * @param rot
     *         the head rotation to set
     */
    void setHeadRotation(float rot);

    AttributeMap getAttributeMap();

    /**
     * Gets the entity in this entity is looking at. with a default search radius
     * of 64 blocks.
     *
     * @return The Entity in this entity is looking at or null if none in range.
     */
    Entity getTargetLookingAt();

    /**
     * Gets the entity in this entity is looking at. with the given search
     * radius from this entity.
     *
     * @param searchRadius
     *         search radius from this entity to search within
     *
     * @return The Entity in this entity is looking at or null if none in range.
     */
    Entity getTargetLookingAt(int searchRadius);

    /**
     * Gets whether the Entity drops loot or not
     *
     * @return {@code true} if drops loot; {@code false} if not
     */
    boolean lootDrop();

    /**
     * Sets whether the Entity drops loot or not
     *
     * @param lootDrop
     *         {@code true} if drops loot; {@code false} if not
     */
    void setLootDrop(boolean lootDrop);

    /**
     * Gets whether the Entity drops xp or not
     *
     * @return {@code true} if drops xp; {@code false} if not
     */
    boolean xpDrop();

    /**
     * Sets whether the Entity drops xp or not
     *
     * @param xpDrop
     *         {@code true} if drops xp; {@code false} if not
     */
    void setXPDrop(boolean xpDrop);
}
