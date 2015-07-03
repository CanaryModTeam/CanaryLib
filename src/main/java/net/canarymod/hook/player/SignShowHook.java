package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Sign;
import net.canarymod.hook.Hook;

/**
 * Sign Change hook. Contains information about a sign shown to a player
 *
 * @author Jason (darkdiplomat)
 */
public final class SignShowHook extends Hook {
    private final Player player;
    private final Sign sign;

    /**
     * Constructs a new SignShowHook
     *
     * @param player
     *         the {@link Player} being shown a {@link Sign}
     * @param sign
     *         the {@link Sign} being shown
     */
    public SignShowHook(Player player, Sign sign) {
        this.player = player;
        this.sign = sign;
    }

    /**
     * Gets the {@link Player} being shown a {@link Sign}
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Sign} being shown
     *
     * @return the {@link Sign}
     */
    public Sign getSign() {
        return sign;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Sign=%s]", getHookName(), player, sign);
    }
}
