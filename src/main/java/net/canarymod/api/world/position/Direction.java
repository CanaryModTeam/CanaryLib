package net.canarymod.api.world.position;

/**
 * Representation of the cardinal direction of a player
 * This is a convenient way of representing degrees of yaw
 *
 * @author Chris (damagefilter)
 */
public enum Direction {

    NORTH(0),
    NORTHEAST(1),
    EAST(2),
    SOUTHEAST(3),
    SOUTH(4),
    SOUTHWEST(5),
    WEST(6),
    NORTHWEST(7),
    ERROR(8);

    private int intValue = 0;

    private Direction(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public static Direction getFromIntValue(int value) {
        switch (value) {
            case 0:
                return NORTH;

            case 1:
                return NORTHEAST;

            case 2:
                return EAST;

            case 3:
                return SOUTHEAST;

            case 4:
                return SOUTH;

            case 5:
                return SOUTHWEST;

            case 6:
                return WEST;

            case 7:
                return NORTHWEST;

            default:
                return ERROR;
        }
    }
}
