package net.canarymod.api.nbt;

/**
 * An NBT tag that stores an array of integers.
 *
 * @author gregthegeek
 */
public interface IntArrayTag extends BaseTag<IntArrayTag> {

    /**
     * Returns the value associated with this tag.
     *
     * @return the int array value
     */
    int[] getValue();

    /**
     * Sets the value associated with this tag.
     *
     * @param value
     *         the int array value
     */
    void setValue(int[] value);
}
