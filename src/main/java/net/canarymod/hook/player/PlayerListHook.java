package net.canarymod.hook.player;

import net.canarymod.api.PlayerListData;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;

/**
 * PlayerListHook
 * <p/>
 * Called when a {@link net.canarymod.api.entity.living.humanoid.Player} information is sent to another {@link net.canarymod.api.entity.living.humanoid.Player}
 *
 * @author Jason (darkdiplomat)
 */
public final class PlayerListHook extends CancelableHook {
    private final PlayerListData data;
    private final Player receiver;

    /**
     * Constructs a new PlayerListEntryHook
     *
     * @param entry
     *         the {@link net.canarymod.api.PlayerListData} being sent
     * @param receiver
     *         the {@link net.canarymod.api.entity.living.humanoid.Player} to receiver the {@link net.canarymod.api.PlayerListData}
     */
    public PlayerListHook(PlayerListData data, Player receiver) {
        this.data = data;
        this.receiver = receiver;
    }

    /**
     * Gets the {@link net.canarymod.api.PlayerListData} being sent
     *
     * @return {@link net.canarymod.api.PlayerListData} being sent
     */
    public final PlayerListData getData() {
        return data;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.living.humanoid.Player} to receive the PlayerListEntry
     *
     * @return the {@link net.canarymod.api.entity.living.humanoid.Player} receiver
     */
    public final Player getReceiver() {
        return receiver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return String.format("%s[Data=%s Receiver=%s]", getHookName(), data, receiver);
    }
}
