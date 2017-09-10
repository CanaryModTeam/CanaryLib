package net.canarymod.channels;

import static net.canarymod.Canary.log;

import com.google.common.collect.ArrayListMultimap;
import net.canarymod.api.NetServerHandler;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.plugin.Plugin;

import java.util.Iterator;

/**
 * This class manages incoming and outgoing Packet250CustomPayload's. This allows
 * custom communication between the client and server. <br>
 * <br>
 * <b>NOTE:</b><br>
 * - Channel names must be 20 characters long or less.<br>
 * - Byte data can be no larger than 32 kb.<br>
 * - Neither the channel, plugin, listener, player or byte[] can be null in any case.<br>
 * - The channels 'REGISTER' and 'UNREGISTER' are reserved by the server and invalid.<br>
 * - no name or and empty String is an invalid channel name.<br>
 * - To register and unregister the client, send packets with the names 'REGISTER'
 * and 'UNREGISTER' respectively, with a message of the actual channel name to
 * register/unregister.<br>
 *
 * @author Somners
 */
public abstract class ChannelManager implements ChannelManagerInterface {

    protected final ArrayListMultimap<String, RegisteredChannelListener> listeners = ArrayListMultimap.create();
    protected final ArrayListMultimap<String, NetServerHandler> clients = ArrayListMultimap.create();

    protected static boolean isReservedChannel(String channel) {
        return channel.equals("REGISTER") || channel.equals("UNREGISTER");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerListener(Plugin plugin, String channel, ChannelListener listener) {
        try {
            if (plugin == null) {
                throw new CustomPayloadChannelException("Invalid Registered Listener: Plugin is null.");
            }
            if (channel == null || channel.trim().equals("") || isReservedChannel(channel)) {
                throw new CustomPayloadChannelException(String.format("Invalid Registered Listener: Invalid channel name of '%s'", channel));
            }
            if (channel.length() > 20) {
                throw new CustomPayloadChannelException(String.format("Invalid Registered Listener: Channel Name too long '%s'", channel));
            }
            if (listener == null) {
                throw new CustomPayloadChannelException("Invalid Registered Listener: Channel Listener is null.");
            }

            synchronized (listeners) {
                listeners.put(channel, new RegisteredChannelListener(plugin, listener));
            }
        }
        catch (CustomPayloadChannelException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean unregisterListeners(Plugin plugin) {
        boolean toRet = false;
        synchronized (listeners) {
            Iterator<RegisteredChannelListener> itr = listeners.values().iterator();
            while (itr.hasNext()) {
                if (itr.next().getPlugin().equals(plugin)) {
                    itr.remove();
                    toRet = true;
                }
            }
        }
        return toRet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract boolean sendCustomPayloadToAllPlayers(String channel, byte[] bytestream);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract boolean sendCustomPayloadToPlayer(String channel, byte[] bytestream, Player player);

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendCustomPayloadToListeners(String channel, byte[] byteStream, Player player) {
        if (listeners.containsKey(channel)) {
            for (RegisteredChannelListener listener : listeners.get(channel)) {
                listener.getChannelListener().onChannelInput(channel, player, byteStream);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerClient(String channel, NetServerHandler handler) {
        try {
            if (channel == null || channel.trim().equals("") || isReservedChannel(channel)) {
                throw new CustomPayloadChannelException(String.format("Invalid Registered Client: Invalid channel name of '%s'", channel));
            }
            if (channel.length() > 20) {
                throw new CustomPayloadChannelException(String.format("Invalid Registered Client: Channel Name too long '%s'", channel));
            }
            if (handler == null) {
                throw new CustomPayloadChannelException("Invalid Registered Client: NetServerHandler is null.");
            }
            synchronized (clients) {
                clients.put(channel, handler);
            }
        }
        catch (CustomPayloadChannelException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean unregisterClient(String channel, NetServerHandler handler) {
        synchronized (clients) {
            if (clients.containsKey(channel) && clients.get(channel).remove(handler)) {
                log.info(String.format("Client Custom Payload channel '%s' has been unregistered for client '%s'", channel, handler.getUser().getName()));
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean unregisterClientAll(NetServerHandler handler) {
        boolean toRet = true;
        String[] channels = clients.keySet().toArray(new String[clients.keySet().size()]);
        for (String channel : channels) {
            toRet &= unregisterClient(channel, handler);
        }
        return toRet;
    }
}
