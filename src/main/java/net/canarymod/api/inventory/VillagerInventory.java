package net.canarymod.api.inventory;

import net.canarymod.api.VillagerTrade;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.humanoid.Villager;

/**
 * Villager inventory interface
 *
 * @author Almog (Swift)
 */
public interface VillagerInventory extends Inventory {

    /**
     * Get the {@link Villager} involved with this trade
     *
     * @return The {@link Villager} owning this inventory
     */
    Villager getOwner();

    /**
     * Get the {@link Player} who is trading with this Villager
     *
     * @return The {@link Player} trading this Villager
     */
    Player getPlayer();

    /**
     * Get the {@link VillagerTrade} in the inventory window
     *
     * @return the {@link VillagerTrade} in the inventory
     */
    VillagerTrade getTrade();
}
