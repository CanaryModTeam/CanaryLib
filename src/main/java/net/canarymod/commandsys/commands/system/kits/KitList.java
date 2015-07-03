package net.canarymod.commandsys.commands.system.kits;

import com.google.common.collect.Lists;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.kit.Kit;

import java.util.Collections;
import java.util.List;

/**
 * /kit list
 *
 * @author Jason Jones (darkdiplomat)
 */
public class KitList implements NativeCommand {

    @Override
    public void execute(MessageReceiver caller, String[] parameters) {
        boolean notPlayer = !caller.getReceiverType().equals(ReceiverType.PLAYER);
        caller.message(ChatFormat.YELLOW + "Available Kits: ");
        List<Kit> kits = Canary.kits().getAllKits();
        StringBuilder kitList = new StringBuilder();

        for (Kit k : kits) {
            List<String> groups = Lists.newArrayList();
            if (k.getGroups() != null) {
                Collections.addAll(groups, k.getGroups());
            }
            if (notPlayer || groups.contains(((Player)caller).getGroup().getName()) || ((Player)caller).isAdmin()) {
                kitList.append(k.getName()).append(",");
            }
        }
        caller.message(kitList.toString());
    }
}
