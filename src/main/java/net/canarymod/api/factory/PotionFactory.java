package net.canarymod.api.factory;

import net.canarymod.api.potion.PotionEffect;
import net.canarymod.api.potion.PotionEffectType;

/**
 * PotionEffect Manufacturing Factory
 *
 * @author Jason (darkdiplomat)
 */
public interface PotionFactory {

    /**
     * Make a new {@link PotionEffect} with id, duration, and amplifier
     *
     * @param id
     *         the Potion ID
     * @param duration
     *         the Potion duration
     * @param amplifier
     *         the Potion amplifier
     *
     * @return new {@link PotionEffect}
     */
    PotionEffect newPotionEffect(int id, int duration, int amplifier);

    /**
     * Make a new {@link PotionEffect} with id, duration, amplifier, and ambient
     *
     * @param id
     *         the Potion ID
     * @param duration
     *         the Potion duration
     * @param amplifier
     *         the Potion amplifier
     * @param ambient
     *         {@code true} for ambient; {@code false} for not
     *
     * @return new {@link PotionEffect}
     */
    PotionEffect newPotionEffect(int id, int duration, int amplifier, boolean ambient);

    /**
     * Make a new {@link PotionEffect} with type, duration, and amplifier
     *
     * @param type
     *         the {@link PotionEffectType}
     * @param duration
     *         the Potion duration
     * @param amplifier
     *         the Potion amplifier
     *
     * @return new {@link PotionEffect}
     */
    PotionEffect newPotionEffect(PotionEffectType type, int duration, int amplifier);

    /**
     * Make a new {@link PotionEffect} with type, duration, and amplifier
     *
     * @param type
     *         the {@link PotionEffectType}
     * @param duration
     *         the Potion duration
     * @param amplifier
     *         the Potion amplifier
     * @param ambient
     *         {@code true} for ambient; {@code false} for not
     *
     * @return new {@link PotionEffect}
     */
    PotionEffect newPotionEffect(PotionEffectType type, int duration, int amplifier, boolean ambient);
}
