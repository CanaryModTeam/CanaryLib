package net.canarymod.api.entity;

/**
 * WitherSkull wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface WitherSkull extends Fireball, Explosive {

    /**
     * Gets if the WitherSkull comes from an invulnerable WitherBoss
     *
     * @return {@code true} if invulnerable; {@code false} if not
     */
    boolean isInvulnerable();

    /**
     * Sets if the WitherSkull comes from an invulnerable WitherBoss
     *
     * @param invulenerable
     *         {@code true} for invulnerable; {@code false} if not
     */
    void setInvulnerable(boolean invulenerable);
}
