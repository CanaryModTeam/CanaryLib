package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a player right-clicks a block, eg. uses it.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public final class BlockPlaceHook extends CancelableHook {
    private Block clicked;
    private Block placed;
    private Player player;

    /**
     * Constructs a new BlockPlaceHook
     *
     * @param player
     *         the {@link Player} placing a {@link Block}
     * @param clicked
     *         the {@link Block} being clicked
     * @param placed
     *         the {@link Block} to be placed
     */
    public BlockPlaceHook(Player player, Block clicked, Block placed) {
        this.player = player;
        this.clicked = clicked;
        this.placed = placed;
    }

    /**
     * Get the player who is placing a {@link Block}
     *
     * @return the {@link Player} placing
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the {@link Block} that was clicked
     *
     * @return the {@link Block} that was clicked
     */
    public Block getBlockClicked() {
        return clicked;
    }

    /**
     * Gets the block that will be placed
     *
     * @return the {@link Block} to be placed
     */
    public Block getBlockPlaced() {
        return placed;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Clicked=%s, Placed=%s]", getHookName(), player, clicked, placed);
    }
}
