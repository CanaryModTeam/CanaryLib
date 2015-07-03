package net.canarymod.hook.system;

import net.canarymod.hook.Hook;

/**
 * Called in the servers tick loop, before world processing.
 * For informational use
 *
 * @author Chris (damagefilter)
 */
public final class ServerTickHook extends Hook {
    private long deltaTime;

    public ServerTickHook(long deltaTime) {
        this.deltaTime = deltaTime;
    }

    /**
     * @return the deltaTime
     */
    public long getDeltaTime() {
        return deltaTime;
    }

    /**
     * @param deltaTime
     *         the deltaTime to set
     */
    public void setDeltaTime(long deltaTime) {
        this.deltaTime = deltaTime;
    }

    @Override
    public final String toString() {
        return String.format("%s[DeltaTime=%d]", getHookName(), deltaTime);
    }
}
