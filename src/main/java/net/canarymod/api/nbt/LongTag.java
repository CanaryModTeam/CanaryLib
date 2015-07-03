package net.canarymod.api.nbt;

/**
 * An NBT tag that stores a long.
 *
 * @author gregthegeek
 */
public interface LongTag extends PrimitiveTag<LongTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the long value
     */
    long getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the long value
     */
    void setValue(long value);
}
