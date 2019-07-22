package net.canarymod.api.statistics;

import com.google.common.collect.Maps;
import net.canarymod.Canary;

import java.util.HashMap;

/**
 * Statistics Tracker
 *
 * @author Jason (darkdiplomat)
 */
public enum Statistics {
    LEAVEGAME("leaveGame"),
    PLAYONEMINUTE("playOneMinute"),
    TIMESINCEDEATH("timeSinceDeath"),
    WALKONECM("walkOneCm"),
    CROUCHONECM("crouchOneCm"),
    SPRINTONECM("sprintOneCm"),
    SWIMONECM("swimOneCm"),
    FALLONECM("fallOneCm"),
    CLIMBONECM("climbOneCm"),
    FLYONECM("flyOneCm"),
    DRIVEONECM("diveOneCm"),
    MINECARTONECM("minecartOneCm"),
    BOATONECM("boatOneCm"),
    PIGONECM("pigOneCm"),
    HORSEONECM("horseOneCm"),
    JUMP("jump"),
    DROP("drop"),
    DAMAGEDEALT("damageDealt"),
    DAMAGETAKEN("damageTaken"),
    DEATHS("deaths"),
    MOBKILLS("mobKills"),
    ANIMALSBRED("animalsBred"),
    PLAYERKILLS("playerKills"),
    FISHCAUGHT("fishCaught"),
    JUNKFISHED("junkFished"),
    TREASUREFISHED("treasureFished"),
    TALKEDTOVILLAGER("talkedToVillager"),
    TRADEDWITHVILLAGER("tradedWithVillager"),
    CAKESLICESEATEN("cakeSlicesEaten"),
    CAULDRONFILLED("cauldronFilled"),
    CAULDRONUSED("cauldronUsed"),
    ARMORCLEANED("armorCleaned"),
    BANNERCLEANED("bannerCleaned"),
    BREWINGSTANDINTERACTION("brewingstandInteraction"),
    BEACONINTERACTION("beaconInteraction"),
    DROPPERINSPECTED("dropperInspected"),
    HOPPERINSPECTED("hopperInspected"),
    DISPENSERINSPECTED("dispenserInspected"),
    NOTEBLOCKPLAYED("noteblockPlayed"),
    NOTEBLOCKTUNED("noteblockTuned"),
    FLOWERPOTTED("flowerPotted"),
    TRAPPEDCHESTTRIGGERED("trappedChestTriggered"),
    ENDERCHESTOPENED("enderchestOpened"),
    ITEMENCHANTED("itemEnchanted"),
    RECORDPLAYED("recordPlayed"),
    FURNACEINTERACTION("furnaceInteraction"),
    CRAFTINGTABLEINTERACTION("craftingTableInteraction"),
    CHESTOPENED("chestOpened"),
    SLEEPINBED("sleepInBed"),
    ;

    private final String nmsName;
    private final static HashMap<String, Statistics> statisticsHashMap = Maps.newHashMap();

    Statistics(String nmsName) {
        this.nmsName = "stat.".concat(nmsName);
    }

    /**
     * Gets the full native name of the {@code Statistics}
     *
     * @return full native name
     */
    public final String getNativeName() {
        return nmsName;
    }

    /**
     * Gets the {@link net.canarymod.api.statistics.Stat} instance for the given {@code Statistics}
     *
     * @return {@link net.canarymod.api.statistics.Stat} instance
     */
    public final Stat getInstance() {
        return Canary.factory().getStatisticsFactory().getStat(nmsName);
    }

    /**
     * Gets an {@code Statistics} for the native name
     *
     * @param nmsName
     *         the native Minecraft name
     *
     * @return {@code Statistics} matching the name or {@code null} if not match found
     */
    public static Statistics forNMSName(final String nmsName) {
        String temp = nmsName;
        if (!nmsName.startsWith("stat.")) {
            temp = "stat.".concat(nmsName);
        }
        return statisticsHashMap.get(temp);
    }

    static {
        for (Statistics statistic : Statistics.values()) {
            statisticsHashMap.put(statistic.nmsName, statistic);
        }
    }
}
