package net.canarymod.api.entity.living.animal;

import net.canarymod.api.DyeColor;
import net.canarymod.api.entity.living.Ageable;

/**
 * Sheep wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Sheep extends EntityAnimal, Ageable {

    /**
     * Applies stuff to the sheep that would be applied when it actually eats
     * grass
     */
    void eatGrass();

    /**
     * Get fleece color data (that is what you need to set a cloth's data to)
     *
     * @return the associated {@link DyeColor}
     */
    DyeColor getColor();

    /**
     * Set this sheep's fleece color
     *
     * @param color
     *         the {@link DyeColor} to set
     */
    void setColor(DyeColor color);

    /**
     * Check if this sheep is sheared
     *
     * @return {@code true} if sheared; {@code false} otherwise
     */
    boolean isSheared();

    /**
     * Set this sheep sheared or not
     *
     * @param sheared
     *         {@code true} for sheared; {@code false} for not
     */
    void setSheared(boolean sheared);
}
