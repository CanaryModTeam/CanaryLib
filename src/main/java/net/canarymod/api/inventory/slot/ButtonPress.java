package net.canarymod.api.inventory.slot;

/**
 * Button press enum for SlotClickHook
 *
 * @author Jason (darkdiplomat)
 */
public enum ButtonPress {

    /**
     * Left Mouse Button
     */
    LEFT,
    //
    /**
     * Right Mouse Button
     */
    RIGHT,
    //
    /**
     * Middle Mouse Button
     */
    MIDDLE,
    //
    /**
     * Hotbar 1
     */
    KEY_1,
    //
    /**
     * Hotbar 2
     */
    KEY_2,
    //
    /**
     * Hotbar 3
     */
    KEY_3,
    //
    /**
     * Hotbar 4
     */
    KEY_4,
    //
    /**
     * Hotbar 5
     */
    KEY_5,
    //
    /**
     * Hotbar 6
     */
    KEY_6,
    //
    /**
     * Hotbar 7
     */
    KEY_7,
    //
    /**
     * Hotbar 8
     */
    KEY_8,
    //
    /**
     * Hotbar 9
     */
    KEY_9,
    //
    /**
     * Drop Key
     */
    KEY_DROP,
    //
    /**
     * Control + Drop key
     */
    CTRL_DROP,
    //
    /**
     * Starting Painting with Left Click (or Middle Click)
     */
    LEFT_PAINT_START,
    //
    /**
     * Slot passed with Left Click Paint (or Middle Click)
     */
    LEFT_PAINT_PROGRESS,
    //
    /**
     * Left Click Paint end (or Middle Click)
     */
    LEFT_PAINT_END,
    //
    /**
     * Starting Painting with Right Click
     */
    RIGHT_PAINT_START,
    //
    /**
     * Slot passed with Right Click Paint
     */
    RIGHT_PAINT_PROGRESS,
    //
    /**
     * Right Click Paint end
     */
    RIGHT_PAINT_END,
    //
    /**
     * Unknown button pressed
     */
    UNKNOWN,
    //
    ;

    /**
     * Gets the ButtonPress as defined with {@link GrabMode}, the button id, and the slot id
     *
     * @param mode
     *         the {@link GrabMode} to use with matching
     * @param pressed
     *         the button id from the packet
     * @param slot
     *         the slot id
     *
     * @return the ButtonPress constant that matches with the arguments
     */
    public static ButtonPress matchButton(GrabMode mode, int pressed, int slot) {
        if (mode == GrabMode.HOVER_SWAP) {
            switch (pressed) {
                case 0:
                    return KEY_1;
                case 1:
                    return KEY_2;
                case 2:
                    return KEY_3;
                case 3:
                    return KEY_4;
                case 4:
                    return KEY_5;
                case 5:
                    return KEY_6;
                case 6:
                    return KEY_7;
                case 7:
                    return KEY_8;
                case 8:
                    return KEY_9;
                default:
                    return UNKNOWN;
            }
        }
        else if (mode == GrabMode.PAINT) {
            switch (pressed) {
                case 0:
                    return LEFT_PAINT_START;
                case 1:
                    return LEFT_PAINT_PROGRESS;
                case 2:
                    return LEFT_PAINT_END;
                case 4:
                    return RIGHT_PAINT_START;
                case 5:
                    return RIGHT_PAINT_PROGRESS;
                case 6:
                    return RIGHT_PAINT_END;
                default:
                    return UNKNOWN;
            }
        }
        else if (mode == GrabMode.DROP) {
            switch (pressed) {
                case 0:
                    if (slot == -999) {
                        return LEFT;
                    }
                    else {
                        return KEY_DROP;
                    }
                case 1:
                    if (slot == -999) {
                        return RIGHT;
                    }
                    else {
                        return CTRL_DROP;
                    }
                default:
                    return UNKNOWN;
            }
        }
        else {
            switch (pressed) {
                case 0:
                    return LEFT;
                case 1:
                    return RIGHT;
                case 2:
                    return MIDDLE;
                default:
                    return UNKNOWN;
            }
        }
    }
}
