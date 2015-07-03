package net.canarymod.warp;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.backbone.BackboneWarps;

import java.util.Collections;
import java.util.List;

/**
 * Access to the backbone for the whitelist
 *
 * @author Chris (damagefilter)
 */
public class WarpProvider {
    private List<Warp> warps;
    private BackboneWarps backbone;

    public WarpProvider() {
        backbone = new BackboneWarps();
        warps = backbone.loadWarps();
    }

    /**
     * Add new warp
     *
     * @param warp
     */
    public void addWarp(Warp warp) {
        Warp test = getWarp(warp.getName());

        if (test != null) {
            warps.remove(test);
        }
        backbone.addWarp(warp);
        warps.add(warp);
    }

    /**
     * Remove a warp
     *
     * @param warp
     */
    public void removeWarp(Warp warp) {
        backbone.removeWarp(warp);
        warps.remove(warp);
    }

    /**
     * Set home for player, this updates a player home if there already is one
     *
     * @param player
     */
    public void setHome(Player player, Location location) {
        Warp warp = getHome(player);

        if (warp != null) {
            if (!ToolBox.isUUID(warp.getOwner())) {
                Canary.log.info("Replacing legacy Home for User: " + player.getName() + " (Original: " + warp.toString() + ")");
                removeWarp(warp);
                warp = new Warp(location, "HOME_" + player.getUUIDString(), player.getUUIDString(), true);
                warps.add(warp);
                backbone.addWarp(warp);
            }
            else {
                warp.setLocation(location);
                backbone.updateWarp(warp);
            }
        }
        else {
            Warp newWarp = new Warp(location, "HOME_" + player.getUUIDString(), player.getUUIDString(), true);
            warps.add(newWarp);
            backbone.addWarp(newWarp);
        }
    }

    /**
     * Returns warp that has the given name or null if not exists
     *
     * @param name
     *
     * @return
     */
    public Warp getWarp(String name) {
        for (Warp warp : warps) {
            if (warp.getName().equals(name)) {
                if (!warp.isPlayerHome()) {
                    return warp;
                }
            }
        }
        return null;
    }

    /**
     * Returns this players home
     *
     * @param player
     *
     * @return
     */
    public Warp getHome(Player player) {
        Warp home = getHome(player.getUUIDString());
        if (home == null) {
            home = getHome(player.getName());
            if (home != null) {
                Canary.log.info("Replacing legacy Home for User: " + player.getName() + " (Original: " + home.toString() + ")");
                Location original = home.getLocation();
                removeWarp(home);
                home = new Warp(original, "HOME_" + player.getUUIDString(), player.getUUIDString(), true);
                addWarp(home);
            }
        }
        return home;
    }

    /**
     * Return home for a player with this name
     *
     * @param identity
     *
     * @return
     */
    public Warp getHome(String identity) {
        for (Warp warp : warps) {
            if (warp.isPlayerHome()) {
                if (warp.getOwner().equals(identity)) {
                    return warp;
                }
            }
        }
        return null;
    }

    /**
     * Return a non-modifiable list of all available warps
     *
     * @return
     */
    public List<Warp> getAllWarps() {
        return Collections.unmodifiableList(warps);
    }

    public boolean warpExists(String name) {
        for (Warp w : warps) {
            if (w.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void reload() {
        warps.clear();
        warps = backbone.loadWarps();
    }
}
