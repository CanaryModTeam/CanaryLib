package net.canarymod.api.statistics;

/**
 * Achievement
 *
 * @author Jason (darkdiplomat)
 */
public interface Achievement extends Stat {

    /**
     * Gets the description of the achievement
     *
     * @return achievement description
     */
    String getDescription();

    /**
     * Gets the achievement required to get this achievement
     *
     * @return parent achievement
     */
    Achievement getParent();

    /**
     * Gets whether the achievement is special
     * <p/>
     * Special achievements have a 'spiked' (on normal texture pack) frame, special achievements are the hardest ones to
     * achieve.
     *
     * @return {@code true} if special; {@code false} if not
     */
    boolean isSpecial();
}
