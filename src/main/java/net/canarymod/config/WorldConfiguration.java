package net.canarymod.config;

import net.canarymod.MathHelp;
import net.canarymod.api.GameMode;
import net.canarymod.api.world.DimensionType;
import net.canarymod.api.world.World;
import net.canarymod.api.world.WorldType;
import net.visualillusionsent.utils.PropertiesFile;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static net.canarymod.Canary.log;

/**
 * @author Jason (darkdiplomat)
 * @author Jos Kuijpers
 */
public class WorldConfiguration implements ConfigurationContainer {
    private PropertiesFile cfg;
    private String worldname;
    private HashMap<String, Boolean> boolCache = new HashMap<String, Boolean>();

    /* Arrays of default mobs, leave static */
    private final static String[]
            animals = new String[]{ "Bat", "Chicken", "Cow", "Mooshroom", "Ocelot", "Pig", "Sheep", "Wolf", "Horse", "Rabbit" },
            wateranimals = new String[]{ "Squid" },
            monsters = new String[]{ "Enderman", "PigZombie", "Blaze", "CaveSpider", "Creeper", "Ghast", "MagmaCube", "Silverfish", "Skeleton", "Slime", "Spider", "Witch", "Zombie", "Wither", "EnderDragon", "GiantZombie", "Endermite", "Guardian" },
            golems = new String[]{ "IronGolem", "Snowman" };

    /* Arrays of default enderblocks and disallowed blocks, leave static */
    private final static int[]
            enderblocks = new int[]{ 2, 3, 12, 13, 37, 38, 39, 40, 46, 81, 82, 86, 103, 110 },
            disallowedblocks = new int[]{ 7, 8, 9, 10, 11, 46, 51, 52 };

    /* Only read this once. Major performance improvement here. */
    private HashSet<String> spawnableAnimals, spawnableGolems, spawnableMobs, spawnableWaterAnimals;

    public WorldConfiguration(String path, String worldname) {
        this.worldname = worldname;
        File test = new File(path);

        if (!test.exists()) {
            log.info("Could not find the world configuration for " + worldname + " at " + path + ", creating default.");
        }
        cfg = new PropertiesFile(path + File.separatorChar + worldname + ".cfg");
        verifyConfig();
    }

    /**
     * Reloads the configuration file
     */
    @Override
    public void reload() {
        cfg.reload();
        verifyConfig();
    }

    /**
     * Get the configuration file
     */
    @Override
    public PropertiesFile getFile() {
        return cfg;
    }

    /**
     * Verifies the world configuration file
     */
    private void verifyConfig() {
        cfg.getString("world-name", worldname);
        cfg.getString("world-type", "DEFAULT");
        cfg.getInt("spawn-protection", 16);
        cfg.getInt("max-build-height", 256);
        cfg.getBoolean("generate-structures", true);
        cfg.getString("generator-settings", "");
        cfg.getString("world-seed", "");

        cfg.getBoolean("startup-autoload", false);
        cfg.getBoolean("warp-autoload", false);

        cfg.getBoolean("allow-nether", true);
        cfg.getBoolean("allow-end", true);
        cfg.getBoolean("allow-flight", true);

        cfg.getBoolean("pvp", true);
        cfg.getInt("difficulty", 1);
        cfg.getInt("gamemode", 0);
        cfg.getBoolean("forceDefaultGameMode", true);
        cfg.getBoolean("forceDefaultGameModeDimensional", false);
        cfg.getString("auto-heal", "default");
        cfg.getBoolean("enable-experience", true);
        cfg.getBoolean("enable-health", true);

        cfg.getBoolean("spawn-villagers", true);
        cfg.getBoolean("spawn-golems", true);
        cfg.getBoolean("spawn-animals", true);
        cfg.getBoolean("spawn-monsters", true);
        spawnableAnimals = new HashSet<String>(Arrays.asList(cfg.getStringArray("natural-animals", animals)));
        spawnableMobs = new HashSet<String>(Arrays.asList(cfg.getStringArray("natural-monsters", monsters)));
        spawnableGolems = new HashSet<String>(Arrays.asList(cfg.getStringArray("natural-golems", golems)));
        spawnableWaterAnimals = new HashSet<String>(Arrays.asList(cfg.getStringArray("natural-wateranimals", wateranimals)));
        cfg.getInt("natural-spawn-rate", 100);

        cfg.getIntArray("ender-blocks", enderblocks);
        cfg.getIntArray("disallowed-blocks", disallowedblocks);

        cfg.save();
    }

    private boolean getBoolean(String key, boolean def) {
        Boolean r = boolCache.get(key);
        if (r != null) {
            return r;
        }
        r = cfg.getBoolean(key, def);
        boolCache.put(key, r);
        return r;
    }

