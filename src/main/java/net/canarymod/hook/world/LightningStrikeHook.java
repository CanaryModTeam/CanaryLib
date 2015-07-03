package net.canarymod.hook.world;

import net.canarymod.api.entity.effect.LightningBolt;
import net.canarymod.hook.Hook;
import net.canarymod.hook.entity.EntityLightningStruckHook;

/**
 * LightningStrikeHook
 * <p/>
 * Called when a {@link LightningBolt} strikes
 *
 * @author Jason (darkdiplomat)
 * @see EntityLightningStruckHook
 */
public final class LightningStrikeHook extends Hook {
    public LightningBolt lightbolt;

    /**
     * Creates a new LightningStrikeHook
     *
     * @param lightbolt
     *         the {@link LightningBolt} striking
     */
    public LightningStrikeHook(LightningBolt lightbolt) {
        this.lightbolt = lightbolt;
    }

    /**
     * Gets the {@link LightningBolt} striking
     *
     * @return the striking {@link LightningBolt}
     */
    public LightningBolt getLightningBolt() {
        return lightbolt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return String.format("%s[LightningBolt=%s]", getHookName(), lightbolt);
    }
}
