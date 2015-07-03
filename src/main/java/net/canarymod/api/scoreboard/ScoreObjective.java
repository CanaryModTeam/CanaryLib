package net.canarymod.api.scoreboard;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.World;

/**
 * ScoreObjective wrapper
 *
 * @author Somners
 */
public interface ScoreObjective {

    /**
     * Get the protocol name for this score objective. This name is for internal
     * use only. It can be thought of as the "key" or "identifier" of this
     * score objective.
     *
     * @return The protocol name.
     */
    String getProtocolName();

    /**
     * Gets the ScoreObjectiveCriteria for this ScoreObjective.
     *
     * @return The score Objective Criteria.
     */
    ScoreObjectiveCriteria getScoreObjectiveCriteria();

    /**
     * Gets the display name for this ScoreObjective. This is the name that will
     * be seen in game by players.
     *
     * @return The display name.
     */
    String getDisplayName();

    /**
     * Sets and updates the display name to all clients.
     *
     * @param name
     *         The name you wish to set the display name to.
     */
    void setDisplayName(String name);

    /**
     * Sets this {@link ScoreObjective}'s position for all players on the server.
     *
     * @param type
     *         the position type.
     */
    void setScoreboardPosition(ScorePosition type);

    /**
     * Sets this {@link ScoreObjective}'s position for the given player.
     *
     * @param type
     *         the position type.
     * @param player
     *         the player to set the scoreboard for.
     */
    void setScoreboardPosition(ScorePosition type, Player player);

    /**
     * Sets this {@link ScoreObjective}'s position for all Players in the given
     * {@link World}.
     *
     * @param type
     *         the position type.
     * @param world
     *         the player to set the scoreboard for.
     */
    void setScoreboardPosition(ScorePosition type, World world);

    /**
     * Gets the {@link Scoreboard} instance this ScoreObjective instance is
     * attached to.
     *
     * @return {@link Scoreboard}
     */
    Scoreboard getScoreboard();
}
