package net.canarymod.api.entity.living;

/**
 * Ageable wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Ageable {

    /**
     * Set this animals age.
     * Set negative to turn it into a baby animal.
     * (Breeding related)
     *
     * @param age
     *         Age to set. Negative values are child ages.
     */
    void setGrowingAge(int age);

    /**
     * Get the growing age for this entity.
     * (Breeding related)
     *
     * @return The integer age of the Entity. Negative values are child ages.
     */
    int getGrowingAge();
}
