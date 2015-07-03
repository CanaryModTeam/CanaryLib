package net.canarymod.api.world.position;

import net.canarymod.CanaryDeserializeException;

/**
 * A Vector3D represents a point ins in the 3D space.
 * That can be a block or a player coodinate
 *
 * @author chris, Tobias (Toble_Miner)
 */
public class Vector3D extends Position {
    /**
     * This is the nullvector (0,0,0)
     */
    public static final Vector3D zero = new Vector3D(0, 0, 0);

    /**
     * Shortcut to Vector3D(0,0,1)
     */
    public static final Vector3D forward = new Vector3D(0, 0, 1);

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Copy constructor copies the primitives
     *
     * @param templ
     */
    public Vector3D(Vector3D templ) {
        super(templ);
    }

    /**
     * Copy constructor copies the primitives
     *
     * @param templ
     */
    public Vector3D(Position templ) {
        super(templ);
    }

    /**
     * Get the distance between this and the given vector
     *
     * @param v
     *
     * @return
     */
    public double getDistance(Position v) {
        double diffX = v.getX() - this.getX();
        double diffY = v.getY() - this.getY();
        double diffZ = v.getZ() - this.getZ();

        return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
    }

    /**
     * Get the square distance between this and the given vector.
     * This is substantially faster than the standard getDistance
     * but you'll have to squre the numbers you're checking against yourself
     *
     * @param v
     *
     * @return
     */
    public double getSquareDistance(Position v) {
        double diffX = v.getX() - this.getX();
        double diffY = v.getY() - this.getY();
        double diffZ = v.getZ() - this.getZ();

        return (diffX * diffX + diffY * diffY + diffZ * diffZ);
    }

    /**
     * Retrieve the distance between 2 given vectors
     *
     * @param v1
     *
     * @return double The Distance
     */
    public static double getDistance(Vector3D v1, Vector3D v2) {
        return v2.getDistance(v1);
    }

    /**
     * Checks if another object equals this one
     *
     * @param obj
     *
     * @return whether the other object has the same values for x,y,z
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector3D)) {
            return false;
        }
        Vector3D other = (Vector3D)obj;

        return other.getX() == this.x && other.getY() == this.y && other.getZ() == this.z;
    }

    /**
     * Return a hashcode for this object
     */
    @Override
    public int hashCode() {
        int hash = 3;

        hash = (int)(hash + x);
        hash = (int)(hash + y);
        hash = (int)(hash + z);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();

        format.append(this.x).append(":").append(this.y).append(":").append(this.z);
        return format.toString();
    }

    /**
     * Check if this vector is contained within the range of the given two.
     * It can be seen as a AABB collision test.
     *
     * @param min
     * @param max
     *
     * @return
     */
    public boolean isWithin(Position min, Position max) {
        return (min.x <= this.x && this.x <= max.x) &&
                (min.y <= this.y && this.y <= max.y) &&
                (min.z <= this.z && this.z <= max.z);

//        return this.getBlockX() >= min.getBlockX() && this.getBlockX() <= max.getBlockX() && this.getBlockY() >= min.getBlockY() && this.getBlockY() <= max.getBlockY() && this.getBlockZ() >= min.getBlockZ() && this.getBlockZ() <= max.getBlockZ();
    }

    /**
     * Add the given Vector to this Vector and return the result as new Vector3D
     *
     * @param toAdd
     *
     * @return Vector3D result of addition
     */
    public Vector3D add(Vector3D toAdd) {
        return new Vector3D(this.x + toAdd.x, this.y + toAdd.y, this.z + toAdd.z);
    }

    /**
     * Subtract the given Vector from this Vector and return the result as new Vector3D
     *
     * @param toRemove
     *
     * @return Vector3D result of subtraction
     */
    public Vector3D subtract(Vector3D toRemove) {
        return new Vector3D(this.x - toRemove.x, this.y - toRemove.y, this.z - toRemove.z);
    }

    /**
     * Scalar multiply this vector with a given factor and return the result as new Vector3D
     *
     * @param scalar
     *
     * @return scalar product as Vector3D
     */
    public Vector3D multiply(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Calculates the dot product of this vector with another
     *
     * @param v
     *         Vector
     *
     * @return dot product
     */
    public double dot(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /**
     * Calculates the angle between this vector and another
     * @param v Vector
     *
     * @return angle between vectors
     */
    public double angle(Vector3D v) {
        return Math.acos(this.dot(v) / (this.getMagnitude() * v.getMagnitude()));
    }


    /**
     * Get the length (or magnitude) of this vector
     *
     * @return
     */
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public Vector3D clone() throws CloneNotSupportedException {
        return (Vector3D)super.clone();
    }

    public Vector3D copy() {
        try {
            return this.clone();
        }
        catch (CloneNotSupportedException e) {
            // it is supported...
        }
        return new Vector3D(this);
    }

    /**
     * Gets the minimum components of two vectors.
     *
     * @param v1
     * @param v2
     *
     * @return minimum
     */
    public static Vector3D getMinimum(Position v1, Position v2) {
        return new Vector3D(Math.min(v1.getX(), v2.getX()), Math.min(v1.getY(), v2.getY()), Math.min(v1.getZ(), v2.getZ()));
    }

    /**
     * Gets the maximum components of two vectors.
     *
     * @param v1
     * @param v2
     *
     * @return minimum
     */
    public static Vector3D getMaximum(Position v1, Position v2) {
        return new Vector3D(Math.max(v1.getX(), v2.getX()), Math.max(v1.getY(), v2.getY()), Math.max(v1.getZ(), v2.getZ()));
    }

    /**
     * Calculates the center point between 2 points
     *
     * @param p1
     *         first point
     * @param p2
     *         second point
     *
     * @return Vector between p1 and p2
     */
    public static Vector3D getCenterPoint(Position p1, Position p2) {
        double x = (p1.getX() + p2.getX()) / 2;
        double y = (p1.getY() + p2.getY()) / 2;
        double z = (p1.getZ() + p2.getZ()) / 2;
        return new Vector3D(x, y, z);
    }

    /**
     * Retrieve the major of two vectors (the one farther away from 0,0,0)
     *
     * @param v1
     * @param v2
     *
     * @return Major Vector, null if something went wrong
     */
    public static Vector3D getMajor(Vector3D v1, Vector3D v2) {
        double dv1 = v1.getMagnitude();
        double dv2 = v2.getMagnitude();
        double max = Math.max(v1.getMagnitude(), v2.getMagnitude());
        if (max == dv1) {
            return v1;
        }
        else if (max == dv2) {
            return v2;
        }
        else {
            return null;
        }
    }

    /**
     * Retrieve the minor of two vectors (the one nearer to 0,0,0
     *
     * @param v1
     * @param v2
     *
     * @return Minor Vector, null if something went wrong
     */
    public static Vector3D getMinor(Vector3D v1, Vector3D v2) {
        double dv1 = v1.getMagnitude();
        double dv2 = v2.getMagnitude();
        double min = Math.min(v1.getMagnitude(), v2.getMagnitude());
        if (min == dv1) {
            return v1;
        }
        else if (min == dv2) {
            return v2;
        }
        else {
            return null;
        }
    }

    public static Vector3D fromString(String in) {
        String[] parts = in.split(":");
        if (parts.length != 3) {
            throw new CanaryDeserializeException("Given Vector3 String does not contain 3 components!", "CanaryMod");
        }
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        double z = Double.parseDouble(parts[2]);
        return new Vector3D(x, y, z);
    }
}
