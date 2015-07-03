package net.canarymod.backbone;

import net.canarymod.bansystem.Ban;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Backbone to the ban System. This contains NO logic, it is only the data
 * source access!
 *
 * @author Chris
 */
public class BackboneBans extends Backbone {

    private static BanDataAccess schema = new BanDataAccess();

    public BackboneBans() {
        super(Backbone.System.BANS);
        try {
            Database.get().updateSchema(schema);
        }
        catch (DatabaseWriteException e) {
            log.error("Failed to update Database Schema!", e);
        }
    }

    private boolean banExists(Ban ban) {
        BanDataAccess data = new BanDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", ban.getUUID());
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return data.hasData();
    }

    /**
     * Add a new Ban to the list of bans.
     *
     * @param ban
     *         The ban to add.
     */
    public void addBan(Ban ban) {
        if (banExists(ban)) {
            updateBan(ban);
            return;
        }
        BanDataAccess data = new BanDataAccess();

        data.uuid = ban.getUUID();
        data.player = ban.getSubject();
        data.banningPlayer = ban.getBanningPlayer();
        data.unbanDate = ban.getExpiration();
        data.reason = ban.getReason();
        data.ip = ban.getIp();
        data.issuedDate = ban.getIssuedDate();
        try {
            Database.get().insert(data);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Lift a ban that was issued for the player with the given uuid
     *
     * @param uuid
     *         Player uuid to unban.
     */
    public void liftBan(String uuid) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", uuid);
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Lift an IP ban.
     *
     * @param subject
     *         IP Address to unban.
     */
    public void liftIpBan(String subject) {
        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("ip", subject);
            Database.get().remove(schema, filter);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Get a ban for this player uuid.
     * This may return null if the ban does not exist
     *
     * @param uuid
     *         Ban for the player with the given uuid or null if none.
     *
     * @return Returns a ban object if that ban was found, null otherwise
     */
    public Ban getBan(String uuid) {
        BanDataAccess data = new BanDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", uuid);
            Database.get().load(data, filter);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        if (!data.hasData()) {
            return null;
        }
        Ban newBan = new Ban();
        newBan.setUUID(data.uuid);
        newBan.setIp(data.ip);
        newBan.setIsIpBan(!data.ip.contains("xxx"));
        newBan.setReason(data.reason);
        newBan.setSubject(data.player);
        newBan.setExpiration(data.unbanDate);
        newBan.setIssuedDate(data.issuedDate);
        newBan.setBanningPlayer(data.banningPlayer);
        return newBan;
    }

    /**
     * Update a ban.
     *
     * @param ban
     *         Ban instance to update.
     */
    public void updateBan(Ban ban) {
        BanDataAccess data = new BanDataAccess();

        try {
            HashMap<String, Object> filter = new HashMap<String, Object>();
            filter.put("uuid", ban.getUUID());
            Database.get().load(data, filter);
            if (data.hasData()) {
                data.uuid = ban.getUUID();
                data.banningPlayer = ban.getBanningPlayer();
                data.ip = ban.getIp();
                data.player = ban.getSubject();
                data.reason = ban.getReason();
                data.unbanDate = ban.getExpiration();
                data.issuedDate = ban.getIssuedDate();
                Database.get().update(data, filter);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        catch (DatabaseWriteException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Load and return all recorded bans
     *
     * @return An array list of all recorded ban instances.
     */
    public List<Ban> loadBans() {
        List<Ban> banList = new ArrayList<Ban>();
        List<DataAccess> dataList = new ArrayList<DataAccess>();

        try {
            Database.get().loadAll(schema, dataList, new HashMap<String, Object>());
            for (DataAccess da : dataList) {
                BanDataAccess data = (BanDataAccess)da;
                Ban ban = new Ban();

                ban.setUUID(data.uuid);
                ban.setBanningPlayer(data.banningPlayer);
                ban.setIp(data.ip);
                ban.setIsIpBan(!data.ip.contains("xxx"));
                ban.setReason(data.reason);
                ban.setSubject(data.player);
                ban.setExpiration(data.unbanDate);
                ban.setIssuedDate(data.issuedDate);
                banList.add(ban);
            }
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        return banList;
    }
}
