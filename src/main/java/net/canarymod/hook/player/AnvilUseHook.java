package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Anvil;
import net.canarymod.hook.Hook;

/**
 * AnvilUse Hook
 * <p/>
 * Called when a {@link Player} uses an Anvil<br>
 * Get the {@link Anvil} and modify it's values directly
 *
 * @author Jason (darkdiplomat)
 */
public final class AnvilUseHook extends Hook {
    private Player player;
    private Anvil anvil;

    /**
     * Constructs a new AnvilUseHook
     *
     * @param player
     *         the {@link Player} using the {@link Anvil}
     * @param anvil
     *         the {@link Anvil} being used
     */
    public AnvilUseHook(Player player, Anvil anvil) {
        this.player = player;
        this.anvil = anvil;
    }

    /**
     * Gets the {@link Player} using the {@link Anvil}
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Anvil} in use
     *
     * @return the {@link Anvil}
     */
    public Anvil getAnvil() {
        return anvil;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Anvil=%s]", getHookName(), player, anvil);
    }
}
