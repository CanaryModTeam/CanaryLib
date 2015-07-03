package net.canarymod;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.position.Location;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator wrapper for a LineTracer
 */
public class BlockIterator implements Iterator<Block> {
    private final LineTracer tracer;
    private final boolean doAir;
    private boolean alreadyAdvanced;

    /**
     * Constructor requiring player, uses default values
     *
     * @param in_player
     *         the {@link Player} to check Line of Sight for
     */
    public BlockIterator(Player in_player) {
        this.tracer = new LineTracer(in_player);
        this.doAir = false;
    }

    /**
     * Constructor requiring player, uses default values<br />
     * Skips air blocks
     *
     * @param in_player
     *         the {@link Player} to check Line of Sight for
     * @param doAir
     *         set to {@code true} to include Air blocks
     */
    public BlockIterator(Player in_player, boolean doAir) {
        this.tracer = new LineTracer(in_player);
        this.doAir = doAir;
    }

    /**
     * Constructor requiring location, uses default values<br />
     * Skips air blocks
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     */
    public BlockIterator(Location in_location) {
        this.tracer = new LineTracer(in_location);
        this.doAir = false;
    }

    /**
     * Constructor requiring location, uses default values
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     * @param doAir
     *         set to {@code true} to include Air blocks
     */
    public BlockIterator(Location in_location, boolean doAir) {
        this.tracer = new LineTracer(in_location);
        this.doAir = doAir;
    }

    /**
     * Constructor requiring player, max range, and a stepping value<br />
     * Skips air blocks
     *
     * @param in_player
     *         the {@link Player} to check Line of Sight for
     * @param in_range
     *         the maximum range to check
     * @param in_step
     *         the stepping value, the amount Y to increase/decrease the further away the checks get
     */
    public BlockIterator(Player in_player, int in_range, double in_step) {
        this.tracer = new LineTracer(in_player, in_range, in_step);
        this.doAir = false;
    }

    /**
     * Constructor requiring player, max range, and a stepping value
     *
     * @param in_player
     *         the {@link Player} to check Line of Sight for
     * @param in_range
     *         the maximum range to check
     * @param in_step
     *         the stepping value, the amount Y to increase/decrease the further away the checks get
     * @param doAir
     *         set to {@code true} to include Air blocks
     */
    public BlockIterator(Player in_player, int in_range, double in_step, boolean doAir) {
        this.tracer = new LineTracer(in_player, in_range, in_step);
        this.doAir = doAir;
    }

    /**
     * Constructor requiring location, max range, and a stepping value<br />
     * Skips air blocks
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     * @param in_range
     *         the maximum range to check
     * @param in_step
     *         the stepping value, the amount Y to increase/decrease the further away the checks get
     */
    public BlockIterator(Location in_location, int in_range, double in_step) {
        this.tracer = new LineTracer(in_location, in_range, in_step);
        this.doAir = false;
    }

    /**
     * Constructor requiring location, max range, and a stepping value
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     * @param in_range
     *         the maximum range to check
     * @param in_step
     *         the stepping value, the amount Y to increase/decrease the further away the checks get
     * @param doAir
     *         set to {@code true} to include Air blocks
     */
    public BlockIterator(Location in_location, int in_range, double in_step, boolean doAir) {
        this.tracer = new LineTracer(in_location, in_range, in_step);
        this.doAir = false;
    }

    /**
     * Creats a BlockIterator from a {@link net.canarymod.LineTracer}<br />
     * Skips air blocks
     *
     * @param tracer
     *         the LineTracer to use with this BlockIterator
     */
    public BlockIterator(LineTracer tracer) {
        this.tracer = tracer;
        this.doAir = false;
    }

    /**
     * Creats a BlockIterator from a {@link net.canarymod.LineTracer}
     *
     * @param tracer
     *         the LineTracer to use with this BlockIterator
     * @param doAir
     *         set to {@code true} to include Air blocks
     */
    public BlockIterator(LineTracer tracer, boolean doAir) {
        this.tracer = tracer;
        this.doAir = doAir;
    }

    /**
     * Checks if there are more {@link net.canarymod.api.world.blocks.Block}s in line
     *
     * @return {@code true} if the is a next block
     */
    @Override
    public boolean hasNext() {
        if (alreadyAdvanced) { 
            /* we've already done this check, so check the curent LineTracer block */
            return tracer.getCurBlock() != null;
        }
        alreadyAdvanced = true; // Need to track if we have advanced or not
        return tracer.getNextBlock(doAir) != null;
    }

    /**
     * Gets the next {@link net.canarymod.api.world.blocks.Block} in line
     *
     * @return next block
     *
     * @throws NoSuchElementException
     *         if there are no more blocks
     */
    @Override
    public Block next() {
        if (alreadyAdvanced) { // If hasNext was checked, then we need to check the current block
            alreadyAdvanced = false; //We are no longer advanced
            if (tracer.getCurBlock() == null) {
                throw new NoSuchElementException("No more blocks");
            }
            return tracer.getCurBlock();
        }
        Block block = tracer.getNextBlock(doAir);
        if (block == null) {
            throw new NoSuchElementException("No more blocks");
        }
        return block;
    }

    /**
     * Sets the current block to Air, effectively removing it from the world
     */
    @Override
    public void remove() {
        tracer.getCurBlock().setType(BlockType.Air);
        tracer.getCurBlock().update();
    }

    /**
     * Replaces the current block with the given BlockType
     *
     * @param type
     *         the block type used to replace the current block
     */
    public void replace(BlockType type) {
        tracer.getCurBlock().setType(type);
        tracer.getCurBlock().update();
    }

    /**
     * Replaces the current block type to the given BlockType Id
     *
     * @param type
     *         the new block id
     */
    public void replace(int type) {
        tracer.getCurBlock().setTypeId((short)type);
        tracer.getCurBlock().update();
    }

    /**
     * Replaces the current block type to the given BlockType Id and data
     *
     * @param type
     *         the new block id
     * @param data
     *         the new block data
     */
    public void replace(int type, int data) {
        tracer.getCurBlock().setTypeId((short)type);
        tracer.getCurBlock().setData((short)data);
    }
}
