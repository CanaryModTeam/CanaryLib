package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

/**
 * Permission Data Access
 *
 * @author Chris (damagefilter)
 */
public class PermissionDataAccess extends DataAccess {

    private String suffix;

    /**
     * Create this data access with an additional suffix
     *
     * @param suffix
     *         the suffix
     */
    public PermissionDataAccess(String suffix) {
        super(Configuration.getDbConfig().getPermissionsTableName(), suffix);
        this.suffix = suffix;
    }

    /**
     * Node for this Permission.
     */
    @Column(columnName = "path", dataType = DataType.STRING)
    public String path;

    /**
     * Whether or not this permission is true or false.
     */
    @Column(columnName = "value", dataType = DataType.BOOLEAN)
    public boolean value;

    /**
     * The name of the owner of this node (group or player uuid )
     */
    @Column(columnName = "owner", dataType = DataType.STRING)
    public String owner;

    /**
     * The permission node type (player or group)
     */
    @Column(columnName = "type", dataType = DataType.STRING)
    public String type;

    @Override
    public DataAccess getInstance() {
        return new PermissionDataAccess(suffix);
    }
}
