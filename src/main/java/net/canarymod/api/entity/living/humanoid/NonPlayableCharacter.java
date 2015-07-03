package net.canarymod.api.entity.living.humanoid;

import net.canarymod.api.PathFinder;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener;

import java.util.List;

/**
 * Non-Playable Character interface
 *
 * @author Jason (darkdiplomat)
 */
public interface NonPlayableCharacter extends Human {

    /**
     * Tell the NPC to look at nearest player
     */
    void lookAtNearest();

    /**
     * Shows the NPC to the specified Player
     *
     * @param player
     *         the {@link Player} to be shown the NPC
     */
    void haunt(Player player);

    /**
     * Hides the NPC from specified Player
     *
     * @param player
     *         the Player to hide from
     */
    void ghost(Player player);

    /**
     * De-spawn the NPC and return its reference for further processing.
     * This does not DELETE this entity, it stays there, its just no longer shown
     *
     * @return the NonPlayableCharacter instance
     */
    NonPlayableCharacter despawn();

    /**
     * Sends a message as the NonPlayableCharacter
     *
     * @param msg
     *         the Message to send
     */
    void chat(String msg);

    /**
     * Sends a private message as the NonPlayerCharacter to the specified Player
     *
     * @param player
     *         the {@link Player} to pm
     * @param msg
     *         the message to send
     */
    void privateMessage(Player player, String msg);

    /**
     * Attacks for the NonPlayableCharacter the targeted entity with the
     * currently equipped item.
     *
     * @param entity
     *         Entity to attack.
     */
    void attackEntity(Entity entity);

    /**
     * Get the {@link PathFinder} class for this Entity.
     *
     * @return the pathfinder
     */
    PathFinder getPathFinder();

    /**
     * Gets the {@link NPCBehaviorListener} for this NonPlayableCharacter of the
     * given class type.
     *
     * @return the {@link NPCBehaviorListener} or null if one of this type is not
     * Registered to this NPC.
     */
    NPCBehaviorListener getRegisteredListener(Class<? extends NPCBehaviorListener> clazz);

    /**
     * Gets the list of {@link NPCBehaviorListener} for this NonPlayableCharacter
     *
     * @return the list of {@link NPCBehaviorListener}s
     *
     * @deprecated in favour of getRegisteredListeners();
     */
    @Deprecated
    List<NPCBehaviorListener> geRegisteredListeners();

    /**
     * Gets the list of {@link NPCBehaviorListener} for this NonPlayableCharacter
     *
     * @return the list of {@link NPCBehaviorListener}s
     */
    List<NPCBehaviorListener> getRegisteredListeners();
}
