package net.canarymod.hook.world;

import net.canarymod.api.world.BiomeType;
import net.canarymod.api.world.World;
import net.canarymod.hook.Hook;

/**
 * Chunk creation hook. Contains information about a new chunk being created.
 *
 * @author Jason (darkdiplomat)
 */
public final class ChunkCreationHook extends Hook {

    private int x, z;
    private int[] blockdata;
    private BiomeType[] biomedata;
    private World dimension;

    public ChunkCreationHook(int x, int z, World dimension) {
        this.x = x;
        this.z = z;
        this.dimension = dimension;
    }

    /**
     * Gets the x coordinate of the chunk
     *
     * @return x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the z coordinate of the chunk
     *
     * @return z coordinate.
     */
    public int getZ() {
        return z;
    }

    /**
     * Gets the dimension the chunk is in
     *
     * @return dimension
     */
    public World getWorld() {
        return dimension;
    }

    /**
     * Sets the blocks data. Tips: Set a int[32768] if you want to generate a new chunk.
     * The block index equals (x * 16 + z) * 128 + y where 16>x<=0, 16>z<=0, and 128>y<=0
     */
    public void setBlockData(int[] blockdata) {
        this.blockdata = blockdata;
    }

    /**
     * Gets the block data of the chunk
     *
     * @return blockdata
     */
    public int[] getBlockData() {
        return blockdata;
    }

    /**
     * Sets the biome data of each y column in the chunk
     *
     * @param biomedata
     *         An array of {@link BiomeType} for setting biome data in a chunk.
     */
    public void setBiomeData(BiomeType[] biomedata) {
        this.biomedata = biomedata;
    }

    /**
     * Gets the biomedata for the chunk
     *
     * @return An array of {@link BiomeType} for the biome data in a chunk.
     */
    public BiomeType[] getBiomeData() {
        return biomedata;
    }

    @Override
    public final String toString() {
        return String.format("%s[Chunk X=%s, Chunk Z=%s, Biome Type=%s, Block Data=%s, World=%s]", getHookName(), x, z, biomedata, blockdata, dimension);
    }
}
