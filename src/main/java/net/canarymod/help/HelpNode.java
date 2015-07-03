package net.canarymod.help;

import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.CanaryCommand;
import net.canarymod.commandsys.CommandOwner;

/**
 * Contains relevant information about a piece of help.
 * One help node contains the localized description of a command, its tooltip,
 * required permissions, keywords (currently unused), parent and a list of sub commands.
 *
 * @author Chris (damagefilter)
 * @author Jarvix
 */
public class HelpNode {
    /**
     * The Plugin (or Server) that has registered this command
     */
    private CommandOwner plugin;
    /**
     * A list of names of sub commands
     */
    public String[] subCommands;

    private CanaryCommand command;

    public HelpNode(CommandOwner owner, CanaryCommand command) {
        this.command = command;
        this.plugin = owner;
        this.subCommands = HelpManager.subCommandsToStringArray(command.getSubCommands());
    }

    /**
     * get the Plugin (or CanaryMod instance) that has registered this help
     *
     * @return
     */
    public CommandOwner getOwner() {
        return plugin;
    }

    /**
     * Gets the first alias (or name) for this command
     *
     * @return
     */
    public String getCommand() {
        return command.meta.aliases()[0];
    }

    /**
     * Returns a coloured string that displays all command aliases in the specified color
     *
     * @return
     */
    public String getPrintableAliases(String color) {
        StringBuilder str = new StringBuilder(color).append("[");
        for (String alias : command.meta.aliases()) {
            str.append(alias).append(", ");
        }
        // Removes the last space and comma
        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        str.append("]").append(ChatFormat.WHITE);
        return str.toString();
    }

    /**
     * Returns an uncoloured string that displays all command aliases in the specified color
     *
     * @return
     */
    public String getPrintableAliases() {
        StringBuilder str = new StringBuilder().append("[");
        for (String alias : command.meta.aliases()) {
            str.append(alias).append(", ");
        }
        // Removes the last space and comma
        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }

    /**
     * Gets the description for this command
     *
     * @return
     */
    public String getDescription() {
        return command.meta.description();
    }

    /**
     * get the tooltip for this command
     *
     * @return
     */
    public String getTooltip() {
        return command.meta.toolTip();
    }

    /**
     * get some keywords for this command.
     * Used for looking up help contexts
     *
     * @return
     */
    public String[] getKeywords() {
        return command.meta.searchTerms();
    }

    /**
     * Get the name of this commands parent command.
     * Returns an empty string if there is no parent
     *
     * @return
     */
    public String getParent() {
        return command.meta.parent();
    }

    /**
     * Returns true if this is a sub command (parent is not empty)
     *
     * @return
     */
    public boolean isSubCommand() {
        return !command.meta.parent().isEmpty();
    }

    /**
     * Returns an array of all subcommands for this
     *
     * @return
     */
    public String[] getSubCommands() {
        return subCommands;
    }

    /**
     * Check if this node has the given alias
     *
     * @param name
     *
     * @return
     */
    public boolean hasAlias(String name) {
        for (String n : command.meta.aliases()) {
            if (n.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a MessageReceiver (Player for instance) can use the command associated with this help node
     *
     * @param caller
     *
     * @return true if player can use this command, false otherwise
     */
    public boolean canUse(MessageReceiver caller) {
        if (caller == null) {
            return true;
        }
        for (String perm : command.meta.permissions()) {
            if (caller.hasPermission(perm)) {
                return true;
            }
        }
        return false;
    }
}
