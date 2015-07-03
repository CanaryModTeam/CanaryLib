package net.canarymod.commandsys.commands.world;

import net.canarymod.Canary;
import net.canarymod.api.world.DimensionType;
import net.canarymod.api.world.WorldManager;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.NativeCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.canarymod.Translator.sendTranslatedNotice;

/**
 * Checks for and unloads a World
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class UnloadWorldCommand implements NativeCommand {
    private final Matcher matcher = Pattern.compile(".+_\\w+").matcher("");

    public final void execute(MessageReceiver caller, String[] parameters) {
        try {
            WorldManager manage = Canary.getServer().getWorldManager();
            String worldName = parameters[0];
            String fqName = parameters[0];
            String dim = parameters.length > 1 ? parameters[1].toUpperCase() : "";
            DimensionType type = null;

            if (matcher.reset(worldName).matches()) {
                dim = worldName.substring(worldName.lastIndexOf('_') + 1);
                worldName = worldName.substring(0, worldName.lastIndexOf('_'));
                type = DimensionType.fromName(dim);
            }
            else if (parameters.length > 1) {
                if (parameters[1].matches("\\d")) {
                    type = DimensionType.fromId(Integer.parseInt(dim));
                }
                else {
                    type = DimensionType.fromName(dim);
                }
                fqName = worldName + "_" + type.getName();
            }

            if (type != null) {
                if (manage.worldExists(fqName)) {
                    if (manage.worldIsLoaded(worldName, type)) {
                        manage.unloadWorld(worldName, type, true);
                        caller.notice("World Unloaded!");
                    }
                    else {
                        caller.notice("World wasn't loaded...");
                    }
                }
                else {
                    sendTranslatedNotice(caller, "unknown world", parameters[0]);
                }
            }
            else {
                sendTranslatedNotice(caller, "unknown dimension", dim);
            }
        }
        catch (Exception ex) {
            caller.notice("Failed to unload '" + parameters[0] + "'. See console for error.");
            Canary.log.error("Error executing command '/world unload (/unloadworld)' for caller '" + caller.getName() + "'", ex);
        }
    }
}
