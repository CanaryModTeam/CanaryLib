package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

/**
 * Operators Data Access
 *
 * @author Jason (darkdiplomat)
 */
public class OperatorsDataAccess extends DataAccess {

    public OperatorsDataAccess() {
        super(Configuration.getDbConfig().getOpertatorsTableName());
    }

    /**
     * Playername for this operator entry
     */
    @Column(columnName = "player", dataType = DataType.STRING)
    public String player;

    @Override
    public DataAccess getInstance() {
        return new OperatorsDataAccess();
    }
}
