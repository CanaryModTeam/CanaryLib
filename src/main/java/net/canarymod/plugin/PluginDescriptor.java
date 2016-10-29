package net.canarymod.plugin;

import net.canarymod.exceptions.InvalidPluginException;
import net.canarymod.plugin.lifecycle.PluginLifecycleFactory;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.UtilityException;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * Describes information about a plugin, including meta information and start/stop/load information.
 * It also contains a reference to the loaded instance of the plugin, should there be one.
 *
 * @author Pwootage
 */
public class PluginDescriptor {
    private PropertiesFile canaryInf;
    private String path;
    private String name;
    private String version;
    private String author;
    private String language;
    private boolean enableEarly;
    private Plugin plugin;
    private PluginLifecycle pluginLifecycle;
    private String[] dependencies;
    private PluginState currentState;
    private int priority;

    public PluginDescriptor(String path) throws InvalidPluginException {
        this.path = path;
        try {
            reloadInf();
        }
        catch (UtilityException uex) {
            throw new InvalidPluginException("Unable to load INF file", uex);
        }
        currentState = PluginState.KNOWN;
    }

    PluginDescriptor() {
        // Used for the PluginLangLoader initializing a Plugin Lang
    }

    protected void reloadInf() throws InvalidPluginException {
        findAndLoadCanaryInf();
        name = canaryInf.getString("name", "");
        if (name.equals("")) {
            name = canaryInf.getString("main-class", "");
        }
        if (name.equals("")) {
            name = new File(path).getName();
        }
        version = canaryInf.getString("version", "UNKNOWN");
        author = canaryInf.getString("author", "UNKNOWN");
        language = canaryInf.getString("language", "java");
        enableEarly = canaryInf.getBoolean("enable-early", false); // Enable before subsystems are initialized and before the first world gets loaded
        if (canaryInf.containsKey("dependencies")) {
            dependencies = canaryInf.getStringArray("dependencies", ",");
        }
        else {
            dependencies = new String[0];
        }
        pluginLifecycle = PluginLifecycleFactory.createLifecycle(this);
    }

    private void findAndLoadCanaryInf() throws InvalidPluginException {
        File pluginFile = new File(path);
        if (pluginFile.isFile() && pluginFile.getName().matches(".+\\.(jar|zip)$")) {
            try {
                ZipFile zip = new ZipFile(path);
                if (zip.getEntry("Canary.inf") == null) {
                    if (zip.getEntry("plugin.yml") != null) {
                        throw new InvalidPluginException("Bukkit Plugins are not natively supported. Please remove '" + pluginFile.getName() + "' from your plugins directory.");
                    }
                    if (zip.getEntry("mcmod.info") != null) {
                        throw new InvalidPluginException("Forge Mods and Sponge Plugins are not natively supported. Please remove '" + pluginFile.getName() + "' from your plugins directory.");
                    }
                    throw new InvalidPluginException("I don't know where to find a Canary.inf in " + path);
                }
            }
            catch (IOException ioex) {
                throw new InvalidPluginException("Oops, something exploded while checking " + path, ioex);
            }

            canaryInf = new PropertiesFile(pluginFile.getAbsolutePath(), "Canary.inf");
        }
        else if (pluginFile.isDirectory()) {
            File confFile = new File(pluginFile, "Canary.inf");
            canaryInf = new PropertiesFile(confFile.getAbsolutePath());
        }
        else {
            throw new InvalidPluginException("I don't know where to find a Canary.inf in " + path);
        }
    }

    public PropertiesFile getCanaryInf() {
        return canaryInf;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }

    public String getPath() {
        return path;
    }

    public String getLanguage() {
        return language;
    }

    public boolean enableEarly() {
        return enableEarly;
    }

    public PluginLifecycle getPluginLifecycle() {
        return pluginLifecycle;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * DO NOT CALL THIS METHOD. It is for internal use only.
     *
     * @param plugin
     *         Current plugin object
     */
    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public PluginState getCurrentState() {
        return currentState;
    }

    /**
     * DO NOT CALL THIS METHOD. It is for internal use only.
     *
     * @param state
     *         New plugin state
     */
    public void setCurrentState(PluginState state) {
        this.currentState = state;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
