package net.canarymod.hook.player;

import net.canarymod.MathHelp;
import net.canarymod.api.entity.hanging.ItemFrame;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;

/**
 * Called when a {@link net.canarymod.api.entity.living.humanoid.Player} rotates an {@link net.canarymod.api.inventory.Item} in an {@link net.canarymod.api.entity.hanging.ItemFrame}
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class ItemFrameRotateHook extends CancelableHook {

    private final Player player;
    private final ItemFrame itemFrame;
    private int newRotation = 0;

    public ItemFrameRotateHook(Player player, ItemFrame itemFrame) {
        this.player = player;
        this.itemFrame = itemFrame;
        this.newRotation = itemFrame.getItemRotation() + 1;
    }

    /**
     * Gets the {@link Player} interacting with the {@link net.canarymod.api.entity.hanging.ItemFrame}
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
    public final ItemFrame getItemFrame() {
        return itemFrame;
    }

    /**
     * Gets the current rotation of the {@link net.canarymod.api.inventory.Item} in the {@link net.canarymod.api.entity.hanging.ItemFrame}<br/>
     * This is the same as calling {@link net.canarymod.api.entity.hanging.ItemFrame#getItemRotation}
     *
     * @return item rotation
     */
    public int getCurrentRotation() {
        return itemFrame.getItemRotation();
    }

    /**
     * Gets the new rotation that the {@link net.canarymod.api.inventory.Item} in the {@link net.canarymod.api.entity.hanging.ItemFrame} will be at.
     *
     * @return new rotation
     */
    public int getNewRotation() {
        return newRotation;
    }

    /**
     * Sets the new rotation.
     *
     * @param rotation
     *         new rotation value (0-3)
     */
    public void setNewRotation(int rotation) {
        this.newRotation = MathHelp.setInRange(rotation, 0, 3);
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, ItemFrame=%s]", getHookName(), player, itemFrame);
    }
}
