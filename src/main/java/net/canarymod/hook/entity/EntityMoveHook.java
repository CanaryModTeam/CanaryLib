package net.canarymod.hook.entity;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.position.Location;
import net.canarymod.hook.CancelableHook;
import net.canarymod.hook.player.PlayerMoveHook;

/**
 * Entity Move Hook
 * <p/>
 * Called when an {@link Entity} (other than a {@link Player}) moves.<br>
 * Use {@link PlayerMoveHook} for Player movements.
 *
 * @author Jason (darkdiplomat)
 * @see PlayerMoveHook
 */
public final class EntityMoveHook extends CancelableHook {
    private Entity entity;
    private Location from;

    public EntityMoveHook(Entity entity, Location from) {
        this.entity = entity;
        this.from = from;
    }

    public Entity getEntity() {
        return entity;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return entity.getLocation();
    }

    @Override
    public final String toString() {
        return String.format("%s[Entity=%s, From=%s, To=%s]", getHookName(), getEntity(), getFrom(), getTo());
    }
}
