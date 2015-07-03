package net.canarymod.api.world;

import java.util.HashMap;
import java.util.Map;

/**
 * Biome types enumeration
 *
 * @author Jason (darkdiplomat)
 */
public enum BiomeType {
    UNDEFINED(-1),
    // Is this one safe?
    OCEAN(0),
    //
    PLAINS(1),
    //
    DESERT(2),
    //
    HILLS_EXTREME(3),
    //
    FOREST(4),
    //
    TAIGA(5),
    //
    SWAMPLAND(6),
    //
    RIVER(7),
    //
    HELL(8),
    //
    SKY(9),
    //
    OCEAN_FROZEN(10),
    //
    RIVER_FROZEN(11),
    //
    PLAINS_ICE(12),
    //
    MOUNTAINS_ICE(13),
    //
    MUSHROOM_ISLAND(14),
    //
    MUSHROOM_ISLAND_SHORE(15),
    //
    BEACH(16),
    //
    HILLS_DESERT(17),
    //
    HILLS_FOREST(18),
    //
    HILLS_TAIGA(19),
    //
    HILLS_EXTREME_EDGE(20),
    //
    JUNGLE(21),
    //
    HILLS_JUNGLE(22),
    //
    JUNGLE_EDGE(23),
    //
    OCEAN_DEEP(24),
    //
    BEACH_STONE(25),
    //
    BEACH_COLD(26),
    //
    FOREST_BIRCH(27),
    //
    HILLS_FOREST_BIRCH(28),
    //
    FOREST_ROOFED(29),
    //
    TAIGA_COLD(30),
    //
    HILLS_TAIGA_COLD(31),
    //
    TAIGA_MEGA(32),
    //
    HILLS_TAIGA_MEGA(33),
    //
    HILLS_EXTREME_PLUS(34),
    //
    SAVANNA(35),
    //
    PLATEAU_SAVANNA(36),
    //
    MESA(37),
    //
    PLATEAU_MESA_F(38),
    //
    PLATEAU_MESA(39),
    //
    ;

    private byte id;
    private static Map<Byte, BiomeType> map;
    private static byte biomeCount = -1; //Start at -1 to account for undefined being -1

    private BiomeType(int id) {
        this.id = (byte)id;
        add(this.id, this);
    }

    private void add(byte type, BiomeType name) {
        if (map == null) {
            map = new HashMap<Byte, BiomeType>();
        }
        map.put(type, name);
        biomeCount++;
    }

    /**
     * Gets the byte for the BiomeType
     *
     * @return id
     * the BiomeType id
     */
    public byte getId() {
        return id;
    }

    /**
     * Gets the BiomeType from the byte id
     *
     * @param id
     *         the byte id
     *
     * @return the BiomeType
     */
    public static BiomeType fromId(byte id) {
        return map.get(id);
    }

    /**
     * Gets an array of BiomeTypes based on a byte array
     *
     * @param ids
     *         the byte array of Biome ids
     *
     * @return a BiomeType array
     */
    public static BiomeType[] fromIdArray(byte[] ids) {
        BiomeType[] types = new BiomeType[ids.length];
        for (int index = 0; index < ids.length; index++) {
            byte id;
            if ((id = ids[index]) < 0 || id > count()) {
                id = -1;
            }
            types[index] = fromId(id);
        }
        return types;
    }

    /**
     * Gets an array of bytes based on a BiomeType array
     *
     * @param types
     *         the biome types
     *
     * @return a byte array of Biome ids
     */
    public static byte[] fromTypeArray(BiomeType[] types) {
        byte[] ids = new byte[types.length];
        for (int index = 0; index < types.length; index++) {
            BiomeType type;
            if ((type = types[index]) == null) {
                type = BiomeType.UNDEFINED;
            }
            ids[index] = type.getId();
        }
        return ids;
    }

    public static int count() {
        return biomeCount;
    }
}
