package net.canarymod.api.world;

import java.util.HashMap;

import static net.canarymod.Canary.log;

/**
 * Dynamic worldType list
 *
 * @author Chris (damagefilter)
 */
public class DimensionType {

    // *** STATIC STUFF ***
    private static HashMap<String, DimensionType> typeList = new HashMap<String, DimensionType>(5); // 3 std dims and 2 extras

    public static final DimensionType NETHER = registerType("NETHER", -1);
    public static final DimensionType NORMAL = registerType("NORMAL", 0);
    public static final DimensionType END = registerType("END", 1);

    /**
     * Registers a shallow {@link DimensionType} (only the name without attached Generator) to the system.
     * using a DimensionType like this will not have any effect on the world generation.
     * A default generator, based on the ID will be used. If there is none,
     * the default Minecraft world generator is used.
     *
     * @param name
     *         The name of the dimension
     * @param id
     *         The id. If the ID is already taken, a unique one is auto-generated
     */
    public static DimensionType registerType(String name, int id) {
        if (typeList.containsKey(name.toLowerCase())) {
            log.warn("Tried to add existing dimension type, aborting! DimensionType: " + name);
            return fromName(name);
        }
        if (validateId(id)) {
            typeList.put(name.toLowerCase(), new DimensionType(name, id));
            return fromName(name);
        }
        else {
            log.warn("DimensionType ID is not unique! Id: " + id + ", Type: " + name + " - Creating unique ID from hashCode!");
            typeList.put(name.toLowerCase(), new DimensionType(name, name.hashCode()));
            return fromName(name);
        }
    }

    /**
     * Registers a {@link DimensionType} with an attached world generator.
     * If a DimensionType like this is used, CanaryMod will substitute the default Minecraft World Generator
     * with the one that has been registered with this DimensionType.
     *
     * @param name
     *         The name of the dimension
     * @param id
     *         The id. If the ID is already taken, a unique one is auto-generated
     * @param cpc
     *         The Class instance of the custom world generator
     */
    public static DimensionType registerType(String name, int id, Class<? extends ChunkProviderCustom> cpc) {
        if (typeList.containsKey(name.toLowerCase())) {
            log.warn("Tried to add existing dimension type, aborting! DimensionType: " + name);
            return fromName(name);
        }
        if (validateId(id)) {
            typeList.put(name.toLowerCase(), new DimensionType(name, id, cpc));
            return fromName(name);
        }
        else {
            log.warn("WorldType ID is not unique! Id: " + id + ", Type: " + name + " - Creating unique ID from hashCode!");
            typeList.put(name.toLowerCase(), new DimensionType(name, name.hashCode(), cpc));
            return fromName(name);
        }
    }

    /**
     * Get a {@link DimensionType} from a given name.
     * May return null if there is no DimensionType with the given name.
     *
     * @param name
     *         The name. It's case insensitive.
     *
     * @return DimensionType based on the given name
     */
    public static DimensionType fromName(String name) {
        return typeList.get(name.toLowerCase());
    }

    /**
     * Get a {@link DimensionType} from a given ID.
     * May return null if there is no DimensionType with this ID
     *
     * @param id
     *         the Dimension ID
     *
     * @return {@link DimensionType} based on the given ID
     */
    public static DimensionType fromId(int id) {
        for (String name : typeList.keySet()) {
            String tmpname = name.toLowerCase();
            if (typeList.get(tmpname).getId() == id) {
                return typeList.get(tmpname);
            }
        }
        return null;
    }

    /**
     * Gets a {@link String[]} of known Dimension names
     *
     * @return {@link String[]} of known Dimension names
     */
    public static String[] knownDimensionNames() {
        return typeList.keySet().toArray(new String[typeList.size()]);
    }

    /**
     * Gets a {@link net.canarymod.api.world.DimensionType[]} of known Dimensions
     *
     * @return {@link net.canarymod.api.world.DimensionType[]} of known Dimensions
     */
    public static DimensionType[] knownDimensions() {
        return typeList.values().toArray(new DimensionType[typeList.size()]);
    }

    /**
     * Validates uniqueness of an ID
     *
     * @param id
     *         the id to check
     *
     * @return {@code true} if ID is unique, false otherwise
     */
    private static boolean validateId(int id) {
        for (String n : typeList.keySet()) {
            if (typeList.get(n.toLowerCase()).getId() == id) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a type with the given name exists.
     * This is case sensitive
     *
     * @param name
     *         the name of the DimensionType
     *
     * @return {@code true} if exists; {@code false} otherwise
     */
    public static boolean typeExists(String name) {
        return typeList.containsKey(name.toLowerCase());
    }

    // *** END STATIC STUFF ***

    private int id;
    private String name;
    private Class<? extends ChunkProviderCustom> cpc = null;

    // Make sure no-one can just instantiate a new world type
    private DimensionType(String name, int id) {
        this.id = id;
        this.name = name;
    }

    private DimensionType(String name, int id, Class<? extends ChunkProviderCustom> cpc) {
        this.id = id;
        this.name = name;
        this.cpc = cpc;
    }

    /**
     * Get the ID of this dimension type. With this ID the DimensionType can be identified.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name of this dimension type
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if this dimension type has a custom chunk provider attached
     *
     * @return {@code true} if has provider; {@code false} if not
     */
    public boolean hasChunkProvider() {
        return cpc != null;
    }

    /**
     * Get the ChunkProviderCustom that is attached to this Dimensiontype.
     * Note that this returns null if the DimensionType has no provider attached
     *
     * @return a new {@link ChunkProviderCustom}
     */
    public ChunkProviderCustom getChunkProvider() {
        try {
            return cpc.newInstance();
        }
        catch (InstantiationException ex) {
            log.error(ex.getMessage());
        }
        catch (IllegalAccessException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof DimensionType)) {
            return false;
        }
        DimensionType o = (DimensionType)ob;

        return o.name.equals(name) && o.id == id;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + id;
    }

    @Override
    public String toString() {
        return name + ":" + id;
    }
}
