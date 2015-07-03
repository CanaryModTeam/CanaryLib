package net.canarymod.hook.player;

import net.canarymod.api.entity.ArmorStand;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.hook.CancelableHook;

/**
 * Called when a @{link Player} places/replaces armor in an {@link net.canarymod.api.entity.ArmorStand}
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class ArmorStandModifyHook extends CancelableHook {
    private final ArmorStand armorStand;
    private final Player player;
    private final int slotId;
    private final Item current, setting;

    public ArmorStandModifyHook(ArmorStand armorStand, Player player, int slotId, Item current, Item setting) {
        this.armorStand = armorStand;
        this.player = player;
        this.slotId = slotId;
        this.current = current;
        this.setting = setting;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.living.humanoid.Player} modifying the ArmorStand
     *
     * @return the {@link net.canarymod.api.entity.living.humanoid.Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link net.canarymod.api.inventory.Item} currently in the ArmorStand
     *
     * @return the current {@link net.canarymod.api.inventory.Item} or {@code null} if currently no item is in the slot
     */
    public Item getCurrentItem() {
        return current;
    }

    /**
     * Gets the {@link net.canarymod.api.inventory.Item} being set in the ArmorStand
     *
     * @return the placing/replacing {@link net.canarymod.api.inventory.Item} or {@code null} if removing armor from the stand
     */
    public Item getSettingItem() {
        return setting;
    }

    public int getSlotId() {
        return slotId;
    }

    @Override
    public final String toString() {
        return String.format("%s[ArmorStand=%s, Player=%s, Current=%s, Setting=%s]", getHookName(), armorStand, player, current, setting);
    }
}
