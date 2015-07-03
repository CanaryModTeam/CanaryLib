package net.canarymod.hook.world;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Ignition hook. Contains information about a {@link Block} being set on fire.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public final class IgnitionHook extends CancelableHook {

    private final Player player;
    private final Block ignited, clicked;
    private final IgnitionCause cause;

    public IgnitionHook(Block ignited, Player player, Block clicked, IgnitionCause cause) {
        this.ignited = ignited;
        this.player = player;
        this.clicked = clicked;
        this.cause = cause;
    }

    /**
     * Gets the {@link Block} that is about to go up in flames
     * <p/>
     * Block Statuses: <b>NOTE: Block statuses are subject to future removal. Use {@link #getCause} instead.</b>
     * <ul>
     * <li><b>1</b> - Lava</li>
     * <li><b>2</b> - Flint&Steel</li>
     * <li><b>3</b> - Spread</li>
     * <li><b>4</b> - Burned Up</li>
     * <li><b>5</b> - Lightning Strike</li>
     * <li><b>6</b> - Small FireBall click</li>
     * <li><b>7</b> - FireBall hitting a block</li>
     * </ul>
     *
     * @return the {@link Block} catching fire
     *
     * @see Block#getStatus()
     * @see IgnitionCause
     */
    public Block getBlock() {
        return ignited;
    }

    /**
     * The {@link Player} starting the fire if present
     *
     * @return the {@link Player} starting the fire or {@code null} if not started by a Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * The {@link Block} that was clicked to cause an ignition if applicable.
     *
     * @return {@link Block} if one was clicked; {@code null} otherwise.
     */
    public Block getClickedBlock() {
        return clicked;
    }

    /**
     * Gets the {@link IgnitionCause} causing the ignition
     *
     * @return the {@link IgnitionCause}
     */
    public IgnitionCause getCause() {
        return cause;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Ignited=%s, Clicked=%s, IgnitionCause=%s]", getHookName(), player, ignited, clicked, cause);
    }

    /**
     * Ignition Cause
     * <p/>
     * Replacement for the block status codes to signify what caused the ignition<br>
     * Constants are ordered in the original block status numbers with the exception of 0 being the UNDEFINED
     *
     * @author Jason (darkdiplomat)
     */
    public enum IgnitionCause {
        /**
         * Unknown/Undefined reason
         */
        UNDEFINED,
        //
        /**
         * Lava causing ignition
         */
        LAVA,
        //
        /**
         * Flint & Steel clicking
         */
        FLINT_AND_STEEL,
        //
        /**
         * Natural Fire Spread
         */
        FIRE_SPREAD,
        //
        /**
         * Block burning up from fire nearby
         */
        BURNT,
        //
        /**
         * Lightning strikes
         */
        LIGHTNING_STRIKE,
        //
        /**
         * Small Fireball clicking
         */
        FIREBALL_CLICK,
        //
        /**
         * Small or Large Fireball hitting a block
         */
        FIREBALL_HIT,
        //
        ;
    }
}
