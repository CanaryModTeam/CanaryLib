package net.canarymod.user;

import net.canarymod.api.PlayerReference;

/**
 * Reserve List Provider
 *
 * @author Jason (darkdiplomat)
 */
public interface ReservelistProvider {

    /**
     * Reload the reservelist from database
     */
    void reload();

    /**
     * Check if a given player is reservelist.
     *
     * @param nameOrUUID
     *         the player's name or UUID to check
     *
     * @return {@code true}
     */
    boolean isSlotReserved(String nameOrUUID);

    boolean isSlotReserved(PlayerReference playerReference);

    /**
     * Adds a new whitelist entry
     *
     * @param name
     */
    void addPlayer(String name);

    /**
     * Removes the given player from the reservelist
     *
     * @param name
     */
    void removePlayer(String name);

    /**
     * gets the current size of the reservelist
     *
     * @return
     */
    int getSize();

    /**
     * Gets all reservations
     *
     * @return
     */
    String[] getReservations();
}
