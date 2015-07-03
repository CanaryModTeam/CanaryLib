package net.canarymod.api;

import net.canarymod.api.inventory.EnderChestInventory;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.PlayerInventory;
import net.canarymod.api.statistics.Achievement;
import net.canarymod.api.statistics.Achievements;
import net.canarymod.api.statistics.Stat;
import net.canarymod.api.statistics.Statistics;
import net.canarymod.api.world.World;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Position;
import net.canarymod.permissionsystem.PermissionProvider;
import net.canarymod.user.Group;

import java.util.UUID;

/**
 * The reference that brings {@link net.canarymod.api.OfflinePlayer} and {@link net.canarymod.api.entity.living.humanoid.Player} together
 *
 * @author Jason (darkdiplomat)
 */
public interface PlayerReference {

    /**
     * Get the permission provider that is responsible for the player
     *
     * @return PermissionProvider
     */
    PermissionProvider getPermissionProvider();

    /**
     * Get this players main group
     *
     * @return {@link Group}
     */
    Group getGroup();

    /**
     * get this players prefix
     *
     * @return {@link String}
     */
    String getPrefix();

    /**
     * Check if there is an online player for this offline player
     *
     * @return {@code true} if online; {@code false} otherwise
     */
    boolean isOnline();

    /**
     * Check if this player has the given permission
     *
     * @param path
     *         the permission path
     *
     * @return {@code true} if has permission; {@code false} otherwise
     */
    boolean hasPermission(String path);

    /**
     * Set this players group
     *
     * @param group
     *         the {@link net.canarymod.user.Group} to set
     */
    void setGroup(Group group);

    /**
     * Add a group to this players sub groups
     *
     * @param group
     *         the {@link Group} to add
     */
    void addGroup(Group group);

    /**
     * Remove this group from the player.<br>
     * You can NOT delete the default group.
     *
     * @param g
     *         the {@link Group} to remove
     *
     * @return {@code true} if successful; {@code false} otherwise
     */
    boolean removeGroup(Group g);

    /**
     * Remove a group with this name from the player.<br>
     * You can NOT delete the default group.
     *
     * @param g
     *         the name of the {@link Group} to remove
     *
     * @return {@code true} if successful; {@code false} otherwise
     */
    boolean removeGroup(String g);

    /**
     * Check if player is in the given group
     *
     * @param group
     *         the {@link Group} to check
     * @param parents
     *         {@code true} if you want to take parent groups into account; {@code false} otherwise
     *
     * @return {@code true} if the player is in the group, {@code false} otherwise
     */
    boolean isInGroup(Group group, boolean parents);

    /**
     * Check if player is in the given group
     *
     * @param group
     *         the name of the group to check
     * @param parents
     *         {@code true} if you want to take parent groups into account; {@code false} otherwise
     *
     * @return {@code true} if the player is in the group; {@code false} otherwise
     */
    boolean isInGroup(String group, boolean parents);

    /**
     * Set this players prefix
     *
     * @param prefix
     *         the prefix to be set
     */
    void setPrefix(String prefix);

    /**
     * get the world the player logged off in
     *
     * @return {@link net.canarymod.api.world.World}
     */
    World getWorld();

    /**
     * get the position the player logged off at
     *
     * @return {@link net.canarymod.api.world.position.Position}
     */
    Position getPosition();

    /**
     * Get this offline players name
     *
     * @return name
     */
    String getName();

    /**
     * Get the UUID of this Player
     *
     * @return UUID
     */
    UUID getUUID();

    /**
     * Gets the UUID of this Player as a string
     *
     * @return UUID as string
     */
    String getUUIDString();

    /**
     * Check if this player is muted
     *
     * @return {@code true} if muted; {@code false} otherwise
     */
    boolean isMuted();

    /**
     * Mute or unmute this offline player
     *
     * @param muted
     *         {@code true} to mute; {@code false} to unmute
     */
    void setMuted(boolean muted);

    /**
     * Get all of this players groups
     *
     * @return Group array
     */
    Group[] getPlayerGroups();

