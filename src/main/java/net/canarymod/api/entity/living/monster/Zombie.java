package net.canarymod.api.entity.living.monster;

import net.canarymod.api.entity.living.humanoid.Villager;

/**
 * Zombie wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Zombie extends EntityMob {

    /**
     * Gets if the Zombie is a {@link Villager}
     *
     * @return {@code true} if Villager; {@code false} if not
     */
    boolean isVillager();

    /**
     * Sets if the Zombie is a {@link Villager}
     *
     * @param villager
     *         {@code true} for Villager; {@code false} for not
     */
    void setVillager(boolean villager);

    /**
     * Gets if the Zombie is a child
     *
     * @return {@code true} if child; {@code false} if not
     */
    boolean isChild();

    /**
     * Sets if the Zombie is a child
     *
     * @param child
     *         {@code true} for child; {@code false} for not
     */
    void setChild(boolean child);

    /**
     * Gets the number of ticks till converting into a {@link Villager}<br>
     * NOTE: This will be 0 or -1 if the Zombie isn't converting
     *
     * @return the ticks till converting
     */
    int getConversionTime();

    /**
     * Sets the number of ticks till converting into a {@link Villager}<br>
     * NOTE: This will cause the Conversion process to start
     *
     * @param ticks
     *         the number of ticks till converting
     */
    void setConversionTime(int ticks);

    /**
     * Gets whether the Zombie is in the process of converting to a {@link Villager}
     *
     * @return {@code true} if converting; {@code false} if not
     */
    boolean isConverting();

    /**
     * Stops the conversion process of the Zombie.<br>
     * NOTE: This will set the ConversionTime to -1
     */
    void stopConverting();

    /**
     * Converts the Zombie into a {@link Villager}
     */
    void convertToVillager();
}
