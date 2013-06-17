package net.canarymod.api.entity.living.animal;

import net.canarymod.api.entity.living.EntityLiving;

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
    public EntityLiving getOwner();

    /**
     * Set the owner of this entity
     * 
     * @param entity
     *            the {@link EntityLiving} to set as Owner
     */
    public void setOwner(EntityLiving entity);

    /**
     * Check if that animal is tamed
     * 
     * @return {@code true} if tame; {@code false} otherwise
     */
    public boolean isTamed();

    /**
     * Set this entity tamed or not
     * 
     * @param tamed
     *            {@code true} for tame; {@code false} for not tame
     */
    public void setTamed(boolean tamed);

    /**
     * Check if this animal is currently sitting
     * 
     * @return {@code true} if sitting; {@code false} otherwise
     */
    public boolean isSitting();

    /**
     * Set this entity sitting or not
     * 
     * @param sitting
     *            {@code true} for sitting; {@code false} for not sitting
     */
    public void setSitting(boolean sitting);
}
