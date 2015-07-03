package net.canarymod.api.entity.living.humanoid.npc.ai;

import net.canarymod.api.entity.living.humanoid.NonPlayableCharacter;
import net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorRegistry;

/**
 * Abstract container for the NPC AI system
 *
 * @author Jason (darkdiplomat)
 */
public abstract class NPCAI {

    /**
     * Gets the name of the NPC AI class
     *
     * @return NPCAI subclass name
     */
    public final String getName() {
        return "NPCAI." + this.getClass().getSimpleName();
    }

    /**
     * Short cut to calling this AI event
     *
     * @param npc
     *         the NPC the event is taking place for
     */
    public final void call(NonPlayableCharacter npc) {
        NPCBehaviorRegistry.execute(npc, this);
    }
}
