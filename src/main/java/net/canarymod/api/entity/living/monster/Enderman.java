package net.canarymod.api.entity.living.monster;

import net.canarymod.api.world.blocks.Block;

/**
 * Enderman Wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Enderman extends EntityMob {

    /**
     * Gets the {@link Block} the Enderman carries
     * NOTE: the World and Position data of the block may be based on the Enderman's current location at the time the method is called
     *
     * @return the block being carried
     */
    Block getCarriedBlock();

    /**
     * Get the block id for the block this Enderman carries
     *
     * @return block id
     *
     * @deprecated Use {@link #getCarriedBlock} instead
     */
    @Deprecated
    short getCarriedBlockID();

    /**
     * Sets the Block the Enderman carries
     *
     * @param block
     *         the block to set
     */
    void setCarriedBlock(Block block);

    /**
     * Sets the Block ID for the block this Enderman carries
     *
     * @param blockId
     *         the block id
     *
     * @deprecated Use {@link #setCarriedBlock(net.canarymod.api.world.blocks.Block)} instead
     */
    @Deprecated
    void setCarriedBlockID(short blockId);

    /**
     * Gets the metadata of the Block the Enderman carries
     *
     * @return metadata
     *
     * @deprecated Block MetaData has gone away, use {@link #getCarriedBlock()} instead
     */
    @Deprecated
    short getCarriedBlockMetaData();

    /**
     * Sets the metadata of the Block
     *
     * @param metadata
     *         the data for the block being carried
     *
     * @deprecated Block MetaData has gone away, use {@link #setCarriedBlock(net.canarymod.api.world.blocks.Block)} instead
     */
    @Deprecated
    void setCarriedBlockMetaData(short metadata);

    /**
     * Teleport the Enderman to a random position nearby
     *
     * @return {@code true} if successful; {@code false} if not
     */
    boolean randomTeleport();

    /**
     * Gets if the Enderman is screaming
     *
     * @return {@code true} if screaming; {@code false} if not
     */
    boolean isScreaming();

    /**
     * Sets if the Enderman is screaming
     *
     * @param screaming
     *         {@code true} for screaming; {@code false} for not
     */
    void setScreaming(boolean screaming);
}
