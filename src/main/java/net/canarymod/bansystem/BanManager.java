package net.canarymod.bansystem;

import static net.canarymod.Canary.log;

import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.backbone.BackboneBans;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to issue bans
 *
 * @author Chris (damagefilter)
 */
public class BanManager {
    private BackboneBans backbone;
    private List<Ban> bans = new ArrayList<Ban>();

    public BanManager() {
        backbone = new BackboneBans();
        bans = backbone.loadBans();
    }

    /**
     * Issue a permanent ban for this player with a given reason
     *
     * @param player
     *         the {@link PlayerReference} being banned
     * @param reason
     *         the reason for the ban
     */
    public void issueBan(PlayerReference player, String reason) {
        Ban ban = new Ban(player, reason, false);

        bans.add(ban);
        backbone.addBan(ban);
    }

    /**
     * Issues a ban using the given {@link Ban}
     *
     * @param ban
     *         the {@link Ban} to be issued
     */
    public void issueBan(Ban ban) {
        bans.add(ban);
        backbone.addBan(ban);
    }

    /**
     * Issue a temporary ban.
     *
     * @param player
     *         the {@link PlayerReference} being banned
     * @param reason
     *         the reason for the ban
     * @param time
     *         The time component must be NUMBER HOUR/DAY/WEEK/MONTH. <br>
     *         Example: /ban player Being incredibly stupid 5 HOURS If you
     *         put nothing as time unit, it will evaluate as HOURS!
     */
    public void issueBan(PlayerReference player, String reason, String time) {
        long timeToAdd;

        try {
            timeToAdd = parseTimeSpec(time);
        }
        catch (NumberFormatException e) {
            log.warn("Invalid time for temp ban specified(" + time + "). Skipping!");
            return;
        }
        Ban ban = new Ban(player, reason, ToolBox.getUnixTimestamp() + timeToAdd, false);

        bans.add(ban);
        backbone.addBan(ban);
    }

    /**
     * Ban player by IP
     *
     * @param player
     *         the {@link PlayerReference} who's IP is being banned
     * @param reason
     *         the reason for the ban
     */
    public void issueIpBan(PlayerReference player, String reason) {
        Ban ban = new Ban(player, reason, true);

        bans.add(ban);
        backbone.addBan(ban);
    }

    /**
     * Issue an IP Ban with the given amount of time
     *
     * @param player
     *         the {@link PlayerReference} who's IP is being banned
     * @param reason
     *         the reason for the ban
     * @param time
     *         The time component must be NUMBER HOUR/DAY/WEEK/MONTH. <br>
     *         Example: /ban player Being incredibly stupid 5 HOURS If you
     *         put nothing as time unit, it will evaluate as HOURS!
     */
    public void issueIpBan(PlayerReference player, String reason, String time) {
        long timeToAdd = 0L;

        try {
            timeToAdd = parseTimeSpec(time);
        }
        catch (NumberFormatException e) {
            log.warn("Invalid time for temp ban specified. Skipping!");
        }
        Ban ban = new Ban(player, reason, ToolBox.getUnixTimestamp() + timeToAdd, true);

        bans.add(ban);
        backbone.addBan(ban);
    }

    public void issueIpBan(PlayerReference player, String reason, long bantime) {

        Ban ban = new Ban(player, reason, ToolBox.getUnixTimestamp() + bantime, false);

        bans.add(ban);
        backbone.addBan(ban);
    }

