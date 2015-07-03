package net.canarymod.api;

/**
 * DataWatcher interface to manipulate data within Native Minecraft Sources.
 * This might as well be used as Stand-Alone datawatcher implementation
 * along with the wrapper.
 *
 * @author Chris (damagefilter)
 */
public interface DataWatcher {

    /**
     * Add a new {@link Object} to watch and file
     *
     * @param index
     *         the index to add the {@link Object} at
     * @param object
     *         the {@link Object} to be added
     */
    void addObject(int index, Object object);

    /**
     * Update the value of an already existing {@link Object}
     *
     * @param index
     *         the index of the {@link Object}
     * @param object
     *         the {@link Object} to update
     */
    void updateObject(int index, Object object);

    /**
     * Gets a {@code byte} value of a watchable {@link Object} at the specified index
     *
     * @param index
     *         the index to get from
     *
     * @return the {@code byte} value
     */
    byte getByte(int index);

    /**
     * Gets a {@code short} value of a watchable {@link Object} at the specified index
     *
     * @param index
     *         the index to get from
     *
     * @return the {@code short} value
     */
    short getShort(int index);

    /**
     * Gets a {@code int} value of a watchable {@link Object} at the specified index
     *
     * @param index
     *         the index to get from
     *
     * @return the {@code int} value
     */
    int getInt(int index);

    /**
     * Gets a {@link String} value of a watchable {@link Object} at the specified index
     *
     * @param index
     *         the index to get from
     *
     * @return the {@link String} value
     */
    String getString(int index);
}
