package net.canarymod.hook.player;

import net.canarymod.api.entity.hanging.ItemFrame;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.hook.CancelableHook;

/**
 * Called when an {@link net.canarymod.api.entity.living.humanoid.Player} sets and {@link net.canarymod.api.inventory.Item} in a {@link net.canarymod.api.entity.hanging.ItemFrame}
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class ItemFrameSetItemHook extends CancelableHook {
    private final Player player;
    private final ItemFrame itemFrame;
    private final Item item;

    public ItemFrameSetItemHook(Player player, ItemFrame itemFrame, Item item) {
        this.player = player;
        this.itemFrame = itemFrame;
        this.item = item;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.living.humanoid.Player} interacting with the {@link net.canarymod.api.entity.hanging.ItemFrame}
     *
     * @return the player
     */
    public final Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.hanging.ItemFrame} being interacted with
     *
     * @return the item frame
     */
    public ItemFrame getItemFrame() {
        return itemFrame;
    }

    /**
     * Gets the {@link net.canarymod.api.inventory.Item} being placed into the {@link net.canarymod.api.entity.hanging.ItemFrame}
     *
     * @return the item or {@code null} if the item is being removed from the frame
     */
    public Item getItem() {
        return item;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, ItemFrame=%s, Item=%s]", getHookName(), player, itemFrame, item);
    }
}
