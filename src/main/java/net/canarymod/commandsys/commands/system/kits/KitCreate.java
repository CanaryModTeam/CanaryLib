package net.canarymod.commandsys.commands.system.kits;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.Item;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.kit.Kit;
import net.canarymod.user.Group;

import java.util.ArrayList;
import java.util.Arrays;

import static net.canarymod.Translator.sendTranslatedMessage;
import static net.canarymod.Translator.sendTranslatedNotice;
import static net.canarymod.Translator.translate;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$GROUP;
import static net.canarymod.commandsys.CanaryCommandPermissions.KIT$PRIVATE;

/**
 * /kit create
 *
 * @author Jason Jones (darkdiplomat)
 */
public class KitCreate implements NativeCommand {

    @Override
    public void execute(MessageReceiver caller, String[] args) {
        if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
            Player player = caller.asPlayer();
            // Default public kit
            if (args.length == 2) {
                Kit newKit = new Kit();

                newKit.setContent(new ArrayList<Item>(Arrays.asList(player.getInventory().getContents())));
                newKit.setDelay(Integer.parseInt(args[1]));
                newKit.setName(args[0]);
                Canary.kits().addKit(newKit);
                sendTranslatedMessage(caller, ChatFormat.YELLOW, "kit created", args[0]);
                return;
            }
            else if (args.length >= 4) {
                // ADD GROUPS KIT
                if (args[2].equalsIgnoreCase("G") && player.hasPermission(KIT$GROUP)) {
                    String[] groups = new String[args.length - 3];

                    for (int i = 0; i < groups.length; i++) {
                        Group g = Canary.usersAndGroups().getGroup(args[i + 3]);

                        if (g != null) {
                            groups[i] = g.getName();
                        }
                        else {
                            groups[i] = Canary.usersAndGroups().getDefaultGroup().getName();
                        }
                    }
                    Kit newKit = new Kit();

                    newKit.setContent(new ArrayList<Item>(Arrays.asList(player.getInventory().getContents())));
                    newKit.setDelay(Integer.parseInt(args[1]));
                    newKit.setName(args[0]);
                    newKit.setGroups(groups);
                    Canary.kits().addKit(newKit);
                    sendTranslatedMessage(caller, ChatFormat.YELLOW, "kit created group", args[0]);
                    return;
                }
                // ADD PLAYER PRIVATE KIT
                else if (args[2].equalsIgnoreCase("P") && player.hasPermission(KIT$PRIVATE)) {
                    String[] players = new String[args.length - 3];

                    System.arraycopy(args, 3, players, 0, players.length);
                    Kit newKit = new Kit();

                    newKit.setContent(new ArrayList<Item>(Arrays.asList(player.getInventory().getContents())));
                    newKit.setDelay(Integer.parseInt(args[1]));
                    newKit.setName(args[0]);
                    newKit.setOwner(players);
                    Canary.kits().addKit(newKit);
                    sendTranslatedMessage(caller, ChatFormat.YELLOW, "kit created private", args[0]);
                    return;
                }
            }
            sendTranslatedNotice(caller, "usage", "/kit create <name> <use delay> [G|P Groups|Players]" + " - " + translate("kit from inventory"));
        }
        else {
            caller.notice("Cannot run command from Console/CommandBlock");
        }
    }
}
