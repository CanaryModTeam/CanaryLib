package net.canarymod.api.scoreboard;

/**
 * Convenience enum for handle minecraft id protocol values for scoreboard positions.
 *
 * @author Somners
 */
public enum ScorePosition {
    /**
     * Shows next to the players name in the player list when pressing the TAB key.
     */
    PLAYER_LIST(0),
    /**
     * shows in a sidebar that pops up on the side of the players screen.
     */
    SIDEBAR(1),
    /**
     * Shows below the name above a players head.
     */
    BELOW_NAME(2);

    /**
     * Minecraft protocol ID value for the scoreboard position.
     */
    private int id;

    ScorePosition(int id) {
        this.id = id;
    }

    /**
     * Get the id for this Position.
     *
     * @return id value
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets a {@link ScorePosition} for the given id value.
     *
     * @param id
     *         id value to get the {@link ScorePosition} for.
     *
     * @return the {@link ScorePosition} or null if it doesn't exist.
     */
    public static ScorePosition fromId(int id) {
        for (ScorePosition type : ScorePosition.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }
}
