package net.canarymod.hook.entity;

import net.canarymod.api.entity.vehicle.Minecart;
import net.canarymod.hook.CancelableHook;

/**
 * MinecartActivateHook<br>
 * Called when a {@link Minecart} passes over an activation rail.
 *
 * @author Jason (darkdiplomat)
 */
public final class MinecartActivateHook extends CancelableHook {
    private Minecart minecart;
    private boolean power;

    /**
     * Constructs a new MinecartActivateHook
     *
     * @param minecart
     *         the {@link Minecart} being activated
     * @param power
     *         whether the {@link Minecart} is receiving power or not
     */
    public MinecartActivateHook(Minecart minecart, boolean power) {
        this.minecart = minecart;
        this.power = power;
    }

    /**
     * Gets the {@link Minecart}
     *
     * @return the {@link Minecart}
     */
    public Minecart getMinecart() {
        return minecart;
    }

    /**
     * Checks if the {@link Minecart} is receiving power or not
     *
     * @return {@code true} if powered; {@code false} if not
     */
    public boolean isPowered() {
        return power;
    }

    @Override
    public final String toString() {
        return String.format("%s[Minecart=%s, Power=%b]", getHookName(), minecart, power);
    }
}
