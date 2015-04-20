package net.canarymod.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.slf4j.LoggerFactory;

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
 *
 * @deprecated use {@link LoggerFactory} instead
 */
@Deprecated
public class Logman implements Logger {
    private final static ConcurrentHashMap<String, Logman> loggers = new ConcurrentHashMap<String, Logman>();
    private final Logger logger;

    public static final Marker NOTICE = MarkerManager.getMarker("NOTICE");
    public static final Marker MESSAGE = MarkerManager.getMarker("MESSAGE");
    public static final Marker DERP = MarkerManager.getMarker("DERP");
    public static final Marker PLUGINDEBUG = MarkerManager.getMarker("PLUGINDEBUG");

    protected Logman(String name) {
        this.logger = LogManager.getLogger(name);
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
    public void catching(Level level, Throwable t) {
        logger.catching(level, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void catching(Throwable t) {
        logger.catching(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, Message msg) {
        logger.debug(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, Message msg, Throwable t) {
        logger.debug(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, Object message) {
        logger.debug(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, Object message, Throwable t) {
        logger.debug(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String message) {
        logger.debug(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String message, Object... params) {
        logger.debug(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Marker marker, String message, Throwable t) {
        logger.debug(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Message msg) {
        logger.debug(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Message msg, Throwable t) {
        logger.debug(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Object message) {
        logger.debug(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(Object message, Throwable t) {
        logger.debug(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String message, Object... params) {
        logger.debug(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(String message, Throwable t) {
        logger.debug(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void entry() {
        logger.entry();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void entry(Object... params) {
        logger.entry(params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, Message msg) {
        logger.error(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, Message msg, Throwable t) {
        logger.error(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, Object message) {
        logger.error(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, Object message, Throwable t) {
        logger.error(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String message) {
        logger.error(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String message, Object... params) {
        logger.error(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Marker marker, String message, Throwable t) {
        logger.error(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Message msg) {
        logger.error(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Message msg, Throwable t) {
        logger.error(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Object message) {
        logger.error(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(Object message, Throwable t) {
        logger.error(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String message) {
        logger.error(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String message, Object... params) {
        logger.error(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exit() {
        logger.exit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> R exit(R result) {
        return logger.exit(result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, Message msg) {
        logger.fatal(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, Message msg, Throwable t) {
        logger.fatal(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, Object message) {
        logger.fatal(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, Object message, Throwable t) {
        logger.fatal(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, String message) {
        logger.fatal(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, String message, Object... params) {
        logger.fatal(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Marker marker, String message, Throwable t) {
        logger.fatal(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Message msg) {
        logger.fatal(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Message msg, Throwable t) {
        logger.fatal(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Object message) {
        logger.fatal(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(Object message, Throwable t) {
        logger.fatal(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(String message) {
        logger.fatal(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(String message, Object... params) {
        logger.fatal(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fatal(String message, Throwable t) {
        logger.fatal(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessageFactory getMessageFactory() {
        return logger.getMessageFactory();
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
    public void info(Marker marker, Message msg) {
        logger.info(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, Message msg, Throwable t) {
        logger.info(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, Object message) {
        logger.info(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, Object message, Throwable t) {
        logger.info(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String message) {
        logger.info(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String message, Object... params) {
        logger.info(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Marker marker, String message, Throwable t) {
        logger.info(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Message msg) {
        logger.info(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Message msg, Throwable t) {
        logger.info(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Object message) {
        logger.info(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(Object message, Throwable t) {
        logger.info(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String message) {
        logger.info(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String message, Object... params) {
        logger.info(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(String message, Throwable t) {
        logger.info(message, t);
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
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled(Level level) {
        return logger.isEnabled(level);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled(Level level, Marker marker) {
        return logger.isEnabled(level, marker);
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
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFatalEnabled(Marker marker) {
        return logger.isFatalEnabled(marker);
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
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
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
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
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
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, Message msg) {
        logger.log(level, marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, Message msg, Throwable t) {
        logger.log(level, marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, Object message) {
        logger.log(level, marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, Object message, Throwable t) {
        logger.log(level, marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, String message) {
        logger.log(level, marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, String message, Object... params) {
        logger.log(level, marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Marker marker, String message, Throwable t) {
        logger.log(level, marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Message msg) {
        logger.log(level, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Message msg, Throwable t) {
        logger.log(level, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Object message) {
        logger.log(level, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, Object message, Throwable t) {
        logger.log(level, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, String message) {
        logger.log(level, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, String message, Object... params) {
        logger.log(level, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(Level level, String message, Throwable t) {
        logger.log(level, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printf(Level level, Marker marker, String format, Object... params) {
        logger.printf(level, marker, format, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printf(Level level, String format, Object... params) {
        logger.printf(level, format, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Throwable> T throwing(Level level, T t) {
        return logger.throwing(level, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends Throwable> T throwing(T t) {
        return logger.throwing(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, Message msg) {
        logger.trace(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, Message msg, Throwable t) {
        logger.trace(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, Object message) {
        logger.trace(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, Object message, Throwable t) {
        logger.trace(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String message) {
        logger.trace(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String message, Object... params) {
        logger.trace(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Marker marker, String message, Throwable t) {
        logger.trace(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Message msg) {
        logger.trace(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Message msg, Throwable t) {
        logger.trace(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Object message) {
        logger.trace(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(Object message, Throwable t) {
        logger.trace(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String message, Object... params) {
        logger.trace(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(String message, Throwable t) {
        logger.trace(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, Message msg) {
        logger.warn(marker, msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, Message msg, Throwable t) {
        logger.warn(marker, msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, Object message) {
        logger.warn(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, Object message, Throwable t) {
        logger.warn(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String message) {
        logger.warn(marker, message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String message, Object... params) {
        logger.warn(marker, message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Marker marker, String message, Throwable t) {
        logger.warn(marker, message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Message msg) {
        logger.warn(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Message msg, Throwable t) {
        logger.warn(msg, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Object message) {
        logger.warn(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(Object message, Throwable t) {
        logger.warn(message, t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String message, Object... params) {
        logger.warn(message, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(String message, Throwable t) {
        logger.warn(message, t);
    }
}
