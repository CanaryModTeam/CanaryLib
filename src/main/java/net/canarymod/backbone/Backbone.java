package net.canarymod.backbone;

/**
 * The backbone system.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public class Backbone {

    private System system;

    public Backbone(System system) {
        this.system = system;
    }

    public enum System {
        BANS,
        GROUPS,
        WARPS,
        KITS,
        PERMISSIONS,
        USERS,
        WHITELIST,
        OPERATORS,
        RESERVELIST;
    }

    /**
     * Get the System of this backbone
     *
     * @return The System instance.
     */
    public System getSystem() {
        return system;
    }
}
