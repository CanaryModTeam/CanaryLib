package net.canarymod.backbone;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.chat.ChatFormat;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.canarymod.user.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the groups System. This contains NO logic, it is only the data
 * source access!
 *
 * @author Chris
 */
public class BackboneGroups extends Backbone {

    private static GroupDataAccess schema = new GroupDataAccess();

    public BackboneGroups() {
        super(Backbone.System.GROUPS);
        try {
            Database.get().updateSchema(schema);
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
    }

    /**
     * Add a new Group to the list of Groups.
     *
     * @param group
     *         The group instance to add.
     */
    public void addGroup(Group group) {
        if (groupExists(group)) {
            updateGroup(group);
            return;
        }
        GroupDataAccess data = group.toDataAccess();
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    private boolean groupExists(Group group) {
        GroupDataAccess data = new GroupDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", group.getName());
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return data.hasData();
    }

    /**
     * Remove a group from the data source
     *
     * @param group
     *         the Group instance to remove.
     */
    public void removeGroup(Group group) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", group.getName());
            Database.get().remove(schema, filter);
            // Additionally remove all permissions belonging to a group!
            Canary.permissionManager().removeAllGroupPermissions(group);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void renameGroup(Group subject, String newname) {
        GroupDataAccess group = subject.toDataAccess();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("id", group.id);
            filter.put("world", group.worldName);
            group.name = newname;
            Database.get().update(group, filter);
            subject.setName(newname);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Update a Group and all its child groups.
     * This will not perform rename operations properly. For renaming groups, use renameGroup()
     *
     * @param group
     *         The group instance to update to the database.
     */
    public void updateGroup(Group group) {
        if (!groupExists(group)) {
            log.warn("Group " + group.getName() + " was not updated, it does not exist!");
            return;
        }
        GroupDataAccess updatedData = group.toDataAccess();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("id", updatedData.id);
            filter.put("name", updatedData.name);
            Database.get().update(updatedData, filter);
            for (Group g : group.getChildren()) {
                updateGroup(g);
            }
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    private Group loadParents(String parent, BiMap<String, Group> existingGroups) {
        if (ToolBox.stringToNull(parent) == null || parent.isEmpty()) {
            return null;
        }
        if (existingGroups.containsKey(parent)) {
            return existingGroups.get(parent);
        }
        GroupDataAccess data = new GroupDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("name", parent);
            Database.get().load(data, filter);
            if (data.hasData()) {
                Group g = new Group();
                g.setDefaultGroup(data.isDefault);
                g.setId(data.id);
                g.setName(data.name);
                g.setWorldName(ToolBox.stringToNull(data.worldName));
                g.setPrefix(data.prefix);
                g.setParent(loadParents(data.parent, existingGroups));
                existingGroups.put(g.getName(), g);
                return g;
            }
            else {
                log.warn(parent + " group was requested but could not be loaded! DataAccess was empty!");
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Check if group with this name is already in the list.
     * That can happen because the list gets filled by 2 methods,
     *
     * @param name
     *         name of the group to check.
     * @param list
     *         list of groups to check in.
     *
     * @return true - the group is in the list<br>
     * false - the group is not in the list.
     */
    private boolean alreadyInList(String name, List<Group> list) {
        for (Group g : list) {
            if (g.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Load and return all recorded groups
     *
     * @return An ArrayList containing all recorded groups.
     */
    public BiMap<String, Group> loadGroups() {
        List<DataAccess> dataList = new ArrayList<DataAccess>();
        BiMap<String, Group> groups = HashBiMap.create();

        try {
            Database.get().loadAll(schema, dataList, new HashMap<String, Object>());
            for (DataAccess da : dataList) {
                GroupDataAccess data = (GroupDataAccess)da;
                if (groups.containsKey(data.name)) {
                    continue;
                }
                Group g = new Group();

                g.setDefaultGroup(data.isDefault);
                g.setId(data.id);
                g.setName(data.name);
                g.setWorldName(ToolBox.stringToNull(data.worldName));
                g.setPrefix(data.prefix);
                if (!data.isDefault || !data.name.equals(data.parent)) {
                    g.setParent(loadParents(data.parent, groups));
                }
                groups.put(g.getName(), g);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return groups;
    }

    /**
     * Creates a set of default groups and puts them into the database
     */
    public static void createDefaults() {
        GroupDataAccess visitors = new GroupDataAccess();
        GroupDataAccess players = new GroupDataAccess();
        GroupDataAccess mods = new GroupDataAccess();
        GroupDataAccess admins = new GroupDataAccess();

        // make visitors group data
        visitors.isDefault = true;
        visitors.name = "visitors";
        visitors.parent = "visitors";
        visitors.prefix = ChatFormat.GRAY.toString();
        visitors.worldName = null;

        // make player group data
        players.isDefault = false;
        players.name = "players";
        players.parent = "visitors";
        players.prefix = ChatFormat.WHITE.toString();
        players.worldName = null;

        // make mod group data
        mods.isDefault = false;
        mods.name = "mods";
        mods.parent = "players";
        mods.prefix = ChatFormat.YELLOW.toString();
        mods.worldName = null;

        // make admins group data
        admins.isDefault = false;
        admins.name = "admins";
        admins.parent = "mods";
        admins.prefix = ChatFormat.RED.toString();
        admins.worldName = null;
        try {
            Database.get().insert(visitors);
            Database.get().insert(players);
            Database.get().insert(mods);
            Database.get().insert(admins);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
        BackbonePermissions.createDefaultPermissionSet();
    }
}
