package net.canarymod.hook.command;

import net.canarymod.api.CommandBlockLogic;
import net.canarymod.api.entity.vehicle.CommandBlockMinecart;
import net.canarymod.api.world.blocks.CommandBlock;
import net.canarymod.hook.CancelableHook;
import net.visualillusionsent.utils.StringUtils;

/**
 * CommandBlockCommandHook<br>
 * Called when a CommandBlock executes a command.
 *
 * @author Jason (darkdiplomat)
 */
public final class CommandBlockCommandHook extends CancelableHook {
    private CommandBlockLogic reference;
    private String[] args;

    /**
     * Constructs a new CommandBlockCommandHook
     *
     * @param reference
     *         the {@link CommandBlockLogic} used (either CommandBlock or CommandBlockMinecart)
     * @param args
     *         the command and arguments
     */
    public CommandBlockCommandHook(CommandBlockLogic reference, String[] args) {
        this.reference = reference;
        this.args = args;
    }

    /**
     * Gets the CommandBlock if actually a CommandBlock
     *
     * @return the {@link CommandBlock} if it is one; {@code null} if its a {@link CommandBlockMinecart} instead
     */
    public CommandBlock getCommandBlock() {
        return reference instanceof CommandBlock ? (CommandBlock)reference : null;
    }

    /**
     * Gets the CommandBlockMinecart if actually a CommandBlockMinecart
     *
     * @return the {@link CommandBlockMinecart} if it is one; {@code null} if its a {@link CommandBlock} instead
     */
    public CommandBlockMinecart getCommandBlockMinecart() {
        return reference instanceof CommandBlockMinecart ? (CommandBlockMinecart)reference : null;
    }

    public CommandBlockLogic getReference() {
        return reference;
    }

    /**
     * Gets the command and arguments
     *
     * @return the command and arguments
     */
    public String[] getArguments() {
        return args;
    }

    @Override
    public final String toString() {
        return String.format("%s[CommandBlock=%s, Arguments=%s]", getHookName(), reference, StringUtils.joinString(args, " ", 0));
    }
}
