package net.canarymod.permissionsystem;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.Translator;
import net.canarymod.backbone.PermissionDataAccess;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A PermissionProvider implementation based on PermissionNode objects,
 * with multiworld support
 *
 * @author Chris (damagefilter)
 */
public class MultiworldPermissionProvider implements PermissionProvider {
    private List<PermissionNode> permissions;
    private Map<String, Boolean> permissionCache = new HashMap<String, Boolean>(35);
    private boolean isPlayerProvider;
    private String owner; // This can either be a player uuid or group name
    private String world;
    private PermissionProvider parent = null;

    /**
     * Constructs a new PermissionProvider that's valid for the given world
     *
     * @param world
     *         the world
     */
    public MultiworldPermissionProvider(String world, boolean isPlayer, String owner) {
        this.world = world;
        permissions = new ArrayList<PermissionNode>();
        this.isPlayerProvider = isPlayer;
        // If world is not null, set the parent to the global providers
        if (world != null) {
            if (isPlayer) {
                if (!ToolBox.isUUID(owner)) {
                    owner = ToolBox.usernameToUUID(owner);
                }
                this.parent = Canary.permissionManager().getPlayerProvider(owner, null);
            }
            else {
                this.parent = Canary.permissionManager().getGroupsProvider(owner, null);
            }
        }
        // Set owner here, it might have been altered because of UUID mangling
        this.owner = owner;
    }

    /**
     * Testing constructor. Use only for testing changes to this provider
     */
    public MultiworldPermissionProvider() {
        this.world = null;
        permissions = new ArrayList<PermissionNode>();
        this.isPlayerProvider = false;
        this.owner = "admins";
    }

    /**
     * Testing constructor. Use only for testing changes to this provider
     */
    public MultiworldPermissionProvider(MultiworldPermissionProvider parent) {
        this.world = null;
        permissions = new ArrayList<PermissionNode>();
        this.isPlayerProvider = false;
        this.owner = "admins";
        this.parent = parent;
    }

    /**
     * Add a given permission to the permissions cache. The cache is limited and
     * will prune itself if it gets too big.
     *
     * @param path
     * @param value
     */
    private void addPermissionToCache(String path, boolean value) {
        if (permissionCache.size() > 35) {
            Iterator<Entry<String, Boolean>> it = permissionCache.entrySet().iterator();

            while (it.hasNext() && permissionCache.size() > 10) {
                it.next();
                it.remove();
            }
        }
        permissionCache.put(path, value);
    }

    /**
     * Check the permission cache if we have something already
     *
     * @param permission
     *
     * @return
     */
    private Boolean checkCached(String permission) {
        return permissionCache.get(permission);
    }

    @Override
    public List<PermissionNode> getChildNodes(PermissionNode node, List<PermissionNode> childs) {
        childs.add(node);
        if (node.hasChilds()) {
            for (String key : node.getChilds().keySet()) {
                getChildNodes(node.getChilds().get(key), childs);
            }
        }
        return childs;
    }

    /**
     * get a node that must be directly in the permissions list
     *
     * @param name
     *
     * @return
     */
    private PermissionNode getRootNode(String name) {
        for (PermissionNode n : permissions) {
            if (n.getName().equals(name) || n.isWildcard()) {
                return n;
            }
        }
        return null;
    }

    /**
     * Resolve a path when adding new stuff
     *
     * @param path
     * @param value
     *
     * @return
     */
    private PermissionNode addPath(String[] path, boolean value) {
        PermissionNode node = getRootNode(path[0]);
        if (node == null) {
            node = new PermissionNode(path[0], value);
            permissions.add(node);
        }
        node.addPath(path, value, 1);

        return node;
    }

    /**
     * Resolve the string path and return the result
     *
     * @param path
     *
     * @return
     */
    private boolean resolvePath(String[] path) {
        PermissionNode node = getRootNode(path[0]);
        return node != null && node.resolveToValue(path, 1);
    }

    /**
     * Checks if this permission provider actually has the given path loaded.
     *
     * @param path
     *
     * @return
     */
    private boolean hasPath(String[] path) {
        PermissionNode node = getRootNode(path[0]);
        return node != null && node.resolvePath(path, 1);
    }

    @Override
    public void addPermission(String path, boolean value, int id) {
        String[] paths = path.split("\\.");

        if (paths.length == 0) {
            paths = new String[]{ path }; // we have only one node (root)
        }
        PermissionNode node = addPath(paths, value);

        node.setId(id);
        flushCache();
    }

    @Override
    public void addPermission(String path, boolean value) {
        addPermission(path, value, Canary.permissionManager().addPermission(path, value, owner, isPlayerProvider ? "player" : "group", this.world));
        // addPermission(path, value, permissions.size()); //Testing
        flushCache();
    }

    @Override
    public boolean queryPermission(String permission) {
        if (permission.isEmpty() || permission.equals(" ")) {
            return true;
        }
        Boolean b = checkCached(permission);
        if (b != null) {
            return b;
        }
        String[] path = permission.split("\\.");
        if (!this.hasPath(path)) {
            if (parent != null) {
                return parent.queryPermission(permission);
            }
        }
        boolean result = resolvePath(permission.split("\\."));
        addPermissionToCache(permission, result);

        return result;
    }

    @Override
    public boolean pathExists(String permission) {
        return permission.trim().isEmpty() || hasPath(permission.split("\\.")) || (parent != null && parent.pathExists(permission));
    }

    @Override
    public void flushCache() {
        permissionCache.clear();
    }

    @Override
    public void reload() {
        permissions.clear();
        permissionCache.clear();
        if (isPlayerProvider) {
            PermissionProvider p = Canary.permissionManager().getPlayerProvider(owner, world);
            permissions = p.getPermissionMap();
        }
        else {
            PermissionProvider p = Canary.permissionManager().getGroupsProvider(owner, world);
            permissions = p.getPermissionMap();
        }
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setType(boolean isPlayerProvider) {
        this.isPlayerProvider = isPlayerProvider;
    }

    @Override
    public List<PermissionNode> getPermissionMap() {
        return permissions;
    }

    @Override
    public List<String> getPermissionsAsStringList() {
        List<String> list = new ArrayList<String>();

        for (PermissionNode node : permissions) {
            list.add(node.getFullPath());
        }
        return list;
    }

    @Override
    public void printPermissionsToCaller(MessageReceiver caller) {
        PermissionDataAccess data = new PermissionDataAccess(world);
        ArrayList<DataAccess> list = new ArrayList<DataAccess>();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("owner", this.owner);
            filter.put("type", isPlayerProvider ? "player" : "group");
            Database.get().loadAll(data, list, filter);
        }
        catch (DatabaseReadException e) {
            caller.notice(Translator.translate("no permissions"));
        }
        if (list.size() > 0) {
            for (DataAccess da : list) {
                PermissionDataAccess perm = (PermissionDataAccess)da;
                if (perm.value) {
                    caller.message(ChatFormat.GREEN + perm.path + ": true");
                }
                else {
                    caller.message(ChatFormat.RED + perm.path + ": false");
                }
            }
        }
        else {
            caller.notice(Translator.translate("no permissions"));
        }
    }

    @Override
    public String getWorld() {
        return world;
    }

    @Override
    public PermissionProvider getParent() {
        return parent;
    }
}
