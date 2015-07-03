package net.canarymod.api.world;

import java.util.List;

/**
 * Chunk Provider interface. This has two purposes.<br>
 * One is to wrap the ChunkProviderServer in the NMS implementation. <br>
 * The other, much more interesting purpose is to be implemented by Plugins,
 * then mapped to dimension types - in order to provide custom world generation.<br>
 * <h4>Custom World Generation</h4> This is the interface everything related to world generation boils down to.
 * A world will use this to create its terrain and call the provideChunk methid.
 *
 * @author Chris (damagefilter)
 */
public interface ChunkProvider {

    /**
     * Check if this chunk provider is allowed to save chunks
     *
     * @return true if chunks can be saved, false otherwise
     *
     * @PluginDev You do not need to implement this
     */
    boolean canSave();

    /**
     * Check if a chunk at the given coords exist
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return {@code true} if exists; {@code false} if not
     *
     * @PluginDev You do not need to implement this
     */
    boolean chunkExists(int x, int z);

    /**
     * Load chunk at that x-z coordinate
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return Chunk that has been loaded
     */
    Chunk loadChunk(int x, int z);

    /**
     * Is called after the large-scale generation is done to populate the world with details.
     * For instance glowstone blocks
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param provider
     *         the {@link ChunkProvider}
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     */
    void populate(ChunkProvider provider, int x, int z);

    /**
     * Return a String that displays the statistics for this ChunkProvider.
     * This will be shown in the servers GUI for instance.<br>
     * The default NMS method returns the size of the Chunk Cache and the number of dropped chunks
     *
     * @return statistics string
     *
     * @PluginDev You do not need to implement this (But you can)
     */
    String getStatistics();

    /**
     * Reload the given chunk.
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @PluginDev You do not need to implement this
     */
    void reloadChunk(int x, int z);

    /**
     * Drop the chunk at the given coordinates
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @PluginDev You do not need to implement this
     */
    void dropChunk(int x, int z);

    /**
     * Provides a Chunk. If that chunk didn't exist in any case it will
     * generate a new one.
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return the provided {@link Chunk}
     */
    Chunk provideChunk(int x, int z);

    /**
     * Save up to two chunks or if saveAll is true, save all chunks.
     *
     * @param saveAll
     *         {@code true} for saving all; {@code false} for not
     *
     * @return true on success, false otherwise
     *
     * @PluginDev You do not need to implement this
     */
    boolean saveChunk(boolean saveAll);

    /**
     * Regenerate the whole chunk at the given x/z coordinate.
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return the {@link Chunk} regenerated
     */
    Chunk regenerateChunk(int x, int z);

    /**
     * Check if a chunk at the specified coordinates is loaded
     * The x/z must be chunk coordinates, that means right-shifted by 4
     *
     * @param x
     *         the X Chunk coordinate
     * @param z
     *         the Z Chunk coordinate
     *
     * @return {@code true} if loaded; {@code false} for not
     *
     * @PluginDev You do not need to implement this
     */
    boolean isChunkLoaded(int x, int z);

    /**
     * Get a List of Chunks that are currently handled by this ChunkProvider.
     * It is not advisable to keep hold of these Chunks for a long period of time,
     * as that can cause severe problems with automatically unloaded worlds
     * and may also cause memory leaks and corrupted Chunk data.
     * The returned List is always fresh.
     *
     * @return a List of Chunk objects.
     */
    List<Chunk> getLoadedChunks();
}
