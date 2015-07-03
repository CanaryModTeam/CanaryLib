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
public class WhitelistDataAccess extends DataAccess {

    public WhitelistDataAccess() {
        super(Configuration.getDbConfig().getWhitelistTableName());
    }

    /**
     * UUID for this reservelist entry
     */
    @Column(columnName = "uuid", dataType = DataType.STRING)
    public String uuid;

    /**
     * Playername for this
     * <p/>
     * /** Playername for this whitelist entry
     */
    @Column(columnName = "player", dataType = DataType.STRING)
    public String player;

    @Override
    public DataAccess getInstance() {
        return new WhitelistDataAccess();
    }
}
