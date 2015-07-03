package net.canarymod.api.entity.living.humanoid.npc;

import net.canarymod.api.entity.living.humanoid.NonPlayableCharacter;
import net.canarymod.api.entity.living.humanoid.npc.ai.NPCAI;
import net.canarymod.hook.HookExecutionException;

import java.lang.reflect.Method;

/**
 * Internal use class for registering a {@link net.canarymod.api.entity.living.humanoid.NonPlayableCharacter} to
 * a {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener} and used to call the apporate AI event methods
 *
 * @author Jason (darkdiplomat)
 */
final class NPCBehaviorRegisteredListener {
    private final NPCBehaviorListener listener;
    private final NonPlayableCharacter npc;
    private final Method method;

    NPCBehaviorRegisteredListener(final NPCBehaviorListener listener, final NonPlayableCharacter npc, final Method method) {
        this.listener = listener;
        this.npc = npc;
        this.method = method;
    }

    final boolean isFor(NonPlayableCharacter npc) {
        return this.npc.equals(npc);
    }

    void execute(NPCAI npcai) {
        try {
            method.invoke(listener, npcai);
        }
        catch (Throwable thrown) {
            throw new HookExecutionException(String.format("Failed to execute NPCAI (NPC:'%s' Listener:'%s')", npc, listener.getClass().getName()), thrown);
        }
    }

    /**
     * Gets the Listener associated with this registered listener entry.
     *
     * @return The {@link NPCBehaviorListener}
     */
    public NPCBehaviorListener getListener() {
        return this.listener;
    }
}
