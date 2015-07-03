package net.canarymod.hook.system;

import net.canarymod.api.world.World;
import net.canarymod.hook.Hook;

/**
 * Load World Hook
 * <p/>
 * Called when a {@link World} is loaded and initialized
 *
 * @author Jason (darkdiplomat)
 */
public final class LoadWorldHook extends Hook {
    private final World world;

    public LoadWorldHook(World world) {
        this.world = world;
    }

    /**
     * Gets the {@link World} that has loaded
     *
     * @return the {@link World} that loaded
     */
    public World getWorld() {
        return world;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s[World=%s]", getHookName(), world);
    }
}
