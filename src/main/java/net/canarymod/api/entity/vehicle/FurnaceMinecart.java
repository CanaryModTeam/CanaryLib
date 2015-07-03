package net.canarymod.api.entity.vehicle;

/**
 * FurnaceMinecart wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface FurnaceMinecart extends Minecart {

    /**
     * Gets the fuel level of the FurnaceMinecart
     *
     * @return fuel level
     */
    int getFuelLevel();

    /**
     * Sets the fuel level of the FurnaceMinecart
     * NOTE: The level increases by 3600 per Coal
     *
     * @param level
     *         the level to be set
     */
    void setFuelLevel(int level);

    /**
     * Increases the fuel level of the FurnaceMinecart
     *
     * @param increase
     *         the amount to increase the fuel level
     */
    void increaseFuelLevel(int increase);

    /**
     * Decreases the fuel level of the FurnaceMinecart
     *
     * @param decrease
     *         the amount to decrease the fuel level
     */
    void decreaseFuelLevel(int decrease);
}
