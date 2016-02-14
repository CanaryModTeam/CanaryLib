package net.canarymod.hook;

/**
 * Thrown when an exception propagates up to the hook dispatcher
 * The exception is wrapped in this exception
 *
 * @author Chris (damagefilter)
 */
public class HookExecutionException extends RuntimeException {

    private static final long serialVersionUID = 5665326099228188167L;

    public HookExecutionException(String message) {
        super(message);
    }

    public HookExecutionException(String msg, Throwable t) {
        super(msg, t);
    }
}
