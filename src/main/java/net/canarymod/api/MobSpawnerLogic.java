package net.canarymod.api;

/**
 * Wraps the MobSpawnerLogic
 *
 * @author Jason Jason (darkdiplomat)
 * @author Willem (l4mRh4X0r)
 */
public interface MobSpawnerLogic {

    /**
     * Gets the ID of the Mob that spawns (ignoring MobSpawnerEntries)
     *
     * @return mob name
     */
    String getSpawnId();

    /**
     * Sets the ID of the mob that spawns (ignoring MobSpawnerEntries)
     *
     * @param mobName
     *         the fully qualified name of the Entity
     */
    void setSpawnId(String mobName);

    /**
     * Gets the current delay of the next spawn. This number is ever changing and gets randomized between spawns.
     *
     * @return current spawn delay
     */
    int getDelay();

    /**
     * Allows delay of what to spawn to change on-the-fly.
     * Modification of this is near-useless as delays get randomized after
     * spawn.
     *
     * @param delay
     *         Set the next spawn delay.
     */
    void setDelay(int delay);

    /**
     * Returns the minimum delay of the spawner.
     * The delay between spawns is picked randomly between this and the max delay.
     *
     * @return minDelay
     * The minimum delay for spawning.
     */
    int getMinDelay();

    /**
     * Sets the minimum delay of the spawner.
     * The delay between spawns is picked randomly between this and the max delay.
     * Default is 200.
     *
     * @param delay
     *         The min delay value to set.
     */
    void setMinDelay(int delay);

    /**
     * Returns the maximum delay of the spawner.
     * The delay between spawns is picked randomly between this and the min delay.
     *
     * @return maxDelay
     * The max delay value.
     */
    int getMaxDelay();

    /**
     * Sets the maximum delay of the spawner.
     * The delay between spawns is picked randomly between this and the min delay.
     * Default is 800.
     *
     * @param delay
     *         The max delay value to set.
     */
    void setMaxDelay(int delay);

    /**
     * Returns the amount of mobs this spawner attempts to spawn.
     *
     * @return The amount of mobs this spawner attempts to spawn.
     */
    int getSpawnCount();

    /**
     * Sets the amount of mobs this spawner attempts to spawn.
     * Default is 4.
     *
     * @param count
     *         Number of mobs for this spawner to spawn.
     */
    void setSpawnCount(int count);

    /**
     * Returns the maximum number of entities this spawner allows nearby in order to continue spawning.
     * Any more entities and this spawner won't spawn mobs.
     *
     * @return Max number of entities allowed to continue spawning.
     */
    int getMaxNearbyEntities();

    /**
     * Sets the maximum number of entities this spawner allows nearby in order to continue spawning.
     * Any more entities and this spawner won't spawn mobs.
     * Default is 6.
     *
     * @param entities
     *         Value to set for max number of entities allowed to continue spawning.
     */
    void setMaxNearbyEntities(int entities);

    /**
     * If there are no players within this distance of the spawner, it won't spawn.
     *
     * @return the required range
     */
    int getRequiredPlayerRange();

    /**
     * If there are no players within this distance of the spawner, it won't spawn.
     * Default is 16.
     *
     * @param range
     *         the range to be set
     */
    void setRequiredPlayerRange(int range);

    /**
     * Returns the maximum distance that this spawner will spawn mobs at.
     *
     * @return the spawn range
     */
    int getSpawnRange();

    /**
     * Sets the maximum distance that this spawner will spawn mobs at.
     * Default is 4.
     *
     * @param range
     *         the spawn range to set
     */
    void setSpawnRange(int range);

    /**
     * Returns the spawns used.
     *
     * @return A String array of the names of the currently set Entities to spawn.
     */
    String[] getSpawns();

    /**
     * Sets the entities spawned by this spawner.
     *
     * @param entries
     *         The entities this spawner should spawn
     */
    void setSpawnedEntities(MobSpawnerEntry... entries);

    /**
     * Adds the entities passed to the list of entities
     * to be spawned by this spawner.
     *
     * @param entries
     *         The entities this spawner should spawn
     */
    void addSpawnedEntities(MobSpawnerEntry... entries);

    /**
     * Gets the entities spawned by this spawner.
     *
     * @return An {@code Array} of Entities set to spawn on this logic.
     */
    MobSpawnerEntry[] getSpawnedEntities();
}
