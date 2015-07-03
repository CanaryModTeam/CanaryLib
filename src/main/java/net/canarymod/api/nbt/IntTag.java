package net.canarymod.api.nbt;

/**
 * An NBT tag that stores an integer.
 *
 * @author gregthegeek
 */
public interface IntTag extends PrimitiveTag<IntTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the integer value
     */
    int getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the integer value
     */
    void setValue(int value);
}
