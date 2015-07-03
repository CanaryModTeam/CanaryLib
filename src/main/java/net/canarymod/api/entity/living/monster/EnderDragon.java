package net.canarymod.api.entity.living.monster;

import net.canarymod.api.entity.EnderCrystal;

/**
 * EnderDragon wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface EnderDragon extends EntityMob {

    /**
     * Checks if the EnderDragon is being slowed down (ie: flying through blocks)
     *
     * @return {@code true} if slowed; {@code false} if not
     */
    boolean isSlowed();

    /**
     * Gets the EnderCrystal healing the EnderDragon if present
     *
     * @return EnderCrystal if one is healing the dragon; {@code null} if none present
     */
    EnderCrystal getHealingCrystal();
}
