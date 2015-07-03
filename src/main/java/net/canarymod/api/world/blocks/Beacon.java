package net.canarymod.api.world.blocks;

import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.potion.PotionEffectType;

/**
 * Beacon wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Beacon extends LockableTileEntity, Inventory {

    /**
     * Checks through the list of supported potions to see if the input effect
     * is one of them.
     *
     * @param effect
     *         the {@link PotionEffectType} to check
     *
     * @return {@code true} if valid; {@code false} if not
     */
    boolean isValidEffect(PotionEffectType effect);

    /**
     * Checks through the list of supported potions up to the specified level
     *
     * @param effect
     *         the {@link PotionEffectType} to check
     * @param levels
     *         the max level
     *
     * @return {@code true} if valid; {@code false} if not
     */
    boolean isValidEffectAtLevels(PotionEffectType effect, int levels);

    /**
     * Gets the primary {@link PotionEffectType}
     *
     * @return the primary {@link PotionEffectType}
     */
    PotionEffectType getPrimaryEffect();

    /**
     * Sets the primary {@link PotionEffectType} *IF* the effect is on the supported potion list
     *
     * @param effect
     *         the {@link PotionEffectType} to set
     */
    void setPrimaryEffect(PotionEffectType effect);

    /**
     * Allows mods to set other potion effects not allowed by default
     *
     * @param effect
     *         the {@link PotionEffectType} to set
     */
    void setPrimaryEffectDirectly(PotionEffectType effect);

    /**
     * Gets the secondary {@link PotionEffectType}
     *
     * @return the secondary {@link PotionEffectType}
     */
    PotionEffectType getSecondaryEffect();

    /**
     * Sets the secondary {@link PotionEffectType} *IF* the effect is on the supported potion list
     *
     * @param effect
     *         the secondary {@link PotionEffectType}
     */
    void setSecondaryEffect(PotionEffectType effect);

    /**
     * Allows mods to set other potion effects not allowed by default
     *
     * @param effect
     *         the {@link PotionEffectType} to set
     */
    void setSecondaryEffectDirectly(PotionEffectType effect);

    /**
     * Gets the levels of the Beacon
     *
     * @return the beacon levels
     */
    int getLevels();

    /**
     * Sets the levels of the Beacon
     *
     * @param levels
     *         the beacon levels
     */
    void setLevels(int levels);
}
