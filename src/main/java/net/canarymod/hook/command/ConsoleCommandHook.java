package net.canarymod.hook.command;

import net.canarymod.chat.MessageReceiver;
import net.canarymod.hook.CancelableHook;
import net.visualillusionsent.utils.StringUtils;

/**
 * Server command hook. Contains the command issued by the server
 *
 * @author Chris (damagefilter)
 */
public final class ConsoleCommandHook extends CancelableHook {
    private String[] command;
    private MessageReceiver receiver;

    /**
     * Constructs a new ConsoleCommandHook
     *
     * @param receiver
     *         the {@link MessageReceiver} executing the command
     * @param textInput
     *         the text input
     */
    public ConsoleCommandHook(MessageReceiver receiver, String textInput) {
        command = textInput.split(" ");
        this.receiver = receiver;
    }

    /**
     * Get command that was issued by the console
     *
     * @return String array of the arguments
     */
    public String[] getCommand() {
        return command;
    }

    /**
     * Get the object that has issued the command.
     * This can be a player or the console (Server).
     * Use <tt>instanceof</tt> to check types
     *
     * @return the message receiver (command caller)
     */
    public MessageReceiver getCaller() {
        return receiver;
    }

    @Override
    public final String toString() {
        return String.format("%s[MessageReceiver=%s, Command=%s]", getHookName(), receiver, StringUtils.joinString(command, " ", 0));
    }
}
