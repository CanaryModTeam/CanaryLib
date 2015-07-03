package net.canarymod.plugin;

/**
 * The Plugin Priority or "Execution order"
 *
 * @author Chris (damagefilter)
 */
public enum Priority {

    /**
     * For Plugins that monitor actions but do not interfere
     */
    PASSIVE(100),
    /**
     * Low level stuff like process player walking etc.
     */
    LOW(300),
    /**
     * Preferred Priority. This is the usual thing for blocking/altering actions
     */
    NORMAL(500),
    /**
     * Executed after critical.
     */
    HIGH(700),
    /**
     * Extremely critical. Will be executed as the very first Plugin.
     */
    CRITICAL(900);

    final int value;

    Priority(int priority) {
        this.value = priority;
    }

    public int getPriorityValue() {
        return this.value;
    }
}
