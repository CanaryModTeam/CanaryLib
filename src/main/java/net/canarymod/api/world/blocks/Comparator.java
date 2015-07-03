package net.canarymod.api.world.blocks;

/**
 * Comparator wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Comparator extends TileEntity {

    /**
     * Gets the output signal of the Comparator
     *
     * @return output signal
     */
    int getOutputSignal();

    /**
     * Sets the output signal of the Comparator
     *
     * @param signal
     *         the output signal
     */
    void setOutputSignal(int signal);
}
