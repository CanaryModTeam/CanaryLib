package net.canarymod.api.entity.living.animal;

import net.canarymod.api.entity.living.LivingBase;

/**
 * Tameable wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Tameable extends EntityAnimal {

    /**
     * If the entity is tamed, this returns its owner
     *
     * @return owner
     */
    LivingBase getOwner();

    /**
     * Gets the name of the owner <br/>
     * NOTE: As of Minecraft 1.8, this returns UUID string.
     *
     * @return the owner's name
     *
     * @deprecated use {@link net.canarymod.api.entity.living.animal.Tameable#getOwnerID()} instead
     */
    @Deprecated
    String getOwnerName();

    /**
     * Return the identity of this Tamable's Owner
     *
     * @return owner id
     */
    String getOwnerID();

    /**
     * Set the owner of this entity
     *
     * @param entity
     *         the {@link LivingBase} to set as Owner
     */
    void setOwner(LivingBase entity);

    /**
     * Sets the owner's name
     *
     * @param name
     *         the name of the owner
     */
    void setOwner(String name);

    /**
     * Check if that animal is tamed
     *
     * @return {@code true} if tame; {@code false} otherwise
     */
    boolean isTamed();

    /**
     * Set this entity tamed or not
     *
     * @param tamed
     *         {@code true} for tame; {@code false} for not tame
     */
    void setTamed(boolean tamed);

    /**
     * Check if this animal is currently sitting
     *
     * @return {@code true} if sitting; {@code false} otherwise
     */
    boolean isSitting();

    /**
     * Set this entity sitting or not
     *
     * @param sitting
     *         {@code true} for sitting; {@code false} for not sitting
     */
    void setSitting(boolean sitting);
}
