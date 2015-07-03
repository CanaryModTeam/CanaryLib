package net.canarymod.api.ai;

/**
 * This class executes AI tasks on a Living Entity based on the following Logic.
 * To use this, create a class implementing it and then add it to an entity via
 * {@link AIManager}.
 *
 * @author Aaron (somners)
 */
public interface AIBase {

    /**
     * Returns whether the AIBase should begin execution.
     *
     * @return {@code true} if the manager should execute this, {@code false}
     * otherwise.
     */
    boolean shouldExecute();

    /**
     * Returns whether an in-progress AIBase should continue executing
     *
     * @return {@code true} if the manager should continue executing this,
     * {@code false} otherwise.
     */
    boolean continueExecuting();

    /**
     * Returns whether the task requires multiple updates or not
     *
     * @return {@code true} means this takes multiple ticks to execute,
     * {@code false} otherwise.
     */
    boolean isContinuous();

    /**
     * Execute a one shot task or start executing a continuous task
     */
    void startExecuting();

    /**
     * Resets the task
     */
    void resetTask();

    /**
     * Updates the task.<br>
     * This is called on ticks following the tick where AIBase.startExecuting()
     * is called until AIBase.resetTask() is called.
     */
    void updateTask();
}
