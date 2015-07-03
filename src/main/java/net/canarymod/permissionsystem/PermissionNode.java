package net.canarymod.permissionsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A permission node. This represents a permission. Who would have thought
 *
 * @author Chris (damagefilter)
 */
public class PermissionNode {

    private boolean value = false;

    private String name;

    /**
     * ID in the database
     */
    private int id;

    private Map<String, PermissionNode> childs = new HashMap<String, PermissionNode>();

    private PermissionNode parent = null;

    /**
     * Create a new PermissionNode.
     *
     * @param name
     *         the name
     * @param value
     *         the value
     */
    public PermissionNode(String name, boolean value) {
        if (name == null) {
            throw new IllegalArgumentException("PermissionNode: Name cannot be null!");
        }
        this.name = name;
        this.value = value;
        this.id = -1;
    }

    /**
     * Get the database ID for this node
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the database ID for this Node.
     * <b style="color:red">Do not use this unless you're dead sure what you're doing! it is HIGHLY unlikely that you will need this</b>
     *
     * @param id
     *         the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the parent node.
     *
     * @param parent
     *         the new parent
     */
    public void setParentNode(PermissionNode parent) {
        if (this.parent != null) {
            this.parent.childs.remove(name);
        }
        this.parent = parent;
        parent.childs.put(name, this);
    }

    /**
     * Get the value of this node
     *
     * @return the value of this node where true means "granted" false means "denied"
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Override the initially given value for this node
     *
     * @param value
     *         the value for this node
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * Get the name of this node
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full path name for this node starting here,
     * upwards to the first node in the inheritance tree
     *
     * @return a string representing the path up to this node
     */
    public String getFullPath() {
        List<PermissionNode> parents = parentsToList();
        StringBuilder path = new StringBuilder();

        for (int i = parents.size() - 1; i >= 0; i--) {
            path.append(parents.get(i).name).append(".");
        }
        path.append(this.name);
        return path.toString();
    }

    /**
     * This creates a list of parents starting with this nodes parent, walking the tree upwards to the first,
     * resulting in a reverse parent list. For example if this node was canary.world.canEnter,
     * the list would be ordered like this: canEnter,world,canary
     *
     * @return list of parents
     */
    private List<PermissionNode> parentsToList() {
        ArrayList<PermissionNode> parents = new ArrayList<PermissionNode>();

        walkParents(parents, this);
        return parents;
    }

    private void walkParents(List<PermissionNode> list, PermissionNode node) {
        if (node.parent == null) {
            return; // Found topmost permission
        }
        list.add(node.parent);
        walkParents(list, node.parent);
    }

    /**
     * Get a child node of this node with the given name
     *
     * @param child
     *         name of the child node
     *
     * @return an instance of the child node. Might be null if the specified child does not exist
     */
    public PermissionNode getChildNode(String child) {
        return childs.get(child);
    }

    /**
     * Check if this child node exists already
     *
     * @param child
     *
     * @return
     */
    public boolean hasChildNode(String child) {
        return childs.containsKey(child);
    }

    /**
     * Get all childs for this node
     *
     * @return a map of name=>permissionNode pairs representing this nodes children
     */
    public Map<String, PermissionNode> getChilds() {
        return childs;
    }

    /**
     * Check if this node has childs
     *
     * @return true if this node has children, false otherwise
     */
    public boolean hasChilds() {
        return childs.isEmpty();
    }

    /**
     * Put the given PermissionNode into the child list of this PermissionNode
     *
     * @param child
     *         the child to add
     */
    public void addChildNode(PermissionNode child) {
        child.setParentNode(this);
        childs.put(child.getName(), child);
    }

    /**
     * Check if this is an asterisk permission, granting access to all
     * subsequent nodes
     *
     * @return true if this is a wildcard node, false otherwise
     */
    public boolean isWildcard() {
        return name.equals("*");
    }

    @Override
    public String toString() {
        return "Name: " + name + " :: Value: " + value;
    }

    /**
     * Returns a permission node from a well formatted string.<br>
     * The String should be node.path:value<br>
     * Where value should be true or false. Value is an optional field. It will default to true
     *
     * @param in
     *
     * @return
     */
    public static PermissionNode fromString(String in) {
        String[] split = in.split(":");
        if (split.length == 1) {
            return new PermissionNode(in, true);
        }
        else {
            return new PermissionNode(split[0], Boolean.valueOf(split[1]));
        }
    }

    public void addPath(String[] path, boolean value, int index) {
        // If we grant a permission on a path, all preceding segments need to become granted.
        // Conversely, if we deny a specific node, all preceding segments should remain unchanged
        // as other paths may require them to remain granted.

        // If this nodes value is false but new value is true, grant this node
        if ((!this.getValue() && value) && !this.isWildcard()) {
            setValue(true);
        }
        if (index >= path.length) {
            // end
            return;
        }
        if (!hasChildNode(path[index])) {
            addChildNode(new PermissionNode(path[index], value));
        }
        getChildNode(path[index]).addPath(path, value, ++index);
    }

    /**
     * Resolves a given path of permission names into the resulting value.
     * This resolves the permission
     *
     * @param path
     *         the path
     * @param index
     *         the current index in the string array
     *
     * @return true if permission on this path is granted, false otherwise
     */
    public boolean resolveToValue(String[] path, int index) {
        boolean hasWildcardChild = this.hasChildNode("*");

        // If this is denied and it's not a wildcard, exit.
        // Wildcards specify no direct path thus subsequent nodes may be allowed
        if (!this.getValue() && !this.isWildcard()) {
            return false;
        }
        // Found final node
        if (index >= path.length) {
            return this.getValue();
        }
        // Check explicit permission
        if (this.hasChildNode(path[index])) {
            return this.getChildNode(path[index]).resolveToValue(path, ++index);
        }
        // Check implicit permission via wildcards
        else if (hasWildcardChild) {
            return getChildNode("*").getValue();
        }
        // Cannot resolve path to the end.
        // If this is a wildcard, return this value, false otherwise
        return isWildcard() && this.getValue();
    }

    /**
     * Purely resolves a path.
     * This can be used to see if any given permission path
     * can be fully resolved. Wildcards are taken into account
     *
     * @param path
     *         the path
     * @param index
     *         the current index in the string array
     *
     * @return true if path can be resolved, false otherwise
     */
    public boolean resolvePath(String[] path, int index) {
        boolean hasWildcardChild = hasChildNode("*");

        // We reached the end.
        if (index >= path.length) {
            return isWildcard() || getName().equals(path[path.length - 1]);
        }

        // Check explicit permission
        if (hasChildNode(path[index])) {
            return getChildNode(path[index]).resolvePath(path, ++index);
        }
        // Check implicit permission
        else if (hasWildcardChild) {
            return true;
        }

        return isWildcard();
    }
}
