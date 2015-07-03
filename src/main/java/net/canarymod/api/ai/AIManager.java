package net.canarymod.api.ai;

/**
 * This class manages AI for Living Entities. Will do nothing for players.
 *
 * @author Aaron (somners)
 */
public interface AIManager {

    /**
     * Adds this instance of the class extending AIBase to be added to the
     * Entity that owns this AIManager.
     *
     * @param priority
     *         priority of this task. Higher numbers are higher priority.
     * @param ai
     *         The class to add.
     *
     * @return True if it was successfully added, false otherwise.
     */
    boolean addTask(int priority, AIBase ai);

    /**
     * Remove the instance of the class extending AIBase from this entities list
     * of AI.
     *
     * @param ai
     *         The Class type to remove
     *
     * @return {@code true} if successfully removed; {@code false} otherwise
     */
    boolean removeTask(Class<? extends AIBase> ai);

    /**
     * Checks if the entity that owns this AIManager has an instance of the AIBase
     * of this class type.
     *
     * @param ai
     *         Class to check.
     *
     * @return {@code true} if it already has this ai, {@code false} otherwise.
     */
    boolean hasTask(Class<? extends AIBase> ai);

    /**
     * Get a Task of the specific class type.
     *
     * @param ai
     *         Class type to check
     *
     * @return the task if it exits, {@code null} if it does not.
     */
    AIBase getTask(Class<? extends AIBase> ai);
}
