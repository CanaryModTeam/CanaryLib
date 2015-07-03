package net.canarymod.api;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.nbt.CompoundTag;

/**
 * This represents an Entity to spawn from a Mob Spawner.
 *
 * @author Aaron (somners)
 */
public interface MobSpawnerEntry {

    /**
     * Sets the chance that this entry will spawn compared to other entries.
     *
     * @param weight
     *         The chance that this entry will spawn.
     */
    void setWeight(int weight);

    /**
     * Gets the chance that this entry will spawn compared to other entries.
     *
     * @return The chance that this entry will spawn.
     */
    int getWeight();

    /**
     * Get an instance of the {@link Entity} representing this Entry.
     *
     * @return An instance of the {@link Entity} this Entry will spawn.
     */
    Entity getEntity();

    /**
     * Set an instance of the {@link Entity} we wish to spawn with this Entry.
     *
     * @param entity
     *         The {@link Entity} to spawn.
     */
    void setEntity(Entity entity);

    /**
     * Checks if this is a valid Mob Spawner Entry.<br>
     * Basically makes sure the {@link Entity} set is not null;
     *
     * @return {@code true} if the Entry is Valid; {@code false} if not
     */
    boolean isValid();

    /**
     * Get the 'SpawnPotentials' {@link Entity} for this Entry.<br>
     * NOTE: This should probably only be used by Canary.
     *
     * @return A 'SpawnPotentials' {@link Entity} entry if valid; {@code null} if not a valid entry.
     */
    CompoundTag getSpawnPotentialsTag();
}
