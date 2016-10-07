package net.canarymod.user;

import net.canarymod.api.PlayerReference;

/**
 * Access to the backbone for operators
 *
 * @author Jason (darkdiplomat)
 */
public interface OperatorsProvider {

    /**
     * Reload the ops from database
     */
    void reload();

    /**
     * Check if a given Player name or UUID is opped.
     *
     * @param nameOrUUID
     *         the uuid/name of a player
     *
     * @return true if player is opped, false otherwise
     */
    boolean isOpped(String nameOrUUID);

    boolean isOpped(PlayerReference playerReference);

    /**
     * Adds a new operators entry
     *
     * @param entry
     *         the player uuid/name you want to add
     */
    void addPlayer(String entry);

    /**
     * Removes the given player from the ops list
     *
     * @param entry
     *         the player uuid/name you want to remove
     */
    void removePlayer(String entry);

    /**
     * gets the current size of the ops list
     *
     * @return the size
     */
    int getSize();

    /**
     * Gets an array of all Operators
     *
     * @return
     */
    String[] getOps();
}
