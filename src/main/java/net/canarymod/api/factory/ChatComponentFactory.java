package net.canarymod.api.factory;

import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ChatFormatting;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.ClickEventAction;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.chat.HoverEventAction;

/**
 * Interface to creating the ChatComponent components
 *
 * @author Jason (darkdiplomat)
 */
public interface ChatComponentFactory {

    /**
     * Creates a new {@link ChatComponent}
     *
     * @param text
     *         the text value for the component
     *
     * @return new {@link ChatComponent}
     */
    ChatComponent newChatComponent(String text);

    /**
     * Creates a new {@link ChatComponent}
     * and applies formatting and events where possible
     *
     * @param text
     *         the text value for the component
     *
     * @return new {@link ChatComponent}
     */
    ChatComponent compileChatComponent(String text);

    /**
     * Reverses the process of {@link #compileChatComponent(String)}
     *
     * @param chatComponent
     *         the {@link ChatComponent} you want to decompile
     *
     * @return string version of the ChatComponent
     */
    String decompileChatComponent(ChatComponent chatComponent);

    /**
     * Deserializes a ChatComponent from a Json String
     *
     * @param json
     *         the json string
     *
     * @return new {@link ChatComponent}
     */
    ChatComponent deserialize(String json);
    
    /* Formatting */

    /**
     * Gets the {@link ChatFormatting} by name
     *
     * @param name
     *         the name of the {@link ChatFormatting}
     *
     * @return the matching {@link ChatFormatting}
     */
    ChatFormatting getFormattingByName(String name);

    /**
     * Gets the {@link ChatFormatting} by it's matching character
     *
     * @param charcode
     *         the charcode matching the {@link ChatFormatting}
     *
     * @return the matching {@link ChatFormatting}
     */
    ChatFormatting getStyleByChar(char charcode);

    /**
     * Gets the {@code BLACK} {@link ChatFormatting}
     *
     * @return {@code BLACK} {@link ChatFormatting}
     */
    ChatFormatting colorBlack();

    /**
     * Gets the {@code DARK_BLUE} {@link ChatFormatting}
     *
     * @return {@code DARK_BLUE} {@link ChatFormatting}
     */
    ChatFormatting colorDarkBlue();

    /**
     * Gets the {@code DARK_GREEN} {@link ChatFormatting}
     *
     * @return {@code DARK_GREEN} {@link ChatFormatting}
     */
    ChatFormatting colorDarkGreen();

    /**
     * Gets the {@code DARK_AQUA} {@link ChatFormatting}
     *
     * @return {@code DARK_AQUA} {@link ChatFormatting}
     */
    ChatFormatting colorDarkAqua();

    /**
     * Gets the {@code DARK_RED} {@link ChatFormatting}
     *
     * @return {@code DARK_RED} {@link ChatFormatting}
     */
    ChatFormatting colorDarkRed();

    /**
     * Gets the {@code DARK_PURPLE} {@link ChatFormatting}
     *
     * @return {@code DARK_PURPLE} {@link ChatFormatting}
     */
    ChatFormatting colorDarkPurple();

    /**
     * Gets the {@code GOLD} {@link ChatFormatting}
     *
     * @return {@code GOLD} {@link ChatFormatting}
     */
    ChatFormatting colorGold();

    /**
     * Gets the {@code GRAY} {@link ChatFormatting}
     *
     * @return {@code GRAY} {@link ChatFormatting}
     */
    ChatFormatting colorGray();

    /**
     * Gets the {@code DARK_GRAY} {@link ChatFormatting}
     *
     * @return {@code DARK_GRAY} {@link ChatFormatting}
     */
    ChatFormatting colorDarkGray();

    /**
     * Gets the {@code BLUE} {@link ChatFormatting}
     *
     * @return {@code BLUE} {@link ChatFormatting}
     */
    ChatFormatting colorBlue();

    /**
     * Gets the {@code GREEN} {@link ChatFormatting}
     *
     * @return {@code GREEN} {@link ChatFormatting}
     */
    ChatFormatting colorGreen();

    /**
     * Gets the {@code AQUA} {@link ChatFormatting}
     *
     * @return {@code AQUA} {@link ChatFormatting}
     */
    ChatFormatting colorAqua();

    /**
     * Gets the {@code RED} {@link ChatFormatting}
     *
     * @return {@code RED} {@link ChatFormatting}
     */
    ChatFormatting colorRed();

