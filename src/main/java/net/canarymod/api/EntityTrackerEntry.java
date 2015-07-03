package net.canarymod.api;

import net.canarymod.api.entity.Entity;

/**
 * EntityTrackerEntry to handle entries in entity trackers
 * Perhaps we need some more at some point, then we can have it here
 *
 * @author Chris (damagefilter)
 */
public interface EntityTrackerEntry {

    /**
     * Gets the {@link Entity}
     *
     * @return the {@link Entity}
     */
    Entity getEntity();
}
