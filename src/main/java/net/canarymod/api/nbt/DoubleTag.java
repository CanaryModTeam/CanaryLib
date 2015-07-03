package net.canarymod.api.nbt;

/**
 * An NBT tag that stores a double.
 *
 * @author gregthegeek
 */
public interface DoubleTag extends PrimitiveTag<DoubleTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the double value
     */
    double getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the double value
     */
    void setValue(double value);
}
