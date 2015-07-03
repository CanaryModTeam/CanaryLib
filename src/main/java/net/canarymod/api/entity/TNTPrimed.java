package net.canarymod.api.entity;

import net.canarymod.api.entity.living.LivingBase;

/**
 * TNTPrimed wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface TNTPrimed extends Entity, Explosive {

    /**
     * Gets the {@link LivingBase} that activated the TNT
     *
     * @return {@link LivingBase} if activated by an entity; {@code null} if not activated by an entity
     */
    LivingBase getActivatedBy();
}
