package net.canarymod.hook.entity;

import net.canarymod.api.DamageSource;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.hook.CancelableHook;

/**
 * Damage hook. Contains information about an entity taking damage.
 *
 * @author Jason (darkdiplomat)
 */
public final class DamageHook extends CancelableHook {

    private Entity attacker;
    private Entity defender;
    private DamageSource source;
    private float dealt;

    /**
     * Constructs a new DamageHook
     *
     * @param attacker
     *         the Entity attacking if present
     * @param defender
     *         the Entity being hurt
     * @param source
     *         the DamageSource of the cause
     * @param dealt
     *         the amount of damage to be dealt
     */
    public DamageHook(Entity attacker, Entity defender, DamageSource source, float dealt) {
        this.attacker = attacker;
        this.defender = defender;
        this.source = source;
        this.dealt = dealt;
    }

    /**
     * Gets the attacking {@link EntityLiving} if present
     *
     * @return attacker if there is one, {@code null} otherwise
     */
    public Entity getAttacker() {
        return attacker;
    }

    /**
     * Gets the defending {@link Entity}
     *
     * @return defender
     */
    public Entity getDefender() {
        return defender;
    }

    /**
     * Gets the {@link DamageSource} type
     *
     * @return the DamageSource
     */
    public DamageSource getDamageSource() {
        return source;
    }

    /**
     * Sets the {@link DamageSource}
     *
     * @param source
     *         the DamageSource cause
     */
    public void setDamageSource(DamageSource source) {
        this.source = source;
    }

    /**
     * Gets the amount of damage dealt
     *
     * @return dealt
     */
    public float getDamageDealt() {
        return dealt;
    }

    /**
     * Sets the amount of damage dealt
     *
     * @param dealt
     *         the amount of damage to deal
     */
    public void setDamageDealt(float dealt) {
        this.dealt = dealt;
    }

    @Override
    public final String toString() {
        return String.format("%s[Attacker=%s, Defender=%s, DamageSource=%s, Dealt=%.4f]", getHookName(), attacker != null ? attacker : "null", defender, source, dealt);
    }
}
