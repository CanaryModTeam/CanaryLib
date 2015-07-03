package net.canarymod.hook.world;

import net.canarymod.api.world.World;
import net.canarymod.hook.CancelableHook;

/**
 * Time Change hook
 *
 * @author Jason (darkdiplomat)
 */
public final class TimeChangeHook extends CancelableHook {
    private World world;
    private long time;

    /**
     * Constructs a new TimeChangeHook
     *
     * @param world
     *         the {@link World} the time is changing in
     * @param time
     *         the time being set to
     */
    public TimeChangeHook(World world, long time) {
        this.world = world;
        this.time = time;
    }

    /**
     * Gets the {@link World} the time is changing in
     *
     * @return the {@link World} of the time change
     */
    public World getWorld() {
        return world;
    }

    /**
     * Gets the time the {@link World} is being set to
     *
     * @return time to be set
     */
    public long getTime() {
        return time;
    }

    @Override
    public final String toString() {
        return String.format("%s[World=%s, Time=%s]", getHookName(), world, time);
    }
}
