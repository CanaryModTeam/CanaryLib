package net.canarymod.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CanaryMod Log manager.
 * <p/>
 * You can get an appropriate logger for your plugin here.
 *
 * @author Chris (damagefilter)
 * @author Jos Kuijpers
 * @author Jason (darkdiplomat)
 * @author Larry1123
 *         Updated to make use of log4j
 * @author Jamie (jamierocks)
 *         Updated to make use of slf4j
 */
public class Logman implements Logger {
    private final static ConcurrentHashMap<String, Logman> loggers = new ConcurrentHashMap<String, Logman>();
    private final Logger logger;

    public static final Marker NOTICE = MarkerFactory.getMarker("NOTICE");
    public static final Marker MESSAGE = MarkerFactory.getMarker("MESSAGE");
    public static final Marker DERP = MarkerFactory.getMarker("DERP");
    public static final Marker PLUGINDEBUG = MarkerFactory.getMarker("PLUGINDEBUG");

    protected Logman(String name) {
        this.logger = LoggerFactory.getLogger(name);
        loggers.putIfAbsent(name, this);
    }

    /**
     * Get a Logman for the name given
     *
     * @param name
     *         the name of the Logger to use
     *
     * @return the Logman instance
     */
    public static Logman getLogman(String name) {
        return loggers.containsKey(name) ? loggers.get(name) : new Logman(name);
    }

    /**
     * Convenience shortcut to System.out.println().
     * Prints to the output stream on a new line
     *
     * @param message
     *         the message to be printed to the console
     */
    public static void println(String message) {
        System.out.println(message);
    }

    /**
     * Convenience shortcut to System.out.print().<br>
     * Prints to the output stream on the same line
     *
     * @param message
     *         the message to be printed to the console
     */
    public static void print(String message) {
        System.out.print(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return logger.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String s) {
        logger.trace(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String s, Object o) {
        logger.trace(s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String s, Object o, Object o1) {
        logger.trace(s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String s, Object... objects) {
        logger.trace(s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String s, Throwable throwable) {
        logger.trace(s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String s) {
        logger.trace(marker, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String s, Object o) {
        logger.trace(marker,s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        logger.trace(marker,s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String s, Object... objects) {
        logger.trace(marker, s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        logger.trace(marker, s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String s) {
        logger.debug(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String s, Object o) {
        logger.debug(s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String s, Object o, Object o1) {
        logger.debug(s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String s, Object... objects) {
        logger.debug(s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String s, Throwable throwable) {
        logger.debug(s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String s) {
        logger.debug(marker, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String s, Object o) {
        logger.debug(marker, s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        logger.debug(marker, s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String s, Object... objects) {
        logger.debug(marker, s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        logger.debug(marker, s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String s) {
        logger.info(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String s, Object o) {
        logger.info(s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String s, Object o, Object o1) {
        logger.info(s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String s, Object... objects) {
        logger.info(s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String s, Throwable throwable) {
        logger.info(s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String s) {
        logger.info(marker, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String s, Object o) {
        logger.info(marker, s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        logger.info(marker, s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String s, Object... objects) {
        logger.info(marker, s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        logger.info(marker, s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String s) {
        logger.warn(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String s, Object o) {
        logger.warn(s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String s, Object... objects) {
        logger.warn(s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String s, Object o, Object o1) {
        logger.warn(s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String s, Throwable throwable) {
        logger.warn(s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String s) {
        logger.warn(marker, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String s, Object o) {
        logger.warn(marker, s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        logger.warn(marker, s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String s, Object... objects) {
        logger.warn(marker, s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        logger.warn(marker, s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String s) {
        logger.error(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String s, Object o) {
        logger.error(s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String s, Object o, Object o1) {
        logger.error(s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String s, Object... objects) {
        logger.error(s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String s, Throwable throwable) {
        logger.error(s, throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String s) {
        logger.error(marker, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String s, Object o) {
        logger.error(marker, s, o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        logger.error(marker, s, o, o1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String s, Object... objects) {
        logger.error(marker, s, objects);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        logger.error(marker, s, throwable);
    }
}
