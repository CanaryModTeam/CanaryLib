package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

import java.util.List;

/**
 * Kit Data Access
 *
 * @author Chris (damagefilter)
 */
public class KitDataAccess extends DataAccess {

    public KitDataAccess() {
        super(Configuration.getDbConfig().getKitsTableName());
    }

    /**
     * Delay in seconds to receive this kit.
     */
    @Column(columnName = "useDelay", dataType = DataType.INTEGER)
    public int useDelay;

    /**
     * List of Users names who can use this kit.
     */
    @Column(columnName = "owners", dataType = DataType.STRING, isList = true)
    public List<String> owners;

    /**
     * List of groups who can use this kit.
     */
    @Column(columnName = "groups", dataType = DataType.STRING, isList = true)
    public List<String> groups;

    /**
     * Name of this kit.
     */
    @Column(columnName = "name", dataType = DataType.STRING)
    public String name;

    /**
     * Items to give from this kit.
     */
    @Column(columnName = "items", dataType = DataType.STRING, isList = true)
    public List<String> items;

    @Override
    public DataAccess getInstance() {
        return new KitDataAccess();
    }
}
