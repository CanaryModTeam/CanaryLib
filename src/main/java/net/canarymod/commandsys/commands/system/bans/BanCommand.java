package net.canarymod.commandsys.commands.system.bans;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.Translator;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.bansystem.Ban;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.hook.player.BanHook;
import net.visualillusionsent.utils.StringUtils;

import java.util.UUID;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to ban players by name
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public class BanCommand implements NativeCommand {

    public void execute(MessageReceiver caller, String[] parameters) {
        if (parameters.length < 1) {
            Canary.help().getHelp(caller, "ban");
            return;
        }
        boolean isPlayer = caller.getReceiverType().equals(ReceiverType.PLAYER);

        String reason = "Permanently Banned";
        long timestamp = -1L;

        if (parameters.length >= 3) {
            try {
                timestamp = ToolBox.getUnixTimestamp() +
                        ToolBox.parseTime(Long.parseLong(parameters[parameters.length - 2]), parameters[parameters.length - 1]);
                if (parameters.length > 3) {
                    // There is also a reason then
                    reason = StringUtils.joinString(parameters, " ", 1, parameters.length - 3);
                }
                else {
                    reason = "Temporarily banned until " + ToolBox.formatTimestamp(timestamp);
                }
            }
            catch (NumberFormatException e) {
                timestamp = -1L;
                try {
                    reason = StringUtils.joinString(parameters, " ", 1);
                }
                catch (Exception f) {
                    reason = "Permanently Banned";
                }
            }
        }

        Player[] playerSelectorArray = Canary.playerSelector().matchPlayers(caller, parameters[0]);
        if (playerSelectorArray != null) {
            if (playerSelectorArray.length > 0) {
                for (Player p : playerSelectorArray) {
                    if (isPlayer) {
                        Player c = (Player)caller;
                        if (!c.getGroup().hasControlOver(p.getGroup())) {
                            continue;
                        }
                    }
                    Ban ban = new Ban();
                    ban.setReason(reason);
                    ban.setExpiration(timestamp);
                    ban.setBanningPlayer(caller.getName());
                    ban.setUUID(p.getUUIDString());
                    ban.setSubject(p.getName());
                    Canary.bans().issueBan(ban);
                    Canary.hooks().callHook(new BanHook(p, p.getIP(), caller, reason, timestamp));
                    sendTranslatedNotice(caller, "ban banned", p.getName());
                    p.kick(reason);
                }
            }
            else {
                if (!attemptPlayerBan(caller, parameters[0], reason, timestamp, isPlayer)) { // Targeting may have done something stupid

                    // Person not found on the server. Look remotely
                    UUID uuid = ToolBox.uuidFromUsername(parameters[0]);
                    if (uuid == null) {
                        caller.notice(Translator.translateAndFormat("ban invalid user", parameters[0]));
                        return;
                    }

                    Ban ban = new Ban();
                    ban.setReason(reason);
                    ban.setExpiration(timestamp);
                    ban.setBanningPlayer(caller.getName());
                    ban.setUUID(uuid.toString());
                    ban.setSubject(parameters[0]);
                    Canary.bans().issueBan(ban);

                    // NOTE: Ban hook cannot be issued here, there is no player instance
                    sendTranslatedNotice(caller, "ban banned", parameters[0]);
                }
            }
        }
        else {
            attemptPlayerBan(caller, parameters[0], reason, timestamp, isPlayer);
        }
    }

    private boolean attemptPlayerBan(MessageReceiver caller, String name, String reason, long timestamp, boolean isPlayer) {
        PlayerReference ref = Canary.getServer().matchKnownPlayer(name);
        if (ref == null) {
            return false;
        }
        if (isPlayer) {
            Player c = (Player)caller;
            if (!c.getGroup().hasControlOver(ref.getGroup())) {
                sendTranslatedNotice(caller, "ban nocontrol", caller.getLocale());
                return true;
            }
        }

        Ban ban = new Ban();
        ban.setReason(reason);
        ban.setExpiration(timestamp);
        ban.setBanningPlayer(caller.getName());
        ban.setUUID(ref.getUUIDString());
        ban.setSubject(ref.getName());
        Canary.bans().issueBan(ban);
        Canary.hooks().callHook(new BanHook(ref, ref.getIP(), caller, reason, timestamp));
        sendTranslatedNotice(caller, "ban banned", ref.getName());
        if (ref.isOnline() && ref instanceof Player) {
            ((Player)ref).kick(reason);
        }
        return true;
    }
}
