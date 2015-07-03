package net.canarymod.hook.player;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.CancelableHook;

/**
 * Is called when a player right-clicks an entity, for instance a villager for trading or a vehicle for entering
 *
 * @author Chris (damagefilter)
 */
public final class EntityRightClickHook extends CancelableHook {
    private Entity clickedEntity;
    private Player player;

    /**
     * Construct a new EntityRightClickHook
     *
     * @param clicked
     *         the {@link Entity} clicked
     * @param player
     *         the {@link Player} clicking
     */
    public EntityRightClickHook(Entity clicked, Player player) {
        this.clickedEntity = clicked;
        this.player = player;
    }

    /**
     * Get the player who clicked
     *
     * @return the {@link Player}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the entity that was clicked
     *
     * @return the {@link Entity}
     */
    public Entity getEntity() {
        return clickedEntity;
    }

    @Override
    public final String toString() {
        return String.format("%s[Player=%s, Entity=%s]", getHookName(), player, clickedEntity);
    }
}
