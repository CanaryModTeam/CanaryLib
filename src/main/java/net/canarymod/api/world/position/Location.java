package net.canarymod.api.world.position;

import net.canarymod.Canary;
import net.canarymod.CanaryDeserializeException;
import net.canarymod.ToolBox;
import net.canarymod.api.world.DimensionType;
import net.canarymod.api.world.World;
import net.canarymod.config.Configuration;
import net.canarymod.database.LocationDataAccess;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * A Location represents a point in the world including pitch and rotation headings.
 *
 * @author Chris (damagefilter)
 */
public class Location extends Vector3D {

    private DimensionType dimension;
    private String world;
    private World cachedWorld;
    private float pitch, rotation;

    /**
     * Constructs a new Location
     *
     * @param world
     *         the world of the location
     * @param x
     *         the x coordinate of the location
     * @param y
     *         the y coordinate of the location
     * @param z
     *         the z coordinate of the location
     * @param pitch
     *         the y-rotation of the location
     * @param rotation
     *         the z-rotation of the location
     */
    public Location(World world, double x, double y, double z, float pitch, float rotation) {
        super(x, y, z);
        this.cachedWorld = world;
        this.dimension = cachedWorld.getType();
        this.world = cachedWorld.getName();
        this.pitch = pitch;
        this.rotation = rotation;
    }

    public Location(World world, Position template) {
        super(template.x, template.y, template.z);
        this.cachedWorld = world;
        this.dimension = cachedWorld.getType();
        this.world = cachedWorld.getName();
        this.pitch = 0f;
        this.rotation = 0f;
    }

    /**
     * Constructs a new Location in the default world
     *
     * @param x
     *         the x coordinate
     * @param y
     *         the y coordinate
     * @param z
     *         the z coordinate
     */
    public Location(double x, double y, double z) {
        super(x, y, z);
        this.cachedWorld = Canary.getServer().getDefaultWorld();
        this.dimension = cachedWorld.getType();
        this.world = cachedWorld.getName();
        pitch = rotation = 0f;
    }

    /**
     * Copy constructor copies the primitives
     *
     * @param templ
     */
    public Location(Location templ) {
        super(templ);
        this.cachedWorld = templ.cachedWorld;
        this.dimension = cachedWorld.getType();
        this.world = cachedWorld.getName();
        this.pitch = templ.getPitch();
        this.rotation = templ.getRotation();
    }

    /**
     * Get the rotation around the Y axis
     *
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Set the rotation around the Y axis
     *
     * @param rotation
     *         the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * Get the rotation around the X axis
     *
     * @return the pitch
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * Set the rotation around the X axis
     *
     * @param pitch
     *         the pitch to set
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    /**
     * The dimension ID
     *
     * @return the dimension
     */
    public DimensionType getType() {
        return cachedWorld.getType();
    }

    /**
     * @param dimension
     *         the dimension to set
     */
    public void setType(DimensionType dimension) {
        this.cachedWorld = Canary.getServer().getWorldManager().getWorld(cachedWorld.getName(), dimension, true);
        this.dimension = dimension;
    }

    /**
     * Check if this object is equal to another one
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location)) {
            return false;
        }
        else {
            Location l = (Location)other;

            return ((l.x == x) && (l.y == y) && (l.z == z) && (l.dimension == dimension) && (l.pitch == pitch) && (l.rotation == rotation) && (l.world.equals(world)));
        }
    }

    /**
     * Return a hashcode for this object
     */
    @Override
    public int hashCode() {
        int hash = 5;

        hash = (int)(hash + x);
        hash = (int)(hash + y);
        hash = (int)(hash + z);
        hash = (int)(hash + pitch);
        hash = (int)(hash + rotation);
        return hash;
    }

    /**
     * @return the world
     */
    public String getWorldName() {
        return cachedWorld.getName();
    }

    /**
     * @param world
     *         the world to set
     */
    public void setWorldName(String world) {
        this.cachedWorld = Canary.getServer().getWorldManager().getWorld(world, dimension, true);
        this.world = world;
    }

    /**
     * Returns the actual world this location belongs to
     *
     * @param autoload
     *         {@code true} to auto load the world; {@code false} otherwise.
     *
     * @return the location's world
     *
     * @deprecated Use getWorld instead. World is loaded in all cases
     */
    @Deprecated
    public World getWorld(boolean autoload) {
        return Canary.getServer().getWorldManager().getWorld(world, dimension, autoload);
    }

    /**
     * Returns the actual world this location belongs to.
     * Returns null if the world name or dimension that was specified was invalid.
     *
     * @return the location's world
     */
    public World getWorld() {
        return this.cachedWorld;
    }

    /**
     * Internal method to set the world after deserializing.
     */
    private void setWorld() {
        this.cachedWorld = Canary.getServer().getWorldManager().getWorld(this.world, this.dimension, true);
    }

