package net.canarymod.api.potion;

/**
 * Enum of all possible potion types.
 *
 * @author Brian (WWOL)
 * @author Jason (darkdiplomat)
 */
public enum PotionEffectType {
    MOVESPEED(1),
    //
    MOVESLOWDOWN(2),
    //
    DIGSPEED(3),
    //
    DIGSLOWDOWN(4),
    //
    DAMAGEBOOST(5),
    //
    HEAL(6),
    //
    HARM(7),
    //
    JUMP(8),
    //
    CONFUSION(9),
    //
    REGENERATION(10),
    //
    RESISTANCE(11),
    //
    FIRERESISTANCE(12),
    //
    WATERBREATHING(13),
    //
    INVISIBILITY(14),
    //
    BLINDNESS(15),
    //
    NIGHTVISION(16),
    //
    HUNGER(17),
    //
    WEAKNESS(18),
    //
    POISON(19),
    //
    WITHER(20),
    //
    HEALTHBOOST(21),
    //
    ABSORPTION(22),
    //
    SATURATION(23),
    //
    ;

    private final int id;

    PotionEffectType(int id) {
        this.id = id;
    }

    /**
     * Get a {@link PotionEffectType} from a name
     *
     * @param name
     *         the name of the PotionEffect
     *
     * @return PotionType or null if not valid name
     */
    public static PotionEffectType fromName(String name) {
        if (name.contains(".")) {
            name = name.substring(name.indexOf(".") + 1);
        }
        name = name.toUpperCase();

        try {
            return valueOf(name);
        }
        catch (IllegalArgumentException iaex) {
            return null;
        }
    }

    /**
     * Gets a PotionEffectType from an ID
     *
     * @param id
     *         the ID to get effect type for
     *
     * @return the PotionEffectType
     */
    public static PotionEffectType fromId(final int id) {
        for (PotionEffectType type : values()) {
            if (type.getID() == id) {
                return type;
            }
        }
        return null;
    }

    /**
     * Gets the PotionEffect ID
     *
     * @return the id
     */
    public int getID() {
        return id;
    }
}
