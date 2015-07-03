package net.canarymod.api.packet;

/**
 * Packet interface.
 * This interface is not automatically applied to packets,
 * for performance reason packets should be wrapped on demand only!
 *
 * @author Chris (damagefilter)
 */
public interface Packet {

    /**
     * Get the packet size
     *
     * @return the packet's size
     */
    int getPacketSize();

    /**
     * Returns the ID for this packet.<br>
     * For example the Id of packet3Chat is 3
     *
     * @return the packet's id
     */
    int getPacketId();
}
