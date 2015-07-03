package net.canarymod.api.nbt;

/**
 * An NBT tag that stores a byte.
 *
 * @author gregthegeek
 */
public interface ByteTag extends PrimitiveTag<ByteTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the byte value
     */
    byte getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the byte value
     */
    void setValue(byte value);
}
