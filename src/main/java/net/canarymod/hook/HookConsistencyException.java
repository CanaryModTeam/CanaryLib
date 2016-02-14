package net.canarymod.hook;

/**
 * Thrown when a hook can not be passed to a listener due to the method
 * signature being incorrect
 *
 * @author Chris (damagefilter)
 */
public class HookConsistencyException extends RuntimeException {

    private static final long serialVersionUID = 5665326099228188167L;

    public HookConsistencyException(String message) {
        super(message);
    }
}
