package net.canarymod.api.nbt;

/**
 * An NBT tag that stores a short.
 *
 * @author gregthegeek
 */
public interface ShortTag extends PrimitiveTag<ShortTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the short value
     */
    short getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the short value
     */
    void setValue(short value);
}
