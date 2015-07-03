package net.canarymod.api;

import net.canarymod.api.nbt.CompoundTag;

/**
 * An offline player. This is an offline version of a registered player.
 * OfflinePlayer contains information about groups, permissions, world and
 * location where the player has logged out, according to data on disk.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public interface OfflinePlayer extends PlayerReference {

    /**
     * Get the NBT tag for this offline player
     *
     * @return {@link CompoundTag}
     */
    CompoundTag getNBT();

    /**
     * Save changes made to this offline player.
     * <b>Important:</b> This will only apply if the player is not online!
     */
    void save();
}
