package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Bed enter hook, called when a player enters a bed
 *
 * @author Ehud (EhudB)
 */
public class BedEnterHook extends CancelableHook {
    private Player player;
    private Block bed;

    /**
     * Create a new BedEnterHook
     *
     * @param player
     *         the player that entered the bed
     * @param bed
     *         the bed that the player entered
     */
    public BedEnterHook(Player player, Block bed) {
        this.player = player;
        this.bed = bed;
    }

    /**
     * Gets the {@link Player} entering the bed
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the bed {@link Block} the {@link Player} is entering
     *
     * @return bed block player is entering
     */
    public Block getBed() {
        return bed;
    }

    @Override
    public String toString() {
        return String.format("%s[Player=%s, Block=%s]", getHookName(), player, bed);
    }
}
