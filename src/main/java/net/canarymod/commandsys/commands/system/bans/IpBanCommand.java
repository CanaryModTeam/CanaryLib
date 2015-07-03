package net.canarymod.commandsys.commands.system.bans;

import net.canarymod.Canary;
import net.canarymod.ToolBox;
import net.canarymod.Translator;
import net.canarymod.api.PlayerReference;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.bansystem.Ban;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.hook.player.BanHook;
import net.visualillusionsent.utils.IPAddressUtils;
import net.visualillusionsent.utils.StringUtils;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to ban players by ip
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public class IpBanCommand implements NativeCommand {

    public void execute(MessageReceiver caller, String[] parameters) {
        if (parameters.length < 1) {
            Canary.help().getHelp(caller, "ipban");
            return;
        }

        PlayerReference ref = Canary.getServer().matchKnownPlayer(parameters[0]);
        if (ref == null && !IPAddressUtils.isIPv4Address(parameters[0])) {
            caller.notice(Translator.translate("ban failed") + " " + Translator.translateAndFormat("unknown player", parameters[0]));
            return;
        }
        Ban ban = new Ban();
        String reason = "Permanently Banned";
        long timestamp = -1L;

        if (parameters.length >= 2) {
            try {
                timestamp = ToolBox.parseTime(Long.parseLong(parameters[parameters.length - 1]), parameters[parameters.length]);
                reason = StringUtils.joinString(parameters, " ", 2, parameters.length - 1);
            }
            catch (NumberFormatException e) {
                reason = StringUtils.joinString(parameters, " ", 1);
                timestamp = -1L;
            }
        }
        ban.setReason(reason);
        ban.setExpiration(timestamp);
        ban.setBanningPlayer(caller.getName());
        ban.setIsIpBan(true);
        if (ref != null) {
            ban.setUUID(ref.getUUIDString());
            ban.setSubject(ref.getName());
            ban.setIp(ref.getIP());
        }
        else {
            ban.setIp(parameters[0]);
        }

        Canary.bans().issueBan(ban);
        Canary.hooks().callHook(new BanHook(ref != null ? ref : null, ref != null ? ref.getIP() : parameters[0], caller, reason, timestamp));
        sendTranslatedNotice(caller, "ipban banned", parameters[0]);
        if (ref != null && ref.isOnline() && ref instanceof Player) {
            ((Player)ref).kick(reason);
        }
    }
}
