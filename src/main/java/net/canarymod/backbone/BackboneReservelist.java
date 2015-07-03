package net.canarymod.backbone;

import net.canarymod.ToolBox;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the reservelist system. This contains NO logic, it is only the data
 * source access!
 *
 * @author Jason (darkdiplomat)
 */
public class BackboneReservelist extends Backbone {

    private ReservelistDataAccess schema = new ReservelistDataAccess();

    public BackboneReservelist() {
        super(Backbone.System.RESERVELIST);
        this.validateReserveList();
        try {
            Database.get().updateSchema(new ReservelistDataAccess());
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
    }

    /**
     * Checks if the player has a reserved slot
     *
     * @param player
     *         the player's name to check
     *
     * @return {@code true} if slot reserved; {@code false} otherwise
     */
    public boolean isSlotReserved(String player) {
        WhitelistDataAccess data = new WhitelistDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            if (ToolBox.isUUID(player)) {
                filter.put("uuid", player);
            }
            else {
                filter.put("player", player);
            }
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.hasData();
    }

    /**
     * Add a new reservelist entry
     *
     * @param player
     *         the player's name or uuid
     */
    public void addSlotReservation(String player) {
        if (isSlotReserved(player)) {
            return;
        }
        ReservelistDataAccess data = new ReservelistDataAccess();
        if (ToolBox.isUUID(player)) {
            data.player = "";
            data.uuid = player;
        }
        else {
            data.player = player;
            data.uuid = ToolBox.usernameToUUID(player);
        }
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Removes a player from the reservelist
     *
     * @param subject
     *         the player's name or uuid
     */
    public void removeReservelistEntry(String subject) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            if (ToolBox.isUUID(subject)) {
                filter.put("uuid", subject);
            }
            else {
                filter.put("uuid", ToolBox.usernameToUUID(subject));
            }
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load and return all recorded reservelist entries
     *
     * @return An array list of all recorded reserve entries.
     */
    public List<String> loadReservelist() {
        List<String> reservelist = new ArrayList<String>();
        List<DataAccess> dataList = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, dataList, new HashMap<String, Object>());
            for (DataAccess da : dataList) {
                ReservelistDataAccess data = (ReservelistDataAccess)da;
                reservelist.add(data.uuid);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return reservelist;
    }

    /**
     * Validate all user entries in the database.
     * At this time it merely checks that all entries have a valid UUID.  If an
     * entry does not, it attempts to retrieve it from Mojang's web service and
     */
    public void validateReserveList() {
        List<DataAccess> daos = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, daos, new HashMap<String, Object>());
            for (DataAccess dao : daos) {
                ReservelistDataAccess data = (ReservelistDataAccess)dao;
                if (data.uuid != null && !data.uuid.trim().equals("")) {
                    continue;
                }
                String uuid = ToolBox.usernameToUUID(data.player);
                HashMap<String, Object> filter = new HashMap<String, Object>();
                filter.put("player", data.player);
                data.uuid = uuid == null ? "" : uuid;
                try {
                    Database.get().update(data, filter);
                }
                catch (DatabaseWriteException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
    }
}
