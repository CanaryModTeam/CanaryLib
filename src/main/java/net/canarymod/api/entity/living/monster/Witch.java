package net.canarymod.api.entity.living.monster;

/**
 * Witch wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Witch extends EntityMob, RangedAttackMob {

    boolean isAgressive();

    void setAggressive(boolean aggressive);
}
