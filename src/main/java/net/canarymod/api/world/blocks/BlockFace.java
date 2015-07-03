package net.canarymod.api.world.blocks;

/**
 * A BlockFace is a side of a block
 *
 * @author Chris (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public enum BlockFace {
    BOTTOM(AxisDirection.NEGATIVE, Axis.Y),
    TOP(AxisDirection.POSITIVE, Axis.Y),
    NORTH(AxisDirection.NEGATIVE, Axis.Z),
    SOUTH(AxisDirection.POSITIVE, Axis.Z),
    WEST(AxisDirection.NEGATIVE, Axis.X),
    EAST(AxisDirection.POSITIVE, Axis.X),
    UNKNOWN(null, null);

    private final AxisDirection direction;
    private final Axis axis;

    private BlockFace(AxisDirection direction, Axis axis) {
        this.direction = direction;
        this.axis = axis;
    }

    /**
     * Return this faces normal direction (The byte value to this face)
     *
     * @return the face byte value
     */
    public byte getByte() {
        return (byte)ordinal();
    }

    public Axis getAxis() {
        return axis;
    }

    public AxisDirection getDirection() {
        return direction;
    }

    /**
     * Get a BlockFace from byte
     *
     * @param normal
     *         the facing byte value
     *
     * @return the {@link BlockFace}
     */
    public static BlockFace fromByte(byte normal) {
        if (normal >= 6 || normal <= -1) {
            return UNKNOWN;
        }
        return values()[normal];
    }

    public static enum AxisDirection {
        POSITIVE,
        NEGATIVE
    }

    public static enum Axis {
        X(Plane.HORIZONTAL),
        Y(Plane.VERTICAL),
        Z(Plane.HORIZONTAL);

        private final Plane plane;

        private Axis(Plane plane) {
            this.plane = plane;
        }

        public Plane getPlane() {
            return plane;
        }
    }

    public static enum Plane {
        HORIZONTAL,
        VERTICAL
    }
}
