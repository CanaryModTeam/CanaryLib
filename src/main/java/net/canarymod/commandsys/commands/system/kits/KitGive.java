package net.canarymod.commandsys.commands.system.kits;

import net.canarymod.Canary;
import net.canarymod.Translator;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.kit.Kit;
import net.canarymod.kit.KitProvider;

import static net.canarymod.Translator.sendTranslatedMessage;
import static net.canarymod.Translator.sendTranslatedNotice;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$OTHER;

/**
 * /kit give
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class KitGive implements NativeCommand {
    private static final KitProvider kits = Canary.kits();

    @Override
    public void execute(MessageReceiver caller, String[] parameters) {
        if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
            asPlayer((Player)caller, parameters);
        }
        else {
            asServer(caller, parameters);
        }
    }

    private enum Result {
        GIVEN,
        UNAVAILABLE,
        INVALID,
        NORECEIVER
    }

    protected void asPlayer(Player player, String[] args) {
        // Give kit to player
        if (args.length == 1) {
            Result result = doGive(player, kits.getKit(args[0]), false);
            switch (result) {
                case GIVEN:
                    sendTranslatedMessage(player, ChatFormat.YELLOW, "kit given");
                    break;
                case UNAVAILABLE:
                    sendTranslatedNotice(player, "kit unavailable");
                    break;
                case INVALID:
                    sendTranslatedNotice(player, "kit invalid", args[0]);
                    break;
            }
        }
        // Give kit to a subject
        else if (args.length > 1) {
            if (!player.hasPermission(KIT$OTHER)) {
                player.notice(Translator.nativeTranslate("commands.generic.permission"));
                return;
            }

            Player recipient = Canary.getServer().matchPlayer(args[1]);
            Result result = doGive(recipient, kits.getKit(args[0]), false);
            switch (result) {
                case GIVEN:
                    sendTranslatedMessage(recipient, ChatFormat.YELLOW, "kit given other", player.getName());
                    break;
                case UNAVAILABLE:
                    sendTranslatedNotice(player, "kit unavailable other", recipient.getName());
                    break;
                case INVALID:
                    sendTranslatedNotice(player, "kit invalid", args[0]);
                    break;
                case NORECEIVER:
                    sendTranslatedNotice(player, "unknown player", args[1]);
                    break;
            }
        }
    }

    protected void asServer(MessageReceiver caller, String[] args) {
        // Give kit to a subject
        if (args.length >= 2) {
            boolean override = args.length > 2 && args[2].toLowerCase().equals("override");

            Player[] selection = Canary.playerSelector().matchPlayers(caller, args[1]);
            if (selection != null && selection.length > 0) {
                for (Player recipient : selection) {
                    Result result = doGive(recipient, kits.getKit(args[0]), override);
                    switch (result) {
                        case GIVEN:
                            sendTranslatedMessage(recipient, ChatFormat.YELLOW, "kit given other", caller.getName());
                            break;
                        case UNAVAILABLE:
                            sendTranslatedNotice(caller, "kit unavailable other", recipient.getName());
                            break;
                        case INVALID:
                            sendTranslatedNotice(caller, "kit invalid", args[0]);
                            break;
                    }
                }
            }
            else {
                Player recipient = Canary.getServer().matchPlayer(args[1]);
                Result result = doGive(recipient, kits.getKit(args[0]), override);
                switch (result) {
                    case GIVEN:
                        sendTranslatedMessage(recipient, ChatFormat.YELLOW, "kit given other", caller.getName());
                        break;
                    case UNAVAILABLE:
                        sendTranslatedNotice(caller, "kit unavailable other", recipient.getName());
                        break;
                    case INVALID:
                        sendTranslatedNotice(caller, "kit invalid", args[0]);
                        break;
                    case NORECEIVER:
                        sendTranslatedNotice(caller, "unknown player", args[1]);
                        break;
                }
            }
        }
        else {
            sendTranslatedNotice(caller, "usage", "/kit give <name> <player> [override]");
        }
    }

    private Result doGive(Player recipient, Kit kit, boolean override) {
        if (recipient != null) {
            if (kit != null) {
                if (kit.giveKit(recipient, override)) {
                    return Result.GIVEN;
                }
                return Result.UNAVAILABLE;
            }
            return Result.INVALID;
        }
        return Result.NORECEIVER;
    }
}
