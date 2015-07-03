package net.canarymod.api;

import net.canarymod.api.world.World;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.user.Group;

/**
 * Command Block Logical Interface wrapping
 *
 * @author Jason (darkdiplomat)
 */
public interface CommandBlockLogic extends MessageReceiver {

    /**
     * Sets the CommandBlock's command
     *
     * @param command
     *         the command to execute when this block is activated
     */
    void setCommand(String command);

    /**
     * Returns the CommandBlock's command
     *
     * @return the command
     */
    String getCommand();

    /**
     * Run this CommandBlock's command.
     */
    void activate();

    /**
     * Gets the dimension
     *
     * @return dimension
     */
    World getWorld();

    /**
     * Sets this command block's name.
     * Displayed as prefix in chat when the doCommandBlockOutput game rule is
     * true. Default value is "@".
     *
     * @param name
     *         This command block's new name
     */
    void setName(String name);

    /**
     * Returns the group that is used to handle CommandBlock permissions.
     *
     * @return the Group
     */
    Group getGroup();

    /**
     * Sets the group that is used to handle CommandBlock permissions,
     * but only for this command block.
     *
     * @param group
     *         the {@link Group} to give the CommandBlock
     */
    void setGroup(Group group);
}