    /**
     * Returns the actual world this location belongs to
     * Will auto load the world if the world's config has allow warp auto load set to {@code true}
     *
     * @return the location's world
     *
     * @deprecated use getWorld, world is already checked
     */
    @Deprecated
    public World getWorldChecked() {
        String fqName = ToolBox.parseWorldName(world, dimension);
        return getWorld(Configuration.getWorldConfig(fqName).allowWarpAutoLoad());
    }

    /**
     * Return a String representation that can also be used for storing somewhere
     * for this Location.
     */
    public String toString() {
        StringBuilder fields = new StringBuilder();

        fields.append(this.x).append(";").append(this.y).append(";").append(this.z).append(";").append(this.pitch).append(";").append(this.rotation).append(";").append(this.dimension.getId()).append(";").append(this.world);
        return fields.toString();
    }

    /**
     * Turn a String Location that has been formatted by Location.toString() (or has a compatible format) into a Location object
     *
     * @param fields
     *         the string of the fields
     *
     * @return deserialized Location
     *
     * @throws CanaryDeserializeException
     *         if the String does not contain enough information or incorrect information
     */
    public static Location fromString(String fields) throws CanaryDeserializeException {
        Location loc = emptyLocation();
        String[] split = fields.split(";");

        if (split.length != 7) {
            throw new CanaryDeserializeException("Failed to deserialize Location: Expected fields are 7. Found " + split.length, "CanaryMod");
        }
        try {
            loc.setX(Double.parseDouble(split[0]));
            loc.setY(Double.parseDouble(split[1]));
            loc.setZ(Double.parseDouble(split[2]));
            loc.setPitch(Float.parseFloat(split[3]));
            loc.setRotation(Float.parseFloat(split[4]));
            loc.setType(DimensionType.fromId(Integer.parseInt(split[5])));
            loc.setWorldName(split[6]);
            loc.setWorld();
            return loc;
        }
        catch (NumberFormatException e) {
            throw new CanaryDeserializeException("Failed to deserialize Location: " + e.getMessage(), "CanaryMod");
        }
    }

    public String asReadableString(ReadMode... modes) {
        EnumSet<ReadMode> modeSet = EnumSet.noneOf(ReadMode.class);
        if (modes != null && modes.length != 0) {
            modeSet.addAll(Arrays.asList(modes));
        }
        StringBuilder builder = new StringBuilder();
        if (modeSet.contains(ReadMode.XYZ)) {
            builder.append("X:").append(getBlockX()).append(" ");
            builder.append("Y:").append(getBlockY()).append(" ");
            builder.append("Z:").append(getBlockZ()).append(" ");
        }
        else if (modeSet.contains(ReadMode.XYZFLOAT)) {
            builder.append("X:").append(String.format("%.3f", getX())).append(" ");
            builder.append("Y:").append(String.format("%.3f", getY())).append(" ");
            builder.append("Z:").append(String.format("%.3f", getZ())).append(" ");
        }

        if (modeSet.contains(ReadMode.ROTATION)) {
            builder.append("Rotation:").append(String.format("%.3f", getRotation())).append(" ");
            builder.append("Pitch:").append(String.format("%.3f", getPitch())).append(" ");
        }

        if (modeSet.contains(ReadMode.WORLD)) {
            builder.append("World:").append(getWorldName()).append(" ");
        }

        if (modeSet.contains(ReadMode.DIMENSION)) {
            builder.append("Dimension:").append(getType().getName()).append(" ");
        }
        return builder.toString();
    }

    public LocationDataAccess toDataAccess(LocationDataAccess lda) {
        super.toDataAccess(lda);
        lda.rotation = this.rotation;
        lda.pitch = this.pitch;
        lda.world = this.world;
        lda.dimension = this.dimension.getName();
        return lda;
    }

    public static Location fromDataAccess(LocationDataAccess lda) {
        Location loc = emptyLocation();
        loc.setX(lda.posX);
        loc.setY(lda.posY);
        loc.setZ(lda.posZ);
        loc.setPitch(lda.pitch);
        loc.setRotation(lda.rotation);
        loc.setType(DimensionType.fromName(lda.dimension));
        loc.setWorldName(lda.world);
        loc.setWorld();
        return loc;
    }

    public static Location emptyLocation() {
        return new Location(0, 0, 0);
    }

    @Override
    public Location clone() throws CloneNotSupportedException {
        return (Location)super.clone();
    }

    public Location copy() {
        try {
            return this.clone();
        }
        catch (CloneNotSupportedException e) {
            // it is supported...
        }
        return new Location(this);
    }

    /**
     * Used in Readable String to define what information to pass
     */
    public enum ReadMode {
        XYZ,
        XYZFLOAT,
        ROTATION,
        WORLD,
        DIMENSION
    }
}
