package net.canarymod.commandsys.commands.system;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Position;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.plugin.Plugin;
import net.canarymod.user.Group;
import net.canarymod.warp.Warp;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import static net.canarymod.Translator.sendTranslatedMessage;
import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to view multiple types of info about a player (possible yourself)
 *
 * @author Jason (darkdiplomat)
 */
public final class PlayerInformation implements NativeCommand {
    private static final ConcurrentLinkedQueue<PlayerInfoAddition> extraData = new ConcurrentLinkedQueue<PlayerInfoAddition>();

    @Override
    public void execute(MessageReceiver caller, String[] args) {
        if (caller.getReceiverType() != ReceiverType.PLAYER && args.length == 0) {
            sendTranslatedNotice(caller, "target not specified");
            return;
        }

        PlayerReference subject;
        if (args.length == 1) {
            subject = Canary.getServer().matchKnownPlayer(args[0]);
        }
        else {
            subject = (Player)caller;
        }

        if (subject != null) {
            caller.message(ChatFormat.DARK_GREEN.concat(subject.getName()).concat("'s info:"));
            sendData(caller, "playerinfo firstjoin", subject.getFirstJoined());
            sendData(caller, "playerinfo lastjoined", subject.getLastJoined());
            sendData(caller, "playerinfo timeplayed", ToolBox.getTimeUntil(subject.getTimePlayed()));
            sendData(caller, "playerinfo muted", subject.isMuted());
            sendData(caller, "playerinfo prefix", subject.getPrefix());
            sendData(caller, "playerinfo ip", subject.getIP());
            sendData(caller, "playerinfo primarygroup", subject.getGroup().getName());
            sendData(caller, "playerinfo subgroups", subject.getPlayerGroups());
            sendData(caller, "playerinfo health", String.format("%.1f", subject.getHealth()));
            sendData(caller, "playerinfo gamemode", subject.getMode());
            sendData(caller, "playerinfo foodlevel", subject.getHunger());
            sendData(caller, "playerinfo foodexhaustion", String.format("%.2f", subject.getExhaustionLevel()));
            sendData(caller, "playerinfo xplevel", subject.getLevel());
            sendData(caller, "playerinfo xptotal", subject.getExperience());
            Position pos = subject.getPosition();

            sendData(caller, "playerinfo position", String.format("X: %.2f Y: %.2f Z: %.2f", pos.getX(), pos.getY(), pos.getZ()));
            sendData(caller, "playerinfo world", subject.getWorld().getFqName());
            Warp home = Canary.warps().getHome(subject.getName());

            if (home != null) {
                pos = home.getLocation();
                sendData(caller, "playerinfo homeset", String.format("X: %.2f Y: %.2f Z: %.2f", pos.getX(), pos.getY(), pos.getZ()));
            }
            else {
                sendData(caller, "playerinfo homeunset", "");
            }

            // Plugin added information parsing
            synchronized (extraData) {
                Iterator<PlayerInfoAddition> itr = extraData.iterator();
                do {
                    if (!itr.hasNext()) {
                        break;
                    }
                    PlayerInfoAddition data = itr.next();
                    if (!data.canApply()) {
                        itr.remove(); // Clear out dead information
                    }
                    else {
                        String msg = data.applyData(caller, subject);
                        if (msg != null && !msg.trim().isEmpty()) {
                            caller.message(data.applyData(caller, subject));
                        }
                    }
                }
                while (itr.hasNext());
            }
            //
        }
        else {
            sendTranslatedNotice(caller, "unknown player", args[0]);
        }
    }

    private void sendData(MessageReceiver caller, String caption, Group[] data) {
        StringBuilder gnames = new StringBuilder("");
        for (int index = 1; index < data.length; index++) {
            gnames.append(data[index].getName());
        }
        sendTranslatedMessage(caller, ChatFormat.GREEN, caption, ChatFormat.GOLD.concat(gnames.toString()));
    }

    private void sendData(MessageReceiver caller, String caption, Object data) {
        sendTranslatedMessage(caller, ChatFormat.GREEN, caption, ChatFormat.GOLD.concat(String.valueOf(data)));
    }

    public static boolean addInfoAddition(PlayerInfoAddition addition) {
        synchronized (extraData) {
            if (addition == null || extraData.contains(addition)) {
                return false;
            }
            extraData.add(addition);
            return true;
        }
    }

    public static void removeInfoAddition(PlayerInfoAddition addition) {
        synchronized (extraData) {
            extraData.remove(addition);
        }
    }

    public static void removeInfoAdditions(Plugin plugin) {
        synchronized (extraData) {
            Iterator<PlayerInfoAddition> itr = extraData.iterator();
            do {
                if (!itr.hasNext()) {
                    break;
                }
                else if (itr.next().isFor(plugin)) {
                    itr.remove();
                }
            }
            while (itr.hasNext());
        }
    }
}
