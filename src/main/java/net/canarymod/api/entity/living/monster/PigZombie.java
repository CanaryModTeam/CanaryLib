package net.canarymod.api.entity.living.monster;

import net.canarymod.api.entity.living.humanoid.Player;

/**
 * PigZombie wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface PigZombie extends Zombie {

    /**
     * basic check to see if this PigZombie is angry
     *
     * @return true if angry
     */
    boolean isAngry();

    /**
     * gets this PigZombie's anger level
     *
     * @return level
     */
    int getAngerLevel();

    /**
     * sets this PigZombie's anger level
     *
     * @param level
     *         the anger level
     */
    void setAngerLevel(int level);

    /**
     * Argo on the specified {@link Player}
     *
     * @param player
     *         the {@link Player} to become angry at
     */
    void becomeAngryAt(Player player);

    /**
     * Get mad!
     *
     * @param player
     *         target
     */
    void dontMakeLemonade(Player player);
}
