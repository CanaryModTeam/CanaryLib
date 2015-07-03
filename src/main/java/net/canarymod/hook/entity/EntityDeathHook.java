package net.canarymod.hook.entity;

import net.canarymod.api.DamageSource;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;
import net.canarymod.hook.player.PlayerDeathHook;

/**
 * EntityDeathHook
 * <p/>
 * Called when a Entity (other than a {@link Player}) dies.<br>
 * For {@link Player} death, use {@link PlayerDeathHook}
 *
 * @author Jason (darkdiplomat)
 * @see PlayerDeathHook
 */
public final class EntityDeathHook extends Hook {
    private Entity entity;
    private DamageSource cause;

    /**
     * Constructs a new EntityDeathHook
     *
     * @param entity
     *         the {@link Entity} that is dying
     * @param cause
     *         the {@link DamageSource} that killed the Entity
     */
    public EntityDeathHook(Entity entity, DamageSource cause) {
        this.entity = entity;
        this.cause = cause;
    }

    /**
     * Gets the {@link Entity} that is dying
     *
     * @return the dying entity
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * Gets the {@link DamageSource} that killed the {@link Entity}
     *
     * @return the death dealing {@link DamageSource}
     */
    public DamageSource getDamageSource() {
        return cause;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return String.format("%s[Entity=%s DamageSource=%s]", getHookName(), entity, cause);
    }
}
