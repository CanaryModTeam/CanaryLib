package net.canarymod.plugin;

/*
 * Thrown when an exception occurs in a plugin. The exception is wrapped
 * in this exception. // TODO Correct?
 *
 * @author Chris (damagefilter)
 */
public class PluginException extends RuntimeException {
    private static final long serialVersionUID = -8544875171002713131L;

    public PluginException(String str) {
        super(str);
    }

    public PluginException(String msg, Throwable t) {
        super(msg, t);
    }
}
