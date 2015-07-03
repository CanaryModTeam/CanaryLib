package net.canarymod.hook.entity;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.effect.LightningBolt;
import net.canarymod.hook.CancelableHook;

/**
 * EntityLightningStruckHook
 * <p/>
 * Called when an {@link Entity} should be struck by a {@link LightningBolt}
 *
 * @author Jason (darkdiplomat)
 */
public final class EntityLightningStruckHook extends CancelableHook {
    private LightningBolt bolt;
    private Entity entity;

    /**
     * Constructs a new EntityLightningStruckHook
     *
     * @param bolt
     *         the {@link LightningBolt} striking
     * @param entity
     *         the {@link Entity} being stuck
     */
    public EntityLightningStruckHook(LightningBolt bolt, Entity entity) {
        this.bolt = bolt;
        this.entity = entity;
    }

    /**
     * Gets the {@link LightningBolt} striking
     *
     * @return the striking {@link LightningBolt}
     */
    public LightningBolt getLightningBolt() {
        return bolt;
    }

    /**
     * Gets the {@link Entity} being struck
     *
     * @return the struck {@link Entity}
     */
    public Entity getStruckEntity() {
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return String.format("%s[LightningBolt=%s Entity=%s]", getHookName(), bolt, entity);
    }
}
