package net.canarymod.commandsys.commands.vanilla;

import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.visualillusionsent.utils.StringUtils;

import static net.canarymod.Canary.getServer;

/**
 * Intermediate class between Canary permissions and Vanilla Command System
 *
 * @author Jason Jones (darkdiplomat)
 */
abstract class VanillaCommandWrapper implements NativeCommand {

    private String rebuildForVanilla(String cmd, String[] parameters) {
        if (parameters.length == 0) {
            return cmd;
        }
        return cmd + " " + StringUtils.joinString(parameters, " ", 0);
    }

    public final void passOn(MessageReceiver caller, String cmd, String[] parameters) {
        getServer().executeVanillaCommand(caller, rebuildForVanilla(cmd, parameters));
    }

    boolean isNotSelfOrServer(MessageReceiver caller, String target) {
        return caller.getReceiverType() != ReceiverType.SERVER && !caller.getName().equalsIgnoreCase(target);
    }
}