    /**
     * Get the spawn protection size
     *
     * @return an integer between 0 and INTMAX, 16 on failure.
     */
    public int getSpawnProtectionSize() {
        return cfg.getInt("spawn-protection", 16);
    }

    /**
     * Get whether auto heal is enabled.
     *
     * @return true or false. Returns value of canSpawnMonsters() if auto-heal is 'default'
     */
    public boolean isAutoHealEnabled() {
        if (cfg.getString("auto-heal", "default").equals("default")) {
            return this.canSpawnMonsters();
        }
        return getBoolean("auto-heal", false);
    }

    /**
     * Get whether experience is enabled
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isExperienceEnabled() {
        return getBoolean("enable-experience", true);
    }

    /**
     * Get whether health is enabled.
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isHealthEnabled() {
        return getBoolean("enable-health", true);
    }

    /**
     * Get an Array of String of spawnable animals
     *
     * @return animals array
     */
    public Set<String> getSpawnableAnimals() {
        return spawnableAnimals;
    }

    /**
     * Get an Array of String of spawnable water animals
     *
     * @return water animals array
     */
    public Set<String> getSpawnableWaterAnimals() {
        return spawnableWaterAnimals;
    }

    /**
     * Get an Array of String of spawnable monsters
     *
     * @return monster array
     */
    public Set<String> getSpawnableMobs() {
        return spawnableMobs;
    }

    /**
     * Get an Array of String of spawnable golems
     *
     * @return golem array
     */
    public Set<String> getSpawnableGolems() {
        return spawnableGolems;
    }

    /**
     * Get the block types allowed for enderman to move.
     *
     * @return An integer array containing the block types.
     */
    public int[] getEnderBlocks() {
        return cfg.getIntArray("ender-blocks", enderblocks);
    }

    /**
     * Get the block types banned.
     *
     * @return An integer array containing the block types.
     */
    public int[] getBannedBlocks() {
        return cfg.getIntArray("disallowed-blocks", disallowedblocks);
    }

