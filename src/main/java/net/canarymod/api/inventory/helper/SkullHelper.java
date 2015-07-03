package net.canarymod.api.inventory.helper;

import com.mojang.authlib.GameProfile;
import net.canarymod.Canary;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;

import java.util.UUID;

import static net.canarymod.api.nbt.NBTTagType.COMPOUND;
import static net.canarymod.api.nbt.NBTTagType.STRING;

/**
 * Skull helper
 *
 * @author Jason (darkdiplomat)
 */
public class SkullHelper extends ItemHelper {
    private SkullHelper() {
    } // This class should never be constructed

    public enum SkullType {
        /**
         * Skeleton Skull
         */
        SKELETON,
        //
        /**
         * Wither Skull
         */
        WITHER,
        //
        /**
         * Zombie Skull
         */
        ZOMBIE,
        //
        /**
         * Player Skull
         */
        PLAYER,
        //
        /**
         * Creeper Skull
         */
        CREEPER,
        //
        ;
    }

    /**
     * Checks if the Skull has a owner
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     *
     * @return {@code true} if has owner; {@code false} if not
     */
    public static boolean hasOwner(Item skull) {
        if (skull == null || !validSkull(skull.getType()) || getSkullType(skull) != SkullType.PLAYER) {
            return false;
        }
        if (!verifyTags(skull, "SkullOwner", COMPOUND, false)) {
            if (!verifyTags(skull, "SkullOwner", STRING, false)) {
                String owner = skull.getDataTag().getString("SkullOwner");
                return !owner.isEmpty();
            }
            return false;
        }
        return skull.getDataTag().getCompoundTag("SkullOwner").containsKey("Name", STRING);
    }

    /**
     * Gets the name of the owner if present
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     *
     * @return the owner's name or {@code null} if no owner
     */
    public static String getOwner(Item skull) {
        if (skull == null || !validSkull(skull.getType()) || getSkullType(skull) != SkullType.PLAYER) {
            return null;
        }
        if (!verifyTags(skull, "SkullOwner", COMPOUND, false)) {
            if (!verifyTags(skull, "SkullOwner", STRING, false)) {
                return skull.getDataTag().getString("SkullOwner");
            }
            return null;
        }
        return skull.getDataTag().getCompoundTag("SkullOwner").containsKey("Name", STRING) ? skull.getDataTag().getCompoundTag("SkullOwner").getString("Name") : null;
    }

    /**
     * Gets the profile of the owner if present
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     *
     * @return the owner's {@link com.mojang.authlib.GameProfile} or {@code null} if no owner
     */
    public static GameProfile getOwnerProfile(Item skull) {
        if (skull == null || !validSkull(skull.getType()) || getSkullType(skull) != SkullType.PLAYER) {
            return null;
        }
        if (!verifyTags(skull, "SkullOwner", COMPOUND, false)) {
            return null;
        }
        return Canary.jsonNBT().gameProfileFromNBT(skull.getDataTag().getCompoundTag("SkullOwner"));
    }

    /**
     * Sets the owner of the skull.<br>
     * Providing a null owner will remove the current owner
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     * @param owner
     *         the owner to be set, or null to remove the owner
     */
    public static void setOwner(Item skull, String owner) {
        setOwner(skull, owner != null && !owner.trim().isEmpty() ? new GameProfile(null, owner) : null);
    }

    /**
     * Sets the owner of the skull.<br/>
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     * @param ownerUUID
     *         the {@link UUID} of the Owner (can be null)
     * @param ownerName
     *         the name of the owner
     */
    public static void setOwner(Item skull, UUID ownerUUID, String ownerName) {
        setOwner(skull, new GameProfile(ownerUUID, ownerName));
    }

    /**
     * Sets the owner of the skull.<br/>
     *
     * @param skull
     *         the skull {@link net.canarymod.api.inventory.Item}
     * @param owner
     *         the {@link com.mojang.authlib.GameProfile} of the owner
     */
    public static void setOwner(Item skull, GameProfile owner) {
        if (skull == null || !validSkull(skull.getType()) || getSkullType(skull) != SkullType.PLAYER) {
            return;
        }
        if (!verifyTags(skull, "SkullOwner", COMPOUND, owner != null)) {
            return;
        }
        if (owner == null || (owner.getId() == null && (owner.getName() == null || owner.getName().trim().isEmpty()))) {
            skull.getDataTag().remove("SkullOwner");
        }
        else {
            skull.getDataTag().put("SkullOwner", Canary.jsonNBT().gameProfileToNBT(owner));
        }
    }

    /**
     * Gets the SkullType for the Skull
     *
     * @param skull
     *         the skull {@link Item}
     *
     * @return the SkullType
     */
    public static SkullType getSkullType(Item skull) {
        if (skull == null || !validSkull(skull.getType())) {
            return null;
        }
        switch (skull.getDamage()) {
            case 0:
                return SkullType.SKELETON;
            case 1:
                return SkullType.WITHER;
            case 2:
                return SkullType.ZOMBIE;
            case 3:
                return SkullType.PLAYER;
            case 4:
                return SkullType.CREEPER;
            default:
                return SkullType.SKELETON;
        }
    }

    private static boolean validSkull(ItemType type) {
        if (type.getMachineName().equals(ItemType.SkeletonHead.getMachineName())) {
            switch (type.getData()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
