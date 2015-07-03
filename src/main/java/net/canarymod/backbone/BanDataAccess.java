package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

/**
 * Ban Data Access
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public class BanDataAccess extends DataAccess {

    public BanDataAccess() {
        super(Configuration.getDbConfig().getBansTableName());
    }

    /**
     * Player uuid for this ban.
     */
    @Column(columnName = "uuid", dataType = DataType.STRING)
    public String uuid;

    /**
     * Player name for this ban.
     */
    @Column(columnName = "player", dataType = DataType.STRING)
    public String player;

    /**
     * IP Address for this ban.
     */
    @Column(columnName = "ip", dataType = DataType.STRING)
    public String ip;

    /**
     * Reason for this ban.
     */
    @Column(columnName = "reason", dataType = DataType.STRING)
    public String reason;

    /**
     * Player who banned this player.
     */
    @Column(columnName = "banningPlayer", dataType = DataType.STRING)
    public String banningPlayer;

    /**
     * Date to unban.
     */
    @Column(columnName = "unbanDate", dataType = DataType.LONG)
    public long unbanDate = -1;

    /**
     * Date ban issued.
     */
    @Column(columnName = "issuedDate", dataType = DataType.LONG)
    public long issuedDate = -1;

    @Override
    public DataAccess getInstance() {
        return new BanDataAccess();
    }
}
