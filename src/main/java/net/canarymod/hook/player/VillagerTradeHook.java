package net.canarymod.hook.player;

import net.canarymod.api.VillagerTrade;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.humanoid.Villager;
import net.canarymod.hook.CancelableHook;

/**
 * VillagerTrade Hook<br>
 * Called when a {@link Player} trades with a {@link VillagerTrade} from an {@link Villager}
 *
 * @author Jason (darkdiplomat)
 */
public final class VillagerTradeHook extends CancelableHook {
    private Player player;
    private Villager villager;
    private VillagerTrade trade;

    /**
     * Constructs a new VillagerTradeHook
     *
     * @param player
     *         the {@link Player} who is trading
     * @param villager
     *         the {@link Villager} merchant
     * @param trade
     *         the {@link VillagerTrade}
     */
    public VillagerTradeHook(Player player, Villager villager, VillagerTrade trade) {
        this.player = player;
        this.villager = villager;
        this.trade = trade;
    }

    /**
     * Gets the {@link Player} who is trading
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
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
     * Gets the {@link VillagerTrade}
     *
     * @return the {@link VillagerTrade}
     */
    public VillagerTrade getTrade() {
        return trade;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Villager=%s, Villager Trade=%s]", getHookName(), player, villager, trade);
    }
}
