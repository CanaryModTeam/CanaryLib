package net.canarymod.hook.world;

import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.position.Position;
import net.canarymod.hook.CancelableHook;

/**
 * PortalDestroyHook<br/>
 * Contains information about a portal being destroyed
 *
 * @author Chris (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public final class PortalDestroyHook extends CancelableHook {

    private final Block[][] blocks;
    private final Position pos;
    private final World world;

    /**
     * Constructs a new PortalDestroyHook
     *
     * @param blocks
     *         the {@link Block} set the make up the portal
     */
    public PortalDestroyHook(Block[][] blocks, Position pos, World world) {
        this.blocks = blocks;
        this.pos = pos;
        this.world = world;
    }

    /**
     * Get the set of blocks that make up the Portal
     *
     * @return block
     */
    public Block[][] getBlockSet() {
        return blocks;
    }

    /**
     * Gets the {@link net.canarymod.api.world.position.Position} where the portal is being destroyed
     *
     * @return position
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Gets the world the portal was
     *
     * @return the world
     */
    public World getWorld() {
        return this.world;
    }

    @Override
    public final String toString() {
        return String.format("%s[Blocks=%s]", getHookName(), blocks);
    }
}
