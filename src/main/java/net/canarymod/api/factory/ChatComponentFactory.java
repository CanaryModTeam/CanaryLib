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
     * Creates a new {@link net.canarymod.api.chat.ChatComponent}
     *
     * @param text
     *         the text value for the component
     *
     * @return new {@link net.canarymod.api.chat.ChatComponent}
     */
    ChatComponent newChatComponent(String text);

    /**
     * Creates a new {@link net.canarymod.api.chat.ChatComponent}
     * and applies formatting and events where possible
     *
     * @param text
     *         the text value for the component
     *
     * @return new {@link net.canarymod.api.chat.ChatComponent}
     */
    ChatComponent compileChatComponent(String text);

    /**
     * Reverses the process of {@link #compileChatComponent(String)}
     *
     * @param chatComponent
     *         the {@link net.canarymod.api.chat.ChatComponent} you want to decompile
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
     * @return new {@link net.canarymod.api.chat.ChatComponent}
     */
    ChatComponent deserialize(String json);
    
    /* Formatting */

    /**
     * Gets the {@link net.canarymod.api.chat.ChatFormatting} by name
     *
     * @param name
     *         the name of the {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return the matching {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting getFormattingByName(String name);

    /**
     * Gets the {@link net.canarymod.api.chat.ChatFormatting} by it's matching character
     *
     * @param charcode
     *         the charcode matching the {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return the matching {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting getStyleByChar(char charcode);

    /**
     * Gets the {@code BLACK} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code BLACK} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorBlack();

    /**
     * Gets the {@code DARK_BLUE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_BLUE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkBlue();

    /**
     * Gets the {@code DARK_GREEN} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_GREEN} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkGreen();

    /**
     * Gets the {@code DARK_AQUA} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_AQUA} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkAqua();

    /**
     * Gets the {@code DARK_RED} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_RED} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkRed();

    /**
     * Gets the {@code DARK_PURPLE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_PURPLE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkPurple();

    /**
     * Gets the {@code GOLD} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code GOLD} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorGold();

    /**
     * Gets the {@code GRAY} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code GRAY} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorGray();

    /**
     * Gets the {@code DARK_GRAY} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code DARK_GRAY} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorDarkGray();

    /**
     * Gets the {@code BLUE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code BLUE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorBlue();

    /**
     * Gets the {@code GREEN} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code GREEN} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorGreen();

    /**
     * Gets the {@code AQUA} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code AQUA} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorAqua();

    /**
     * Gets the {@code RED} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code RED} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorRed();

    /**
     * Gets the {@code LIGHT_PURPLE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code LIGHT_PURPLE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorLightPurple();

    /**
     * Gets the {@code YELLOW} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code YELLOW} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorYellow();

    /**
     * Gets the {@code WHITE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code WHITE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting colorWhite();

    /**
     * Gets the {@code OBFUSCATED} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code OBFUSCATED} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleObfuscated();

    /**
     * Gets the {@code BOLD} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code BOLD} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleBold();

    /**
     * Gets the {@code STRIKETHROUGH} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code STRIKETHROUGH} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleStrikethrough();

    /**
     * Gets the {@code UNDERLINE} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code UNDERLINE} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleUnderline();

    /**
     * Gets the {@code ITALIC} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code ITALIC} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleItalic();

    /**
     * Gets the {@code RESET} {@link net.canarymod.api.chat.ChatFormatting}
     *
     * @return {@code RESET} {@link net.canarymod.api.chat.ChatFormatting}
     */
    ChatFormatting styleReset();
    //
    
    /* ClickEvent Action */

    /**
     * Creates a new {@link net.canarymod.api.chat.ClickEvent}
     *
     * @param action
     *         the {@link net.canarymod.api.chat.ClickEventAction}
     * @param value
     *         the value
     *
     * @return new {@link net.canarymod.api.chat.ClickEvent}
     */
    ClickEvent newClickEvent(ClickEventAction action, String value);

    /**
     * Gets a {@link net.canarymod.api.chat.ClickEventAction} by name
     *
     * @param name
     *         the name of the {@link net.canarymod.api.chat.ClickEventAction}
     *
     * @return the {@link net.canarymod.api.chat.ClickEventAction}
     */
    ClickEventAction getClickEventActionByName(String name);

    /**
     * Gets the {@code OPEN_URL} {@link net.canarymod.api.chat.ClickEventAction}
     *
     * @return the {@code OPEN_URL} {@link net.canarymod.api.chat.ClickEventAction}
     */
    ClickEventAction getOpenURL();

    /**
     * Gets the {@code OPEN_FILE} {@link net.canarymod.api.chat.ClickEventAction}
     *
     * @return the {@code OPEN_FILE} {@link net.canarymod.api.chat.ClickEventAction}
     */
    ClickEventAction getOpenFile();

    /**
     * Gets the {@code RUN_COMMAND} {@link net.canarymod.api.chat.ClickEventAction}
     *
     * @return the {@code RUN_COMMAND} {@link net.canarymod.api.chat.ClickEventAction}
     */
    ClickEventAction getRunCommand();

    /**
     * Gets the {@code SUGGEST_COMMAND} {@link net.canarymod.api.chat.ClickEventAction}
     *
     * @return the {@code SUGGEST_COMMAND} {@link net.canarymod.api.chat.ClickEventAction}
     */
    ClickEventAction getSuggestCommand();
    //

    /* HoverEvent Action */

    /**
     * Creates a new {@link net.canarymod.api.chat.HoverEvent}
     *
     * @param action
     *         the {@link net.canarymod.api.chat.HoverEventAction}
     * @param value
     *         the value
     *
     * @return new {@link net.canarymod.api.chat.HoverEvent}
     */
    HoverEvent newHoverEvent(HoverEventAction action, ChatComponent value);

    /**
     * Gets a {@link net.canarymod.api.chat.HoverEventAction} by name
     *
     * @param name
     *         the name of the {@link net.canarymod.api.chat.HoverEventAction}
     *
     * @return the {@link net.canarymod.api.chat.HoverEventAction}
     */
    HoverEventAction getHoverEventActionByName(String name);

    /**
     * Gets the {@code SHOW_TEXT} {@link net.canarymod.api.chat.HoverEventAction}
     *
     * @return the {@code SHOW_TEXT} {@link net.canarymod.api.chat.HoverEventAction}
     */
    HoverEventAction getShowText();

    /**
     * Gets the {@code SHOW_ACHIEVEMENT} {@link net.canarymod.api.chat.HoverEventAction}
     *
     * @return the {@code SHOW_ACHIEVEMENT} {@link net.canarymod.api.chat.HoverEventAction}
     */
    HoverEventAction getShowAchievement();

    /**
     * Gets the {@code SHOW_ITEM} {@link net.canarymod.api.chat.HoverEventAction}
     *
     * @return the {@code SHOW_ITEM} {@link net.canarymod.api.chat.HoverEventAction}
     */
    HoverEventAction getShowItem();
    //
}
