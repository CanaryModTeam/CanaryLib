package net.canarymod.backbone;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.World;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.canarymod.permissionsystem.MultiworldPermissionProvider;
import net.canarymod.permissionsystem.PermissionNode;
import net.canarymod.permissionsystem.PermissionProvider;
import net.canarymod.user.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the permissions System. This contains NO logic, it is only the
 * data source access!
 *
 * @author Chris (damagefilter)
 */
public class BackbonePermissions extends Backbone {

    private static PermissionDataAccess schema = new PermissionDataAccess(null);

    public BackbonePermissions() {
        super(Backbone.System.PERMISSIONS);
        try {
            for (String fqname : Canary.getServer().getWorldManager().getExistingWorlds()) {
                Database.get().updateSchema(new PermissionDataAccess(fqname));
            }
            Database.get().updateSchema(schema);
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update database schema", e);
        }
    }

    /**
     * Load permissions for a group
     *
     * @param name
     *         the group name
     * @param world
     *         the world name
     *
     * @return PermissionsProvider instance for this group.
     */
    public PermissionProvider loadGroupPermissions(String name, String world) {
        if (world != null && world.isEmpty()) {
            world = null;
        }
        PermissionProvider provider = new MultiworldPermissionProvider(world, false, name);
        ArrayList<DataAccess> dataList = new ArrayList<DataAccess>();
        log.debug("Loading permissions for " + name + ". World: " + ((world != null && !world.isEmpty()) ? world : "none"));
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("owner", name);
            filter.put("type", "group");
            Database.get().loadAll(new PermissionDataAccess(world), dataList, filter);
            for (DataAccess da : dataList) {
                PermissionDataAccess data = (PermissionDataAccess)da;

                provider.addPermission(data.path, data.value, data.id);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return provider;
    }

    /**
     * Load permissions for a player
     *
     * @param uuid
     *         uuid of the player.
     * @param world
     *         the world name
     *
     * @return PermissionProvider for this player.
     */
    public PermissionProvider loadPlayerPermissions(String uuid, String world) {
        if (world != null && world.isEmpty()) {
            world = null;
        }
        // Validate player permissions
        this.validatePlayerPermissions(world);
        // Database.get().remove("permission", new String[] {"owner", "type"}, new Object[] {group.getName(), "group"});
        PermissionProvider provider = new MultiworldPermissionProvider(world, true, uuid);
        ArrayList<DataAccess> dataList = new ArrayList<DataAccess>();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("owner", uuid);
            filter.put("type", "player");
            Database.get().loadAll(new PermissionDataAccess(world), dataList, filter);
            for (DataAccess da : dataList) {
                PermissionDataAccess data = (PermissionDataAccess)da;

                provider.addPermission(data.path, data.value, data.id);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }

        return provider;
    }

    /**
     * Saves group permissions. This also adds new permissions + relations if there are any and
     * and updates existing ones
     *
     * @param g
     *         Group to save permission from to the database.
     */
    public void saveGroupPermissions(Group g) {
        PermissionProvider permissions = g.getPermissionProvider();
        List<PermissionNode> permissionList = permissions.getPermissionMap();
        HashMap<String, Object> filter = new HashMap<String, Object>();

        try {
            for (PermissionNode node : permissionList) {
                ArrayList<PermissionNode> childs = new ArrayList<PermissionNode>();

                for (PermissionNode child : permissions.getChildNodes(node, childs)) {
                    PermissionDataAccess data = new PermissionDataAccess(g.getWorldName());
                    filter.clear();
                    filter.put("id", child.getId());
                    Database.get().load(data, filter);
                    if (data.hasData()) {
                        data.path = child.getFullPath();
                        data.value = child.getValue();
                        Database.get().update(data, filter);
                    }
                    else {
                        data.owner = g.getName();
                        data.path = child.getFullPath();
                        data.type = "group";
                        data.value = child.getValue();
                        Database.get().insert(data);
                    }
                }
            }
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Save user permissions to file and add new ones if needed + update relations
     *
     * @param p
     *         Player to save permissions for to the database.
     */
    public void saveUserPermissions(Player p) {
        PermissionProvider permissions = p.getPermissionProvider();
        List<PermissionNode> permissionList = permissions.getPermissionMap();
        HashMap<String, Object> filter = new HashMap<String, Object>();

        try {
            for (PermissionNode node : permissionList) {
                ArrayList<PermissionNode> childs = new ArrayList<PermissionNode>();

                for (PermissionNode child : permissions.getChildNodes(node, childs)) {
                    PermissionDataAccess data = new PermissionDataAccess(permissions.getWorld());
                    filter.clear();
                    filter.put("id", child.getId());
                    Database.get().load(data, filter);
                    if (data.hasData()) {
                        data.path = child.getFullPath();
                        data.value = child.getValue();
                        Database.get().update(data, filter);
                    }
                    else {
                        data.owner = p.getUUIDString();
                        data.path = child.getFullPath();
                        data.type = "player";
                        data.value = child.getValue();
                        Database.get().insert(data);
                    }
                }
            }
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Remove a permission from database. This also removes any relations to groups and players
     *
     * @param path
     *         String representation of the permission to remove.<br>
     *         EXAMPLE: "canary.command.player.compass"
     * @param world
     *         The fully qualified world name as given by {@link World#getFqName()}<br>
     *         Can be null to access the global permissions table.
     */
    public void removePermission(String path, String world) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("path", path);
            if (world != null) {
                Database.get().remove(new PermissionDataAccess(world), filter);
            }
            else {
                Database.get().remove(schema, filter);
            }
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Removes a permission specific to a player or group
     *
     * @param path
     *         the permission node
     * @param subject
     *         the name of the subject (either group or player uuid)
     * @param world
     *         The fully qualified world name as given by {@link World#getFqName()}<br>
     *         Can be null to access the global permissions table.
     * @param isPlayer
     *         {@code true} if player; {@code false} if not
     */
    public void removePermission(String path, String subject, String world, boolean isPlayer) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("path", path);
            filter.put("owner", subject);
            if (isPlayer) {
                filter.put("type", "player");
                if (world != null) {
                    Database.get().remove(new PermissionDataAccess(world), filter);
                }
                else {
                    Database.get().remove(schema, filter);
                }
            }
            else {
                filter.put("type", "group");
                if (world != null) {
                    Database.get().remove(new PermissionDataAccess(world), filter);
                }
                else {
                    Database.get().remove(schema, filter);
                }
            }
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Remove all permissions that belong to the given group!
     *
     * @param group
     */
    public void removePermissions(Group group) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("owner", group.getName());
            filter.put("type", "group");
            Database.get().remove(new PermissionDataAccess(group.getWorldName()), filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Add a new Permission to database and return its proper object.
     * If the permission already exists, it will be updated instead and the appropriate ID will be returned.
     *
     * @param path
     *         String representation of the permission to add.<br>
     *         EXAMPLE: "canary.command.player.compass"
     * @param value
     *         Whether permission is true or false.
     * @param owner
     *         Name of the owner. Can be a player UUID or a group name.
     * @param type
     *         "player" or "group".
     * @param world
     *         The fully qualified world name as given by {@link World#getFqName()}<br>
     *         Can be null to access the global permissions table.
     *
     * @return The ID for the permission.
     */
    public int addPermission(String path, boolean value, String owner, String type, String world) {
        if (pathExists(path, owner, type, world)) {
            return updatePermission(path, owner, type, world, value);
        }
        PermissionDataAccess data = new PermissionDataAccess(world);

        data.path = path;
        data.value = value;
        data.owner = owner;
        data.type = type;

        try {
            Database.get().insert(data);
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("path", path);
            filter.put("owner", owner);
            filter.put("type", type);
            Database.get().load(data, filter);
            return data.id;
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.id;
    }

    /**
     * Update a permission node with the given values.
     * The values given must clearly identify the node to update.
     *
     * @param path
     *         String representation of the permission to add.<br>
     *         EXAMPLE: "canary.command.player.compass"
     * @param owner
     *         Name of the owner. Can be a player UUID or a group name.
     * @param type
     *         "player" or "group".
     * @param world
     *         The fully qualified world name as given by {@link World#getFqName()}<br>
     *         Can be null to access the global permissions table.
     * @param value
     *         True or false
     *
     * @return The ID of the updated permission
     */
    public int updatePermission(String path, String owner, String type, String world, boolean value) {
        PermissionDataAccess data = new PermissionDataAccess(world);
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("path", path);
            filter.put("owner", owner);
            filter.put("type", type);
            Database.get().load(data, filter);
            if (!data.hasData()) {
                throw new DatabaseReadException("Could not load a permission path! (" + path + ")");
            }
            data.value = value;
            Database.get().update(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
        return data.id;
    }

    public boolean pathExists(String path, String owner, String type, String world) {
        PermissionDataAccess data = new PermissionDataAccess(world);

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("path", path);
            filter.put("owner", owner);
            filter.put("type", type);
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.hasData();
    }

    /**
     * Creates a range of default permissions for the default groups defined in BackboneGroups
     */
    public static void createDefaultPermissionSet() {
        PermissionDataAccess admin = new PermissionDataAccess(null);
        PermissionDataAccess mods = new PermissionDataAccess(null);
        PermissionDataAccess players = new PermissionDataAccess(null);

        admin.owner = "admins";
        admin.type = "group";
        admin.path = "*";
        admin.value = true;

        mods.owner = "mods";
        mods.type = "group";
        mods.path = "canary.super.ignoreRestrictions";
        mods.value = true;

        players.owner = "players";
        players.type = "group";
        players.path = "canary.world.build";
        players.value = true;

        try {
            Database.get().insert(admin);
            Database.get().insert(mods);
            Database.get().insert(players);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Validate that player permissions have a UUID and not a playername.
     */
    public void validatePlayerPermissions(String world) {
        if (world != null && world.isEmpty()) {
            world = null;
        }
        // Database.get().remove("permission", new String[] {"owner", "type"}, new Object[] {group.getName(), "group"});
        ArrayList<DataAccess> dataList = new ArrayList<DataAccess>();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("type", "player");
            Database.get().loadAll(new PermissionDataAccess(world), dataList, filter);
            for (DataAccess da : dataList) {
                PermissionDataAccess data = (PermissionDataAccess)da;

                if (!ToolBox.isUUID(data.owner)) {
                    HashMap<String, Object> updateFilter = new HashMap<String, Object>();
                    updateFilter.put("owner", data.owner);

                    String uuid = ToolBox.usernameToUUID(data.owner);
                    data.owner = uuid;
                    try {
                        Database.get().update(data, updateFilter);
                    }
                    catch (DatabaseWriteException ex) {
                        Canary.log.error("Error Validating Player Permissions: ", ex);
                    }
                }
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
    }
}
