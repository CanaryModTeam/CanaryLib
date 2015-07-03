package net.canarymod.hook.entity;

import net.canarymod.api.VillagerTrade;
import net.canarymod.api.entity.living.humanoid.Villager;
import net.canarymod.hook.CancelableHook;

/**
 * VillagerTradeUnlock hook<br>
 * Called when a Trade is unlocked
 *
 * @author Jason (darkdiplomat)
 */
public final class VillagerTradeUnlockHook extends CancelableHook {
    private Villager villager;
    private VillagerTrade trade;

    /**
     * Constructs a new VillagerTradeUnlockHook
     *
     * @param villager
     *         the {@link Villager} merchant
     * @param trade
     *         the {@link VillagerTrade} unlocked
     */
    public VillagerTradeUnlockHook(Villager villager, VillagerTrade trade) {
        this.villager = villager;
        this.trade = trade;
    }

    /**
     * Gets the {@link Villager} merchant
     *
     * @return the {@link Villager}
     */
    public Villager getVillager() {
        return villager;
    }

    /**
     * Gets the {@link VillagerTrade} unlocked
     *
     * @return the {@link VillagerTrade} unlocked
     */
    public VillagerTrade getTrade() {
        return trade;
    }

    @Override
    public final String toString() {
        return String.format("%s[Villager=%s, VillagerTrade=%s]", getHookName(), villager, trade);
    }
}
