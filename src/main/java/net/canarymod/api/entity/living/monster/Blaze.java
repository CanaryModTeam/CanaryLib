package net.canarymod.api.entity.living.monster;

/**
 * Blaze wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Blaze extends EntityMob {

    /**
     * Tells if this Blaze is on fire or not
     *
     * @return {@code true} if burning; {@code false} if not
     */
    boolean isBurning();

    /**
     * Sets if this Blaze is on fire or not
     *
     * @param isBurning
     *         {@code true} for burning; {@code false} for not
     */
    void setBurning(boolean isBurning);
}
