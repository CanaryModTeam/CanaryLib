package net.canarymod.user;

/**
 * Access to the backbone for whitelist
 *
 * @author Chris (damagefilter)
 */
public interface WhitelistProvider {

    /**
     * Reload the whitelist from database
     */
    void reload();

    /**
     * Check if a given player is whitelisted.
     *
     * @param subject
     *         player name or uuid
     *
     * @return
     */
    boolean isWhitelisted(String subject);

    /**
     * Adds a new whitelist entry
     *
     * @param subject
     *         player name or uuid
     */
    void addPlayer(String subject);

    /**
     * Removes the given player from the whitelist
     *
     * @param subject
     *         player name or uuid
     */
    void removePlayer(String subject);

    /**
     * gets the current size of the whitelist
     *
     * @return
     */
    int getSize();

    String[] getWhitelisted();
}
