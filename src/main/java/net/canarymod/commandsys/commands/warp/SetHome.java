package net.canarymod.commandsys.commands.warp;

import net.canarymod.Canary;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;

import static net.canarymod.Translator.sendTranslatedMessage;
import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to set your or another players home
 *
 * @author Chris (damagefilter)
 */
public class SetHome implements NativeCommand {

    public void execute(MessageReceiver caller, String[] parameters) {
        if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
            player(caller.asPlayer(), parameters);
        }
        else {
            sendTranslatedNotice(caller, "home set console");
        }
    }

    private void player(Player player, String[] args) {
        if (args.length == 1) {
            PlayerReference target = Canary.getServer().matchKnownPlayer(args[0]);
            if (target != null) {
                target.setHome(player.getLocation());
                if (target.isOnline()) {
                    sendTranslatedMessage((Player)target, ChatFormat.YELLOW, "home set by other", player.getName());
                }
                sendTranslatedMessage(player, ChatFormat.YELLOW, "home set other", target.getName());
            }
            else {
                sendTranslatedNotice(player, "unknown player", args[0]);
            }
        }
        else {
            player.setHome(player.getLocation());
            sendTranslatedMessage(player, ChatFormat.YELLOW, "home set");
        }
    }
}
