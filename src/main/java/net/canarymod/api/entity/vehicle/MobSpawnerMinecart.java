package net.canarymod.api.entity.vehicle;

import net.canarymod.api.MobSpawnerLogic;

/**
 * MobSpawnerMinecart wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface MobSpawnerMinecart extends Minecart {

    /**
     * Gets the MobSpawnerLogic for this MobSpawnerMinecart
     *
     * @return mobspawnerlogic
     */
    MobSpawnerLogic getMobSpawnerLogic();
}
