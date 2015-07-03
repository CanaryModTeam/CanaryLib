package net.canarymod.hook.system;

import com.google.common.io.BaseEncoding;
import com.mojang.authlib.GameProfile;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.hook.CancelableHook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

/**
 * Called when a client ping the server
 *
 * @author greatman
 * @author Jason (darkdiplomat)
 */
public class ServerListPingHook extends CancelableHook {
    private final InetAddress requesterAddress;
    private final int requesterPort, requesterProtocol, portPinged;
    private final String hostNamePinged;
    private final List<GameProfile> profiles;
    private ChatComponent motd;
    private String favicon;
    private int maxPlayers, currentPlayers;

    public ServerListPingHook(InetSocketAddress remoteSocket, int requesterProtocol, String hostNamePinged, int portPinged, ChatComponent motd, int currentPlayers, int maxPlayers, String favicon, List<GameProfile> profiles) {
        this.requesterAddress = remoteSocket.getAddress();
        this.requesterPort = remoteSocket.getPort();
        this.requesterProtocol = requesterProtocol;
        this.hostNamePinged = hostNamePinged;
        this.portPinged = portPinged;
        this.motd = motd;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
        this.favicon = favicon;
        this.profiles = profiles;
    }

    /**
     * Gets the {@link java.net.InetAddress} (IP) of the requesting party
     *
     * @return {@link java.net.InetAddress} of requesting party
     */
    public InetAddress getRequesterAddress() {
        return requesterAddress;
    }

    /**
     * Gets the port used by the requesting party
     *
     * @return port
     */
    public int getRequesterPort() {
        return requesterPort;
    }

    /**
     * Gets the protocol version for the requesting party
     *
     * @return requester's protocol version
     */
    public int getRequesterProtocol() {
        return requesterProtocol;
    }

    /**
     * Gets the HostName (or IP) used by the requester to connect to the server
     *
     * @return host name (or IP) used
     */
    public String getHostNamePinged() {
        return hostNamePinged;
    }

    /**
     * Gets the port the Requester has stated it has pinged
     *
     * @return port pinged
     */
    public int getPortPinged() {
        return portPinged;
    }

    /**
     * Retrieve the MOTD that will be sent to the client
     *
     * @return The MOTD that will be sent to the client
     */
    public ChatComponent getMotd() {
        return motd;
    }

    /**
     * Retrieve the maximum amount of players the server allows that will be sent to the client.
     *
     * @return The maximum amount of players
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Retrieve the current amount of players connected to the server that will be sent to the client.
     *
     * @return The current amount of players
     */
    public int getCurrentPlayers() {
        return currentPlayers;
    }

    /**
     * Set the MOTD that will be sent to the client
     *
     * @param motd
     *         The new MOTD
     */
    public void setMotd(String motd) {
        this.motd = Canary.factory().getChatComponentFactory().compileChatComponent(motd);
    }

    /**
     * Set the MOTD that will be sent to the client
     *
     * @param motd
     *         The new MOTD
     */
    public void setMotd(ChatComponent motd) {
        if (motd == null) {
            motd = Canary.factory().getChatComponentFactory().newChatComponent("");
        }
        this.motd = motd;
    }

    /**
     * Set the maximum amount of player the server allows that will be sent to the client. <b>Please note that this only fakes the value. It doesn't modify the real value.</b>
     *
     * @param maxPlayers
     *         The maximum amount of player the server allows
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Set the current amount of players connected to the server that will be sent to the client
     *
     * @param currentPlayers
     *         the current amount of players connected to the server
     */
    public void setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    /**
     * Gets the {@link com.mojang.authlib.GameProfile}s to be sent
     *
     * @return profile list
     */
    public List<GameProfile> getProfiles() {
        return profiles;
    }

    /**
     * Returns the Favicon encoded string to be sent
     *
     * @return the favicon string
     */
    public String getFavicon() {
        return favicon;
    }

    /**
     * Sets the favicon encoded string.<br/>
     * The string should be formatted as data:image/png;base64,[base64encodedImage].<br/>
     *
     * @param favicon
     *         the base64 encoded PNG file
     *
     * @throws IllegalArgumentException
     */
    public void setFavicon(String favicon) {
        if (!favicon.startsWith("data:image/png;base64,")) {
            throw new IllegalArgumentException("Favicon string must start with \"data:image/png;base64,\"");
        }
        BaseEncoding.base64().decode(favicon.replace("data:image/png;base64,", "")); // If the string is bad, this will throw an IllegalArgumentException
        this.favicon = favicon;
    }

    /**
     * Sets the server favicon from a given file path
     *
     * @param favicon
     *         the path to the png image file
     *
     * @throws IOException
     */
    public void setFaviconFromFile(String favicon) throws IOException {
        if (!favicon.endsWith(".png")) {
            throw new IOException("Image needs to be in PNG format (bad file extension detected)");
        }
        setFaviconFromFile(new File(favicon));
    }

    /**
     * Sets the server favicon from a given file
     *
     * @param favicon
     *         the path to the png image file
     *
     * @throws IOException
     */
    public void setFaviconFromFile(File favicon) throws IOException {
        if (!favicon.isFile()) {
            throw new IOException("Image does not exist");
        }
        verifyFileSignature(favicon);
        setFaviconFromBufferedImage(ImageIO.read(favicon));
    }

    /**
     * Sets the server favicon from a given {@link java.awt.image.BufferedImage}
     *
     * @param image
     *         the path to the png image file
     *
     * @throws IOException
     */
    public void setFaviconFromBufferedImage(BufferedImage image) throws IOException {
        if (image.getHeight() != 64 || image.getWidth() != 64) {
            throw new IOException("Image needs to be 64x64 pixels");
        }
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            ImageIO.write(image, "PNG", bos);
            this.favicon = "data:image/png;base64," + new String(BaseEncoding.base64().encode(bos.toByteArray()));
        }
        finally {
            if (bos != null) {
                bos.close();
            }
        }
    }

    /* A little extra checking that the File matches the header of a PNG file */
    private void verifyFileSignature(File file) throws IOException {
        RandomAccessFile raf = null;
        byte[] wedontneednostinking = new byte[]{ (byte)0x89, (byte)0x50, (byte)0x4E, (byte)0x47, (byte)0x0D, (byte)0x0A, (byte)0x1A, (byte)0x0A };
        try {
            //And we read the first 8 bytes of the file to verify that they are "89 50 4E 47 0D 0A 1A 0A"
            raf = new RandomAccessFile(file, "r");
            byte[] libraries = new byte[8]; // the punchline to come...
            raf.read(libraries, 0, 8); // Just need to read the first 8 bytes for verification
            if (!Arrays.equals(wedontneednostinking, libraries)) // And the punchline, cause we really dont need a library for 1 function
            {
                throw new IOException("Image needs to be in PNG format (invalid PNG file detected)");
            }
        }
        finally {
            if (raf != null) {
                raf.close();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ServerListPingHook[MOTD: '%s' Players[Current: '%d' Max: '%d'] Favicon: '%s' GameProfiles: '%s']", motd, currentPlayers, maxPlayers, favicon, Arrays.toString(profiles.toArray(new GameProfile[profiles.size()])));
    }
}
