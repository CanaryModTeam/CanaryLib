package net.canarymod.api.factory;

import net.canarymod.api.statistics.Achievement;
import net.canarymod.api.statistics.Stat;

/**
 * Statitics Factory
 *
 * @author Jason (darkdiplomat)
 */
public interface StatisticsFactory {

    /**
     * Gets the instance for a given {@link net.canarymod.api.statistics.Stat} name
     *
     * @param nmsName
     *         the name of the stat
     *
     * @return {@link net.canarymod.api.statistics.Stat} instance
     */
    Stat getStat(String nmsName);

    Achievement getAchievement(String nmsName);
}
