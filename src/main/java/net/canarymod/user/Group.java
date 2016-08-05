package net.canarymod.user;

import net.canarymod.backbone.GroupDataAccess;
import net.canarymod.chat.ChatFormat;
import net.canarymod.permissionsystem.PermissionProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player group
 *
 * @author Chris (damagefilter)
 */
public class Group {

    /**
     * ID for retrieving permissions from the database
     */
    private int id;

    /**
     * Group Name
     */
    private String name;

    /**
     * Group Prefix/Color
     */
    private String prefix = null;

    /**
     * The fully qualified world name valid for this group.
     * If this group is valid for all worlds, this may be null
     */
    private String worldName = null;

    /**
     * The permission provider for querying permissions etc.
     */
    private PermissionProvider permissions;

    /**
     * List of groups this group inherits/has control over
     */
    private List<Group> childGroups = new ArrayList<Group>();

    /**
     * The parent group (the group this group is a child of).
     * Parents have control over their childs
     */
    private Group parent = null;

    /**
     * Is true if it's the default group
     */
    private boolean defaultGroup = false;

    /**
     * Check if this group can ignore restrictions
     *
     * @return {@code true} if can Ignore Restrictions
     */
    public boolean canIgnorerestrictions() {
        return hasPermission("canary.super.ignoreRestrictions");
    }

    /**
     * Check if this group is an administrative groups
     *
     * @return {@code true} if administrator group
     */
    public boolean isAdministratorGroup() {
        return hasPermission("canary.super.administrator");
    }

    /**
     * Checks if this group can build
     *
     * @return {@code true} if can build
     */
    public boolean canBuild() {
        return hasPermission("canary.world.build");
    }

    /**
     * Check if this group has control over the given group, specifically, check
     * if the given group is a child of this group, or if this group is admin.<br>
     *
     * @param g
     *         the group to check control of
     *
     * @return {@code true} if has control over
     */
    public boolean hasControlOver(Group g) {
        if (isAdministratorGroup()) {
            return true;
        }
        if (this.name.equals(g.name)) {
            return true;
        }
        for (Group gr : g.childsToList()) {
            if (gr.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks in this group and its's parent (and the parent of the parent etc etc) if it has permission
     * and if the value is true. The first found "true" will be returned,
     * false if there was no "true" or the node had false as value (ie. this group does not have this permission)
     *
     * @return {@code true} if has permission
     */
    public boolean hasPermission(String permission) {
        // NOTE: to whoever comes by and thinks, hey a permission check hook is missing:
        // Permission check hooks are fired in all MessageReceivers.
        // Doing it here too would fire a hook for the same request twice.
        if (permissions.pathExists(permission)) {
            return permissions.queryPermission(permission);
        }
        return parent != null && parent.hasPermission(permission); // Better recursion
    }

    /**
     * Returns all the children groups
     *
     * @return the list of children groups
     */
    public List<Group> childsToList() {
        List<Group> list = new ArrayList<Group>();

        walkChilds(list, this);
        return list;
    }

    /**
     * Returns all the parents from this group upwards
     *
     * @return the list of parent groups
     */
    public List<Group> parentsToList() {
        List<Group> parents = new ArrayList<Group>();
        if (this.parent == null || this.parent == this) {
            return parents;
        }
        if (!parents.contains(this.parent)) {
            parents.add(this.parent);
        }
        walkParents(parents, this.parent);
        return parents;
    }

    private void walkParents(List<Group> list, Group group) {
        if (group.parent == null) {
            return; // Found topmost group
        }
        list.add(group.parent);
        walkParents(list, group.parent);
    }

    private void walkChilds(List<Group> list, Group group) {
        list.add(group);
        for (Group g : group.childGroups) {
            walkChilds(list, g);
        }
    }

    /**
     * Gets the prefix of the Group
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix != null ? prefix : ChatFormat.WHITE.toString();
    }

    /**
     * Sets the prefix of the Group
     *
     * @param prefix
     *         the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(boolean defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    public PermissionProvider getPermissionProvider() {
        return permissions;
    }

    public void setPermissionProvider(PermissionProvider provider) {
        this.permissions = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public Group getParent() {
        return parent;
    }

    /**
     * Set a new parent.
     * This will remove the group from its old parent
     * and add it to the new parents childs list
     *
     * @param group
     */
    public void setParent(Group group) {
        if (parent != null) {
            parent.detachChild(this);
        }

        if (group != null) {
            group.addChild(this);
        }
        parent = group;
    }

    public void addChild(Group g) {
        childGroups.add(g);
    }

    public void detachChild(Group g) {
        childGroups.remove(g);
    }

    /**
     * Return am live list of children.
     * Modify this list only if you know what you're doing.
     * For changing group inheritance use setParent();
     *
     * @return
     */
    public List<Group> getChildren() {
        return childGroups;
    }

    /**
     * @return the worldName fully qualified name for a world
     */
    public String getWorldName() {
        return worldName;
    }

    /**
     * @param worldName
     *         the worldName to set
     */
    public void setWorldName(String worldName) {
        if (this.parent != null) {
            if (this.parent.getWorldName() != null && !this.parent.getWorldName().equals(worldName)) {
                return; //TODO: Throw exception?
            }
        }
        this.worldName = worldName;
        for (Group g : childGroups) {
            g.setWorldName(worldName);
        }
    }

    /**
     * Checks if this group is applied globally (not assigned to a specific world)
     *
     * @return {@code true} if global; {@code false} if not
     */
    public boolean isGlobal() {
        return this.worldName == null;
    }

    /**
     * Creates a {@link net.canarymod.backbone.GroupDataAccess} of this Group
     *
     * @return {@link net.canarymod.backbone.GroupDataAccess}
     */
    public GroupDataAccess toDataAccess() {
        GroupDataAccess gda = new GroupDataAccess();
        gda.id = getId();
        gda.isDefault = isDefaultGroup();
        gda.name = getName();
        gda.parent = getParent() != null ? getParent().getName() : null;
        gda.prefix = getPrefix();
        gda.worldName = getWorldName();
        return gda;
    }
}
