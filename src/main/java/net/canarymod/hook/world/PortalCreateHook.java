package net.canarymod.hook.world;

import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.position.Position;
import net.canarymod.hook.CancelableHook;

/**
 * PortalCreateHook<br/>
 * Contains information about a portal being created
 *
 * @author Chris (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public final class PortalCreateHook extends CancelableHook {

    private final Block[][] blocks;
    private final Position pos;
    private final World world;

    /**
     * Constructs a new PortalCreateHook
     *
     * @param blocks
     *         the {@link Block} set the make up the portal
     * @param pos
     *         the {@link net.canarymod.api.world.position.Position} where the portal is started
     * @param world
     *         the {@link World} the portal is being made in
     */
    public PortalCreateHook(Block[][] blocks, Position pos, World world) {
        this.blocks = blocks;
        this.pos = pos;
        this.world = world;
    }

    /**
     * Get the set of blocks that are used to create this portal
     *
     * @return block
     */
    public Block[][] getBlockSet() {
        return blocks;
    }

    /**
     * Gets the {@link net.canarymod.api.world.position.Position} where the portal is started
     *
     * @return position
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Gets the world the portal will be in
     *
     * @return the world
     */
    public World getWorld() {
        return this.world;
    }

    @Override
    public final String toString() {
        return String.format("%s[Blocks=%s, World=%s]", getHookName(), blocks, world.getFqName());
    }
}
