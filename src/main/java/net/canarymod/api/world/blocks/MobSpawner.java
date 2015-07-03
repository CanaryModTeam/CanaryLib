package net.canarymod.api.world.blocks;

import net.canarymod.api.MobSpawnerLogic;

/**
 * MobSpawner Wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface MobSpawner extends TileEntity {

    /**
     * Get the Logic instance for this MobSpawner.
     *
     * @return The Logic Instance.
     */
    MobSpawnerLogic getLogic();
}
