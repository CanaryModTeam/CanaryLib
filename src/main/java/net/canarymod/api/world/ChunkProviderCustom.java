/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.canarymod.api.world;

/**
 * A ChunkProvider that is used to implement custom world generation.
 * Note that implementations of this class must not have constructors with arguments.
 *
 * @author Chris(damagefilter)
 */
public abstract class ChunkProviderCustom {
    protected World world;

    /**
     * Will be called when a new chunk needs to be generated.
     * The x/z are Chunk coordinates. (right-shifted by 4)
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return the provided {@link Chunk}
     */
    public abstract Chunk provideChunk(int x, int z);

    /**
     * Is called after the large-scale generation is done to populate the world with details.
     * For instance glowstone blocks
     * The x/z are chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     */
    public abstract void populate(int x, int z);

    /**
     * Is called after populate(), in order to create or re-create structures.
     * That means: Houses, Strongholds, temples and the likes
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     */
    public abstract void createStructures(int x, int z);

    /**
     * Set the world used for this generator.
     * Canary will call this before the generation process starts,
     * to make sure the world exists.
     *
     * @param world
     *         the {@link World} used for the Generator
     */
    public void setWorld(World world) {
        this.world = world;
    }
}
