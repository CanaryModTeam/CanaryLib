package net.canarymod.api.chat;

/**
 * Wrapper interface for Minecraft's native ClickEvent.Action
 *
 * @author Jason (darkdiplomat)
 */
public interface ClickEventAction {

    /**
     * Checks if the action is allowed in chat
     *
     * @return {@code true} if allowed; {@code false} if not
     */
    boolean allowedInChat();

    /**
     * Gets the name of the action
     *
     * @return the name
     */
    String getName();
}
