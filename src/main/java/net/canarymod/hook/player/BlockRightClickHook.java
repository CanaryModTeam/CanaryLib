package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a player right-clicks a block, eg. uses it.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdoplomat)
 */
public final class BlockRightClickHook extends CancelableHook {
    private Block clicked;
    private Player player;

    /**
     * Construct a new BlockRightClickHook
     *
     * @param player
     *         the Player doing the clicking
     * @param clicked
     *         the block being clicked
     */
    public BlockRightClickHook(Player player, Block clicked) {
        this.clicked = clicked;
        this.player = player;
    }

    /**
     * Get the {@link Player} who clicked the {@link Block}
     *
     * @return the {@link Player} clicking
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the {@link Block} that was clicked.
     *
     * @return the {@link Block} that was clicked
     */
    public Block getBlockClicked() {
        return clicked;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Clicked=%s]", getHookName(), player, clicked);
    }
}