    /**
     * Gets the date and time the Player first joined (or when the player.dat was created) formatted as dd-MMM-yyyy HH:mm:ss
     *
     * @return first joined
     */
    String getFirstJoined();

    /**
     * Gets the time played in seconds
     *
     * @return time played
     */
    long getTimePlayed();

    /**
     * Gets the {@link GameMode} for the Player
     *
     * @return the Player's {@link GameMode}
     */
    GameMode getMode();

    /**
     * Gets the {@link GameMode} ID for the Player
     *
     * @return 0 for Survival; 1 for Creative; 2 for Adventure
     */
    int getModeId();

    /**
     * Sets the Player's {@link GameMode}
     *
     * @param mode
     *         the {@link GameMode} to set
     */
    void setMode(GameMode mode);

    /**
     * Sets the Player's {@link GameMode}
     *
     * @param mode
     *         0 for Survival; 1 for Creative; 2 for Adventure
     */
    void setModeId(int mode);

    /**
     * Checks if this player is a Server Operator
     *
     * @return {@code true} if is op; {@code false} otherwise
     */
    boolean isOperator();

    /**
     * Check if this player has the admin flag set
     *
     * @return {@code true} if is Admin; {@code false} otherwise
     */
    boolean isAdmin();

    /**
     * Check if this player can modify the world
     *
     * @return {@code true} if can Build; {@code false} otherwise
     */
    boolean canBuild();

    /**
     * Set whether this player can modify the world
     *
     * @param canModify
     *         {@code true} if can build; {@code false} if not
     */
    void setCanBuild(boolean canModify);

    /**
     * Check if this player can bypass permission checks
     *
     * @return {@code true} if can ignore restrictions; {@code false} otherwise
     */
    boolean canIgnoreRestrictions();

    /**
     * Set whether this player can bypass permission checks
     *
     * @param canIgnore
     *         {@code true} if can ignore restrictions; {@code false} if not
     */
    void setCanIgnoreRestrictions(boolean canIgnore);

    /**
     * Add to the level of food exhaustion of a player
     *
     * @param exhaustion
     *         the exhaustion to add
     */
    void addExhaustion(float exhaustion);

    /**
     * Set the food exhaustion level to the specified value
     *
     * @param exhaustion
     *         the exhaustion to set
     */
    void setExhaustion(float exhaustion);

    /**
     * Retrieve the current exhaustion level for this player
     *
     * @return exhaustion level
     */
    float getExhaustionLevel();

    /**
     * Add to the level of food saturation of a player
     *
     * @param saturation
     *         the saturation to add
     */
    void addSaturation(float saturation);

    /**
     * Set the food saturation level to the specified value
     *
     * @param saturation
     *         the saturation to set
     */
    void setSaturation(float saturation);

    /**
     * Retrieve the current food saturation level for this player
     *
     * @return saturation level
     */
    float getSaturationLevel();

    /**
     * Set this players food level
     *
     * @param hunger
     *         the hunger to set
     */
    void setHunger(int hunger);

    /**
     * Get this players food level
     *
     * @return the food level.
     */
    int getHunger();

    /**
     * Add experience to the player
     *
     * @param experience
     *         the experience amount
     */
    void addExperience(int experience);

    /**
     * Remove experience from the player
     *
     * @param experience
     *         the experience amount
     */
    void removeExperience(int experience);

    /**
     * Get experience points for this player
     *
     * @return experience
     */
    int getExperience();

    /**
     * Set the experience of this player
     *
     * @param xp
     *         the experience amount
     */
    void setExperience(int xp);

    /**
     * Get the current level of this player.
     *
     * @return level
     */
    int getLevel();

    /**
     * Explicitly override this players level.
     *
     * @param level
     *         the new player level
     */
    void setLevel(int level);

    /**
     * Add the specific amount of levels to the player.
     *
     * @param level
     *         amount of levels to add
     */
    void addLevel(int level);

    /**
     * Explicitly remove the amount of levels from the player.
     *
     * @param level
     *         amount of levels to remove
     */
    void removeLevel(int level);

