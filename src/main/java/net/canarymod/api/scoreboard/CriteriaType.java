package net.canarymod.api.scoreboard;

/**
 * Scoreboard criteria type
 *
 * @author Somners
 */
public enum CriteriaType {

    DUMMY("dummy"),
    TRIGGER("trigger"),
    DEATH_COUNT("deathCount"),
    PLAYER_KILL_COUNT("playerKillCount"),
    TOTAL_KILL_COUNT("totalKillCount"),
    HEALTH("health");

    private String protocol;

    CriteriaType(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets the Minecraft protocol name for this criteria.
     *
     * @return protocol name
     */
    public String getProtocolName() {
        return this.protocol;
    }

    /**
     * Gets the Criteria Type from the Minecraft protocol name.<br>
     * This is not case sensitive.
     *
     * @param protocol
     *         protocol name you wish to get.
     *
     * @return the criteria type. null if it doesn't exist.
     */
    public static CriteriaType fromProtocolName(String protocol) {
        for (CriteriaType type : CriteriaType.values()) {
            if (type.getProtocolName().equalsIgnoreCase(protocol)) {
                return type;
            }
        }
        return null;
    }
}
