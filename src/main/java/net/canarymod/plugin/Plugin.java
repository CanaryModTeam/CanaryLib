package net.canarymod.plugin;

import net.canarymod.Canary;
import net.canarymod.api.world.World;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.commandsys.CommandOwner;
import net.canarymod.config.Configuration;
import net.canarymod.motd.MOTDOwner;
import net.canarymod.tasks.TaskOwner;
import net.visualillusionsent.utils.LocaleHelper;
import net.visualillusionsent.utils.PropertiesFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * A Canary Mod Plugin.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public abstract class Plugin implements CommandOwner, TaskOwner, MOTDOwner {
    /**
     * This is used to get the correct name during load process, before it is set in the field above.
     */
    public static ThreadLocal<String> threadLocalName = new ThreadLocal<String>() {
    };
    private final ArrayList<String> dependents = new ArrayList<String>();
    private int priority = 0;
    private boolean isClosed = false;
    private boolean disabled = true;
    private String name;

    /**
     * CanaryMod will call this upon enabling this plugin
     *
     * @return {@code true} to signal successful enable; {@code false} if known to be unable to run
     */
    public abstract boolean enable();

    /**
     * CanaryMod will call this upon disabling this plugin
     */
    public abstract void disable();

    /**
     * Return the Plugin's name.
     *
     * @return the Plugin's name
     */
    @Override
    final public String getName() {
        if (name == null) {
            //How to set a value before constructing an object: The hack
            name = threadLocalName.get();
        }
        return name;
    }

    /**
     * Sets the Plugin's name. Used internally since plugins are stored by name.
     * Calling this outside of {@link PluginLifecycle#load()}
     * may end disastrously
     */
    final public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Plugin's priority.
     *
     * @return The Plugin's priority.
     */
    final public int getPriority() {
        return this.priority;
    }

    /**
     * Set this Plugin's priority level. This will affect the order of hook execution.
     *
     * @param priority
     *         the Priority level
     */
    final public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Get the version string of the Plugin
     * The Version should be set in the Canary.inf as "version=[version]"
     *
     * @return the version if found; {@code "UNKNOWN"} if not found
     */
    final public String getVersion() {
        return getDescriptor().getVersion();
    }

    /**
     * Get this Plugin Author's name
     * The Author's name should be set in the Canary.inf as "author=[author]"
     *
     * @return Author's name if found; {@code "UNKNOWN"} if not found
     */
    final public String getAuthor() {
        return getDescriptor().getAuthor();
    }

    /**
     * Gets the name of the Plugin's Jar File
     *
     * @return the Jar File name
     *
     * @deprecated Plugins may or may not be in a jar file. This method will return null if there is no jar.
     */
    public String getJarName() {
        String path = getPath();
        if (path.endsWith(".jar")) {
            return new File(path).getName();
        }
        else {
            return null;
        }
    }

    /**
     * Gets the path of the Plugin's Jar file as {@literal "plugins/<jar>"}
     *
     * @return the Plugin's Jar path
     *
     * @deprecated Plugins may or may not be in a jar file. This method will return null if there is no jar.
     */
    public String getJarPath() {
        String path = getPath();
        if (path.endsWith(".jar")) {
            return path;
        }
        else {
            return null;
        }
    }

    /**
     * Returns the path for this plugin. May be a file, or a directory.
     *
     * @return
     */
    public String getPath() {
        return getDescriptor().getPath();
    }

    /**
     * Gets the {@link Logger} for the Plugin
     *
     * @return the Plugin's {@link Logger}
     */
    public Logger getLogger() {
        return LoggerFactory.getLogger(getName());
    }

    /**
     * Gets the plugin's descriptor
     *
     * @return The plugin's descriptor
     */
    public final PluginDescriptor getDescriptor() {
        return Canary.pluginManager().getPluginDescriptor(this);
    }

    /**
     * Gets the Plugin's Canary.inf file
     * <p/>
     * NOTE: DO NOT CALL {@link PropertiesFile#save()}<br>
     * Saving is unsupported
     * <p/>
     * If the Plugin is reloaded, any changes will be lost
     *
     * @return the Plugin's Canary.inf
     */
    public final PropertiesFile getCanaryInf() {
        return Canary.pluginManager().getPluginDescriptor(this).getCanaryInf();
    }

    /**
     * Gets the server-wide configuration of the Plugin
     *
     * @return configuration of the Plugin
     *
     * @see Configuration#getPluginConfig(Plugin)
     */
    public final PropertiesFile getConfig() {
        return Configuration.getPluginConfig(this);
    }

    /**
     * Gets the server-wide configuration of the Plugin
     *
     * @param module
     *         Used to create multiple configurations for the Plugin.
     *
     * @return configuration of the Plugin
     *
     * @see Configuration#getPluginConfig(Plugin, String)
     */
    public final PropertiesFile getModuleConfig(String module) {
        return Configuration.getPluginConfig(this, module);
    }

    /**
     * Gets the world-specific configuration of the Plugin.
     * If there is no world-specific configuration, it will take the server-wide configuration.
     *
     * @param world
     *         the {@link World} to get configuration for
     *
     * @return configuration of the Plugin for the specified {@link World}
     *
     * @see Configuration#getPluginConfig(Plugin, World)
     */
    public final PropertiesFile getWorldConfig(World world) {
        return Configuration.getPluginConfig(this, world);
    }

    /**
     * Gets the world-specific configuration of the Plugin.
     * If there is no world-specific configuration, it will take the server-wide configuration.
     *
     * @param module
     *         Used to create multiple configurations for the Plugin.
     * @param world
     *         the {@link World} to get configuration for
     *
     * @return configuration of the Plugin for the specified {@link World}
     *
     * @see Configuration#getPluginConfig(Plugin, String, World)
     */
    public final PropertiesFile getWorldModuleConfig(String module, World world) {
        return Configuration.getPluginConfig(this, module, world);
    }

    /**
     * Check if this plugin needs a new instance instead of just re-enabling it
     *
     * @return {@code true} if closed; {@code false} otherwise
     */
    public final boolean isClosed() {
        return isClosed;
    }

    /**
     * Marks this plugin to be re-instantiated on reloading/re-enabling
     */
    final void markClosed() {
        isClosed = true;
    }

    /**
     * Gets whether this Plugin is disabled
     *
     * @return {@code true} if disabled; {@code false} if enabled
     */
    public final boolean isDisabled() {
        // Checking for not ENABLED as a Plugin may just be in a KNOWN state but not ENABLED
        return getDescriptor().getCurrentState() != PluginState.ENABLED;
    }

    /**
     * Register your CommandListener.
     * This will make all annotated commands available to CanaryMod and the help system.
     * Sub Command relations can only be sorted out after availability.
     * That means if you try to register a command that is a sub-command of something
     * that is not registered yet, it will fail.
     * So make sure you add commands in the correct order.
     *
     * @param listener
     *         the {@link CommandListener}
     * @param force
     *         {@code true} to override existing commands; {@code false} for not
     *
     * @throws CommandDependencyException
     */
    public final void registerCommands(CommandListener listener, boolean force) throws CommandDependencyException {
        Canary.commands().registerCommands(listener, this, force);
    }

    /**
     * Register your CommandListener.
     * This will make all annotated commands available to CanaryMod and the help system.
     * Sub Command relations can only be sorted out after availability.
     * That means if you try to register a command that is a sub-command of something
     * that is not registered yet, it will fail.
     * So make sure you add commands in the correct order.
     *
     * @param listener
     *         the {@link CommandListener}
     * @param translator
     *         the {@link LocaleHelper} instance used in Translations
     * @param force
     *         {@code true} to override existing commands; {@code false} for not
     *
     * @throws CommandDependencyException
     */
    public final void registerCommands(CommandListener listener, LocaleHelper translator, boolean force) throws CommandDependencyException {
        Canary.commands().registerCommands(listener, this, translator, force);
    }

    /**
     * Register a {@link PluginListener} for a system hook
     */
    public final void registerListener(PluginListener listener) {
        Canary.hooks().registerListener(listener, this);
    }

    /**
     * Toggles the disabled state of the Plugin
     */
    final void toggleDisabled() {
        this.disabled = !this.disabled;
    }

    final boolean hasDependents() {
        return !dependents.isEmpty();
    }

    final ArrayList<String> getDependents() {
        return dependents;
    }

    final void addDependent(String dependent) {
        if (!dependents.contains(dependent)) {
            dependents.add(dependent);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 6; // number of chars in "Plugin" :P

        return hash * getName().hashCode(); // anyone got a better idea?
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return String.format("Plugin[Name: '%s' Version: '%s' Author: '%s' Path: '%s']", getName(), getVersion(), getAuthor(), getPath());
    }
}
