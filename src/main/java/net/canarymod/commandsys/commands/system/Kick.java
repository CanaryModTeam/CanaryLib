package net.canarymod.commandsys.commands.system;

import net.canarymod.Canary;
import net.canarymod.Translator;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.hook.player.KickHook;
import net.visualillusionsent.utils.StringUtils;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to kick a player from the server
 *
 * @author Brian (WWOL)
 */
public class Kick implements NativeCommand {

    public void execute(MessageReceiver caller, String[] parameters) {
        Player[] targets = Canary.playerSelector().matchPlayers(caller, parameters[0]);
        Player target = Canary.getServer().matchPlayer(parameters[0]);
        if (targets != null && targets.length > 0) {
            for (Player player : targets) {
                if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
                    Player c = (Player)caller;
                    if (!c.getGroup().hasControlOver(player.getGroup())) {
                        continue;
                    }
                }
                if (player != null) {
                    String reason = Translator.translateAndFormat("kick message", caller.getName());
                    if (parameters.length >= 2) {
                        reason = StringUtils.joinString(parameters, " ", 1);
                    }
                    new KickHook(player, caller, reason).call();
                    player.kickNoHook(reason);
                    sendTranslatedNotice(caller, "kick kicked", player.getName());
                }
            }
        }
        else if (target != null) {
            if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
                Player c = (Player)caller;
                if (!c.getGroup().hasControlOver(target.getGroup())) {
                    sendTranslatedNotice(caller, "kick nocontrol");
                    return;
                }
            }
            String reason = Translator.translateAndFormat("kick message", caller.getName());
            if (parameters.length >= 2) {
                reason = StringUtils.joinString(parameters, " ", 1);
            }
            new KickHook(target, caller, reason).call();
            target.kickNoHook(reason);
            sendTranslatedNotice(caller, "kick kicked", target.getName());
        }
        else {
            sendTranslatedNotice(caller, "kick failed");
            sendTranslatedNotice(caller, "unknown player", parameters[0]);
        }
    }
}