    /**
     * Gets the {@code LIGHT_PURPLE} {@link ChatFormatting}
     *
     * @return {@code LIGHT_PURPLE} {@link ChatFormatting}
     */
    ChatFormatting colorLightPurple();

    /**
     * Gets the {@code YELLOW} {@link ChatFormatting}
     *
     * @return {@code YELLOW} {@link ChatFormatting}
     */
    ChatFormatting colorYellow();

    /**
     * Gets the {@code WHITE} {@link ChatFormatting}
     *
     * @return {@code WHITE} {@link ChatFormatting}
     */
    ChatFormatting colorWhite();

    /**
     * Gets the {@code OBFUSCATED} {@link ChatFormatting}
     *
     * @return {@code OBFUSCATED} {@link ChatFormatting}
     */
    ChatFormatting styleObfuscated();

    /**
     * Gets the {@code BOLD} {@link ChatFormatting}
     *
     * @return {@code BOLD} {@link ChatFormatting}
     */
    ChatFormatting styleBold();

    /**
     * Gets the {@code STRIKETHROUGH} {@link ChatFormatting}
     *
     * @return {@code STRIKETHROUGH} {@link ChatFormatting}
     */
    ChatFormatting styleStrikethrough();

    /**
     * Gets the {@code UNDERLINE} {@link ChatFormatting}
     *
     * @return {@code UNDERLINE} {@link ChatFormatting}
     */
    ChatFormatting styleUnderline();

    /**
     * Gets the {@code ITALIC} {@link ChatFormatting}
     *
     * @return {@code ITALIC} {@link ChatFormatting}
     */
    ChatFormatting styleItalic();

    /**
     * Gets the {@code RESET} {@link ChatFormatting}
     *
     * @return {@code RESET} {@link ChatFormatting}
     */
    ChatFormatting styleReset();
    //
    
    /* ClickEvent Action */

    /**
     * Creates a new {@link ClickEvent}
     *
     * @param action
     *         the {@link ClickEventAction}
     * @param value
     *         the value
     *
     * @return new {@link ClickEvent}
     */
    ClickEvent newClickEvent(ClickEventAction action, String value);

    /**
     * Gets a {@link ClickEventAction} by name
     *
     * @param name
     *         the name of the {@link ClickEventAction}
     *
     * @return the {@link ClickEventAction}
     */
    ClickEventAction getClickEventActionByName(String name);

    /**
     * Gets the {@code OPEN_URL} {@link ClickEventAction}
     *
     * @return the {@code OPEN_URL} {@link ClickEventAction}
     */
    ClickEventAction getOpenURL();

    /**
     * Gets the {@code OPEN_FILE} {@link ClickEventAction}
     *
     * @return the {@code OPEN_FILE} {@link ClickEventAction}
     */
    ClickEventAction getOpenFile();

    /**
     * Gets the {@code RUN_COMMAND} {@link ClickEventAction}
     *
     * @return the {@code RUN_COMMAND} {@link ClickEventAction}
     */
    ClickEventAction getRunCommand();

    /**
     * Gets the {@code SUGGEST_COMMAND} {@link ClickEventAction}
     *
     * @return the {@code SUGGEST_COMMAND} {@link ClickEventAction}
     */
    ClickEventAction getSuggestCommand();
    //

    /* HoverEvent Action */

    /**
     * Creates a new {@link HoverEvent}
     *
     * @param action
     *         the {@link HoverEventAction}
     * @param value
     *         the value
     *
     * @return new {@link HoverEvent}
     */
    HoverEvent newHoverEvent(HoverEventAction action, ChatComponent value);

    /**
     * Gets a {@link HoverEventAction} by name
     *
     * @param name
     *         the name of the {@link HoverEventAction}
     *
     * @return the {@link HoverEventAction}
     */
    HoverEventAction getHoverEventActionByName(String name);

    /**
     * Gets the {@code SHOW_TEXT} {@link HoverEventAction}
     *
     * @return the {@code SHOW_TEXT} {@link HoverEventAction}
     */
    HoverEventAction getShowText();

    /**
     * Gets the {@code SHOW_ACHIEVEMENT} {@link HoverEventAction}
     *
     * @return the {@code SHOW_ACHIEVEMENT} {@link HoverEventAction}
     */
    HoverEventAction getShowAchievement();

    /**
     * Gets the {@code SHOW_ITEM} {@link HoverEventAction}
     *
     * @return the {@code SHOW_ITEM} {@link HoverEventAction}
     */
    HoverEventAction getShowItem();
    //
}
