package net.canarymod.hook;

import net.canarymod.plugin.Priority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define a method that listens on a hook.
 *
 * @author Chris (damagefilter)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HookHandler {
    Priority priority() default Priority.NORMAL;

    boolean ignoreCanceled() default false;
}
