package net.canarymod.user;

import com.google.common.collect.BiMap;
import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.OfflinePlayer;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.backbone.BackboneGroups;
import net.canarymod.backbone.BackboneUsers;
import net.canarymod.backbone.PlayerDataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.canarymod.Canary.log;

/**
 * Access to the backbone for users and groups
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public class UserAndGroupsProvider {
    private BiMap<String, Group> groups;
    private Map<String, String[]> playerData;
    private BackboneGroups backboneGroups;
    private BackboneUsers backboneUsers;
    private Group defaultGroup;

    /**
     * Instantiate a groups provider
     */
    public UserAndGroupsProvider() {
        backboneGroups = new BackboneGroups();
        backboneUsers = new BackboneUsers();
        initGroups();
        initPlayers();
    }

    private void initGroups() {
        groups = backboneGroups.loadGroups();
        if (groups.isEmpty()) {
            BackboneGroups.createDefaults();
            // Load again
            groups = backboneGroups.loadGroups();
        }

        for (Group g : this.groups.values()) {
            g.setPermissionProvider(Canary.permissionManager().getGroupsProvider(g.getName(), g.getWorldName()));
        }
        // find default group
        for (Group g : groups.values()) {
            if (g.isDefaultGroup()) {
                defaultGroup = g;
                break;
            }
        }
        if (defaultGroup == null) {
            throw new IllegalStateException("No default group defined! Please define a default group!");
        }
    }

    private void initPlayers() {
        playerData = new BackboneUsers().loadUsers();
        if (playerData.size() == 0) {
            BackboneUsers.createDefaults();
            playerData = new BackboneUsers().loadUsers();
        }
    }

    /**
     * Add a new Group
     *
     * @param g
     */
    public void addGroup(Group g) {
        synchronized (groups) {
            if (groupExists(g.getName())) {
                backboneGroups.updateGroup(g);
            }
            else {
                backboneGroups.addGroup(g);
            }
            groups.put(g.getName(), g);
        }
    }

    /**
     * Remove this group
     *
     * @param g
     *         the group to remove
     */
    public void removeGroup(Group g) {
        synchronized (groups) {
            // Move children up to the next parent
            try {
                List<Group> childs = new ArrayList<Group>();
                childs.addAll(g.getChildren());
                //            Collections.copy(childs, g.getChildren());

                for (Group child : childs) {
                    child.setParent(g.getParent());
                    this.updateGroup(child, false);
                }
                // Now we can safely remove the group
                backboneGroups.removeGroup(g);
                groups.inverse().remove(g);
            }
            catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Rename a group
     *
     * @param group
     *         Group in question
     * @param newName
     *         the new name
     */
    public void renameGroup(Group group, String newName) {
        synchronized (groups) {
            groups.inverse().remove(group);
            backboneGroups.renameGroup(group, newName);
            groups.put(newName, group);

            for (Group g : groups.values()) { // Just update those who need it
                if (g.hasParent() && g.getParent().equals(group)) {
                    updateGroup(g, false);
                }
            }
        }
    }

    /**
     * Check if a group by the given name exists
     *
     * @param name
     *
     * @return {@code true} if exists; {@code false} if not
     */
    public boolean groupExists(String name) {
        synchronized (groups) {
            return groups.containsKey(name);
        }
    }

    /**
     * Check if the given group is filed in this groups provider
     *
     * @param g
     *
     * @return
     */
    public boolean groupExists(Group g) {
        synchronized (groups) {
            return groups.containsValue(g);
        }
    }

    /**
     * Check if there is a set of data present for the given player UUID
     *
     * @param uuid
     *         the players UUID
     *
     * @return true if there is a set of data present, false otherwise
     */
    public boolean playerExists(String uuid) {
        return playerData.containsKey(uuid);
    }

    /**
     * Checks if a {@link net.canarymod.api.PlayerReference} has changed names compared to the database
     *
     * @param reference
     *         the {@link net.canarymod.api.PlayerReference} to check
     *
     * @return {@code true} if the name is different in the database; {@code false} if not
     */
    public boolean nameChanged(PlayerReference reference) {
        PlayerDataAccess data = new PlayerDataAccess();
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", reference.getUUIDString());
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
            return false; // It either broke, or they don't exist
        }
        return !reference.getName().equals(data.name);
    }

    /**
     * Return array of all existent groups
     *
     * @return
     */
    public Group[] getGroups() {
        Group[] grp = new Group[groups.size()];

        return groups.values().toArray(grp);
    }

    /**
     * Return array of all existent group names
     *
     * @return group names
     */
    public String[] getGroupNames() {
        return groups.keySet().toArray(new String[groups.size()]);
    }

    /**
     * Returns group files under the given name or the default group if the specified one doesn't exist
     *
     * @param name
     *
     * @return the group with the assigned name; or {@code defaultGroup} if no group with assigned name is found
     */
    public Group getGroup(String name) {
        if (name == null || name.isEmpty()) {
            return defaultGroup;
        }
        synchronized (groups) {
            if (groups.containsKey(name)) {
                return groups.get(name);
            }
        }
        return defaultGroup;
    }

    /**
     * Get the default group
     *
     * @return default Group object
     */
    public Group getDefaultGroup() {
        return this.defaultGroup;
    }

    /**
     * Returns a String array containing data in this order:
     * Prefix, Group, isMuted
     *
     * @param uuid
     *
     * @return
     */
    public String[] getPlayerData(String uuid) {
        String[] data = playerData.get(uuid);

        if (data == null) {
            data = new String[3];
            data[0] = null;
            data[1] = defaultGroup.getName();
            data[2] = null;
            playerData.put(uuid, data);
        }

        return data;
    }

    /**
     * Get the names of all players in the user table
     *
     * @return
     */
    public String[] getPlayers() {
        String[] retT = {};

        return backboneUsers.loadUsers().keySet().toArray(retT);
    }

    /**
     * Add or update the given player
     *
     * @param player
     */
    public void addOrUpdatePlayerData(Player player) {
        backboneUsers.addUser(player);
        String[] content = new String[3];
        String prefix = player.getPrefix();
        if (prefix.equals(player.getGroup().getPrefix())) {
            content[0] = null;
        }
        else {
            content[0] = prefix;
        }
        content[1] = player.getGroup().getName();
        content[2] = Boolean.toString(player.isMuted());
        playerData.put(player.getUUIDString(), content);
    }

    /**
     * Add a player that is currently offline.
     * It will assume default values for any unspecified data
     *
     * @param name
     * @param group
     */
    public void addOfflinePlayer(String name, String group) {
        String uuid = ToolBox.isUUID(name) ? name : ToolBox.usernameToUUID(name);
        backboneUsers.addUser(uuid, group);
        if (uuid == null) {
            log.error("Was unable to get a UUID for Player: " + name + ". Skipping!");
            return;
        }
        if (playerData.containsKey(uuid)) {
            log.warn("Player " + name + " already exists. Skipping!");
            return;
        }
        String[] content = new String[3];
        content[0] = null;
        content[1] = group;
        content[2] = Boolean.toString(false);
        playerData.put(uuid, content);
    }

    public void addOrUpdateOfflinePlayer(OfflinePlayer player) {
        if (!playerData.containsKey(player.getUUIDString())) {
            addOfflinePlayer(player.getUUIDString(), player.getGroup().getName());
        }
        else {
            backboneUsers.updatePlayer(player);
            playerData.remove(player.getUUIDString());
            String[] data = new String[3];
            String prefix = player.getPrefix();
            if (player.getGroup().getPrefix().equals(prefix)) {
                data[0] = null;
            }
            else {
                data[0] = prefix;
            }
            data[1] = player.getGroup().getName();
            data[2] = Boolean.toString(player.isMuted());
            playerData.put(player.getUUIDString(), data);
        }
    }

    public void updateGroup(Group g, boolean reload) {
        backboneGroups.updateGroup(g);
        if (reload) {
            reloadGroupsData();
        }
    }

    /**
     * Remove permissions and other data for this player from uuid
     *
     * @param uuid
     *         UUID for the player
     */
    public void removeUserData(String uuid) {
        backboneUsers.removeUser(uuid);
        playerData.remove(uuid);
        this.refreshPlayerInstance(uuid);
    }

    public void reloadUserData() {
        playerData.clear();
        playerData = backboneUsers.loadUsers();
    }

    public void reloadGroupsData() {
        groups.clear();
        initGroups();
    }

    public void reloadAll() {
        reloadUserData();
        reloadGroupsData();
        // Update players with new group data
        for (Player player : Canary.getServer().getPlayerList()) {
            // Fetch fresh data from the backbones
            player.initPlayerData();
        }
    }

    /**
     * Returns all additional groups for a player
     *
     * @param uuid
     *
     * @return
     */
    public Group[] getModuleGroupsForPlayer(String uuid) {
        return backboneUsers.getModularGroups(uuid);
    }

    /**
     * Refreshes a players local instance if they are online with any updates
     * performed here.
     *
     * @param uuid
     *         the players uuid
     *
     * @return true if the player was online, false otherwise.
     */
    private boolean refreshPlayerInstance(String uuid) {
        //Player p = Canary.getServer().getPlayerFromUUID(uuid);
        //if (p != null) {
        //    addOrUpdatePlayerData(p);
        //    return true;
        //}
        return false;
    }
}
