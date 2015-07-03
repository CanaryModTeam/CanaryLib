package net.canarymod.tasks;

import net.canarymod.plugin.Plugin;

/**
 * Server Task
 * <p/>
 * Extend this class to add synchronized tasks to the Server queue.<br>
 * Task are set to execute along with the Server's main thread.<br>
 * Exact timing is not guaranteed, and based on how often the Server ticks.
 *
 * @author Jason (darkdiplomat)
 * @see ServerTaskManager
 */
public abstract class ServerTask {
    private final long schedule;
    private final boolean continuous;
    private final TaskOwner owner;
    private long delay;

    /**
     * Constructs a one-time use ServerTask
     *
     * @param owner
     *         the {@link TaskOwner} of the task, typically a {@link Plugin}
     * @param delay
     *         the delay before executing. Set to 0 or less to run within the next Server tick (Roughly once every 50 milliseconds)
     *
     * @throws IllegalArgumentException
     *         if owner is null
     */
    public ServerTask(TaskOwner owner, long delay) {
        this(owner, delay, false);
    }

    /**
     * Constructs either a one-time use or continuous ServerTask
     *
     * @param owner
     *         the {@link TaskOwner} of the task, typically a {@link Plugin}
     * @param delay
     *         the delay before executing. Set to 0 or less to run within the next Server tick<br>
     *         If delay is 0 or less, the task will run with each server tick
     * @param continuous
     *         {@code true} for continuous; {@code false} for one-time use
     *
     * @throws IllegalArgumentException
     *         if owner is null
     */
    public ServerTask(TaskOwner owner, long delay, boolean continuous) {
        this(owner, delay, delay, continuous);
    }

    /**
     * Constructs either a one-time use or continuous ServerTask
     *
     * @param owner
     *         the {@link TaskOwner} of the task, typically a {@link Plugin}
     * @param delay
     *         the delay before executing. Set to 0 or less to run within the next Server tick<br>
     *         If delay is 0 or less, the task will run with each server tick
     * @param schedule
     *         the delay before each execution if the task is continuous
     *         If delay is 0 or less, the task will run with each server tick
     * @param continuous
     *         {@code true} for continuous; {@code false} for one-time use
     *
     * @throws IllegalArgumentException
     *         if owner is null
     */
    public ServerTask(TaskOwner owner, long delay, long schedule, boolean continuous) {
        if (owner == null) {
            throw new IllegalArgumentException("A ServerTask requires an owner.");
        }
        this.schedule = schedule;
        this.delay = delay;
        this.continuous = continuous;
        this.owner = owner;
    }

    /**
     * Gets whether the ServerTask should continuously run
     *
     * @return {@code true} if continuous; {@code false} if not
     */
    public final boolean isContinuous() {
        return continuous;
    }

    /**
     * Gets the {@link TaskOwner} that owns this task
     *
     * @return the {@link TaskOwner} owner
     */
    public final TaskOwner getOwner() {
        return owner;
    }

    /**
     * Execution method. Override and insert your logic here.
     */
    public abstract void run();

    /**
     * Called when a Continuous Task is reset.<br>
     * Override and set any logic you may need to also have reset with each run.
     */
    public void onReset() {
    }

    /**
     * Internal use method to decrease the delay
     */
    final void decrementDelay() {
        --delay;
    }

    /**
     * Internal use method to check if it is time to run the task
     *
     * @return {@code true} for execute; {@code false} for not
     */
    final boolean shouldExecute() {
        return delay <= 0;
    }

    /**
     * Internal use method to reset the delay on continuous tasks
     */
    final void reset() {
        this.delay = this.schedule;
        this.onReset();
    }
}
