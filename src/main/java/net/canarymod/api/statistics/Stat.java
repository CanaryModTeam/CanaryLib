package net.canarymod.api.statistics;

/**
 * Stat wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Stat {

    /**
     * Get the id of this stat.
     *
     * @return the Stat ID
     */
    String getId();

    /**
     * Gets the name of the stat.
     * NOTE: This has gone through Minecraft's string translate to get a readable form
     *
     * @return the name of the Stat
     */
    String getName();

    /**
     * Return is this stat is independent (i.e., lacking prerequisites for being updated)
     *
     * @return {@code true} if independent; {@code false} if not
     */
    boolean isIndependent();
}
