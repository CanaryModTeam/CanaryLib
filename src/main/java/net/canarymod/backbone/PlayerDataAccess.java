package net.canarymod.backbone;

import net.canarymod.config.Configuration;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;

import java.util.Arrays;
import java.util.List;

/**
 * Player Data Access
 *
 * @author Chris (damagefilter)
 */
public class PlayerDataAccess extends DataAccess {

    public PlayerDataAccess() {
        super(Configuration.getDbConfig().getPlayersTableName());
    }

    /**
     * Player uuid for this ban.
     */
    @Column(columnName = "uuid", dataType = DataType.STRING)
    public String uuid;

    /**
     * name of the player.
     */
    @Column(columnName = "name", dataType = DataType.STRING)
    public String name;

    /**
     * Player prefix.
     */
    @Column(columnName = "prefix", dataType = DataType.STRING)
    public String prefix;

    /**
     * Player group.
     */
    @Column(columnName = "group", dataType = DataType.STRING)
    public String group;

    /**
     * Is this player muted?
     */
    @Column(columnName = "isMuted", dataType = DataType.BOOLEAN)
    public boolean isMuted = false;

    /**
     * A list of additional sub groups.
     * Permissions will be solved according to first to come, first to rule.
     * Unless specified otherwise, a players color will be the one of the main group
     */
    @Column(columnName = "subgroups", dataType = DataType.STRING, isList = true)
    public List<String> subgroups;

    @Override
    public DataAccess getInstance() {
        return new PlayerDataAccess();
    }

    public final String toString() {
        return String.format("PlayerDataAccess[UUID:%s Name:%s Prefix:%s Group:%s Muted:%b SubGroups:%s]", uuid, name, prefix, group, isMuted, Arrays.deepToString(subgroups.toArray()));
    }
}
