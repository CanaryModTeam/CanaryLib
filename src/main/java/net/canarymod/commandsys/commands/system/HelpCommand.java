package net.canarymod.commandsys.commands.system;

import net.canarymod.Canary;
import net.canarymod.Translator;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.ChatFormat;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;

import java.util.Arrays;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * Command to access help about all commands
 *
 * @author Chris (damagefilter)
 */
public class HelpCommand implements NativeCommand {

    public void execute(MessageReceiver caller, String[] parameters) {
        if (caller instanceof Player) {
            player((Player)caller, parameters);
        }
        else {
            console(caller, parameters);
        }
    }

    private void console(MessageReceiver caller, String[] args) {
        int page = 1;
        String[] searchTerms = null;
        boolean singleHelp = false;
        if (args.length == 2) {
            singleHelp = true;
            if (args[1].matches("\\d+")) {
                page = Integer.parseInt(args[1]);
            }
            else {
                searchTerms = Arrays.copyOfRange(args, 1, 2);
            }
        }
        else if (args.length > 2) {
            if (args[args.length - 1].matches("\\d+")) {
                page = Integer.parseInt(args[args.length - 1]);
                searchTerms = Arrays.copyOfRange(args, 1, args.length - 1);
            }
            else {
                searchTerms = Arrays.copyOfRange(args, 1, args.length);
            }
        }
        List<String> lines;
        if (searchTerms == null) {
            lines = Canary.help().getHelp(null, page);
        }
        else {
            if (singleHelp) {
                Canary.help().getHelp(caller, searchTerms[0]);
                return;
            }
            lines = Canary.help().getHelp(null, searchTerms, page);
        }

        if (lines == null) {
            log.info(Translator.translate("help not found"));
            return;
        }
        // Send all lines
        for (String l : lines) {
            log.info(ChatFormat.removeFormatting(l));
        }
    }

    private void player(Player player, String[] args) {
        int page = 1;
        String[] searchTerms = null;
        boolean singleHelp = false;
        if (args.length == 2) {
            singleHelp = true;
            if (args[1].matches("\\d+")) {
                page = Integer.parseInt(args[1]);
            }
            else {
                searchTerms = Arrays.copyOfRange(args, 1, 2);
            }
        }
        else if (args.length > 2) {
            if (args[args.length - 1].matches("\\d+")) {
                page = Integer.parseInt(args[args.length - 1]);
                searchTerms = Arrays.copyOfRange(args, 1, args.length - 1);
            }
            else {
                searchTerms = Arrays.copyOfRange(args, 1, args.length);
            }
        }
        List<String> lines;
        if (searchTerms == null) {
            lines = Canary.help().getHelp(player, page);
        }
        else {
            if (singleHelp) {
                Canary.help().getHelp(player, searchTerms[0]);
                return;
            }
            lines = Canary.help().getHelp(player, searchTerms, page);
        }

        if (lines == null) {
            player.notice(Translator.translate("help not found"));
            return;
        }

        // Send all the fancy pre-formatted lines
        for (String l : lines) {
            player.message(l);
        }
    }
}
