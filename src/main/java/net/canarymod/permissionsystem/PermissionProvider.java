package net.canarymod.permissionsystem;

import net.canarymod.chat.MessageReceiver;

import java.util.List;

/**
 * Manages and provides permissions. Handles permission queries. The implementing class can
 * and should be instantiated per group and if player has custom permissions set
 * also for that player.
 *
 * @author Chris (damagefilter)
 */
public interface PermissionProvider {

    /**
     * Put all child nodes and childs of childs etc into one arrayList
     *
     * @param node
     * @param childs
     *
     * @return
     */
    List<PermissionNode> getChildNodes(PermissionNode node, List<PermissionNode> childs);

    /**
     * Add a new permission to the list. This is intelligent and will auto-sort
     * the permission into the tree. If you don't have the permission ID, do not use this!
     *
     * @param path
     * @param value
     * @param id
     */
    void addPermission(String path, boolean value, int id);

    /**
     * This adds a new permission into this provider, also creating a new entry in the database.
     * If the provided permission already exists in the DB, it's being updated.
     * If the path already exists within this provider, it will be updated if required
     *
     * @param path
     * @param value
     */
    void addPermission(String path, boolean value);

    /**
     * Execute a query for the given permission path. If the query finds an
     * asterisk permission on its way to the final node, it will exit
     * prematurely with what the asterisk permission value is
     *
     * @param permission
     *
     * @return boolean value at that path
     */
    boolean queryPermission(String permission);

    boolean pathExists(String permission);

    /**
     * Clears the permission cache
     */
    void flushCache();

    /**
     * Reload the permissions
     */
    void reload();

    void setOwner(String owner);

    void setType(boolean isPlayerProvider);

    /**
     * Get the List of permission root nodes this provider is handling
     *
     * @return
     */
    List<PermissionNode> getPermissionMap();

    /**
     * Returns a List of Strings with the full permission node paths contained in this provider.
     * Mostly used for storing this into a database
     *
     * @return
     */
    List<String> getPermissionsAsStringList();

    /**
     * Print out the list of the permissions filed in this provider in a human readable way to the given caller
     *
     * @param caller
     */
    void printPermissionsToCaller(MessageReceiver caller);

    /**
     * get the world name for this permission provider.
     * This is null if the permission provider is global (valid in all worlds)
     *
     * @return
     */
    String getWorld();

    /**
     * Returns the parent permission provider. usually this is the global provider.
     * Returns null if this PermissionProvider instance has no parent.
     * Default CanaryMod logic mandates that only world-specific providers
     * may have a parent - a global provider.
     *
     * @return
     */
    PermissionProvider getParent();
}
