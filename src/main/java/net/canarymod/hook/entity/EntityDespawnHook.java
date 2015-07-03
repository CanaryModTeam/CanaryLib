package net.canarymod.hook.entity;

import net.canarymod.api.entity.Entity;
import net.canarymod.hook.CancelableHook;

/**
 * Entity despawn hook. Contains information about an entity despawning.
 *
 * @author Jason (darkdiplomat)
 */
public final class EntityDespawnHook extends CancelableHook {

    private Entity entity;

    public EntityDespawnHook(Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets the {@link Entity} despawning
     *
     * @return the {@link Entity} despawning
     */
    public Entity getEntity() {
        return entity;
    }

    @Override
    public final String toString() {
        return String.format("%s[Entity=%s]", getHookName(), entity);
    }
}
