package net.canarymod.api.nbt;

/**
 * An NBT tag that stores an array of bytes.
 *
 * @author gregthegeek
 */
public interface ByteArrayTag extends BaseTag<ByteArrayTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the byte array value
     */
    byte[] getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the byte array value
     */
    void setValue(byte[] value);
}
