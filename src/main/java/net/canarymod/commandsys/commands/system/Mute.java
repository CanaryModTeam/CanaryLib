package net.canarymod.commandsys.commands.system;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to (un)mute a player
 *
 * @author Chris (damagefilter)
 */
public class Mute implements NativeCommand {

    public void execute(MessageReceiver caller, String[] args) {
        Player target = Canary.getServer().matchPlayer(args[0]);

        if (target != null) {
            if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
                Player c = (Player)caller;
                if (!c.getGroup().hasControlOver(target.getGroup())) {
                    sendTranslatedNotice(caller, "mute nocontrol");
                    return;
                }
            }
            if (target.isMuted()) {
                target.setMuted(false);
                sendTranslatedNotice(caller, "mute unmuted", target.getName());
            }
            else {
                target.setMuted(true);
                sendTranslatedNotice(caller, "mute muted", target.getName());
            }
        }
        else {
            sendTranslatedNotice(caller, "unknown player", args[0]);
        }
    }
}
