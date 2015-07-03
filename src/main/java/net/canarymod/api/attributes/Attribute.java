package net.canarymod.api.attributes;

/**
 * @author Jason (darkdiplomat)
 */
public interface Attribute {

    /**
     * Gets the unlocalized internal name
     *
     * @return internal name
     */
    String getInternalName();

    /**
     * Gets the default value of the Attribute
     *
     * @return default value
     */
    double getDefaultValue();

    /**
     * Gets whether this Attribute should be watched
     *
     * @return {@code true} if watched
     */
    boolean shouldWatch();

    /**
     * Sets whether this attribute should be watched
     *
     * @param watch
     *         {@code true} for watched
     *
     * @return {@code this} instance
     */
    Attribute setShouldWatch(boolean watch);
}
