package net.canarymod.api.chat;

import java.util.List;

/**
 * Wrapper interface for IChatComponent
 *
 * @author Jason (darkdiplomat)
 */
public interface ChatComponent extends Cloneable {

    /**
     * Sets the {@link net.canarymod.api.chat.ChatStyle} of this {@code ChatComponent}
     *
     * @param style
     *         the {@link net.canarymod.api.chat.ChatStyle} to be set
     *
     * @return {@code this} with the {@linke ChatStyle} applied
     */
    ChatComponent setChatStyle(ChatStyle style);

    /**
     * Gets the {@link net.canarymod.api.chat.ChatStyle} of this {@code ChatComponent}
     *
     * @return {@link net.canarymod.api.chat.ChatStyle}
     */
    ChatStyle getChatStyle();

    /**
     * Overrides the original text and sets the new text
     *
     * @param text
     *         the text to be set
     *
     * @return {@code this} with the new text set
     */
    ChatComponent setText(String text);

    /**
     * Appends text to this {@code ChatComponent}
     *
     * @param text
     *         the text to append
     *
     * @return {@code this} with text appened
     */
    ChatComponent appendText(String text);

    /**
     * Appends a sibling {@code ChatComponent} to this {@code ChatComponent}
     *
     * @param sibling
     *         the {@code ChatComponent} to append
     *
     * @return {@code this} with the {@code ChatComponent} appended
     */
    ChatComponent appendSibling(ChatComponent sibling);

    /**
     * Gets the unformatted text value of this {@code ChatComponent}
     *
     * @return unformatted text value
     */
    String getText();

    /**
     * Get the full unformatted text value of this {@code ChatComponent} and all siblings
     *
     * @return full unformatted text value
     */
    String getFullText();

    /**
     * Gets a {@link List} of all sibling {@code ChatComponent}s
     *
     * @return list of siblings
     */
    List<ChatComponent> getSiblings();

    /**
     * Serializes the ChatComponent as a Json String
     *
     * @return json string
     */
    String serialize();

    /**
     * Clones this {@code ChatComponent}
     *
     * @return clone of {@code this}
     */
    public ChatComponent clone();
}
