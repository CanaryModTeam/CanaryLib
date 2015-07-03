package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.hook.CancelableHook;

/**
 * Mob target hook
 * <p/>
 * Contains information about a {@link LivingBase} targeting another {@link LivingBase} either for attack or following
 *
 * @author Jason (darkdiplomat)
 */
public final class MobTargetHook extends CancelableHook {

    private LivingBase entity, target;

    /**
     * Constructs a new MobTargetHook
     *
     * @param entity
     *         the {@link LivingBase} doing the targeting
     * @param target
     *         the {@link LivingBase} target
     */
    public MobTargetHook(LivingBase entity, LivingBase target) {
        this.entity = entity;
        this.target = target;
    }

    /**
     * Gets the {@link EntityLiving} doing the targeting
     *
     * @return entity
     */
    public LivingBase getEntity() {
        return entity;
    }

    /**
     * Gets the {@link EntityLiving} being targeted
     *
     * @return the {@link EntityLiving} target
     */
    public LivingBase getTarget() {
        return target;
    }

    @Override
    public final String toString() {
        return String.format("%s[Entity=%s, Target=%s]", getHookName(), entity, target);
    }
}
