package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.ChatFormat;
import net.canarymod.hook.CancelableHook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Chat hook. Contains player, prefix, message and receivers information
 *
 * @author Chris (damagefilter)
 */
public final class ChatHook extends CancelableHook {
    private Player player;
    private String format;
    private List<Player> receivers;
    private Map<String, String> placeholders;

    public ChatHook(Player player, String format, List<Player> receivers, Map<String, String> replacements) {
        this.player = player;
        this.receivers = receivers;
        this.format = format;
        this.placeholders = replacements;
    }

    /**
     * Get the {@link Player} instance
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the message prefix. The prefix contains the following data:<br>
     * This is the prefix as defined in Player or Group.
     *
     * @return the prefix string
     */
    public String getPrefix() {
        return placeholders.get("%prefix");
    }

    /**
     * Get the message this player has sent
     *
     * @return the message
     */
    public String getMessage() {
        return placeholders.get("%message");
    }

    /**
     * Change the message completely
     *
     * @param message
     *         the message to set
     */
    public void setMessage(String message) {
        placeholders.put("%message", message);
    }

    /**
     * Set the name that is used for this player
     *
     * @param name
     *         the display name to set
     */
    public void setPlayerDisplayName(String name) {
        placeholders.put("%name", name);
    }

    /**
     * Get the currently used name for this player
     *
     * @return display name
     */
    public String getPlayerDisplayName() {
        return placeholders.get("%name");
    }

    /**
     * Append the given String to the existing message
     *
     * @param toAppend
     *         the message string to append
     */
    public void appendToMessage(String toAppend) {
        placeholders.put("%message", getMessage().concat(toAppend));
    }

    /**
     * Override the players chat prefix
     *
     * @param newPrefix
     *         the prefix to be set
     */
    public void setPrefix(String newPrefix) {
        placeholders.put("%prefix", newPrefix);
    }

    /**
     * Get a list of all receivers for this message
     *
     * @return the list of {@link Player} receivers
     */
    public List<Player> getReceiverList() {
        return receivers;
    }

    /**
     * Override the list of receivers
     *
     * @param receiverList
     *         the list of {@link Player} receivers
     */
    public void setReceiverList(ArrayList<Player> receiverList) {
        receivers = receiverList;
    }

    /**
     * Remove a {@link Player} from the receiver list
     *
     * @param player
     *         the {@link Player} to remove
     */
    public void removeFromReceiverList(Player player) {
        receivers.remove(player);
    }

    /**
     * Add a {@link Player} to the receiver list. This better not be null!
     *
     * @param player
     *         the {@link Player} to add
     */
    public void addToReceiverList(Player player) {
        receivers.add(player);
    }

    /**
     * Get the chat format. This is a string like this:<br>
     * &lt;%prefix %name&gt; %message
     * You can modify this to your liking.
     * Replacement values can be found in the placeholder map.<br>
     * This is a formatting template, do not replace the placeholders with real values.
     * This will happen automatically.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Override the default chatting format.
     *
     * @param format
     *         the format to set
     *
     * @see ChatHook#getFormat()
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Set or override a placeholder and a value
     *
     * @param placeholder
     *         the palceholder, such as %name or %extraData - something to your liking
     * @param value
     *         The value to substitute the placeholder with when the chat message is dispatched
     */
    public void setPlaceholder(String placeholder, String value) {
        placeholders.put(placeholder, value);
    }

    /**
     * Remove a specified placeholder value.
     *
     * @param placeholder
     *         the placeholder to remove
     */
    public void removePlaceholder(String placeholder) {
        placeholders.remove(placeholder);
    }

    /**
     * Returns the map containing the placeholder => value mappings
     *
     * @return placeholder map
     */
    public Map<String, String> getPlaceholderMapping() {
        return placeholders;
    }

    /**
     * Create the message that will be sent from the placeholder list and the format.
     *
     * @return message
     */
    public String buildSendMessage() {
        String end = format;
        for (String placeholder : placeholders.keySet()) {
            end = end.replace(placeholder, placeholders.get(placeholder));
        }
        return end;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Receivers=%s, Message=%s, Format=%s, Placeholders=%s]", getHookName(), player, receivers, placeholders.get("%message"), format, placeholders());
    }

    private String placeholders() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            if (entry.getKey().equals("%prefix")) {
                builder.append(entry.getKey()).append("=").append(entry.getValue()).append(entry.getValue().replace("\u00A7", ""));
                builder.append(ChatFormat.RESET);
            }
            else {
                builder.append(entry);
            }
        }
        return builder.toString();
    }
}
