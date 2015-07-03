package net.canarymod.api.entity.living;

import net.canarymod.api.PathFinder;
import net.canarymod.api.ai.AIManager;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.inventory.Item;

/**
 * An entity living defines any entities that own health, such as animals and mobs.
 * Every entity with health inherits from this.
 *
 * @author Chris (damagefilter)
 */
public interface EntityLiving extends LivingBase {

    /**
     * Move this entity to exact location with this speed.
     *
     * @param x
     *         x coord
     * @param y
     *         y coord
     * @param z
     *         z coord
     * @param speed
     *         Set the speed of this mob, it should be between 0.0F and 1.0F <br>
     *         <b>NOTE:</b> 1.0F is really really fast.<br>
     */
    void moveEntityToXYZ(double x, double y, double z, float speed);

    /**
     * Plays the sound of this entity (For example the growl of a Zombie if this
     * is a Zombie)
     */
    void playLivingSound();

    /**
     * Spawn this entity with an attached rider(s) on its back
     *
     * @param riders
     *         the rider(s) to spawn with the Entity
     *
     * @return {@code true} if successful; {@code false} if not
     */
    boolean spawn(EntityLiving... riders);

    /**
     * Get this Entity's attack target.
     *
     * @return target
     * the {@link LivingBase} target or {@code null} for no target
     */
    LivingBase getAttackTarget();

    /**
     * Sets this Entity's attack target.
     *
     * @param livingbase
     *         the target to attack
     */
    void setAttackTarget(LivingBase livingbase);

    /**
     * Gets the item this {@link EntityLiving} is holding
     *
     * @return {@link Item} if holding an item; {@code null} otherwise
     */
    Item getItemInHand();

    /**
     * Returns an Item array with 5 elements, representing this Entities current equipment
     *
     * @return an Item array of equipment
     *
     * @see EntityLiving#getEquipmentInSlot(int)
     */
    Item[] getEquipment();

    /**
     * Returns the equipment piece for the given slot.
     * <ul>
     * <li>0 = item in hand</li>
     * <li>1 = boots</li>
     * <li>2 = leggings</li>
     * <li>3 = chestplate</li>
     * <li>4 = helmet</li>
     * </ul>
     *
     * @param slot
     *         the equipment slot
     *
     * @return item in the slot
     */
    Item getEquipmentInSlot(int slot);

    /**
     * Override all of this Entities equipment
     *
     * @param items
     *         the items to set as equipment
     */
    void setEquipment(Item[] items);

    /**
     * Set an item to a given slot.
     * <ul>
     * <li>0 = item in hand</li>
     * <li>1 = boots</li>
     * <li>2 = leggings</li>
     * <li>3 = chestplate</li>
     * <li>4 = helmet</li>
     * </ul>
     *
     * @param item
     *         the {@link Item} to set
     * @param slot
     *         the slot to set
     */
    void setEquipment(Item item, int slot);

    /**
     * Gets the drop chance of the items in the equipment slots
     * <ul>
     * <li>0 = item in hand</li>
     * <li>1 = boots</li>
     * <li>2 = leggings</li>
     * <li>3 = chestplate</li>
     * <li>4 = helmet</li>
     * </ul>
     *
     * @param slot
     *         the slot to get chance for
     *
     * @return drop chance
     */
    float getDropChance(int slot);

    /**
     * Set the drop chance of an item for a given slot.
     * <ul>
     * <li>0 = item in hand</li>
     * <li>1 = boots</li>
     * <li>2 = leggings</li>
     * <li>3 = chestplate</li>
     * <li>4 = helmet</li>
     * </ul>
     *
     * @param slot
     *         the slot to set chance for
     * @param chance
     *         the float chance for drop
     */
    void setDropChance(int slot, float chance);

    /**
     * Gets whether the EntityLiving can pick up loot
     *
     * @return {@code true} if can pick up; {@code false} if not
     */
    boolean canPickUpLoot();

    /**
     * Sets whether the EntityLiving can pick up loot
     *
     * @param loot
     *         {@code true} if can pick up; {@code false} if not
     */
    void setCanPickUpLoot(boolean loot);

    /**
     * Gets if the EntityLiving is persistent (like Ocelots or Wolves)
     *
     * @return {@code true} for persistent; {@code false} for not
     */
    boolean isPersistenceRequired();

    /**
     * Get the PathFinder class for this Entity.
     *
     * @return the pathfinder
     */
    PathFinder getPathFinder();

    /**
     * Returns the AIManager for this entity. <br>
     * <b>NOTE:</b> This manager is for AI that is reaction based. i.e. attacking
     * enemy entities when they are close or picking up an item that is nearby
     * when walking
     *
     * @return AI Manager
     */
    AIManager getAITaskManager();

    /**
     * Returns the targeting AIManager for this entity. <br>
     * <b>NOTE:</b> This manager is for AI that is target based. Like moving to
     * a Location or finding an entity to attack.
     *
     * @return AI Manager
     */
    AIManager getAITargetTaskManager();

    /**
     * Checks if the EntityLiving can attack the {@link EntityType}
     *
     * @param type
     *         the {@link EntityType} to check
     *
     * @return {@code true} if can attack; {@code false} if not
     */
    boolean canAttackEntity(EntityType type);
}