    /**
     * Check if banned and unban if ban has expired. Returns true if still
     * banned, false otherwise. THIS WILL ALSO WORK FOR IP!
     *
     * @param subject
     *         the uuid/ip of the subject who was banned
     *
     * @return {@code true} if banned; {@code false} if not
     */
    public boolean isBanned(String subject) {
        Ban test = null;

        for (Ban b : bans) {
            if (b.getUUID().equals(subject)) {
                test = b;
                break;
            }
            else if (b.getIp().equals(subject)) {
                test = b;
                break;
            }
        }
        if (test == null) {
            return false;
        }
        else if (test.isExpired()) {
            if (test.isIpBan()) {
                backbone.liftIpBan(test.getIp());
            }
            else {
                backbone.liftBan(test.getUUID());
            }
            bans.remove(test);
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Check if the given IP is banned
     *
     * @param ip
     *         the IP address
     *
     * @return {@code true} if banned; {@code false} if not
     */
    public boolean isIpBanned(String ip) {
        for (Ban b : bans) {
            if (b.getIp().equals(ip)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a {@link Ban} for a given player's name
     *
     * @param player
     *         the name of the player
     *
     * @return the Ban if exists; {@code null} otherwise
     */
    public Ban getBanFromName(String player) {
        for (Ban b : bans) {
            if (b.getSubject().equalsIgnoreCase(player)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Gets a {@link Ban} for a given player's uuid
     *
     * @param uuid
     *         the uuid of the player
     *
     * @return the Ban if exists; {@code null} otherwise
     */
    public Ban getBan(String uuid) {
        for (Ban b : bans) {
            if (b.getUUID().equalsIgnoreCase(uuid)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Unban a subject, player or ip
     *
     * @param subject
     *         the uuid/ip of the subject
     */
    public void unban(String subject) {
        Ban test = null;

        for (Ban b : bans) {
            if (b.getUUID().equals(subject)) {
                test = b;
                break;
            }
            else if (b.getIp().equals(subject)) {
                test = b;
                break;
            }
        }
        if (test == null) {
            return;
        }
        if (test.isIpBan()) {
            backbone.liftIpBan(test.getIp());
        }
        else {
            backbone.liftBan(test.getUUID());
        }
        bans.remove(test);
    }

    /**
     * Unban this player (this will NOT work with IPBans!)
     *
     * @param player
     *         the {@link PlayerReference} to unban
     */
    public void unban(PlayerReference player) {
        Ban test = null;

        for (Ban b : bans) {
            if (!b.isIpBan()) {
                if (b.getUUID().equals(player.getUUID())) {
                    test = b;
                    break;
                }
            }
        }
        if (test == null) {
            return;
        }
        backbone.liftBan(test.getUUID());
        bans.remove(test);
    }

    /**
     * Get all bans
     *
     * @return an Array of {@link Ban}(s)
     */
    public Ban[] getAllBans() {
        Ban[] retT = {};

        return bans.toArray(retT);
    }

    /**
     * Get all bans of a certain BanType
     *
     * @param banType The BanType the ban will be sorted by
     *
     * @return an Array of {@link Ban}(s)
     */
    public Ban[] getAllBans(BanType banType) {
        List<Ban> typeBans = new ArrayList<Ban>();

        for (Ban b : bans) {
            if (b.getBanType() == banType) {
                typeBans.add(b);
            }
        }

        Ban[] retT = {};
        return typeBans.toArray(retT);
    }

    /**
     * Take a string and parse an amount of seconds. A String should be
     * formatted like this: number hours|days|months Ex: 1 month and it will
     * return the amount of seconds that contain one month
     *
     * @param ts
     *         timestring
     *
     * @return long amount of seconds
     */
    private long parseTimeSpec(String ts) throws NumberFormatException {
        String[] split = ts.split(" ");

        if (split.length < 2) {
            return -1;
        }
        long seconds = Integer.parseInt(split[0]);

        if (split[1].toLowerCase().startsWith("hour")) {
            seconds *= 3600;
        }
        else if (split[1].toLowerCase().startsWith("day")) {
            seconds *= 86400;
        }
        else if (split[1].toLowerCase().startsWith("week")) {
            seconds *= 604800;
        }
        else if (split[1].toLowerCase().startsWith("month")) {
            seconds *= 2629743;
        }
        return seconds;
    }

    /**
     * Reloads the bans from datasource
     */
    public void reload() {
        bans.clear();
        bans = backbone.loadBans();
    }
}
