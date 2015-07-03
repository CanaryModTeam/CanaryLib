package net.canarymod.commandsys;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation intended to help distinguish what methods are autoComplete methods in a {@link net.canarymod.commandsys.CommandListener}
 *
 * @author Jason (darkdiplomat)
 * @author Chris (damagefilter)
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface TabComplete {

    /**
     * List of commands (or command aliases) to which this tab completion applies
     *
     * @return list of commands or command aliases
     */
    String[] commands() default {}; // Empty as legacy
}
