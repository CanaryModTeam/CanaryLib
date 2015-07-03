package net.canarymod.api.nbt;

/**
 * An NBT tag that stores a float.
 *
 * @author gregthegeek
 */
public interface FloatTag extends PrimitiveTag<FloatTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the float value
     */
    float getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the float value
     */
    void setValue(float value);
}
