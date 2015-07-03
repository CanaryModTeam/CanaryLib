package net.canarymod.api;

import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.packet.Packet;

import java.net.SocketAddress;

/**
 * NetServerHandler wrapper
 *
 * @author Chris (damagefilter)
 */
public interface NetServerHandler {

    /**
     * Add a packet to this {@link Player}'s send queue.<br>
     * It will be sent when it's polled form the queue
     *
     * @param packet
     *         the {@link net.canarymod.api.packet.Packet} to be sent
     */
    void sendPacket(Packet packet);

    /**
     * Handle chat for the {@link Player} attached to this NetServerHandler
     *
     * @param chatPacket
     *         the {@link Packet} for chat
     */
    void handleChat(Packet chatPacket);

    /**
     * Make the attached {@link Player} handle a slash command
     *
     * @param command
     *         the String array of the command and arguments
     */
    void handleCommand(String[] command);

    /**
     * Handle the respawn for the attached {@link Player}
     *
     * @param respawnPacket
     *         the {@link Packet} for respawn
     */
    void handleRespawn(Packet respawnPacket);

    /**
     * Get the {@link Player} that is attached to this NetServerHandler
     *
     * @return the attached {@link Player}
     */
    Player getUser();

    /**
     * Privately send a message to the attached {@link Player}
     *
     * @param messgage
     *         the message to be sent
     */
    void sendMessage(String messgage);

    /**
     * Privately send a {@link net.canarymod.api.chat.ChatComponent} message to the attached {@link Player}
     *
     * @param chatComponent
     *         the {@link net.canarymod.api.chat.ChatComponent} message
     */
    void sendMessage(ChatComponent chatComponent);

    /**
     * Get the {@link SocketAdress} that is attached to this NetServerHandler
     *
     * @return the attached {@link SocketAdress}
     */
    SocketAddress getSocketAdress();
}
