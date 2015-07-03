package net.canarymod.api.world;

import java.util.Random;

/**
 * Biome contains data about a certain {@link BiomeType}
 *
 * @author Chris (damagefilter)
 */
public interface Biome {

    /**
     * Check if this biome can spawn lightning bolts.
     *
     * @return {@code true} is spawns lightning; {@code false} if not
     */
    boolean canSpawnLightning();

    /**
     * Check if this is a tropic biome by determining the amount of rainfall.
     * More rainfall means more tropic biome
     *
     * @return {@code true} is tropic; {@code false} if not
     */
    boolean isTropic();

    /**
     * Returns the chance a create can spawn here.
     * This is on a scale from 0 to 1
     *
     * @return spawn chance
     */
    float getSpawnChance();

    /**
     * get an integer representing the amount of rainfall in this biome
     *
     * @return rainfall
     */
    int getRainfall();

    /**
     * Returns a float value representing this biomes temperature
     *
     * @return temperature
     */
    float getTemperature();

    /**
     * Decorates the chunk coordinates in the given world with decorations of this biome generator
     *
     * @param world
     *         the world
     * @param rnd
     *         the random
     * @param x
     *         the chunk x coordinate
     * @param z
     *         the chunk z coordinate
     */
    void decorate(World world, Random rnd, int x, int z);

    /**
     * get the BiomeType for this BiomeGen
     *
     * @return {@link BiomeType}
     */
    BiomeType getBiomeType();

    /**
     * Sets the temperature for the biome, and the precipitation amount.<br>
     * <b>NOTE:</b>  Please avoid temperatures in the range 0.1 - 0.2 because of snow.<br>
     * Temperatures less than .1 for snow; and temperatures greater than .2 for
     * rain are preferred.<br>
     * All values here should be between 0.0F and 1.0F
     *
     * @param temp
     *         temperature value.
     * @param precipitation
     *         precipitation value
     */
    void setTemperatureAndPrecipitation(float temp, float precipitation);

    /**
     * Sets whether or not snow is permitted.
     *
     * @param canSnow
     *         whether or not it can snow.
     */
    void setCanSnow(boolean canSnow);

    /**
     * Sets whether or not Rain is permitted
     *
     * @param canRain
     *         make it rain.
     */
    void setCanRain(boolean canRain);

    /**
     * Gets whether or not snow is permitted.
     *
     * @return true if snow is permitted.
     */
    boolean canSnow();

    /**
     * Gets whether or not Rain is permitted
     *
     * @return true if rein is permitted.
     */
    boolean canRain();

    /**
     * Sets the color of this biome.
     *
     * @param hexColor
     *         The hex code for this color.
     */
    void setColor(String hexColor);
}
