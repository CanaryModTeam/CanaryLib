package net.canarymod.api.inventory;

import net.canarymod.api.world.World;

/**
 * Interface for Hoppers, At the time of writing this includes HopperBlock and
 * HopperMinecart.
 *
 * @author Somners
 */
public interface Hopper extends Inventory {

    /**
     * Get the {@link World} for this <tt>Hopper</tt>.
     *
     * @return This <tt>Hopper</tt>'s {@link World}
     */
    World getWorld();

    /**
     * Get the X position for this <tt>Hopper</tt>.
     *
     * @return This <tt>Hopper</tt>'s X position
     */
    double getPosX();

    /**
     * Get the Y position for this <tt>Hopper</tt>.
     *
     * @return This <tt>Hopper</tt>'s Y position
     */
    double getPosY();

    /**
     * Get the Y position for this <tt>Hopper</tt>.
     *
     * @return This <tt>Hopper</tt>'s Y position
     */
    double getPosZ();

    /**
     * Get the transfer cooldown for this <tt>Hopper</tt>.
     *
     * @return This <tt>Hopper</tt>'s transfer cooldown in ticks
     */
    int getTranferCooldown();

    /**
     * Set the transfer cooldown for this <tt>Hopper</tt>.
     *
     * @param cooldown
     *         This <tt>Hopper</tt>'s new transfer cooldown in ticks
     */
    void setTransferCooldown(int cooldown);
}
