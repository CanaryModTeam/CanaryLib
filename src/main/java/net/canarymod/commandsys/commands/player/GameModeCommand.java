package net.canarymod.commandsys.commands.player;

import net.canarymod.api.GameMode;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.chat.ReceiverType;
import net.canarymod.commandsys.NativeCommand;

import static net.canarymod.Translator.sendTranslatedNotice;
import static net.canarymod.Translator.sendTranslatedMessage;

/**
 * GameMode command executor
 *
 * @author Matt (MrZoraman)
 */
public final class GameModeCommand implements NativeCommand {
    // gamemode <mode> <player> | alias mode

    @Override
    public void execute(MessageReceiver caller, String[] parameters) {
        if(parameters.length < 1) {
            Canary.help().getHelp(caller, "gamemode");
            return;
        }
        
        GameMode gameMode = null;
        try {
            gameMode = GameMode.fromId(Integer.parseInt(parameters[0]));
        }
        catch (NumberFormatException e) {
            try {
                gameMode = GameMode.valueOf(parameters[0].toUpperCase());
            }
            catch (IllegalArgumentException ex) {
                sendTranslatedNotice(caller, "game mode invalid", parameters[0]);
                return;
            }
        }
        
        assert(gameMode != null);
        
        String targetName;
        if (parameters.length > 1) {
            targetName = parameters[1];
        }
        else if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
            targetName = ((Player) caller).getName();
        }
        else {
            sendTranslatedNotice(caller, "game mode cannot have");
            return;
        }
        
        Player[] targets = Canary.playerSelector().matchPlayers(caller, targetName);
        Player target = Canary.getServer().matchPlayer(targetName);
        if (targets != null && targets.length > 0) {
            for (Player player : targets) {
                tryChangeGameMode(caller, player, gameMode);
            }
        }
        else if (target != null) {
            tryChangeGameMode(caller, target, gameMode);
        }
        else {
            sendTranslatedNotice(caller, "unknown player", targetName);
        }
    }
    
    /**
     * Attempts to change a player's game mode. Sends messages to the player and caller accordingly
     * @param caller The command sender who called this command
     * @param player The target of the command
     * @param gameMode The game mode to change the player to
     */
    private void tryChangeGameMode(MessageReceiver caller, Player player, GameMode gameMode) {
        if(!callerHasControlOverPlayer(caller, player)) {
            sendTranslatedNotice(caller, "game mode nocontrol");
        }
        else if(updateGameMode(player, gameMode)) {
            sendTranslatedMessage(player, "game mode changed player", gameMode.toString().toLowerCase());
            if(player != caller) {
                sendTranslatedMessage(caller, "game mode changed", player.getName(), gameMode.toString().toLowerCase());
            }
        }
        else {
            sendTranslatedNotice(caller, "game mode already has", player.getName(), gameMode.toString().toLowerCase());
        }
    }
    
    /**
     * Updates the player's game mode
     * @param player The player whose game mode needs to be updated
     * @param gamemode The player's new game mode
     * @return True if the game mode was changed, false if the player already had that game mode
     */
    private boolean updateGameMode(Player player, GameMode gameMode) {
        GameMode priorMode = player.getMode();
        if(priorMode.equals(gameMode)) {
            return false;
        }
        else {
            player.setMode(gameMode);
            return true;
        }
    }
    
    /**
     * Checks if the caller has control over a player
     * @param caller The caller to check
     * @param player The player to check
     * @return  True if the caller has control over the player, False if not
     */
    private boolean callerHasControlOverPlayer(MessageReceiver caller, Player player) {
        if (caller.getReceiverType().equals(ReceiverType.PLAYER)) {
            Player c = (Player) caller;
            if (!c.getGroup().hasControlOver(player.getGroup())) {
                return false;
            }
        }
        return true;
    }
}
