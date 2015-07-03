package net.canarymod.hook.world;

import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.entity.vehicle.TNTMinecart;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * TNT Activate Hook
 * <p/>
 * Called when a TNT block or TNTMinecart is activated
 *
 * @author Jason (darkdiplomat)
 */
public final class TNTActivateHook extends CancelableHook {
    private Block tnt;
    private TNTMinecart tntMinecart;
    private LivingBase activator;
    private ActivationCause cause;

    /**
     * Constructs a new TNTActivateHook for a TNT Block
     *
     * @param tnt
     *         the TNT being activated
     * @param activator
     *         the {@link net.canarymod.api.entity.living.LivingBase} activating the TNT if present
     * @param cause
     *         the {@link net.canarymod.hook.world.TNTActivateHook.ActivationCause}
     */
    public TNTActivateHook(Block tnt, LivingBase activator, ActivationCause cause) {
        this.tnt = tnt;
        this.activator = activator;
        this.cause = cause;
    }

    /**
     * Constucts a new TNTActivateHook for a {@link net.canarymod.api.entity.vehicle.TNTMinecart}
     *
     * @param tntMinecart
     *         the TNTMinecart being activated
     */
    public TNTActivateHook(TNTMinecart tntMinecart) {
        this.tnt = null;
        this.activator = null;
        this.cause = ActivationCause.REDSTONE;
        this.tntMinecart = tntMinecart;
    }

    /**
     * Gets the {@link Block} of TNT being activated if not a TNTMinecart call
     *
     * @return the {@link Block} of TNT; {@code null} if TNTMinecart
     */
    public Block getTNT() {
        return tnt;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.vehicle.TNTMinecart} being activated if not a TNT Block
     *
     * @return the {@link net.canarymod.api.entity.vehicle.TNTMinecart}; {@code null} if TNT Block
     */
    public TNTMinecart getTNTCart() {
        return tntMinecart;
    }

    /**
     * Gets the {@link LivingBase} that is causing the TNT to activate (if applicable)
     *
     * @return the {@link LivingBase} if present; {@code null} otherwise
     */
    public LivingBase getActivator() {
        return activator;
    }

    /**
     * Gets the {@link ActivationCause} of the TNT Activation
     *
     * @return the {@link ActivationCause}
     */
    public ActivationCause getCause() {
        return cause;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%s[TNT=%s, Activator=%s, Cause=%s]", getHookName(), tnt != null ? tnt : tntMinecart, activator, cause);
    }

    /**
     * TNT Activation causes
     *
     * @author Jason (darkdiplomat)
     */
    public enum ActivationCause {
        ENTITY,
        FIRE,
        EXPLOSION,
        REDSTONE,
        UNKNOWN;
    }
}
