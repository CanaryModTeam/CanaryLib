package net.canarymod.api.inventory.helper;

import net.canarymod.Canary;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.nbt.ListTag;
import net.canarymod.api.potion.PotionEffect;

import java.util.Iterator;

import static net.canarymod.api.inventory.ItemType.Potion;
import static net.canarymod.api.nbt.NBTTagType.LIST;

/**
 * Potion Item Helper!
 *
 * @author Jason (darkdiplomat)
 */
public class PotionItemHelper extends ItemHelper {
    private PotionItemHelper() {
    }

    /**
     * Checks a Item for being a Potion
     *
     * @param potion
     *         the {@link Item} to check
     *
     * @return {@code true} if Potion; {@code false} if not
     */
    public static boolean isPotion(Item potion) {
        return potion != null && potion.getType() == Potion;
    }

    /**
     * Checks a Potion for custom {@link PotionEffect}(s)
     *
     * @param potion
     *         the potion to be checked
     *
     * @return {@code true} if have custom effect; {@code false} if not
     */
    public static boolean hasCustomPotionEffects(Item potion) {
        if (!isPotion(potion)) {
            return false;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, false)) {
            return false;
        }
        return !potion.getDataTag().getListTag("CustomPotionEffects").isEmpty();
    }

    /**
     * Gets an array of {@link PotionEffect} attached to the Potion if any
     *
     * @param potion
     *         the potion to get effects for
     *
     * @return the {@link PotionEffect} array or {@code null} if no effects
     */
    public static PotionEffect[] getCustomPotionEffects(Item potion) {
        if (!isPotion(potion)) {
            return null;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, false)) {
            return null;
        }
        if (potion.getDataTag().getListTag("CustomPotionEffects").isEmpty()) {
            return null;
        }
        ListTag<CompoundTag> effects = potion.getDataTag().getListTag("CustomPotionEffects");
        PotionEffect[] potion_effects = new PotionEffect[effects.size()];
        for (int index = 0; index < effects.size(); index++) {
            CompoundTag effect = effects.get(index);
            potion_effects[index] = Canary.factory().getPotionFactory().newPotionEffect(effect.getByte("Id"), effect.getInt("Duration"), effect.getByte("Amplifier"), effect.getBoolean("Ambient"));
        }
        return potion_effects;
    }

    /**
     * Adds custom {@link PotionEffect}(s) to the Potion {@link Item}
     *
     * @param potion
     *         the potion to add custom effects to
     * @param effects
     *         the custom effects to add
     *
     * @return {@code true} if successful; {@code false} if not
     */
    public static boolean addCustomPotionEffects(Item potion, PotionEffect... effects) {
        if (!isPotion(potion) || effects == null || effects.length <= 0) {
            return false;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, true)) {
            return false;
        }
        ListTag<CompoundTag> potion_effects = potion.getDataTag().getListTag("CustomPotionEffects");
        boolean success = true;
        for (PotionEffect effect : effects) {
            if (effect == null) {
                continue;
            }
            CompoundTag potion_effect = TAG.copy();
            potion_effect.put("Id", (byte)effect.getPotionID());
            potion_effect.put("Duration", effect.getDuration());
            potion_effect.put("Amplifier", (byte)effect.getAmplifier());
            potion_effect.put("Ambient", effect.isAmbient());
            success &= potion_effects.add(potion_effect);
        }
        return success;
    }

    /**
     * Sets custom {@link PotionEffect}(s) to the Potion {@link Item}
     *
     * @param potion
     *         the potion to set custom effects to
     * @param effects
     *         the custom effects to be set
     *
     * @return {@code true} if successful; {@code false} if not
     */
    public static boolean setCustomPotionEffects(Item potion, PotionEffect... effects) {
        if (!isPotion(potion) || effects == null || effects.length <= 0) {
            return false;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, true)) {
            return false;
        }
        ListTag<CompoundTag> potion_effects = potion.getDataTag().getListTag("CustomPotionEffects");
        potion_effects.clear();
        boolean success = true;
        for (PotionEffect effect : effects) {
            if (effect == null) {
                continue;
            }
            CompoundTag potion_effect = TAG.copy();
            potion_effect.put("Id", (byte)effect.getPotionID());
            potion_effect.put("Duration", effect.getDuration());
            potion_effect.put("Amplifier", (byte)effect.getAmplifier());
            potion_effect.put("Ambient", effect.isAmbient());
            success &= potion_effects.add(potion_effect);
        }
        return success;
    }

    /**
     * Removes specified custom {@link PotionEffect}(s) from the Potion
     *
     * @param potion
     *         the potion to remove effects from
     * @param effects
     *         the effects to remove
     *
     * @return {@code true} if successful; {@code false} if not
     */
    public static boolean removeCustomPotionEffects(Item potion, PotionEffect... effects) {
        if (!isPotion(potion) || effects == null || effects.length <= 0) {
            return false;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, false)) {
            return false;
        }
        ListTag<CompoundTag> custom_effects = potion.getDataTag().getListTag("CustomPotionEffects");
        Iterator<CompoundTag> tagItr = custom_effects.iterator();
        boolean success = true;
        while (tagItr.hasNext()) {
            CompoundTag custom_effect = tagItr.next();
            boolean found = false;
            for (PotionEffect effect : effects) {
                if (custom_effect.getByte("Id") == effect.getPotionID() && custom_effect.getInt("Duration") == effect.getDuration() &&
                        custom_effect.getByte("Amplifier") == effect.getPotionID() && custom_effect.getBoolean("Ambient") == effect.isAmbient()) {
                    tagItr.remove();
                    found = true;
                }
            }
            success &= found;
        }
        return success;
    }

    /**
     * Removes all custom {@link PotionEffect}(s) from the Potion
     *
     * @param potion
     *         the potion to remove effects from
     *
     * @return {@code true} if successful; {@code false} if not
     */
    public static boolean removeAllCustomPotionEffects(Item potion) {
        if (!isPotion(potion)) {
            return false;
        }
        if (!verifyTags(potion, "CustomPotionEffects", LIST, false)) {
            return false;
        }
        if (potion.getDataTag().getListTag("CustomPotionEffects").isEmpty()) {
            return false;
        }
        potion.getDataTag().getListTag("CustomPotionEffects").clear();
        return true;
    }
}