    /**
     * Set this players home location
     *
     * @param loc
     *         The new home location.
     */
    void setHome(Location loc);

    /**
     * Get this players home location
     *
     * @return home {@link Location}
     */
    Location getHome();

    /**
     * Check if this player has a home location set
     *
     * @return {@code true} if home is set; {@code false} if not
     */
    boolean hasHome();

    /**
     * Returns all allowed IPs for this player as Array
     *
     * @return allowed ips
     */
    String[] getAllowedIPs();

    /**
     * Get the IP for this player (or last known IP)
     *
     * @return ip address
     */
    String getIP();

    /**
     * Gets the timestamp of the last time the player was online
     *
     * @return last seen timestamp
     */
    String getLastJoined();

    /**
     * Get this player's health.
     *
     * @return health
     */
    float getHealth();

    /**
     * Set this player's health.
     *
     * @param health
     *         the health to be set
     */
    void setHealth(float health);

    /**
     * Increase this player's health. This does not set but add the amount of
     * health
     *
     * @param health
     *         to increase the health with (negative values decrease)
     */
    void increaseHealth(float health);

    /**
     * Sets the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Stat} to set value of
     * @param value
     *         the value to be set
     */
    void setStat(Stat stat, int value);

    /**
     * Sets the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Statistics} to set value of
     * @param value
     *         the value to be set
     */
    void setStat(Statistics stat, int value);

    /**
     * Increases the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Stat} to increase value of
     * @param value
     *         the amount to increase
     */
    void increaseStat(Stat stat, int value);

    /**
     * Increases the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Statistics} to increase value of
     * @param value
     *         the amount to increase
     */
    void increaseStat(Statistics stat, int value);

    /**
     * Decrease the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Stat} to decrease value of
     * @param value
     *         the amount to decrease
     */
    void decreaseStat(Stat stat, int value);

    /**
     * Decrease the value of a given {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Statistics} to decrease value of
     * @param value
     *         the amount to decrease
     */
    void decreaseStat(Statistics stat, int value);

    /**
     * Gets the value of a {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Stat} to get value of
     *
     * @return stat value
     */
    int getStat(Stat stat);

    /**
     * Gets the value of a {@link net.canarymod.api.statistics.Stat}
     *
     * @param stat
     *         the {@link net.canarymod.api.statistics.Statistics} to get value of
     *
     * @return stat value
     */
    int getStat(Statistics stat);

    /**
     * Checks if the {@link net.canarymod.api.statistics.Achievement} has been awarded
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievement} to check
     *
     * @return {@code true} if has achievement; {@code false} if not
     */
    boolean hasAchievement(Achievement achievement);

    /**
     * Checks if the {@link net.canarymod.api.statistics.Achievement} has been awarded
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievements} to check
     *
     * @return {@code true} if has achievement; {@code false} if not
     */
    boolean hasAchievement(Achievements achievement);

    /**
     * Removes an awarded {@link net.canarymod.api.statistics.Achievement} and any child achievements
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievement} to be removed
     */
    void removeAchievement(Achievement achievement);

    /**
     * Removes an awarded {@link net.canarymod.api.statistics.Achievement} and any child achievements
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievements} to be removed
     */
    void removeAchievement(Achievements achievement);

    /**
     * Awards an {@link net.canarymod.api.statistics.Achievement} and any parent achievements requried
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievement} to be awarded
     */
    void awardAchievement(Achievement achievement);

    /**
     * Awards an {@link net.canarymod.api.statistics.Achievement} and any parent achievements requried
     *
     * @param achievement
     *         the {@link net.canarymod.api.statistics.Achievements} to be awarded
     */
    void awardAchievement(Achievements achievement);

    /**
     * Get player inventory
     *
     * @return inventory
     */
    PlayerInventory getInventory();

    /**
     * Get player enderchest inventory.
     * NOTE: An offline player will throw an exception with {@link EnderChestInventory#getInventoryOwner()} due to null reference.
     *
     * @return enderchest inventory
     */
    Inventory getEnderChestInventory();
}
