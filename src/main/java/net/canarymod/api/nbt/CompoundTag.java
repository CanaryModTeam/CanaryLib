package net.canarymod.api.nbt;

import java.util.Collection;
import java.util.Set;

/**
 * An NBT tag that stores a collection of NBT tags associated with strings.
 *
 * @author gregthegeek
 */
public interface CompoundTag extends BaseTag<CompoundTag> {

    /**
     * Gets the values inside the CompoundTag
     *
     * @return {@link Collection} of values
     */
    Collection<BaseTag> values();

    /**
     * Gets the key set of the CompoundTag
     *
     * @return {@link Set} of keys
     */
    Set<String> keySet();

    /**
     * Puts a new Tag inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the {@link BaseTag} value
     */
    void put(String key, BaseTag value);

    /**
     * Puts a byte value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the byte value
     */
    void put(String key, byte value);

    /**
     * Puts a short value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the short value
     */
    void put(String key, short value);

    /**
     * Puts an integer value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the integer value
     */
    void put(String key, int value);

    /**
     * Puts a long value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the long value
     */
    void put(String key, long value);

    /**
     * Puts a float value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the float value
     */
    void put(String key, float value);

    /**
     * Puts a double value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the double value
     */
    void put(String key, double value);

    /**
     * Puts a String value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the String value
     */
    void put(String key, String value);

    /**
     * Puts a byte array value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the byte array value
     */
    void put(String key, byte[] value);

    /**
     * Puts a int array value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the int array value
     */
    void put(String key, int[] value);

    /**
     * Puts a CompoundTag value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the CompoundTag value
     */
    void put(String key, CompoundTag value);

    /**
     * Puts a boolean value inside the CompoundTag
     *
     * @param key
     *         the name of the tag
     * @param value
     *         the boolean value
     */
    void put(String key, boolean value);

    /**
     * Gets a {@link BaseTag} value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the {@link BaseTag}
     */
    BaseTag get(String key);

    /**
     * Checks if the CompoundTag contains the given key
     *
     * @param key
     *         the key to check for
     *
     * @return {@code true} if contains the key; {@code false} if not
     */
    boolean containsKey(String key);

    /**
     * Checks if the CompoundTag contains the given key with a given value type
     *
     * @param key
     *         the key to check for
     * @param type
     *         the {@link net.canarymod.api.nbt.NBTTagType} to check for
     *
     * @return {@code true} if the key is of the given type; {@code false} if not
     */
    boolean containsKey(String key, NBTTagType type);

    /**
     * Gets a byte value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the byte value
     */
    byte getByte(String key);

    /**
     * Gets a short value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the short value
     */
    short getShort(String key);

    /**
     * Gets a integer value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the integer value
     */
    int getInt(String key);

    /**
     * Gets a long value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the long value
     */
    long getLong(String key);

    /**
     * Gets a float value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the float value
     */
    float getFloat(String key);

    /**
     * Gets a double value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the double value
     */
    double getDouble(String key);

    /**
     * Gets a String value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the String value
     */
    String getString(String key);

    /**
     * Gets a byte array value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the byte array value
     */
    byte[] getByteArray(String key);

    /**
     * Gets a int array value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the int array value
     */
    int[] getIntArray(String key);

    /**
     * Gets a CompoundTag value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the CompoundTag value
     */
    CompoundTag getCompoundTag(String key);

    /**
     * Gets a {@link ListTag} value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the {@link ListTag} value
     */
    <E extends BaseTag> ListTag<E> getListTag(String key);

    /**
     * Gets a boolean value from the CompoundTag
     *
     * @param key
     *         the name of the tag
     *
     * @return the boolean value
     */
    boolean getBoolean(String key);

    /**
     * Removes a key from the CompoundTag
     *
     * @param key
     *         the key to remove
     */
    void remove(String key);

    /**
     * Checks if the CompoundTag is empty
     *
     * @return {@code true} if empty; {@code false} if not
     */
    boolean isEmpty();
}
