package net.canarymod.tasks;

import net.canarymod.plugin.Plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import static net.canarymod.Canary.log;

/**
 * Server Task Manager
 * <p/>
 * The Manager for {@link ServerTask}<br>
 * If an exception occurs while running a task, it gets removed from the queue, regardless of continuous status
 *
 * @author Jason (darkdiplomat)
 */
public final class ServerTaskManager {
    private final static ServerTaskManager INST = new ServerTaskManager();
    private final ConcurrentHashMap<ServerTask, TaskOwner> tasks;

    private ServerTaskManager() {
        tasks = new ConcurrentHashMap<ServerTask, TaskOwner>();
    }

    /**
     * Adds a {@link ServerTask} to the queue
     *
     * @param task
     *         the {@link ServerTask} to be added
     *
     * @return {@code true} if successfully added; {@code false} if not
     */
    public static boolean addTask(ServerTask task) {
        INST.tasks.put(task, task.getOwner());
        return true;
    }

    /**
     * Removes a {@link ServerTask} from the queue<br>
     * When a {@link Plugin} is disabled, it should remove it's tasks from the queue
     *
     * @param task
     *         the {@link ServerTask} to be removed
     *
     * @return {@code true} if removed; {@code false} if not found or unable to be removed
     */
    public static boolean removeTask(ServerTask task) {
        return INST.tasks.remove(task) != null;
    }

    /**
     * Removes all the tasks for a specified {@link TaskOwner}
     *
     * @param owner
     *         the {@link TaskOwner} to remove tasks for
     */
    public static void removeTasks(TaskOwner owner) {
        for (Iterator<TaskOwner> it = INST.tasks.values().iterator(); it.hasNext();) {
            if (it.next().equals(owner)) {
                it.remove();
            }
        }
    }

    /**
     * Finds out if the given {@code task} is queued.
     *
     * @param task
     *         what {@link ServerTask} to check
     * @return
     *         {@code true} if the given {@code task} is queued; {@code false} otherwise
     */
    public static boolean isQueued(ServerTask task) {
        return INST.tasks.containsValue(task);
    }

    /**
     * Gets a {@link List} of {@link ServerTask}s that are in queue with the given {@code owner}
     *
     * @param owner
     *         The {@link TaskOwner} to look for {@link ServerTask}s with
     *
     * @return
     *         will return an empty {@link ArrayList} if no {@link ServerTask}s are found
     */
    public static List<ServerTask> getServerTasksForTaskOwner(TaskOwner owner) {
        ArrayList<ServerTask> tasks = new ArrayList<ServerTask>();
        for (Entry<ServerTask, TaskOwner> serverTaskTaskOwnerEntry : INST.tasks.entrySet()) {
            if (serverTaskTaskOwnerEntry.getValue().equals(owner)) {
                tasks.add(serverTaskTaskOwnerEntry.getKey());
            }
        }
        return tasks;
    }

    /**
     * Internal method called to run the tasks or decrease timers.
     */
    public static void runTasks() {
        for (Iterator<ServerTask> it = INST.tasks.keySet().iterator(); it.hasNext();) {
            ServerTask task = it.next();
            task.decrementDelay();
            if (task.shouldExecute()) {
                try {
                    task.run();
                } catch (Throwable thrown) {
                    log.error("An error occurred while executing ServerTask: " + task.getClass().getSimpleName(), thrown);
                    it.remove();
                    continue;
                }

                if (!task.isContinuous()) {
                    it.remove();
                } else {
                    task.reset();
                }
            }
        }
    }
}
