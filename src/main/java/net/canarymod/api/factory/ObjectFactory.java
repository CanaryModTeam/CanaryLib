package net.canarymod.api.factory;

import net.canarymod.api.MobSpawnerEntry;
import net.canarymod.api.VillagerTrade;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Villager;
import net.canarymod.api.inventory.CustomStorageInventory;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.Chunk;
import net.canarymod.api.world.World;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.api.world.blocks.properties.BlockProperty;

/**
 * Object Manufacturing Factory
 * <p/>
 * For the odds and ends that don't fit else where
 *
 * @author Jason (darkdiplomat)
 */
public interface ObjectFactory {

    /**
     * Creates a new {@link VillagerTrade}
     *
     * @param buying
     *         the {@link Item} the {@link Villager} will buy
     * @param selling
     *         the {@link Item} the {@link Villager} will sell
     *
     * @return new {@link VillagerTrade}
     */
    VillagerTrade newVillagerTrade(Item buying, Item selling);

    /**
     * Creates a new {@link Villager} trade
     *
     * @param buyingOne
     *         the {@link Item} the {@link Villager} will buy
     * @param buyingTwo
     *         the second {@link Item} the {@link Villager} will buy
     * @param selling
     *         the {@link Item} the {@link Villager} will sell
     *
     * @return new {@link VillagerTrade}
     */
    VillagerTrade newVillagerTrade(Item buyingOne, Item buyingTwo, Item selling);

    /**
     * Creates a new {@link MobSpawnerEntry}
     *
     * @param entity
     *         the name of the {@link Entity} to create entry for
     *
     * @return new {@link MobSpawnerEntry}
     */
    MobSpawnerEntry newMobSpawnerEntry(String entity);

    /**
     * Creates a new {@link MobSpawnerEntry}
     *
     * @param entity
     *         the {@link Entity} to create entry for
     *
     * @return new {@link MobSpawnerEntry}
     */
    MobSpawnerEntry newMobSpawnerEntry(Entity entity);

    /**
     * Creates a new {@link MobSpawnerEntry}
     *
     * @param item
     *         the {@link Item} to create entry for
     *
     * @return new {@link MobSpawnerEntry}
     */
    MobSpawnerEntry newMobSpawnerEntry(Item item);

    /**
     * Creates a new empty CustomStorageInventory
     *
     * @param rows
     *         the number of Rows (9 slots per row)
     *
     * @return new {@link CustomStorageInventory}
     */
    CustomStorageInventory newCustomStorageInventory(int rows);

    /**
     * Creates a new empty CustomStorageInventory
     *
     * @param name
     *         the name of the custom inventory
     * @param rows
     *         the number of Rows (9 slots per row)
     *
     * @return new {@link CustomStorageInventory}
     */
    CustomStorageInventory newCustomStorageInventory(String name, int rows);

    /**
     * Creates a new Chunk for use in a world (the given world).
     * The created Chunk will be loose at first. That means it will not affect the world itself,
     * unless it is returned by the provideChunk() method of a ChunkProvider
     *
     * @param world
     *         The world this chunk should be attached to
     * @param x
     *         The chunk coordinates of this Chunk (world x >> 4)
     * @param z
     *         The chunk coordinates of this Chunk (world z >> 4)
     *
     * @return new {@link Chunk}
     */
    Chunk newChunk(World world, int x, int z);

    <T extends BlockProperty> T getPropertyInstance(BlockType blockType, String propertyName);
}
