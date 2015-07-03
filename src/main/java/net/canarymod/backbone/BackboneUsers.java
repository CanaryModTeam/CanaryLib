package net.canarymod.backbone;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.canarymod.user.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.canarymod.Canary.log;

/**
 * Backbone to the Player System. This contains NO logic, it is only the data
 * source access!
 *
 * @author Chris (damagefilter)
 */
public class BackboneUsers extends Backbone {

    private static PlayerDataAccess schema = new PlayerDataAccess();

    public BackboneUsers() {
        super(Backbone.System.USERS);
        try {
            Database.get().updateSchema(new PlayerDataAccess());
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
        this.validateUsers();
    }

    /**
     * Add a new Player to the data source.
     *
     * @param player
     *         Player to add to the data source.
     */
    public void addUser(Player player) {
        if (userExists(player.getUUIDString())) {
            log.debug("Player " + player.getName() + " already exists. Updating it instead!");
            updatePlayer(player);
            return;
        }
        PlayerDataAccess data = new PlayerDataAccess();
        ArrayList<String> groupNames = new ArrayList<String>();
        for (Group g : player.getPlayerGroups()) {
            groupNames.add(g.getName());
        }
        data.uuid = player.getUUIDString();
        data.name = player.getName();
        data.group = groupNames.get(0);
        groupNames.remove(0);
        data.subgroups = groupNames;

        String prefix = player.getPrefix();
        if (prefix.equals(player.getGroup().getPrefix())) {
            data.prefix = null;
        }
        else {
            data.prefix = prefix;
        }
        data.isMuted = player.isMuted();
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Used to update a player. This can not override existing player entries.
     * If there is a player with the uuid name, nothing will happen
     *
     * @param nameOrUUID
     *         the player's name or uuid
     * @param group
     *         the group's name
     */
    public void addUser(String nameOrUUID, String group) {
        String uuid = ToolBox.isUUID(nameOrUUID) ? nameOrUUID : ToolBox.usernameToUUID(nameOrUUID);
        if (uuid == null) {
            log.debug("Player name or uuid is 'null'. Skipping!");
            return;
        }
        if (userExists(uuid)) {
            log.debug("Player " + uuid + " already exists. Attempting update...");
            updatePlayer(Canary.getServer().matchKnownPlayer(nameOrUUID));
            return;
        }
        PlayerDataAccess data = new PlayerDataAccess();
        if (!ToolBox.isUUID(nameOrUUID)) {
            data.name = nameOrUUID;
        }
        data.uuid = uuid;
        data.group = group;
        data.prefix = null;
        data.isMuted = false;
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Get whether a user exists
     *
     * @param uuid
     *         Player to check if they exist.
     *
     * @return true if user exists, false otherwise
     */
    private boolean userExists(String uuid) {
        PlayerDataAccess data = new PlayerDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", uuid);
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return data.hasData();
    }

    /**
     * Remove a player from the data source
     *
     * @param uuid
     *         Player to remove from the data source.
     */
    public void removeUser(String uuid) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", uuid);
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Update a Player.
     *
     * @param player
     *         Player to update to the data source.
     */
    public void updatePlayer(PlayerReference player) {
        if (player == null) {
            log.debug("No PlayerReference to update...");
            return;
        }

        PlayerDataAccess data = new PlayerDataAccess();
        ArrayList<String> groupNames = new ArrayList<String>();
        for (Group g : player.getPlayerGroups()) {
            groupNames.add(g.getName());
        }
        data.uuid = player.getUUIDString();
        data.name = player.getName();
        data.group = groupNames.get(0);
        groupNames.remove(0);
        data.subgroups = groupNames;

        String prefix = player.getPrefix();
        if (prefix != null && prefix.equals(player.getGroup().getPrefix())) {
            data.prefix = null;
        }
        else {
            data.prefix = prefix;
        }
        data.isMuted = player.isMuted();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", player.getUUIDString());
            // filter.put("name", player.getName()); // Can't update a name if its filtered in...
            Database.get().update(data, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load and return String array sets.
     * Each Array in the hashMap value has prefix, group and isMuted for a player, in that order.
     *
     * @return A hashmap with a key of player name, and string array value with
     * a prefix and group for a player, in that order.
     */
    public Map<String, String[]> loadUsers() {
        Map<String, String[]> players = new HashMap<String, String[]>();
        List<DataAccess> daos = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, daos, new HashMap<String, Object>());
            for (DataAccess dao : daos) {
                PlayerDataAccess data = (PlayerDataAccess)dao;
                String[] row = new String[3];

                row[0] = data.prefix;
                row[1] = data.group;
                row[2] = Boolean.toString(data.isMuted);
                players.put(data.uuid == null ? "" : data.uuid, row);
            }
            return players;
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Returns the additional groups for the given player
     *
     * @param uuid
     *         the player's name
     *
     * @return Group array
     */
    public Group[] getModularGroups(String uuid) {
        PlayerDataAccess data = new PlayerDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", uuid);
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        if (!data.hasData()) {
            return new Group[0];
        }
        Group[] groups = new Group[data.subgroups.size()];
        for (int i = 0; i < data.subgroups.size(); ++i) {
            groups[i] = Canary.usersAndGroups().getGroup(data.subgroups.get(i));
        }
        return groups;
    }

    public static void createDefaults() {
        PlayerDataAccess player = new PlayerDataAccess();

        player.group = "players";
        player.uuid = "";
        player.name = "Bob the Builder";

        PlayerDataAccess mod = new PlayerDataAccess();

        mod.group = "mods";
        mod.uuid = "";
        mod.name = "Moderator Person";

        PlayerDataAccess admin = new PlayerDataAccess();

        admin.group = "admins";
        admin.uuid = "";
        admin.name = "Evil Uber Administrator";

        try {
            Database.get().insert(player);
            Database.get().insert(mod);
            Database.get().insert(admin);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Validate all user entries in the database.
     * At this time it merely checks that all entries have a valid UUID.  If an
     * entry does not, it attempts to retrieve it from Mojang's web service and
     */
    public void validateUsers() {
        List<DataAccess> daos = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, daos, new HashMap<String, Object>());
            for (DataAccess dao : daos) {
                PlayerDataAccess data = (PlayerDataAccess)dao;
                if (data.uuid != null && !data.uuid.trim().equals("")) {
                    continue;
                }
                String uuid = ToolBox.usernameToUUID(data.name);
                data.uuid = uuid == null ? "" : uuid;
                HashMap<String, Object> filter = new HashMap<String, Object>();
                filter.put("name", data.name);
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
