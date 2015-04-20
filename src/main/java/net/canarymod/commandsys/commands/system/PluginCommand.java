package net.canarymod.commandsys.commands.system;

import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;
import net.canarymod.exceptions.InvalidPluginException;
import net.canarymod.exceptions.PluginLoadFailedException;
import org.slf4j.LoggerFactory;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Command to enable, disable or reload plugins
 *
 * @author Chris (damagefilter)
 */
public class PluginCommand implements NativeCommand {
    private final boolean disable;
    private final boolean reload;
    private final boolean permanent = false;

    public PluginCommand(boolean disable, boolean reload) {
        this.reload = reload;
        this.disable = !reload && disable;
    }

    public void execute(MessageReceiver caller, String[] parameters) {
        String plugin = parameters[0];

        if (reload) {
            reload(caller, plugin);
        }
        else {
            if (disable) {
                disable(caller, plugin, permanent);
            }
            else {
                enable(caller, plugin);
            }
        }
    }

    private void reload(MessageReceiver caller, String plugin) {
        try {
            if (Canary.pluginManager().reloadPlugin(plugin)) {
                sendTranslatedNotice(caller, "plugin reloaded", plugin);
            }
            else {
                sendTranslatedNotice(caller, "plugin reloaded fail", plugin);
            }
        }
        catch (PluginLoadFailedException e) {
            sendTranslatedNotice(caller, "plugin enabled fail", plugin);
            LoggerFactory.getLogger("pluginCommand").error("Failed to load plugin", e);
        }
        catch (InvalidPluginException e) {
            sendTranslatedNotice(caller, "plugin enabled fail", plugin);
            LoggerFactory.getLogger("pluginCommand").error("Failed to load plugin", e);
        }
    }

    private void enable(MessageReceiver caller, String plugin) {
        try {
            if (Canary.pluginManager().enablePlugin(plugin)) {
                sendTranslatedNotice(caller, "plugin enabled", plugin);
            }
            else {
                sendTranslatedNotice(caller, "plugin enabled fail", plugin);
            }
        }
        catch (PluginLoadFailedException e) {
            sendTranslatedNotice(caller, "plugin enabled fail", plugin);
            LoggerFactory.getLogger("pluginCommand").error("Failed to load plugin", e);
        }
    }

    private void disable(MessageReceiver caller, String plugin, boolean permanent) {
        if (Canary.pluginManager().disablePlugin(plugin)) {
            //TODO: Permanent flag in canary
            if (permanent) {
//                Canary.manager().moveToDisabled(plugin);
            }
            sendTranslatedNotice(caller, "plugin disabled", plugin);
        }
        else {
            sendTranslatedNotice(caller, "plugin disabled fail", plugin);
        }
    }

    /**
     * Check if we have a permanent disable/enable requests
     *
     * @param params
     *
     * @return
     */
    private boolean getPermanentParameter(String[] params) {
        return params[params.length - 2].equalsIgnoreCase("-p");
    }
}
