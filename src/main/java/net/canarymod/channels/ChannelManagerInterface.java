package net.canarymod.channels;

import net.canarymod.api.NetServerHandler;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.plugin.Plugin;

/**
 * @author Somners
 */
public interface ChannelManagerInterface {

    /**
     * Registers the client to the specified channel. Cannot be 'REGISTER',
     * 'UNREGISTER', or ''. The Channel used to register these clients are 'REGISTER'
     * and the Channel used to unregister these clients are 'UNREGISTER'.
     *
     * @param channel
     *         the name of the channel to register the client to.
     * @param handler
     *         the NetServerHandler for the client registering this channel.
     */
    void registerClient(String channel, NetServerHandler handler);

    /**
     * Register a plugins ChannelListener.<br>
     * NOTE: the channel cannot be 'REGISTER', 'UNREGISTER', or ''.
     *
     * @param plugin
     *         the plugin registering.
     * @param channel
     *         the channel being registered
     * @param listener
     *         the listener being registered.
     */
    void registerListener(Plugin plugin, String channel, ChannelListener listener);

    /**
     * Send a Custom Payload packet to all players listening on the given channel.
     *
     * @param channel
     *         the channel to send messages on.
     * @param bytestream
     *         the message to be sent.
     *
     * @return true if any packets were sent, false otherwise.
     */
    boolean sendCustomPayloadToAllPlayers(String channel, byte[] bytestream);

    /**
     * Send an input Custom Payload packet to the listeners listening on the given channel.
     *
     * @param channel
     *         the channel the Custom Payload was sent on.
     * @param byteStream
     *         the message being sent.
     * @param player
     *         the player who sent the Custom Payload.
     */
    void sendCustomPayloadToListeners(String channel, byte[] byteStream, Player player);

    /**
     * Send a Custom Payload packet to the given player listening on the given channel.
     *
     * @param channel
     *         the channel to send messages on.
     * @param bytestream
     *         the message to be sent.
     * @param player
     *         the player to send the Custom Payload to.
     *
     * @return true if any packets were sent, false otherwise.
     */
    boolean sendCustomPayloadToPlayer(String channel, byte[] bytestream, Player player);

    /**
     * Unregisters a client from a Custom Payload Channel.
     *
     * @param channel
     *         The channel the client is listening on.
     * @param handler
     *         The NetServerHandler for the client.
     *
     * @return true if the client was unregistered, false otherwise.
     */
    boolean unregisterClient(String channel, NetServerHandler handler);

    /**
     * Unregisters the client from all channels it is registered on.
     *
     * @param handler
     *         The NetServerHandler for this client.
     *
     * @return true if it was unregistered, false otherwise.
     */
    boolean unregisterClientAll(NetServerHandler handler);

    /**
     * Unregisters all listeners for this plugin.
     *
     * @param plugin
     *         The plugin to remove all lisiteners for.
     *
     * @return True if any channels were unregistered, false otherwise.
     */
    boolean unregisterListeners(Plugin plugin);
}
