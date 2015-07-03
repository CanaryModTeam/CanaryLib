package net.canarymod.api.scoreboard;

import net.canarymod.api.entity.living.humanoid.Player;

import java.util.List;

/**
 * Scoreboard team wrapper
 *
 * @author Somners
 */
public interface Team {

    /**
     * Gets the internal protocol name of this team.
     *
     * @return The team name.
     */
    String getProtocolName();

    /**
     * Gets the display name of this team.
     *
     * @return The team name.
     */
    String getDisplayName();

    /**
     * Sets the display name of this team.
     *
     * @param name
     *         name to set.
     */
    void setDisplayName(String name);

    /**
     * Gets the prefix for this team.
     *
     * @return The prefix for this team.
     */
    String getPrefix();

    /**
     * Sets the prefix for this team.
     *
     * @param prefix
     *         The prefix to set.
     */
    void setPrefix(String prefix);

    /**
     * Gets the suffix for this team.
     *
     * @return This teams suffix.
     */
    String getSuffix();

    /**
     * Sets the suffix for this team.
     *
     * @param suffix
     *         The suffix to set.
     */
    void setSuffix(String suffix);

    /**
     * Get all players on this team.
     *
     * @return A list of the players on this team.
     */
    List<Player> getPlayers();

    /**
     * Get all players names on this team.
     *
     * @return A list of the players names on this team.
     */
    List<String> getPlayerNames();

    /**
     * Adds a player to this team.
     *
     * @param player
     *         The player to add.
     */
    void addPlayer(Player player);

    /**
     * Checks if the given player is on this team.
     *
     * @param player
     *         Player to check.
     *
     * @return True if the player is on this team, false otherwise.
     */
    boolean hasPlayer(Player player);

    /**
     * Removes the given player from this team.
     *
     * @param player
     *         The player to remove.
     */
    void removePlayer(Player player);

    /**
     * Gets the scoreboard this team is associated with.
     *
     * @return The Scoreboard.
     */
    Scoreboard getScoreboard();

    /**
     * Gets whether or not friendly fire is allowed on this team.
     *
     * @return true if friendly fire is allowed, false otherwise.
     */
    boolean getAllowFriendlyFire();

    /**
     * Sets whether or not friendly fire is allowed on this team.
     *
     * @param bool
     *         value to set.
     */
    void setAllowFriendlyFire(boolean bool);

    /**
     * Gets whether or not teamates can see their invisible teamates.
     *
     * @return True if they can see invsible teamates, false otherwise.
     */
    boolean getSeeFriendlyInvisibles();

    /**
     * Sets whether or not teamates can see their invisible teamates.
     *
     * @param bool
     *         value to set.
     */
    void setSeeFriendlyInvisibles(boolean bool);
}
