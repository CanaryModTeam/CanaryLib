package net.canarymod.api.entity.living.humanoid.npc;

import com.google.common.collect.ArrayListMultimap;
import net.canarymod.ToolBox;
import net.canarymod.api.entity.living.humanoid.NonPlayableCharacter;
import net.canarymod.api.entity.living.humanoid.npc.ai.NPCAI;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static net.canarymod.Canary.log;

/**
 * @author Jason (darkdiplomat)
 */
public final class NPCBehaviorRegistry {
    private final static ArrayListMultimap<Class<? extends NPCAI>, NPCBehaviorRegisteredListener> registered = ArrayListMultimap.create();

    /**
     * Registers a new {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener}
     *
     * @param listener
     *         the {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener} to be added
     * @param npc
     *         the {@link net.canarymod.api.entity.living.humanoid.NonPlayableCharacter} associated with the listener
     * @param force
     *         {@code true} to override existing keys if existant; {@code false} to error out on duplicate keys (recommended)
     */
    public static void registerNPCListener(final NPCBehaviorListener listener, final NonPlayableCharacter npc, final boolean force) {
        synchronized (registered) {
            Method[] methods = ToolBox.safeArrayMerge(listener.getClass().getMethods(), listener.getClass().getDeclaredMethods(), new Method[1]);
            for (final Method method : methods) {
                // Check if the method is a NPCBehavior handling method
                final NPCBehavior handler = method.getAnnotation(NPCBehavior.class);

                if (handler == null) {
                    continue; // Next, not one of our things
                }
                // Check the parameters for number and type and decide if it's one
                // that is really a handler method
                Class<?>[] parameters = method.getParameterTypes();

                if (parameters.length != 1) {
                    throw new NpcAiListenerMethodConsistancyException("Amount of parameters for " + method.getName() + " is invalid. Expected 1, was " + parameters.length);
                }
                Class<?> npcAICls = parameters[0];

                if (!NPCAI.class.isAssignableFrom(npcAICls)) {
                    throw new NpcAiListenerMethodConsistancyException("NPCAI is not assignable from " + npcAICls.getName());
                }

                // We checked the class above, ignore unchecked warnings.
                registered.put((Class<? extends NPCAI>)npcAICls, new NPCBehaviorRegisteredListener(listener, npc, method));
            }
        }
    }

    /**
     * Unregisters a {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener}
     *
     * @param listener
     *         the listener to unregister
     */
    public static void unregister(NPCBehaviorListener listener) {
        synchronized (registered) {
            Iterator<NPCBehaviorRegisteredListener> itr = registered.values().iterator();
            while (itr.hasNext()) {
                NPCBehaviorRegisteredListener nbrl = itr.next();
                if (nbrl.equals(listener)) {
                    itr.remove();
                    return;
                }
            }
        }
    }

    /**
     * Unregisters a {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener} using the associated {@link net.canarymod.api.entity.living.humanoid.NonPlayableCharacter}
     *
     * @param npc
     *         the npc associated with the listener to be unregistered
     */
    public static void unregister(NonPlayableCharacter npc) {
        synchronized (registered) {
            Iterator<NPCBehaviorRegisteredListener> itr = registered.values().iterator();
            while (itr.hasNext()) {
                NPCBehaviorRegisteredListener nbrl = itr.next();
                if (nbrl.isFor(npc)) {
                    itr.remove();
                }
            }
        }
    }

    /**
     * Gets the Registered {@link NPCBehaviorListener} for manipulation.
     *
     * @param clazz
     *         The class type of the {@link NPCBehaviorListener} you wish
     *         to get.
     * @param npc
     *         The {@link NonPlayableCharacter} for which the {@link NPCBehaviorListener}
     *         should be registered to.
     *
     * @return The {@link NPCBehaviorListener}  or null if one of that type is
     * not registered to the given {@link NonPlayableCharacter}
     */
    public static NPCBehaviorListener getRegisteredListener(Class<? extends NPCBehaviorListener> clazz, NonPlayableCharacter npc) {
        NPCBehaviorListener listener = null;
        synchronized (registered) {
            Iterator<NPCBehaviorRegisteredListener> itr = registered.values().iterator();
            while (itr.hasNext()) {
                NPCBehaviorRegisteredListener nbrl = itr.next();
                if (nbrl.isFor(npc) && clazz.equals(nbrl.getListener().getClass())) {
                    listener = nbrl.getListener();
                    break;
                }
            }
        }
        return listener;
    }

    /**
     * Gets a list of all the Registered {@link NPCBehaviorListener} for manipulation.
     *
     * @param npc
     *         The {@link NonPlayableCharacter} for which the {@link NPCBehaviorListener}
     *         should be registered to.
     *
     * @return The list of {@link NPCBehaviorListener} registered to the given {@link NonPlayableCharacter}
     */
    public static List<NPCBehaviorListener> getRegisteredListeners(NonPlayableCharacter npc) {
        List<NPCBehaviorListener> listeners = new ArrayList<NPCBehaviorListener>();
        synchronized (registered) {
            Iterator<NPCBehaviorRegisteredListener> itr = registered.values().iterator();
            while (itr.hasNext()) {
                NPCBehaviorRegisteredListener nbrl = itr.next();
                if (nbrl.isFor(npc)) {
                    listeners.add(nbrl.getListener());
                }
            }
        }
        return listeners;
    }

    /**
     * Parses a NPC AI Event to the {@link net.canarymod.api.entity.living.humanoid.npc.NPCBehaviorListener}s
     *
     * @param npc
     *         the {@link net.canarymod.api.entity.living.humanoid.NonPlayableCharacter} the event is called for
     * @param npcai
     *         the AI event called
     */
    public static void execute(NonPlayableCharacter npc, NPCAI npcai) {
        synchronized (registered) {
            if (!registered.containsKey(npcai.getClass())) {
                return;
            }

            Iterator<NPCBehaviorRegisteredListener> iter = registered.get(npcai.getClass()).iterator();
            while (iter.hasNext()) {
                NPCBehaviorRegisteredListener listener = iter.next();
                if (listener.isFor(npc)) {
                    try {
                        listener.execute(npcai);
                    }
                    catch (NPCAIExcutionException npcaieex) {
                        log.error("", npcaieex.getCause());
                    }
                }
            }
        }
    }
}
