package net.canarymod.channels;

import net.canarymod.api.entity.living.humanoid.Player;

/**
 * @author Somners
 */
public abstract class ChannelListener {

    /**
     * Receives the input from Packet250CustomPayload on the registered channels.
     *
     * @param channel
     *         The name of the channel.
     * @param player
     *         The client who sent this byte stream.
     * @param byteStream
     *         The data send by the client.
     */
    public abstract void onChannelInput(String channel, Player player, byte[] byteStream);
}
