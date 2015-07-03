package net.canarymod.api.chat;

/**
 * Wrapper interface for Minecraft's native HoverEvent
 *
 * @author Jason (darkdiplomat)
 */
public interface HoverEvent {

    /**
     * Gets the {@link net.canarymod.api.chat.HoverEventAction} of this {@code HoverEvent}
     *
     * @return the {@link HoverEventAction}
     */
    HoverEventAction getAction();

    /**
     * Gets the {@link net.canarymod.api.chat.ChatComponent} value
     *
     * @return {@link net.canarymod.api.chat.ChatComponent}
     */
    ChatComponent getValue();
}
