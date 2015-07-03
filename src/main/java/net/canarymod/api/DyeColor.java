package net.canarymod.api;

/**
 * DyeColor
 *
 * @author Jason (darkdiplomat)
 */
public enum DyeColor {

    WHITE(15790320),
    //
    ORANGE(15435844),
    //
    MAGENTA(12801229),
    //
    LIGHT_BLUE(6719955),
    //
    YELLOW(14602026),
    //
    LIME(4312372),
    //
    PINK(14188952),
    //
    GRAY(4408131),
    //
    LIGHT_GRAY(11250603),
    //
    CYAN(2651799),
    //
    PURPLE(8073150),
    //
    BLUE(2437522),
    //
    BROWN(5320730),
    //
    GREEN(3887386),
    //
    RED(11743532),
    //
    BLACK(1973019),
    //
    CUSTOM(-1);
    ;

    private final int color_dec;

    private DyeColor(int color_dec) {
        this.color_dec = color_dec;
    }

    /**
     * Gets the Color Code as used for Wool and Wolf Collars
     *
     * @return color code
     */
    public int getColorCode() {
        return ordinal();
    }

    /**
     * Gets the Color Code as used for Dyes
     *
     * @return dye color code
     */
    public int getDyeColorCode() {
        return ~ordinal() & 15;
    }

    /**
     * Gets the decimal representation of the DyeColor
     *
     * @return the decimal code
     */
    public int getDecimalCode() {
        return color_dec;
    }

    /**
     * Gets a DyeColor from a Dye Color Code
     *
     * @param code
     *         the dye code to get a DyeColor for
     *
     * @return the DyeColor
     */
    public static DyeColor fromDyeColorCode(int code) {
        if (code < 0 || code > 15) {
            return CUSTOM;
        }
        return values()[~code & 15];
    }

    /**
     * Gets a DyeColor from a Color Code
     *
     * @param code
     *         the code to get a DyeColor for
     *
     * @return the DyeColor
     */
    public static DyeColor fromColorCode(int code) {
        if (code < 0 || code > 15) {
            return CUSTOM;
        }
        return values()[code];
    }

    /**
     * Gets the DyeColor from the decimal code
     *
     * @param code
     *         the decimal code to get a DyeColor for
     *
     * @return the DyeColor
     */
    public static DyeColor fromDecimalCode(int code) {
        for (DyeColor color : values()) {
            if (color.color_dec == code) {
                return color;
            }
        }
        return CUSTOM;
    }

    /**
     * Gets a raw color code from R G B values
     *
     * @param red
     *         the red color
     * @param green
     *         the green color
     * @param blue
     *         the blue color
     *
     * @return the rgb color
     */
    public static int rawColorFromRGB(int red, int green, int blue) {
        int rgb = Math.max(Math.min(0xFF, red), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, green), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, blue), 0);
        return rgb;
    }
}
