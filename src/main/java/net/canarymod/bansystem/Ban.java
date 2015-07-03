package net.canarymod.bansystem;

import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.backbone.BackboneBans;

/**
 * Contains information regarding a ban
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public class Ban {
    private String uuid, subject, reason, moderator, ip = "xxx.xxx.xxx.xxx";
    private BanType banType = BanType.UUID;
    private long issued = ToolBox.getUnixTimestamp(), expiration = -1;

    /**
     * Create a default ban object.
     * It's highly recommended to override the values before saving to db
     */
    public Ban() {
        this.uuid = "f84c6a790a4e45e0879bcd49ebd4c4e2";
        this.subject = "John Doe";
        this.reason = "Impersonating fictive characters";
    }

    public Ban(PlayerReference player, String reason, boolean ipBan) {
        this(player, reason, -1, ipBan);
    }

    public Ban(PlayerReference player, String reason, long expiration, boolean ipBan) {
        this(player, reason, expiration, ipBan ? BanType.IP : BanType.UUID);
    }

    public Ban(PlayerReference player, String reason, BanType banType) {
        this(player, reason, -1, banType);
    }

    public Ban(PlayerReference player, String reason, long expiration, BanType banType) {
        this.uuid = player.getUUIDString();
        this.subject = player.getName();
        this.reason = reason;
        this.expiration = expiration;

        if(banType == BanType.IP) {
            this.ip = player.getIP();
            this.banType = BanType.IP;
        }
    }

    /**
     * Get the banned subject (usually a player name)
     *
     * @return subject name
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the banned Subject (usually a player name)
     *
     * @param subject
     *         the subject's name
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * If this is an IP ban, you can get the IP address here
     *
     * @return the ip address or null if this is not an ip ban
     */
    public String getIp() {
        return ip;
    }

    /**
     * If this is an IP Ban, set the IP address
     *
     * @param ip
     *         the ip address
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Get the banning reasons. It defaults to the funny reason of
     * "Impersonating fictive characters"
     *
     * @return the ban reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Set the ban reason
     *
     * @param reason
     *         the ban reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Get the UNIX timestamp of when this ban will expire. You can use that
     * with a date formatter if you need to.
     *
     * @return UNIX timestamp
     *
     * @deprecated Use {@link Ban#getExpiration} instead
     */
    @Deprecated
    public long getTimestamp() {
        return expiration;
    }

    /**
     * Get the UNIX timestamp of when this ban will expire. You can use that
     * with a date formatter if you need to.
     *
     * @return UNIX timestamp
     */
    public long getExpiration() {
        return expiration;
    }

    /**
     * Set the UNIX timestamp of when this ban will expire
     *
     * @param timestamp
     *         the UNIX timestamp
     */
    @Deprecated
    public void setTimestamp(long timestamp) {
        this.expiration = timestamp;
    }

    /**
     * Set the UNIX timestamp of when this ban will expire
     *
     * @param expiration
     *         the UNIX timestamp
     */
    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    /**
     * Check if this ban has expired
     *
     * @return {@code true} if expired; {@code false} if not
     */
    public boolean isExpired() {
        return expiration != -1 && ToolBox.getUnixTimestamp() >= expiration;
    }

    /**
     * Checks if the Ban is an IP Ban
     *
     * @return {@code true} if IP Ban; {@code false} if not
     */
    public boolean isIpBan() {
        return banType == BanType.IP;
    }

    /**
     * Sets if the Ban is an IP Ban
     *
     * @param isIpBan
     *         {@code true} for IP Ban; {@code false} for not
     */
    public void setIsIpBan(boolean isIpBan) {
        this.banType = isIpBan ? BanType.IP : BanType.UUID;
    }

    /**
     * Checks the ban type
     *
     * @return the correct ban type for this ban
     */
    public BanType getBanType() {
        return banType;
    }

    /**
     * Sets the ban type
     *
     * @param banType the ban type to apply to this ban
     */
    public void setBanType(BanType banType) {
        this.banType = banType;
    }

    /**
     * Gets the moderator who issued the Ban
     *
     * @return the moderator
     */
    public String getBanningPlayer() {
        return moderator;
    }

    /**
     * Sets the moderator who issued the Ban
     *
     * @param banningPlayer
     *         the moderator
     */
    public void setBanningPlayer(String banningPlayer) {
        this.moderator = banningPlayer;
    }

    /**
     * Gets the UUID of the user for this ban.
     *
     * @return UUID of user
     */
    public String getUUID() {
        if (this.uuid == null) {
            this.uuid = ToolBox.usernameToUUID(this.subject);
            new BackboneBans().updateBan(this);
        }
        return this.uuid;
    }

    /**
     * Sets the UUID for the ban on this user
     *
     * @param uuid
     */
    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets the UNIX timestamp of when this ban was issued.
     *
     * @return UNIX timestamp
     */
    public long getIssuedDate() {
        return issued;
    }

    /**
     * Sets the UNIX timestamp of when this ban was issued.
     *
     * @param issued
     *         UNIX timestamp
     */
    public void setIssuedDate(long issued) {
        this.issued = issued;
    }
}
