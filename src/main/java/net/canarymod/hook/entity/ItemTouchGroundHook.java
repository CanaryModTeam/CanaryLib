package net.canarymod.hook.entity;

import net.canarymod.api.entity.EntityItem;
import net.canarymod.hook.CancelableHook;

/**
 * ItemTouchGroundHook<br>
 * Called when an {@link EntityItem} hits the ground
 *
 * @author Jason (darkdiplomat)
 */
public class ItemTouchGroundHook extends CancelableHook {
    private EntityItem item;

    /**
     * Constructs a new ItemTouchGroundHook
     *
     * @param item
     *         the {@link EntityItem} hitting the ground
     */
    public ItemTouchGroundHook(EntityItem item) {
        this.item = item;
    }

    /**
     * Gets the {@link EntityItem} hitting the ground
     *
     * @return the {@link EntityItem}
     */
    public EntityItem getEntityItem() {
        return item;
    }

    @Override
    public final String toString() {
        return String.format("%s[EntityItem=%s]", getHookName(), item);
    }
}
