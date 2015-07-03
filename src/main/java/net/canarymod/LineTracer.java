package net.canarymod;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.position.Location;

/**
 * Traces the line of sight of an entity.
 * You can retrieve any blocks along the Line of Sight or simply the last block
 * there is within a specified range. Range defaults to 200 blocks
 *
 * @author Ho0ber
 */
public class LineTracer {
    private Location playerLoc;
    private Block currentBlock, lastBlock, targetBlock;
    private double rotX, rotY, viewHeight;
    private double length, step;
    private int range;
    private double xOffset, yOffset, zOffset;
    private double last_x, last_y, last_z;
    private double currentX, currentY, currentZ;

    /**
     * Constructor requiring player, uses default values
     *
     * @param in_player
     *         the {@link Player} to check Line of Sight for
     */
    public LineTracer(Player in_player) {
        Location loc = in_player.getLocation();
        loc.setRotation(in_player.getHeadRotation());
        init(loc, 300, 0.2, in_player.getEyeHeight()); // Reasonable default values
    }

    /**
     * Constructor requiring location, uses default values
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     */
    public LineTracer(Location in_location) {
        init(in_location, 300, 0.2, 0);
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
     */
    public LineTracer(Player in_player, int in_range, double in_step) {
        Location loc = in_player.getLocation();
        loc.setRotation(in_player.getHeadRotation());
        init(loc, in_range, in_step, in_player.getEyeHeight());
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
     */
    public LineTracer(Location in_location, int in_range, double in_step) {
        init(in_location, in_range, in_step, 0);
    }

    /**
     * Initialization method
     *
     * @param in_location
     *         the {@link Location} to check Line of Sight for
     * @param in_range
     *         the maximum range to check
     * @param in_step
     *         the stepping value, the amount Y to increase/decrease the further away the checks get
     * @param in_view_height
     *         the View Height to use, a {@link Player}'s view height is typically 1.62
     */
    public void init(Location in_location, int in_range, double in_step, double in_view_height) {
        playerLoc = in_location;
        viewHeight = in_view_height;
        range = in_range;
        step = in_step;
        length = 0;
        /* Convert these to real world math numbers */
        
        /* convert negative rotation values to positive */
        rotX = playerLoc.getRotation();
        rotX = rotX < 0 ? Math.abs(rotX) : 360 - rotX;
        /* convert minecraft pitch to degree pitch */
        rotY = 90 + playerLoc.getPitch();

        currentX = playerLoc.getX();
        /* Add Eye Height to the Y */
        currentY = playerLoc.getY() + viewHeight;
        currentZ = playerLoc.getZ();
        last_x = currentX;
        last_y = currentY;
        last_z = currentZ;
    }

    /**
     * Returns the block at the cursor, or null if out of range
     *
     * @return the Target {@link Block}
     */
    public Block getTargetBlock() {
        while ((length <= range) && targetBlock == null) {
            /* do nothing, just keep looping til we get out of range of have a block */
            getNextBlock();
        }
        return targetBlock;
    }

    /**
     * Sets the type of the block at the cursor
     *
     * @param type
     *         the {@link Block} type id
     */
    public void setTargetBlock(int type) {
        if (targetBlock != null) {
            targetBlock.setTypeId((short)type);
            targetBlock.update();
        }
    }

    /**
     * Returns STEPS forward along line of vision and returns block.
     * This method skips all Air Blocks.
     *
     * @return the next {@link Block} or null if none exists
     */
    public Block getNextBlock() {
        return getNextBlock(false);
    }

    /**
     * Returns STEPS forward along line of vision and returns block.
     *
     * @param doAir
     *         set to {@code true} to check air; {@code false} otherwise
     *
     * @return the next {@link Block} or null if none exists
     */
    public Block getNextBlock(boolean doAir) {
        Block block = null;

        while ((length <= range) && continueLoop(block)) {
            length += step;
            /* common is the first half of the equation, prevents us from calculating twice */
            double common = (step * Math.sin(Math.toRadians(rotY)));
            /* calculate the offsets */
            yOffset = (step * Math.cos(Math.toRadians(rotY)));
            zOffset = (common * Math.cos(Math.toRadians(rotX)));
            xOffset = (common * Math.sin(Math.toRadians(rotX)));
            /* Apply offset to current coordinates */
            currentX = xOffset + currentX;
            currentY = yOffset + currentY;
            currentZ = zOffset + currentZ;

            if (outOfWorld(currentX, currentY, currentZ)) {
                currentBlock = block = null;
                break;
            }

            block = playerLoc.getWorld().getBlockAt(ToolBox.floorToBlock(currentX), ToolBox.floorToBlock(currentY), ToolBox.floorToBlock(currentZ));

            if (block != null && !block.equals(currentBlock)) {
                if (block.isAir() && !doAir) {
                    continue;
                }
                /* set last values to current values */
                lastBlock = currentBlock;
                currentBlock = block;
                last_x = currentX;
                last_y = currentY;
                last_z = currentZ;
                break;
            }
        }

        /* Reset block to null if the block was air and not tracking air */
        if (block != null && block.isAir() && !doAir) {
            block = null;
        }

        /* set target block for later */
        if (targetBlock == null) {
            targetBlock = block;
        }

        return block;
    }

    /* Checks if loop can continue above */
    private boolean continueLoop(Block block) {
        if (block == null) {
            return true;
        }
        if (currentBlock != null && currentBlock.equals(block)) {
            return true;
        }
        if (block.isAir()) {
            return true;
        }
        return false;
    }

    private boolean outOfWorld(double x, double y, double z) {
        return ToolBox.floorToBlock(x) < -30000000 || ToolBox.floorToBlock(x) > 30000000 || ToolBox.floorToBlock(y) < 0 || ToolBox.floorToBlock(y) > 256 || ToolBox.floorToBlock(z) < -30000000 || ToolBox.floorToBlock(z) > 30000000;
    }

    /**
     * Returns the current {@link Block} along the line of vision
     *
     * @return the current {@link Block}
     */
    public Block getCurBlock() {
        return currentBlock;
    }

    /**
     * Sets current block type id
     *
     * @param type
     *         the {@link Block} type id
     */
    public void setCurBlock(int type) {
        if (currentBlock != null) {
            currentBlock.setTypeId((short)type);
            currentBlock.update();
        }
    }

    /**
     * Returns the previous block along the line of vision
     *
     * @return the last {@link Block} could be null if this is first iteration
     */
    public Block getLastBlock() {
        return lastBlock;
    }

    /**
     * Sets previous block type id
     *
     * @param type
     *         the {@link Block} type id
     */
    public void setLastBlock(int type) {
        if (lastBlock != null) {
            lastBlock.setTypeId((short)type);
            lastBlock.update();
        }
    }
}
