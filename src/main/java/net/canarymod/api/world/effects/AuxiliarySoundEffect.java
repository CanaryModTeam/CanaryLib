package net.canarymod.api.world.effects;

/**
 * Auxiliary Sound Effects
 *
 * @author Jason (darkdiplomat)
 */
public class AuxiliarySoundEffect {

    /**
     * The Auxiliary Sound Effect Type
     *
     * @author Jason (darkdiplomat)
     */
    public enum Type {
        CLICK(1000),
        //
        CLICK2(1001),
        //
        BOW(1002),
        //
        DOOR_TOGGLE(1003),
        //
        EXTINGUISH(1004),
        //
        RECORD_PLAY(1005),
        //
        GHAST_SCREAM(1007),
        //
        GHAST_SHOOT(1008),
        //
        BLAZE_SHOOT(1009),
        //
        ZOMBIE_BANG_DOOR(1010),
        //
        ZOMBIE_BANG_IRON_DOOR(1011),
        //
        ZOMBIE_DESTROY_DOOR(1012),
        //
        SMOKE(2000),
        //
        STEP_SOUND(2001),
        //
        POTION_BREAK(2002),
        //
        ENDER_SIGNAL(2003),
        //
        MOBSPAWNER_FLAMES(2004),
        //
        BONE_MEAL(2005),
        //
        ;

        private int digits;

        private Type(int digits) {
            this.digits = digits;
        }

        public int getDigits() {
            return digits;
        }
    }

    public Type type;
    public int x, y, z, extra;

    /**
     * Constructs a new AuxiliarySoundEffect for a specified location
     *
     * @param type
     *         the type of effect to play
     * @param x
     *         the x coordinate to play at
     * @param y
     *         the y coordinate to play at
     * @param z
     *         the z coordinate to play at
     */
    public AuxiliarySoundEffect(Type type, int x, int y, int z) {
        this(type, x, y, z, 0);
    }

    /**
     * Constructs a new AuxiliarySoundEffect for a specified location
     *
     * @param type
     *         the type of effect to play
     * @param x
     *         the x coordinate to play at
     * @param y
     *         the y coordinate to play at
     * @param z
     *         the z coordinate to play at
     * @param extra
     *         extra bits like Potion ID or Direction
     *         for extra help see: http://wiki.vg/Protocol#Effects
     */
    public AuxiliarySoundEffect(Type type, int x, int y, int z, int extra) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.extra = extra;
    }
}
