package net.canarymod.api.entity.living.monster;

/**
 * Skeleton wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Skeleton extends EntityMob, RangedAttackMob {

    /**
     * Gets whether this Skeleton is a WitherSkeleton
     *
     * @return {@code true} if WitherSkeleton; {@code false} if not
     */
    boolean isWitherSkeleton();

    /**
     * Sets whether this Skeleton is a WitherSkeleton
     *
     * @param wither
     *         {@code true} if WitherSkeleton; {@code false} if not
     */
    void setIsWitherSkeleton(boolean wither);
}
