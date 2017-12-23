package net.canarymod.api.chat;

/**
 * Wrapper interface for Minecraft native ChatStyle
 *
 * @author Jason (darkdiplomat)
 */
public interface ChatStyle extends Cloneable {

    /**
     * Gets the {@link ChatFormatting} for this {@code ChatStyle}
     *
     * @return {@link ChatFormatting}
     */
    ChatFormatting getColor();

    /**
     * Checks if this {@code ChatStyle} is bold
     *
     * @return {@code true} if bold; {@code false} if not
     */
    boolean isBold();

    /**
     * Checks if this {@code ChatStyle} is italic
     *
     * @return {@code true} if italic; {@code false} if not
     */
    boolean isItalic();

    /**
     * Checks if this {@code ChatStyle} is strikethrough
     *
     * @return {@code true} if strikethrough; {@code false} if not
     */
    boolean isStrikethrough();

    /**
     * Checks if this {@code ChatStyle} is underlined
     *
     * @return {@code true} if underlined; {@code false} if not
     */
    boolean isUnderlined();

    /**
     * Checks if this {@code ChatStyle} is obfuscated (random)
     *
     * @return {@code true} if obfuscated; {@code false} if not
     */
    boolean isObfuscated();

    /**
     * Checks if this {@code ChatStyle} is empty
     *
     * @return {@code true} if empty; {@code false} if not
     */
    boolean isEmpty();

    /**
     * Gets the assigned {@link ClickEvent}
     *
     * @return {@link ClickEvent}
     */
    ClickEvent getChatClickEvent();

    /**
     * Gets the assigned {@link HoverEvent}
     *
     * @return {@link HoverEvent}
     */
    HoverEvent getChatHoverEvent();

    /**
     * Sets the {@link ChatFormatting} of this {@code ChatStyle}
     *
     * @param color
     *         the {@link ChatFormatting} color
     *
     * @return {@code this}
     */
    ChatStyle setColor(ChatFormatting color);

    /**
     * Sets if this {@code ChatStyle} is bold
     *
     * @param bold
     *         {@code true} if bold; {@code false} if not
     *
     * @return {@code this}
     */
    ChatStyle setBold(boolean bold);

    /**
     * Sets if this {@code ChatStyle} is italic
     *
     * @param italic
     *         {@code true} if bold; {@code false} if not
     *
     * @return {@code this}
     */
    ChatStyle setItalic(boolean italic);

    /**
     * Sets if this {@code ChatStyle} is strikethrough
     *
     * @param strikethrough
     *         {@code true} if strikethrough; {@code false} if not
     *
     * @return {@code this}
     */
    ChatStyle setStrikethrough(boolean strikethrough);

    /**
     * Sets if this {@code ChatStyle} is bold
     *
     * @param underlined
     *         {@code true} if underlined; {@code false} if not
     *
     * @return {@code this}
     */
    ChatStyle setUnderlined(boolean underlined);

    /**
     * Sets if this {@code ChatStyle} is bold
     *
     * @param obfuscated
     *         {@code true} if obfuscated; {@code false} if not
     *
     * @return {@code this}
     */
    ChatStyle setObfuscated(boolean obfuscated);

    /**
     * Sets the {@link ClickEvent} of this {@code ChatStyle}
     *
     * @param clickEvent
     *         the {@link ClickEvent} to be set
     *
     * @return {@code this}
     */
    ChatStyle setChatClickEvent(ClickEvent clickEvent);

    /**
     * Sets the {@link HoverEvent} of this {@code ChatStyle}
     *
     * @param hoverEvent
     *         the {@link HoverEvent} to be set
     *
     * @return {@code this}
     */
    ChatStyle setChatHoverEvent(HoverEvent hoverEvent);

    /**
     * Sets the {@code ChatStyle} parent of this {@code ChatStyle}
     *
     * @param chatStyle
     *         the {@code ChatStyle} to set as parent
     *
     * @return {@code this}
     */
    ChatStyle setParentStyle(ChatStyle chatStyle);

    /**
     * Gets the parent {@code ChatStyle} of this {@code ChatStyle}
     *
     * @return the parent {@code ChatStyle}
     */
    ChatStyle getParentStyle();

    /**
     * Clones this {@code ChatStyle}
     *
     * @return {@code ChatStyle} clone
     */
    ChatStyle clone();
}
