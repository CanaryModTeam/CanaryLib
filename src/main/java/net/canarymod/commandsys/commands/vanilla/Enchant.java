package net.canarymod.commandsys.commands.vanilla;

import net.canarymod.Translator;
import net.canarymod.chat.MessageReceiver;

import static net.canarymod.commandsys.CanaryCommandPermissions.ENCHANT$OTHER;

/**
 * Enchant command wrapper
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class Enchant extends VanillaCommandWrapper {
    // enchant <player> <enchantment ID> [level]

    @Override
    public void execute(MessageReceiver caller, String[] parameters) {
        if (isNotSelfOrServer(caller, parameters[0]) && !caller.hasPermission(ENCHANT$OTHER)) {
            caller.notice(Translator.nativeTranslate("commands.generic.permission"));
            return;
        }
        passOn(caller, "enchant", parameters);
    }
}
