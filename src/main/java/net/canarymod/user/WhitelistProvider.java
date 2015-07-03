package net.canarymod.user;

import net.canarymod.ToolBox;
import net.canarymod.backbone.BackboneWhitelist;

import java.util.List;

/**
 * Access to the backbone for whitelist
 *
 * @author Chris (damagefilter)
 */
public class WhitelistProvider {
    private BackboneWhitelist backboneWhitelist;
    private List<String> whitelist;

    public WhitelistProvider() {
        backboneWhitelist = new BackboneWhitelist();
        whitelist = backboneWhitelist.loadWhitelist();
    }

    /**
     * Reload the whitelist from database
     */
    public void reload() {
        whitelist = backboneWhitelist.loadWhitelist();
    }

    /**
     * Check if a given player is whitelisted.
     *
     * @param subject
     *         player name or uuid
     *
     * @return
     */
    public boolean isWhitelisted(String subject) {
        String uuid = subject;
        if (!ToolBox.isUUID(uuid)) {
            uuid = ToolBox.usernameToUUID(uuid);
        }
        return whitelist.contains(uuid);
    }

    /**
     * Adds a new whitelist entry
     *
     * @param subject
     *         player name or uuid
     */
    public void addPlayer(String subject) {
        String uuid = subject;
        if (!ToolBox.isUUID(uuid)) {
            uuid = ToolBox.usernameToUUID(uuid);
        }
        if (!whitelist.contains(uuid)) {
            whitelist.add(uuid);
            backboneWhitelist.addWhitelistEntry(uuid);
        }
    }

    /**
     * Removes the given player from the whitelist
     *
     * @param subject
     *         player name or uuid
     */
    public void removePlayer(String subject) {
        String uuid = subject;
        if (!ToolBox.isUUID(uuid)) {
            uuid = ToolBox.usernameToUUID(uuid);
        }
        if (whitelist.contains(uuid)) {
            whitelist.remove(uuid);
            backboneWhitelist.removeWhitelistEntry(uuid);
        }
    }

    /**
     * gets the current size of the whitelist
     *
     * @return
     */
    public int getSize() {
        return whitelist.size();
    }

    public String[] getWhitelisted() {
        return whitelist.toArray(new String[getSize()]);
    }
}