    /**
     * See if a given animal is allowed to spawn
     * This method looks in both the normal and water animal lists.
     *
     * @param name
     *         the name of the Animal
     *
     * @return true or false
     */
    public boolean isAnimalSpawnable(String name) {
        for (String animal : cfg.getStringArray("natural-animals")) {
            if (name.equals(animal)) {
                return true;
            }
        }
        for (String animal : cfg.getStringArray("natural-wateranimals")) {
            if (name.equals(animal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * See if a given mob is allowed to spawn
     *
     * @param name
     *         the name of the Mob
     *
     * @return true or false
     */
    public boolean isMobSpawnable(String name) {
        for (String mob : cfg.getStringArray("natural-monsters")) {
            if (name.equals(mob)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the world name
     *
     * @return a string with the world name
     */
    public String getWorldName() {
        return cfg.getString("world-name", worldname);
    }

    /**
     * Get the world type.
     *
     * @return a String with the world type. Default is DEFAULT
     */
    public WorldType getWorldType() {
        return WorldType.fromString(cfg.getString("world-type", "DEFAULT"));
    }

    /**
     * Get the world seed.
     *
     * @return a string containing the world seed
     */
    public String getWorldSeed() {
        return cfg.getString("world-seed", "");
    }

    /**
     * Get whether the nether is allowed
     *
     * @return true when allowed, false otherwise
     */
    public boolean isNetherAllowed() {
        return getBoolean("allow-nether", true);
    }

    /**
     * Get whether the end is allowed
     *
     * @return true when allowed, false otherwise
     */
    public boolean isEndAllowed() {
        return getBoolean("allow-end", true);
    }

    /**
     * Get whether flight is allowed
     *
     * @return true when allowed, false otherwise
     */
    public boolean isFlightAllowed() {
        return getBoolean("allow-flight", true);
    }

    /**
     * Get whether NPCs can be spawned
     *
     * @return true or false
     */
    public boolean canSpawnVillagers() {
        return getBoolean("spawn-villagers", true);
    }

    /**
     * Get whether animals can be spawned
     *
     * @return true or false
     */
    public boolean canSpawnAnimals() {
        return getBoolean("spawn-animals", true);
    }

    /**
     * Get whether monsters can be spawned
     *
     * @return true or false
     */
    public boolean canSpawnMonsters() {
        return getBoolean("spawn-monsters", true);
    }

    /**
     * Get whether golems can be spawned
     *
     * @return true or false
     */
    public boolean canSpawnGolems() {
        return getBoolean("spawn-golems", true);
    }

    /**
     * Get whether structures must be generated
     *
     * @return true or false
     */
    public boolean generatesStructures() {
        return getBoolean("generate-structures", true);
    }

    /**
     * Get the maximum build height
     *
     * @return an integer, defaulting to 256
     */
    public int getMaxBuildHeight() {
        return MathHelp.setInRange(cfg.getInt("max-build-height", 256), 1, 256);
    }

    /**
     * Get whether PVP is enabled
     *
     * @return true when enabled, false otherwise. Default is true.
     */
    public boolean isPvpEnabled() {
        return getBoolean("pvp", true);
    }

    /**
     * Get the difficulty
     *
     * @return difficulty
     */
    public World.Difficulty getDifficulty() {
        return World.Difficulty.fromId(cfg.getInt("difficulty", 1));
    }

    /**
     * Get the game mode for this world
     *
     * @return game mode
     */
    public GameMode getGameMode() {
        return GameMode.fromId(cfg.getInt("gamemode", 0));
    }

    /**
     * Get the natural spawn rate, a percentage.
     *
     * @return A value from 0 to 100, default is 100.
     */
    public int getNaturalSpawnRate() {
        return MathHelp.setInRange(cfg.getInt("natural-spawn-rate", 100), 0, 100);
    }

    /**
     * Gets the World Generator settings
     *
     * @return world generator settings
     */
    public String getGeneratorSettings() {
        return cfg.getString("generator-settings", "");
    }

    /**
     * Gets whether to force the default GameMode on a Player when changing Worlds
     *
     * @return {@code true} if force
     */
    public boolean forceDefaultGamemode() {
        return cfg.getBoolean("forceDefaultGameMode", true);
    }

    /**
     * Gets whether to force the default GameMode on a Player when changing Dimensions
     *
     * @return {@code true} if force
     */
    public boolean forceDefaultGamemodeDimensional() {
        return cfg.getBoolean("forceDefaultGameModeDimensional", false);
    }

    public boolean startupAutoLoadEnabled() {
        return cfg.getBoolean("startup-autoload", false);
    }

    /**
     * Gets whether to load a world when a warp is used
     *
     * @return {@code true} if loading allowed
     */
    public boolean allowWarpAutoLoad() {
        return cfg.getBoolean("warp-autoload", false);
    }

    /**
     * Creates a new WorldConfig for use with {@link net.canarymod.api.world.WorldManager#createWorld(WorldConfiguration)}<p/>
     * Before passing on to createWorld, these settings should be modified using {@link WorldConfiguration#getFile()}<br/>
     * and then calling {@link net.visualillusionsent.utils.PropertiesFile#save()} followed with {@link WorldConfiguration#reload()} when finished
     * <ul>
     * <li>worldType (String)</li>
     * <li>spawn-protection (Integer)</li>
     * <li>max-build-height (Integer)</li>
     * <li>generate-structures (Boolean)</li>
     * <li>generator-settings (String)</li>
     * <li>world-seed (String)</li>
     * <li>startup-autoload (Boolean)</li>
     * <li>warp-autoload (Boolean)</li>
     * <li>allow-nether (Boolean)</li>
     * <li>allow-end (Boolean)</li>
     * <li>allow-flight (Boolean)</li>
     * <li>pvp (Boolean)</li>
     * <li>difficulty (Integer)</li>
     * <li>gamemode (Integer)</li>
     * <li>forceDefaultGameMode (Boolean)</li>
     * <li>forceDefaultGameModeDimensional (Boolean)</li>
     * <li>auto-heal (String)</li>
     * <li>enable-experience (Boolean)</li>
     * <li>enable-health (Boolean)</li>
     * <li>spawn-villagers (Boolean)</li>
     * <li>spawn-golems (Boolean)</li>
     * <li>spawn-animals (Boolean)</li>
     * <li>spawn-monsters (Boolean)</li>
     * <li>natural-animals (String[])</li>
     * <li>natural-monsters (String[])</li>
     * <li>natural-golems (String[])</li>
     * <li>natural-wateranimals (String[])</li>
     * <li>natural-spawn-rate (Integer)</li>
     * <li>ender-blocks (int[])</li>
     * <li>disallowed-blocks (int[])</li>
     * </ul> <br/>
     * NOTE: Settings list may not be entirely up to date.
     *
     * @param name
     *         name of the World
     * @param dimensionType
     *         {@link net.canarymod.api.world.DimensionType} of the world
     *
     * @return the new WorldConfiguraion or {@code null} if a configuration is already existant
     *
     * @see net.canarymod.api.world.WorldManager#createWorld(WorldConfiguration)
     * @see WorldConfiguration#reload()
     * @see WorldConfiguration#getFile()
     */
    public static WorldConfiguration create(String name, DimensionType dimensionType) {
        String worldFqName = name.concat("_").concat(dimensionType.getName());
        //Check that a world for this config isn't already exisitant
        if (Configuration.hasWorldConfig(worldFqName)) {
            return null;
        }
        else if (new File("config" + File.separatorChar + "worlds" + File.separatorChar + name.split("_")[0]).exists()) {
            Configuration.getWorldConfig(worldFqName); // There is a configuration already but wasn't loaded yet, it is now.
            return null;
        }
        return Configuration.getWorldConfig(worldFqName);
    }
}
