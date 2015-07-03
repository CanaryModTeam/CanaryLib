package net.canarymod.hook;

import net.canarymod.plugin.Priority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Chris (damagefilter)
 * @interface for defining that a method should recieve hooks
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HookHandler {
    Priority priority() default Priority.NORMAL;

    boolean ignoreCanceled() default false;
}
