package net.canarymod.api.world.blocks;

import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;

/**
 * Sign wrapper interface
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public interface Sign extends TileEntity {

    /**
     * Get this signs text
     *
     * @return the String array of text
     *
     * @deprecated Use {@link #getLines()} instead
     */
    @Deprecated
    String[] getText();

    /**
     * Get this sign's {@link net.canarymod.api.chat.ChatComponent}(s)
     *
     * @return the array of text
     */
    ChatComponent[] getLines();

    /**
     * Get text in specified line
     *
     * @param line
     *         the line index (0 - 3)
     *
     * @return the line of text
     *
     * @deprecated Use {@link #getComponentOnLine(int)} instead
     */
    @Deprecated
    String getTextOnLine(int line);

    /**
     * Get text in specified line
     *
     * @param line
     *         the line index (0 - 3)
     *
     * @return the line of text
     */
    ChatComponent getComponentOnLine(int line);

    /**
     * Override the whole sign content
     *
     * @param text
     *         the text to set
     *
     * @deprecated Use {@link #setComponents(net.canarymod.api.chat.ChatComponent[])} instead
     */
    @Deprecated
    void setText(String[] text);

    /**
     * Override the whole sign content
     *
     * @param components
     *         the {@link net.canarymod.api.chat.ChatComponent}(s) to set
     */
    void setComponents(ChatComponent[] components);

    /**
     * Set text on this line
     *
     * @param text
     *         the text to set on the line
     * @param line
     *         the line index
     *
     * @deprecated Use {@link #setComponentOnLine(net.canarymod.api.chat.ChatComponent, int)} instead
     */
    @Deprecated
    void setTextOnLine(String text, int line);

    /**
     * Sets a {@link net.canarymod.api.chat.ChatComponent} on this line
     *
     * @param component
     *         the {@link net.canarymod.api.chat.ChatComponent} to set on the line
     * @param line
     *         the line index
     */
    void setComponentOnLine(ChatComponent component, int line);

    /**
     * Gets whether the Sign is hanging on a wall or not
     *
     * @return {@code true} if Wall Sign; {@code false} if not
     */
    boolean isWallSign();

    /**
     * Gets whether the Sign is sitting on a {@link Block} or not
     *
     * @return {@code true} if Sign Post; {@code false} if not
     */
    boolean isSignPost();

    /**
     * Gets the {@link Block} that the Sign is attached to
     *
     * @return the attached to {@link Block}
     */
    Block getBlockAttached();

    /**
     * Checks if the Sign is editable
     *
     * @return {@code true} if editable; {@code false} if not
     */
    boolean isEditable();

    /**
     * Sets if the Sign is editable
     *
     * @param edit
     *         {@code true} for editable; {@code false} for not
     */
    void setEditable(boolean edit);

    /**
     * Gets the Owners name, may return empty string if no owner is set
     *
     * @return Owner's name or empty string if no owner
     */
    String getOwnerName();

    /**
     * Gets the owner of the Sign
     *
     * @return the owner or {@code null} if no owner set
     */
    Player getOwner();

    /**
     * Sets the owner of the Sign
     *
     * @param player
     *         the owner or {@code null} for no owner
     */
    void setOwner(Player player);
}
