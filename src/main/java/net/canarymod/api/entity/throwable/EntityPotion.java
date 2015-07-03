package net.canarymod.api.entity.throwable;

import net.canarymod.api.potion.PotionType;

/**
 * EntityPotion wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface EntityPotion extends EntityThrowable {

    /**
     * Gets the Potion Type ID as a short<br>
     * This id may not match any of the id's in PotionType
     *
     * @return the Potion Type ID
     */
    short getPotionTypeId();

    /**
     * Gets the Potion Type as a PotionType
     *
     * @return the Potion Type
     */
    PotionType getPotionType();

    /**
     * Sets the Potion Type ID
     *
     * @param typeId
     *         the Type ID to set
     */
    void setPotionTypeId(short typeId);

    /**
     * Sets the Potion Type
     *
     * @param type
     *         the PotionType to set
     */
    void setPotionType(PotionType type);
}
