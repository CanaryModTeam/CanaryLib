package net.canarymod.user;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.backbone.BackboneReservelist;

import java.util.List;

/**
 * Reserve List Provider
 *
 * @author Jason (darkdiplomat)
 */
public class ReservelistProvider {
    private BackboneReservelist backbonereservelist;
    private List<String> reservelist;

    public ReservelistProvider() {
        backbonereservelist = new BackboneReservelist();
        reservelist = backbonereservelist.loadReservelist();
    }

    /**
     * Reload the reservelist from database
     */
    public void reload() {
        reservelist = backbonereservelist.loadReservelist();
    }

    /**
     * Check if a given player is reservelist.
     *
     * @param nameOrUUID
     *         the player's name or UUID to check
     *
     * @return {@code true}
     */
    public boolean isSlotReserved(String nameOrUUID) {
        // Did UUID get passed?
        if (ToolBox.isUUID(nameOrUUID)) {
            return reservelist.contains(nameOrUUID);
        }
        else if (Canary.getServer() != null) { // Like at start up...
            // Try to get a UUID reference from a known player
            return isSlotReserved(Canary.getServer().matchKnownPlayer(nameOrUUID));
        }
        else {
            return false;
        }
    }

    public boolean isSlotReserved(PlayerReference playerReference) {
        if (playerReference != null) {
            // Lets update to UUID if we can get a UUID
            if (reservelist.contains(playerReference.getName())) {
                if (playerReference.getUUIDString() != null) {
                    removePlayer(playerReference.getName());
                    addPlayer(playerReference.getUUIDString());
                }
                return true;
            }
            // UUID test it is
            return reservelist.contains(playerReference.getUUIDString());
        }
        return false;
    }

    /**
     * Adds a new whitelist entry
     *
     * @param name
     */
    public void addPlayer(String name) {
        if (!reservelist.contains(name)) {
            reservelist.add(name);
            backbonereservelist.addSlotReservation(name);
        }
    }

    /**
     * Removes the given player from the reservelist
     *
     * @param name
     */
    public void removePlayer(String name) {
        if (reservelist.contains(name)) {
            reservelist.remove(name);
            backbonereservelist.removeReservelistEntry(name);
        }
    }

    /**
     * gets the current size of the reservelist
     *
     * @return
     */
    public int getSize() {
        return reservelist.size();
    }

    /**
     * Gets all reservations
     *
     * @return
     */
    public String[] getReservations() {
        return reservelist.toArray(new String[reservelist.size()]);
    }
}
