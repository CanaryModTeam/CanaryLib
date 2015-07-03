package net.canarymod;

/**
 * Helper class for math methods
 *
 * @author Jason (darkdiplomat)
 */
public class MathHelp {

    /**
     * Checks if an integer is within a given range
     *
     * @param def
     *         the integer to check
     * @param min
     *         the minimum value allowed
     * @param max
     *         the maximum value allowed
     *
     * @return {@code true} if in range; {@code false} if not
     */
    public static boolean isInRange(int def, int min, int max) {
        return def >= min && def <= max;
    }

    /**
     * Sets an integer within the given range
     *
     * @param def
     *         the integer to check
     * @param min
     *         the minimum value allowed
     * @param max
     *         the maximum value allowed
     *
     * @return {@code def} if in range; {@code min} if {@code def} is lower than {@code min}; {@code max} if {@code def} is greater than {@code max}
     */
    public static int setInRange(int def, int min, int max) {
        return def <= max ? def >= min ? def : min : max;
    }

    /**
     * Sets a float within the given range
     *
     * @param def
     *         the float to check
     * @param min
     *         the minimum value allowed
     * @param max
     *         the maximum value allowed
     *
     * @return {@code def} if in range; {@code min} if {@code def} is lower than {@code min}; {@code max} if {@code def} is greater than {@code max}
     */
    public static float setInRange(float def, float min, float max) {
        return def <= max ? def >= min ? def : min : max;
    }
}
