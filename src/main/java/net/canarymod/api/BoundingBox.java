package net.canarymod.api;

/**
 * (Axis-Aligned) Bounding Box wrapper
 *
 * @author Jason Jones (darkdiplomat)
 */
public interface BoundingBox {

    /**
     * Gets the minimum X
     *
     * @return minimum X
     */
    double getMinX();

    /**
     * Gets the minimum Y
     *
     * @return minimum Y
     */
    double getMinY();

    /**
     * Gets the minimum Z
     *
     * @return minimum Z
     */
    double getMinZ();

    /**
     * Gets the maximum X
     *
     * @return maximum X
     */
    double getMaxX();

    /**
     * Gets the maximum Y
     *
     * @return maximum Y
     */
    double getMaxY();

    /**
     * Gets the maximum Z
     *
     * @return maximum Z
     */
    double getMaxZ();

    /**
     * Adds the coordinates to the bounding box extending it if the point lies outside the current ranges.
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     *
     * @return the extended BoundingBox
     */
    BoundingBox addCoordinates(double x, double y, double z);

    /**
     * Returns a bounding box expanded by the specified vector (if negative numbers are given it will shrink).
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     *
     * @return the expanded (or shrank) BoundingBox
     */
    BoundingBox expand(double x, double y, double z);

    /**
     * Returns a bounding box inset by the specified vector (if negative numbers are given it will expand).
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     *
     * @return the shrank (or expanded) BoundingBox
     */
    BoundingBox contract(double x, double y, double z);

    BoundingBox union(BoundingBox boundingBox);

    /**
     * Offsets the current bounding box by the specified coordinates.
     *
     * @param x
     *         the X coordinate
     * @param y
     *         the Y coordinate
     * @param z
     *         the Z coordinate
     *
     * @return the offset BoundingBox
     */
    BoundingBox offset(double x, double y, double z);

    /**
     * if instance and the argument bounding boxes overlap in the Y and Z dimensions, calculate the offset between them
     * in the X dimension.
     *
     * @param other
     *         the other BoundingBox
     * @param xOffset
     *         the X offset
     *
     * @return xOffset if the bounding boxes do not overlap or if xOffset is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    double calculateXOffset(BoundingBox other, double xOffset);

    /**
     * if instance and the argument bounding boxes overlap in the X and Z dimensions, calculate the offset between them
     * in the Y dimension.
     *
     * @param other
     *         the other BoundingBox
     * @param yOffset
     *         the Y offset
     *
     * @return yOffset if the bounding boxes do not overlap or if yOffset is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    double calculateYOffset(BoundingBox other, double yOffset);

    /**
     * if instance and the argument bounding boxes overlap in the X and Y dimensions, calculate the offset between them
     * in the Z dimension.
     *
     * @param other
     *         the other BoundingBox
     * @param zOffset
     *         the Z offset
     *
     * @return zOffset if the bounding boxes do not overlap or if zOffset is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    double calculateZOffset(BoundingBox other, double zOffset);

    /**
     * Checks whether the given bounding box intersects with this one.
     *
     * @return {@code true} if intersects; {@code false} if not
     */
    boolean intersectsWith(BoundingBox other);

    /**
     * Returns the average length of the edges of the bounding box.
     *
     * @return average length
     */
    double getAverageEdgeLength();
}
