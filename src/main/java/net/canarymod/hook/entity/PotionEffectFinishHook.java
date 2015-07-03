package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.hook.Hook;

/**
 * PotionEffectFinishHook<br>
 * Called when a {@link PotionEffect} finishes it's effect on a {@link LivingBase}
 *
 * @author Jason (darkdiplomat)
 */
public final class PotionEffectFinishHook extends Hook {
    private LivingBase entity;
    private PotionEffect effect;

    /**
     * Constructs a new PotionEffectFinshHook
     *
     * @param entity
     *         the {@link LivingBase} having the {@link PotionEffect} finishing it's effect
     * @param effect
     *         the {@link PotionEffect} being finished
     */
    public PotionEffectFinishHook(LivingBase entity, PotionEffect effect) {
        this.entity = entity;
        this.effect = effect;
    }

    /**
     * Gets the {@link LivingBase} having a {@link PotionEffect} finishing it's effect
     *
     * @return the {@link LivingBase}
     */
    public LivingBase getEntity() {
        return entity;
    }

    /**
     * Gets the {@link PotionEffect} finishing
     *
     * @return the {@link PotionEffect}
     */
    public PotionEffect getPotionEffect() {
        return effect;
    }

    @Override
    public final String toString() {
        return String.format("%s[EntityLiving=%s, PotionEffect=%s]", getHookName(), entity, effect);
    }
}
