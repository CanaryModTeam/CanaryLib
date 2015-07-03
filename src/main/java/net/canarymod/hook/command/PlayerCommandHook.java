package net.canarymod.hook.command;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;
import net.visualillusionsent.utils.StringUtils;

/**
 * Player command hook. Contains a player and a command String Array
 *
 * @author Chris (damagefilter)
 */
public final class PlayerCommandHook extends CancelableHook {
    private final Player player;
    private final String[] command;

    /**
     * Constructs a new PlayerCommandHook
     *
     * @param player
     *         the {@link Player} executing the commmand
     * @param textInput
     *         the text input from the {@link Player}
     */
    public PlayerCommandHook(Player player, String[] textInput) {
        this.player = player;
        command = textInput;
    }

    /**
     * Get command that was issued by the {@link Player}
     *
     * @return String array of arguments
     */
    public String[] getCommand() {
        return command;
    }

    /**
     * Get the {@link Player} who issued this command
     *
     * @return the Player
     */
    public Player getPlayer() {
        return player;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Command=%s]", getHookName(), player, StringUtils.joinString(command, " ", 0));
    }
}
