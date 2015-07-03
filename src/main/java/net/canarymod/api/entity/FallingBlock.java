package net.canarymod.api.entity;

import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.blocks.Anvil;
import net.canarymod.api.world.blocks.Block;

/**
 * Falling Block wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface FallingBlock extends Entity {

    /**
     * Gets the {@link Block} (state) of the FallingBlock
     *
     * @return block
     */
    Block getBlock();

    /**
     * Sets the {@link Block} (state) of the FallingBlock
     *
     * @param block
     *         the block to set
     */
    void setBlock(Block block);

    /**
     * Gets the Block ID of the FallingBlock
     *
     * @return the Block ID
     *
     * @deprecated use {@link #getBlock()} instead
     */
    @Deprecated
    short getBlockID();

    /**
     * Sets the Block ID of the FallingBlock
     *
     * @param id
     *         the Block ID
     *
     * @deprecated use {@link #setBlock(net.canarymod.api.world.blocks.Block)} instead
     */
    @Deprecated
    void setBlockID(short id);

    /**
     * Gets the Block's metadata
     *
     * @return the Block's MetaData
     *
     * @deprecated metadata is no longer used, use {@link #getBlock()} instead
     */
    @Deprecated
    short getBlockMetaData();

    /**
     * Sets the Block's metadata
     *
     * @param data
     *         the Block's MetaData
     *
     * @deprecated metadata is no longer used, use {@link #setBlock(net.canarymod.api.world.blocks.Block)} instead
     */
    @Deprecated
    void setBlockMetaData(short data);

    /**
     * Gets the ticks that the entity has fallen.<br>
     * When it reaches 600, it stops.
     *
     * @return fall time
     */
    int getFallTime();

    /**
     * Sets the amount of time the entity has fallen.
     *
     * @param fallTime
     *         the ticks of fallTime
     */
    void setFallTime(int fallTime);

    /**
     * Gets if when the entity finishes falling if it turns into a {@link Block} or drops an {@link Item}
     *
     * @return {@code true} if drops {@link Item}; {@code false} if turns into a {@link Block}
     */
    boolean dropsItem();

    /**
     * Sets if when the entity finishes falling if it turns into a {@link Block} or drops an {@link Item}
     *
     * @param drops
     *         {@code true} if drops {@link Item}; {@code false} if turns into a {@link Block}
     */
    void setDropsItem(boolean drops);

    /**
     * Gets if the fall will destroy the {@link Anvil} (if it is an {@link Anvil})
     *
     * @return {@code true} if breaking; {@code false} if not
     */
    boolean isBreakingAnvil();

    /**
     * Gets if the fall will destroy the {@link Anvil} (if it is an {@link Anvil})<br>
     * If the blockID is not an {@link Anvil}, this has no effect.
     *
     * @param breaking
     *         {@code true} if breaking; {@code false} if not
     */
    void setIsBreakingAnvil(boolean breaking);

    /**
     * Gets if the entity will hurt entities
     *
     * @return {@code true} if hurts; {@code false} if not
     */
    boolean hurtEntities();

    /**
     * Sets if the entity will hurt entities
     *
     * @param hurt
     *         {@code true} if hurts; {@code false} if not
     */
    void setHurtEntities(boolean hurt);

    /**
     * Gets the maximum damage the Block can cause if it hits an Entity
     *
     * @return maximum damage
     */
    int getMaxDamage();

    /**
     * Sets the maximum damage the Block can cause if it hits an Entity
     *
     * @param max
     *         the maximum damage the block may cause
     */
    void setMaxDamage(int max);

    /**
     * Gets the damage caused by the FallingBlock multiplied by the number of blocks fell
     *
     * @return damage
     * the amount of base damage
     */
    float getDamageAmount();

    /**
     * Sets the damage caused by the FallingBlock
     *
     * @param damage
     *         the amount of base damage to cause
     */
    void setDamageAmount(float damage);
}
