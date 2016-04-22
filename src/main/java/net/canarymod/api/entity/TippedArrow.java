package net.canarymod.api.entity;

import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionType;

import java.util.Set;

/**
 * Tipped Arrow wrapper
 *
 * @author Jamie Mansfield (jamierocks)
 */
public interface TippedArrow extends Arrow {

    /**
     * Gets the type of potion used by this Arrow
     *
     * @return the potion type
     */
    PotionType getPotionType();

    /**
     * Gets the potion effects applied to this Arrow
     *
     * @return the potion effects
     */
    Set<PotionEffect> getPotionEffects();

    /**
     * Applies the specified potion effects to this Arrow
     *
     * @param potionEffects the potion effect(s) to apply
     */
    void addPotionEffects(PotionEffect... potionEffects);
}
