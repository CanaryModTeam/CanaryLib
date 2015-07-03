package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

/**
 * Group Data Access
 *
 * @author Chris (damagefilter)
 */
public class GroupDataAccess extends DataAccess {

    public GroupDataAccess() {
        super(Configuration.getDbConfig().getGroupsTableName());
    }

    /**
     * Name of this group.
     */
    @Column(columnName = "name", dataType = DataType.STRING)
    public String name;

    /**
     * Chat prefix for this group.
     */
    @Column(columnName = "prefix", dataType = DataType.STRING)
    public String prefix;

    /**
     * Parent group for this group.
     */
    @Column(columnName = "parent", dataType = DataType.STRING)
    public String parent;

    /**
     * Is this the default group?
     */
    @Column(columnName = "isDefault", dataType = DataType.BOOLEAN)
    public boolean isDefault;

    /**
     * Then world name for this group. May be null if group is global
     */
    @Column(columnName = "world", dataType = DataType.STRING)
    public String worldName;

    @Override
    public DataAccess getInstance() {
        return new GroupDataAccess();
    }
}
