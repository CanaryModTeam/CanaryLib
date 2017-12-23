package net.canarymod.api.chat;

/**
 * Wrapper interface for Minecraft's native HoverEvent
 *
 * @author Jason (darkdiplomat)
 */
public interface HoverEvent {

    /**
     * Gets the {@link HoverEventAction} of this {@code HoverEvent}
     *
     * @return the {@link HoverEventAction}
     */
    HoverEventAction getAction();

    /**
     * Gets the {@link ChatComponent} value
     *
     * @return {@link ChatComponent}
     */
    ChatComponent getValue();
}
