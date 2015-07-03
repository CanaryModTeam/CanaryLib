package net.canarymod.hook.player;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.Hook;

/**
 * Disconnection hook. Contains information about a {@link Player} disconnecting.
 *
 * @author Jason (darkdiplomat)
 */
public final class DisconnectionHook extends Hook {

    private Player player;
    private String reason, leave;
    private boolean hidden;

    public DisconnectionHook(Player player, String reason, String leave) {
        this.player = player;
        this.reason = reason;
        this.leave = leave;
    }

    /**
     * Gets the {@link Player} disconnected
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the reason for disconnect (if applicable)
     *
     * @return reason if disconnecting, null otherwise
     */
    public String getReason() {
        return reason;
    }

    /**
     * Set the reason for disconnection that will be displayed
     *
     * @param reason
     *         the reason for disconnection
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets the LeaveMessage
     *
     * @return leaveMessage
     */
    public String getLeaveMessage() {
        return this.leave;
    }

    /**
     * Sets the LeaveMessage
     *
     * @param leave
     *         the leave message to set
     */
    public void setLeaveMessage(String leave) {
        this.leave = leave;
    }

    /**
     * Gets whether this should be a hidden connect/disconnect
     *
     * @return {@code true} for hidden; {@code false} for not
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets whether this should be a hidden connect/disconnect
     *
     * @param hidden
     *         {@code true} for hiding message; {@code false} for not
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Reason=%s, Leave=%s, Hidden=%s]", getHookName(), player, reason, leave, hidden);
    }
}
