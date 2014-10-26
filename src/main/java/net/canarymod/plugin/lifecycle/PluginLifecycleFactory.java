package net.canarymod.plugin.lifecycle;

import net.canarymod.exceptions.InvalidPluginException;
import net.canarymod.plugin.IPluginLifecycle;
import net.canarymod.plugin.PluginDescriptor;

/**
 * Factory to create {@link net.canarymod.plugin.IPluginLifecycle} instances based on Canary.inf
 * (inside a {@link net.canarymod.plugin.PluginDescriptor}
 *
 * @author Pwootage
 */
public class PluginLifecycleFactory {

    /**
     * Construct a plugin lifecycle for a descriptor
     *
     * @param pluginDescriptor Descriptor of plugin
     * @return Lifecycle for descriptor
     * @throws InvalidPluginException If this type of plugin is not known how to handle
     */
    public static IPluginLifecycle createLifecycle(PluginDescriptor pluginDescriptor) throws InvalidPluginException {
        String language = pluginDescriptor.getLanguage();
        if (language.equals("java") || language.equals("scala")) {
            return new JavaPluginLifecycle(pluginDescriptor);
        }
        else if (language.equals("lua")) {
            return new LuaPluginLifecycle(pluginDescriptor);
        } else if (language.equals("clojure")) {
            // TODO: replace with generic implementation
            return new ClojurePluginLifecycle(pluginDescriptor);
        }
        throw new InvalidPluginException("Unknown plugin language: " + language);
    }
}
