package net.canarymod.hook.player;

import net.canarymod.Canary;
import net.canarymod.api.DamageSource;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Player Death hook
 *
 * @author Jason (darkdiplomat)
 */
public final class PlayerDeathHook extends Hook {
    private Player player;
    private DamageSource source;
    private ChatComponent msg;

    /**
     * Constructs a new PlayerDeathHook
     *
     * @param player
     *         the {@link Player} that died
     * @param source
     *         the {@link DamageSource} that killed the {@link Player}
     * @param msg
     *         the Death message to send all if DeathMessages aren't disabled
     */
    public PlayerDeathHook(Player player, DamageSource source, ChatComponent msg) {
        this.player = player;
        this.msg = msg;
        this.source = source;
    }

    /**
     * Gets the {@link Player} who died
     *
     * @return the dead {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the message to send on Death
     *
     * @return the death message
     *
     * @deprecated Replaced by #getDeathMessage1
     */
    @Deprecated
    public String getDeathMessage() {
        return msg.getFullText();
    }

    /**
     * Gets the {@link net.canarymod.api.chat.ChatComponent} containing the death message
     *
     * @return the ChatComponent containing the death message
     */
    public ChatComponent getDeathMessage1() {
        return msg;
    }

    /**
     * Sets the message to send, if death message are enabled
     *
     * @param msg
     *         the death message
     *
     * @deprecated Replaced by #setDeathMessage1
     */
    @Deprecated
    public void setDeathMessage(String msg) {
        this.msg = Canary.factory().getChatComponentFactory().newChatComponent(msg);
    }

    /**
     * Gets the {@link net.canarymod.api.chat.ChatComponent} containing the death message
     *
     * @param chatComponent
     *         the {@link net.canarymod.api.chat.ChatComponent} containing the death message
     */
    public void setDeathMessage1(ChatComponent chatComponent) {
        this.msg = chatComponent;
    }

    /**
     * Gets the {@link DamageSource} that killed the {@link Player}
     *
     * @return the death dealing {@link DamageSource}
     */
    public DamageSource getDamageSource() {
        return source;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, DamageSource=%s, Message=%s]", getHookName(), player, source, msg);
    }
}
