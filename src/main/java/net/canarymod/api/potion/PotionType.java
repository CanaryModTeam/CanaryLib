package net.canarymod.api.potion;

/**
 * Potion Types<br>
 * EX = Extended, SP = Splash, II = 2, R = Reverted
 *
 * @author Jason (darkdiplomat)
 */
public enum PotionType {

    WATER_BOTTLE(0),
    //
    AWKWARD(16),
    //
    THICK(32),
    //
    MUNDANE_EX(64),
    //
    MUNDANE(8192),
    //
    REGENERATION(8193),
    //
    REGENERATION_II(8225),
    //
    REGENERATION_EX(8257),
    //
    REGENERATION_SP(16385),
    //
    REGENERATION_SP_II(16417),
    //
    REGENERATION_SP_EX(16449),
    //
    SWIFTNESS(8194),
    //
    SWIFTNESS_II(8226),
    //
    SWIFTNESS_EX(8258),
    //
    SWIFTNESS_SP(16386),
    //
    SWIFTNESS_SP_II(16418),
    //
    SWIFTNESS_SP_EX(16450),
    //
    FIRE_RESISTANCE(8195),
    //
    FIRE_RESISTANCE_R(8227),
    //
    FIRE_RESISTANCE_EX(8259),
    //
    FIRE_RESISTANCE_SP(16387),
    //
    FIRE_RESISTANCE_SP_R(16419),
    //
    FIRE_RESISTANCE_SP_EX(16451),
    //
    POISON(8196),
    //
    POISON_II(8228),
    //
    POISON_EX(8260),
    //
    POISON_SP(16388),
    //
    POISON_SP_II(16420),
    //
    POISON_SP_EX(16452),
    //
    INSTANT_HEALTH(8197),
    //
    INSTANT_HEALTH_II(8229),
    //
    INSTANT_HEALTH_R(8261),
    //
    INSTANT_HEALTH_SP(16389),
    //
    INSTANT_HEALTH__SP_II(16421),
    //
    INSTANT_HEALTH_SP_R(16453),
    //
    NIGHT_VISION(8198),
    //
    NIGHT_VISION_R(8230),
    //
    NIGHT_VISION_EX(8262),
    //
    NIGHT_VISION_SP(16390),
    //
    NIGHT_VISION_SP_R(16422),
    //
    NIGHT_VISION_SP_EX(16454),
    //
    WEAKNESS(8200),
    //
    WEAKNESS_R(8232),
    //
    WEAKNESS_EX(8264),
    //
    WEAKNESS_SP(16392),
    //
    WEAKNESS_SP_R(16424),
    //
    WEAKNESS_SP_EX(16456),
    //
    STRENGTH(8201),
    //
    STRENGTH_II(8233),
    //
    STRENGTH_EX(8265),
    //
    STRENGTH_SP(16393),
    //
    STRENGTH_SP_II(16425),
    //
    STRENGTH_SP_EX(16457),
    //
    SLOWNESS(8202),
    //
    SLOWNESS_R(8234),
    //
    SLOWNESS_EX(8266),
    //
    SLOWNESS_SP(16394),
    //
    SLOWNESS_SP_R(16426),
    //
    SLOWNESS_SP_EX(16458),
    //
    HARMING(8204),
    //
    HARMING_II(8236),
    //
    HARMING_R(8268),
    //
    HARMING_SP(16396),
    //
    HARMING_SP_II(16428),
    //
    HARMING_SP_R(16460),
    //
    INVISIBILITY(8206),
    //
    INVISIBILITY_R(8238),
    //
    INVISIBILITY_EX(8270),
    //
    INVISIBILITY_SP(16398),
    //
    INVISIBILITY_SP_R(16430),
    //
    INVISIBILITY_SP_EX(16462); //

    private final short typeId;

    private PotionType(int typeId) {
        this.typeId = (short)typeId; // Cause short and byte aren't as cool as L(ong), D(ouble), or F(loat)...
    }

    /**
     * Gets the TypeId
     *
     * @return typeId
     */
    public short getTypeId() {
        return typeId;
    }

    /**
     * Gets the associated PotionType for the given name
     *
     * @param name
     *         the name of the PotionType to get
     *
     * @return the associated PotionType if found; WATER_BOTTLE otherwise
     */
    public static PotionType fromName(String name) {
        try {
            return valueOf(name.toUpperCase());
        }
        catch (IllegalArgumentException iaex) {
            return WATER_BOTTLE;
        }
    }

    /**
     * Gets the associated PotionType for the given typeId
     *
     * @param typeId
     *         the typeId of the PotionType to get. (Item damage value)
     *
     * @return the associated PotionType if found; WATER_BOTTLE otherwise
     */
    public static PotionType fromTypeID(short typeId) {
        for (PotionType type : values()) {
            if (type.typeId == typeId) {
                return type;
            }
        }
        return WATER_BOTTLE;
    }
}
