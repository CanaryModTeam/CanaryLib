package net.canarymod.api.nbt;

/**
 * @author Jason (darkdiplomat)
 */
public interface PrimitiveTag<T> extends BaseTag<T> {

    long getLongValue();

    int getIntValue();

    short getShortValue();

    byte getByteValue();

    double getDoubleValue();

    float getFloatValue();
}
