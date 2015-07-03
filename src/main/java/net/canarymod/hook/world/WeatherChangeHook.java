package net.canarymod.hook.world;

import net.canarymod.api.world.World;
import net.canarymod.hook.CancelableHook;

/**
 * WeatherChange Hook
 *
 * @author Jason (darkdiplomat)
 */
public final class WeatherChangeHook extends CancelableHook {
    private World world;
    private boolean thunder, on;

    /**
     * Constructs a new WeatherChangeHook
     *
     * @param world
     *         the World where weather is changing
     * @param on
     *         whether weather is turning on or off
     * @param thunder
     *         whether or not thunder is changing
     */
    public WeatherChangeHook(World world, boolean on, boolean thunder) {
        this.world = world;
        this.on = on;
        this.thunder = thunder;
    }

    /**
     * Gets the {@link World} of the change
     *
     * @return the {@link World} the weather is changing
     */
    public World getWorld() {
        return world;
    }

    /**
     * Checks if it's a thunder change or rain change
     *
     * @return {@code true} if thunder is changing; {@code false} if rain is changing
     */
    public boolean isThunderChange() {
        return thunder;
    }

    /**
     * Checks if weather is turning on or off
     *
     * @return {@code true} if turning on; {@code false} if turning off
     */
    public boolean turningOn() {
        return on;
    }

    @Override
    public final String toString() {
        return String.format("%s[World=%s, Turing On=%s, Is Thundering=%s]", getHookName(), world, on, thunder);
    }
}
