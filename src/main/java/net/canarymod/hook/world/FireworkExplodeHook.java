package net.canarymod.hook.world;

import net.canarymod.api.entity.FireworkRocket;
import net.canarymod.hook.CancelableHook;

/**
 * FireworkExplodeHook
 * <p/>
 * Called when a Firework Rocket is to explode
 *
 * @author Jason (darkdiplomat)
 */
public final class FireworkExplodeHook extends CancelableHook {
    private FireworkRocket rocket;

    /**
     * Constructs a new FireworkExplodeHook
     *
     * @param rocket
     *         the {@link FireworkRocket} to explode
     */
    public FireworkExplodeHook(FireworkRocket rocket) {
        this.rocket = rocket;
    }

    /**
     * Gets the {@link FireworkRocket} set to explode
     *
     * @return the {@link FireworkRocket}
     */
    public FireworkRocket getFireworkRocket() {
        return rocket;
    }

    @Override
    public final String toString() {
        return String.format("%s[FireworkRocket=%s]", getHookName(), rocket);
    }
}
