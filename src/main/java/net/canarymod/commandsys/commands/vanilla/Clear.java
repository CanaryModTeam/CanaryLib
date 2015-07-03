package net.canarymod.commandsys.commands.vanilla;

import net.canarymod.Translator;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;

import static net.canarymod.commandsys.CanaryCommandPermissions.CLEAR$OTHER;

/**
 * Clear Inventory command wrapper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class Clear extends VanillaCommandWrapper {
    // clear <player> [item] [data]  | alias clearinventory

    @Override
    public final void execute(MessageReceiver caller, String[] parameters) {
        if (isNotSelfOrServer(caller, parameters[0]) && !caller.hasPermission(CLEAR$OTHER)) {
            caller.notice(Translator.nativeTranslate("commands.generic.permission"));
            return;
        }
        if (parameters.length == 0 && caller.getReceiverType().equals(ReceiverType.PLAYER)) { // Set caller's name as parameter
            parameters = new String[]{ caller.getName() };
        }
        passOn(caller, "clear", parameters);
    }
}
