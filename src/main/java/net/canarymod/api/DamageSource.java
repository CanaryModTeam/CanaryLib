package net.canarymod.api;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Player;

/**
 * DamageSource wrapper
 *
 * @author Chris (damagefilter)
 */
public interface DamageSource {

    /**
     * Can this damage be dealt against an entity in creative mode?
     *
     * @return {@code true} if valid, {@code false} if not
     */
    boolean validInCreativeMode();

    /**
     * Check if this is fire damage
     *
     * @return {@code true} if fire damage; {@code false} if not
     */
    boolean isFireDamage();

    /**
     * Check if this is projectile damage
     *
     * @return {@code true} if projectile damage; {@code false} if not
     */
    boolean isProjectile();

    /**
     * Return the {@link DamageType} of this damage
     *
     * @return the {@link DamageType}
     */
    DamageType getDamagetype();

    /**
     * Set a custom death message to this damage type. put "%d" (without ") as
     * placeholder for a player name. This message will not be localized!
     *
     * @param deathmessage
     *         the death message to be set
     */
    void setCustomDeathMessage(String deathmessage);

    /**
     * Get death message for this DamageSource
     *
     * @param player
     *         the {@link Player} to use to get the message
     *
     * @return the death message
     */
    String getDeathMessage(Player player);

    /**
     * How much hunger will be added by indulging this damage type
     *
     * @return {@code float} damage amount
     */
    float getHungerDamage();

    /**
     * Set the amount of hunger this damage costs
     *
     * @param hunger
     *         the amount of damage
     */
    void setHungerDamage(float hunger);

    /**
     * Get the entity that caused the damage. This may return null if damage
     * wasn't caused by an entity!
     *
     * @return the {@link Entity} dealer
     */
    Entity getDamageDealer();

    /**
     * Check if this damage is unblockable (penetrates armor and can't be held
     * off by blocking it)
     *
     * @return {@code true} if unblockable; {@code false} if not
     */
    boolean isUnblockable();

    /**
     * Set this damagetype as unblockable or not
     *
     * @param blockable
     *         {@code true} for unblockable; {@code false} for not
     */
    void setUnblockable(boolean blockable);

    /**
     * Gets the name used within Native Minecraft Sources
     *
     * @return the name used within NMS
     */
    String getNativeName();

    /**
     * Gets if the DamageSource includes a critical hit.
     *
     * @return {@code true} if critical hit; {@code false} if not
     */
    boolean isCritical();
}
