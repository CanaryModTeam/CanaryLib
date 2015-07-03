package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Enchantment;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.blocks.EnchantmentTable;
import net.canarymod.hook.CancelableHook;

import java.util.List;

/**
 * Enchant hook. Contains information about a player enchanting an item.
 *
 * @author Jason (darkdiplomat)
 * @author Chris (damagefilter)
 */
public final class EnchantHook extends CancelableHook {

    private Player player;
    private Item item;
    private EnchantmentTable enchtab;
    private List<Enchantment> enchantments;

    public EnchantHook(Player player, Item item, EnchantmentTable enchtab, List<Enchantment> enchantments) {
        this.player = player;
        this.item = item;
        this.enchtab = enchtab;
        this.enchantments = enchantments;
    }

    /**
     * Gets the {@link Player} enchanting an {@link Item}
     *
     * @return the {@link Player} enchanting
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the {@link Item}
     *
     * @return the {@link Item} being enchanted
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the {@link EnchantmentTable} in use
     *
     * @return the in use {@link EnchantmentTable}
     */
    public EnchantmentTable getEnchantmentTable() {
        return enchtab;
    }

    /**
     * Gets the new {@link Enchantment} as list
     *
     * @return enchantment list
     */
    public List<Enchantment> getEnchantmentList() {
        return enchantments;
    }

    /**
     * Override the whole list of enchantments
     *
     * @param newList
     *         the list of enchantments to set
     */
    public void setEnchantmentList(List<Enchantment> newList) {
        this.enchantments = newList;
    }

    /**
     * Add a new enchantment to the list of existing enchantments
     *
     * @param enchantment
     *         the {@link Enchantment} to add
     */
    public void addEnchantment(Enchantment enchantment) {
        enchantments.add(enchantment);
    }

    /**
     * Remove an enchantment from the list
     *
     * @param enchantment
     *         the {@link Enchantment} to remove
     */
    public void removeEnchantment(Enchantment enchantment) {
        enchantments.remove(enchantment);
    }

    /**
     * Validate the enchantments
     *
     * @param checkStackable
     *         {@code true} to check if can stack; {@code false} for not
     *
     * @return {@code true} if valid; {@code false} if not
     */
    public boolean isValid(boolean checkStackable) {
        Enchantment[] enchantmentsArray = this.enchantments.toArray(new Enchantment[this.enchantments.size()]);

        for (int i = 0; i < enchantmentsArray.length; i += 1) {
            if (enchantmentsArray[i].isValid()) {
                for (int j = i + 1; j < enchantmentsArray.length; j += 1) {
                    if (enchantmentsArray[j].isValid()) {
                        if (checkStackable && !enchantmentsArray[i].canStack(enchantmentsArray[j])) {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        return enchantmentsArray.length > 0;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Item=%s, EnchantmentTable=%s, Enchantments=%s]", getHookName(), player, item, enchtab, enchantments);
    }
}
