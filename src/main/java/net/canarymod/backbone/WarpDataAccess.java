package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.LocationDataAccess;

import java.util.List;

/**
 * Warp Data Access
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public class WarpDataAccess extends LocationDataAccess {

    public WarpDataAccess() {
        super(Configuration.getDbConfig().getWarpsTableName());
    }

    /**
     * Name of this warp.
     */
    @Column(columnName = "name", notNull = true, dataType = DataType.STRING)
    public String name;

    /**
     * Is this warp a player home?
     */
    @Column(columnName = "isPlayerHome", dataType = DataType.BOOLEAN)
    public boolean isPlayerHome;

    /**
     * Owner of this warp.
     */
    @Column(columnName = "owner", dataType = DataType.STRING)
    public String owner; // Converting to UUID

    /**
     * groups that can use this warp.
     */
    @Column(columnName = "groups", dataType = DataType.STRING, isList = true)
    public List<String> groups;

    /**
     * Serialised location of this warp.
     */
    @Deprecated // We're burning it
    @Column(columnName = "location", dataType = DataType.STRING)
    public String location;

    @Override
    public WarpDataAccess getInstance() {
        return new WarpDataAccess();
    }
}
