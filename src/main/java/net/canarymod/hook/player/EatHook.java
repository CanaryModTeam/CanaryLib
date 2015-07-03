package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.potion.PotionEffect;
import net.canarymod.hook.CancelableHook;

/**
 * EatHook
 * <p/>
 * Contains information about a {@link Player} having finished eating Food
 *
 * @author Jason (darkdiplomat)
 */
public final class EatHook extends CancelableHook {

    private Item item;
    private Player player;
    private int levelGain;
    private float saturationGain;
    private PotionEffect[] effects;

    /**
     * Constructs a new EatHook
     *
     * @param player
     *         the {@link Player} eating
     * @param item
     *         the {@link Item} being eaten
     * @param levelGain
     *         the amount of food level the {@link Player} will gain
     * @param saturationGain
     *         the amount of food saturation the {@link Player} will gain
     */
    public EatHook(Player player, Item item, int levelGain, float saturationGain, PotionEffect[] effects) {
        this.player = player;
        this.item = item;
        this.levelGain = levelGain;
        this.saturationGain = saturationGain;
        this.effects = effects;
    }

    /**
     * Gets the {@link Player} eating
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Item} that is being consumed
     *
     * @return the {@link Item}
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the amount of Food Level the {@link Player} will gain from consuming
     *
     * @return food level gain
     */
    public int getLevelGain() {
        return levelGain;
    }

    /**
     * Sets the Food Level the {@link Player} will gain from consuming
     *
     * @param levelGain
     *         level gain
     */
    public void setLevelGain(int levelGain) {
        this.levelGain = levelGain;
    }

    /**
     * Gets the Food Saturation the {@link Player} will gain from consuming
     *
     * @return food saturation gain
     */
    public float getSaturationGain() {
        return saturationGain;
    }

    /**
     * Sets the Food Saturation the {@link Player} will gain from consuming
     *
     * @param saturationGain
     *         the food saturation to gain
     */
    public void setSaturationGain(float saturationGain) {
        this.saturationGain = saturationGain;
    }

    /**
     * Gets the {@link PotionEffect}s that could be applied on consumption<br>
     * May be null if no effects apply to the food eaten.
     *
     * @return PotionEffects
     */
    public PotionEffect[] getPotionEffects() {
        return effects;
    }

    /**
     * Sets the {@link PotionEffect}s to applied on consumption.
     *
     * @param effects
     *         the {@link PotionEffect}s to apply
     */
    public void setPotionEffects(PotionEffect[] effects) {
        this.effects = effects;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Item=%s, LevelGain=%d, SaturationGain=%.2f, PotionEffects=%s]", getHookName(), player, item, levelGain, saturationGain, effects);
    }
}
