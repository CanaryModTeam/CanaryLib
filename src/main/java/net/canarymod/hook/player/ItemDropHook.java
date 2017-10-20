package net.canarymod.hook.player;

import net.canarymod.api.entity.EntityItem;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;
import net.canarymod.util.NullPlayer;

/**
 * Item Hook. Contains EntityItem and Player
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public final class ItemDropHook extends CancelableHook {

    private EntityItem item;
    private Player player;

    public ItemDropHook(Player player, EntityItem item) {
        this.player = player == null ? new NullPlayer() : player;
        this.item = item;
    }

    /**
     * Gets the {@link Player}
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link EntityItem}
     *
     * @return the {@link EntityItem}
     */
    public EntityItem getItem() {
        return item;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Item=%s]", getHookName(), player, item);
    }
}
