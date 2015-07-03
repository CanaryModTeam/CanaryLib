package net.canarymod.api.entity.living.animal;

import net.canarymod.api.DyeColor;
import net.canarymod.api.entity.living.Ageable;

/**
 * Wolf wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Wolf extends Tameable, Ageable {

    /**
     * Sets the Collar color
     *
     * @param color
     *         the {@link DyeColor} to make the colar
     */
    void setCollarColor(DyeColor color);

    /**
     * Gets the Collar color
     *
     * @return collar color
     */
    DyeColor getCollarColor();

    /**
     * Gets whether the Wolf is angry or not
     *
     * @return {@code true} if angry; {@code false} if not
     */
    boolean isAngry();

    /**
     * Sets whether the Wolf is angry or not
     *
     * @param angry
     *         {@code true} for angry; {@code false} for not angry
     */
    void setAngry(boolean angry);
}
