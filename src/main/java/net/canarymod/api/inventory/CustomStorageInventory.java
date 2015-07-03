package net.canarymod.api.inventory;

import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.nbt.ListTag;

/**
 * Custom Inventory wrapper interface
 *
 * @author Jason (darkdiplomat)
 */
public interface CustomStorageInventory extends Inventory {

    ListTag<CompoundTag> saveInventoryNBT();

    void loadInventoryNBT(ListTag<CompoundTag> listTag);
}
