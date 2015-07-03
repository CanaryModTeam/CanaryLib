package net.canarymod.api.scoreboard;

/**
 * @author Somners
 */
public interface ScoreboardManager {

    /**
     * Get the Default Scoreboard.
     * This is the scoreboard used by the vanilla scoreboard commands.
     *
     * @return the Scoreboard.
     */
    Scoreboard getScoreboard();

    /**
     * Gets a registered {@link ScoreObjectiveCriteria}
     *
     * @param name
     *         the protocol name of the criteria to get.
     *
     * @return The {@link ScoreObjectiveCriteria} or null if it is not registered.
     */
    ScoreObjectiveCriteria getScoreCriteria(String name);

    /**
     * Registers the {@link ScoreObjectiveCriteria} if it is not already registered.
     *
     * @param name
     *         the protocol name of the criteria to register.
     * @param criteria
     *         the class to register.
     */
    void registerScoreCriteria(String name, Class<? extends ScoreObjectiveCriteria> criteria);

    /**
     * Gets a {@link Scoreboard} instance.
     * If the scoreboard already exists it will load from cache or file, whichever
     * is necessary.  If it does not already exist it create a new Scoreboard.
     *
     * @param name
     *         The unique name for this scoreboard.
     *
     * @return {@link Scoreboard} instance
     */
    Scoreboard getScoreboard(String name);

    /**
     * Saves all cached {@link Scoreboard} instances.
     */
    void saveAllScoreboards();
}
