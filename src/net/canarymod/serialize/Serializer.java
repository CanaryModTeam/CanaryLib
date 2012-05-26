package net.canarymod.serialize;

import net.canarymod.CanaryDeserializeException;

/**
 * Generic serializer interface
 * @author Chris Ksoll
 *
 */
public interface Serializer {
    
    /**
     * Deserialize a String into a new Object
     * @param data
     * @return
     * @throws CanaryDeserializeException
     */
    public Object deserialize(String data) throws CanaryDeserializeException;
    
    /**
     * Serialize object into a String that can be saved
     * to database or put into memory for laters usage
     * @param object
     * @return
     */
    public String serialize(Object object);
    
    /**
     * Returns the creator of this serializer.
     * This might be a Plugin, in most cases it will probably the CanaryMod
     * @return
     */
    public String getVendor();
}
