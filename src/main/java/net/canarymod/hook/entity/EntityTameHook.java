package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.animal.EntityAnimal;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;

/**
 * Entity tame hook
 *
 * @author Chris (damagefilter)
 */
public final class EntityTameHook extends CancelableHook {

    private EntityAnimal animal;
    private Player player;
    private boolean isTamed;

    public EntityTameHook(EntityAnimal animal, Player player, boolean isTamed) {
        this.animal = animal;
        this.player = player;
        this.isTamed = isTamed;
    }

    /**
     * Check the default tame result.
     *
     * @return True if the animal was tamed, false otherwise
     */
    public boolean isTamed() {
        return isTamed;
    }

    /**
     * Override the tame result.
     *
     * @param isTamed
     *         True to force the animal being tamed, false to force the taming to fail
     */
    public void setTamed(boolean isTamed) {
        this.isTamed = isTamed;
    }

    /**
     * Get the player that is wanting to tame the animal
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the animal in question
     *
     * @return the {@link EntityAnimal}
     */
    public EntityAnimal getAnimal() {
        return animal;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Animal=%s, isTamed=%b]", getHookName(), player, animal, isTamed);
    }
}
