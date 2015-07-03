package net.canarymod.hook.entity;

import net.canarymod.api.entity.Entity;
import net.canarymod.hook.CancelableHook;

/**
 * ProjectileHitHook<br>
 * Called when a Projectile hits something
 *
 * @author Jason (darkdiplomat)
 */
public final class ProjectileHitHook extends CancelableHook {
    private Entity projectile, hit;

    /**
     * Constructs a new ProjectileHitHook
     *
     * @param projectile
     *         the {@link Entity} projectile
     * @param hit
     *         the {@link Entity} hit if present
     */
    public ProjectileHitHook(Entity projectile, Entity hit) {
        this.projectile = projectile;
        this.hit = hit;
    }

    /**
     * Gets the {@link Entity} projectile
     *
     * @return the projectile
     */
    public Entity getProjectile() {
        return projectile;
    }

    /**
     * Gets the {@link Entity} hit by the projectile
     *
     * @return {@link Entity} if present; {@code null} otherwise
     */
    public Entity getEntityHit() {
        return hit;
    }

    @Override
    public final String toString() {
        return String.format("%s[Projectile=%s, EntityHit=%s]", getHookName(), projectile, hit);
    }
}
