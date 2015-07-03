package net.canarymod.api.inventory.slot;

/**
 * The Grab mode used with SlotClickHook
 *
 * @author Jason (darkdiplomat)
 */
public enum GrabMode {

    /**
     * Default slot clicking
     */
    DEFAULT,
    //

    /**
     * Holding shift while clicking
     */
    SHIFT_CLICK,
    //

    /**
     * Center mouse button click
     */
    PICK_BLOCK,
    //

    /**
     * Hovering over an Item and hitting a HotBar key (0-9)
     */
    HOVER_SWAP,
    //

    /**
     * Drop key press while hovering over an Item or clicking outside window without an item
     */
    DROP,
    //

    /**
     * Clicking outside with an Item stack and dragging it over the window
     */
    PAINT,
    //

    /**
     * Double (left) clicking a slot
     */
    DOUBLE_CLICK,
    //

    /**
     * Unknown mode
     */
    UNKNOWN,
    //
    ;

    /**
     * Gets the grab mode based on the integer from the packet
     *
     * @param opt
     *         the mode id
     *
     * @return the GrabMode for the mode id
     */
    public static GrabMode fromInt(int opt) {
        switch (opt) {
            case 0:
                return DEFAULT;
            case 1:
                return SHIFT_CLICK;
            case 2:
                return HOVER_SWAP;
            case 3:
                return PICK_BLOCK;
            case 4:
                return DROP;
            case 5:
                return PAINT;
            case 6:
                return DOUBLE_CLICK;
            default:
                return UNKNOWN;
        }
    }
}
