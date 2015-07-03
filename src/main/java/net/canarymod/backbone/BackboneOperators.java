package net.canarymod.backbone;

import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the ops system. This contains NO logic, it is only the data
 * source access!
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public class BackboneOperators extends Backbone {

    public static OperatorsDataAccess schema = new OperatorsDataAccess();

    public BackboneOperators() {
        super(Backbone.System.OPERATORS);
        try {
            Database.get().updateSchema(schema);
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
    }

    public boolean isOpped(String player) {
        OperatorsDataAccess data = new OperatorsDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("player", player);

            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.hasData();
    }

    /**
     * Add a new ops entry
     *
     * @param player
     *         the name of the player to op
     */
    public void addOpEntry(String player) {
        if (isOpped(player)) {
            return;
        }
        OperatorsDataAccess data = new OperatorsDataAccess();

        data.player = player;
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Removes a player from the op list
     *
     * @param subject
     *         the name of the player to de-op
     */
    public void removeOpEntry(String subject) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("player", subject);
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load and return all recorded bans
     *
     * @return An array list of all recorded ban instances.
     */
    public List<String> loadOps() {
        List<String> ops = new ArrayList<String>();
        List<DataAccess> dataList = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, dataList, new HashMap<String, Object>());
            for (DataAccess da : dataList) {
                OperatorsDataAccess data = (OperatorsDataAccess)da;
                ops.add(data.player);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return ops;
    }
}
