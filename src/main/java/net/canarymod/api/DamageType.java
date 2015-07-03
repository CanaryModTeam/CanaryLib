package net.canarymod.api;

/**
 * DamageType enum
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public enum DamageType {

    /**
     * Damage cause by an anvil
     */
    ANVIL,
    //
    /**
     * Damage cause by an arrow
     */
    ARROW,
    //
    /**
     * Damage caused by cactus (1)
     */
    CACTUS,
    //
    /**
     * Damage caused by an enchantment
     */
    ENCHANTMENT,
    //
    /**
     * Damage caused by explosion
     */
    EXPLOSION,
    //
    /**
     * Damage caused from falling (fall distance - 3.0)
     */
    FALL,
    //
    /**
     * Damage caused from a falling block
     */
    FALLING_BLOCK,
    //
    /**
     * Damage caused by fire (1)
     */
    FIRE,
    //
    /**
     * Damage cause by a Fireball (Assuming Ghast Fireball)
     */
    FIREBALL,
    //
    /**
     * Low periodic damage caused by burning (1)
     */
    FIRE_TICK,
    //
    /**
     * Typical Vanilla's /kill but could be used for other things
     */
    GENERIC,
    //
    /**
     * Damage caused from lava (4)
     */
    LAVA,
    //
    /**
     * Damage caused from a lightning bolt
     */
    LIGHTNINGBOLT,
    /**
     * Damage dealt by a Mob
     */
    MOB,
    //
    /**
     * Damage caused by a Player
     */
    PLAYER,
    //
    /**
     * Damage caused by poison (1) (Potions, Poison)
     */
    POTION,
    //
    /**
     * Damage caused by starvation (1)
     */
    STARVATION,
    //
    /**
     * Damage caused by suffocating(1)
     */
    SUFFOCATION,
    //
    /**
     * Damage caused by a thrown item (like a snowball)
     */
    THROWN,
    //
    /**
     * Damage caused from falling into the void
     */
    VOID,
    //
    /**
     * Damage caused from drowning (2)
     */
    WATER,
    //
    /**
     * Damage caused from a Wither
     */
    WITHER,
    //
    /**
     * Damage caused from thorns magic
     */
    THORNS,
    //
    ;

    /**
     * Gets the type from the {@link DamageSource}
     *
     * @param source
     *         the {@link DamageSource} to get the type for
     *
     * @return the type of the {@link DamageSource} if valid; {@code null} if not
     */
    public static DamageType fromDamageSource(DamageSource source) {
        if (source.getNativeName().equals("anvil")) {
            return ANVIL;
        }
        else if (source.getNativeName().equals("arrow")) {
            return ARROW;
        }
        else if (source.getNativeName().equals("cactus")) {
            return CACTUS;
        }
        else if (source.getNativeName().equals("indirectMagic")) {
            return ENCHANTMENT; // Assuming thats what it means
        }
        // NOTE: There's explosion and explosion.player which is now creeper damage
        else if (source.getNativeName().startsWith("explosion")) {
            return EXPLOSION; // Can also be a creeper.
        }
        else if (source.getNativeName().equals("fall")) {
            return FALL;
        }
        else if (source.getNativeName().equals("fallingBlock")) {
            return FALLING_BLOCK;
        }
        else if (source.getNativeName().equals("inFire")) {
            return FIRE; // Can also be lightning
        }
        else if (source.getNativeName().equals("fireball")) {
            return FIREBALL;
        }
        else if (source.getNativeName().equals("onFire")) {
            return FIRE_TICK;
        }
        else if (source.getNativeName().equals("generic")) {
            return GENERIC; // Vanilla's /kill, we don't have this, but Generic may just work for other things :3
        }
        else if (source.getNativeName().equals("lava")) {
            return LAVA;
        }
        else if (source.getNativeName().equals("lightningBolt")) {
            return LIGHTNINGBOLT;
        }
        else if (source.getNativeName().equals("mob")) {
            return MOB;
        }
        else if (source.getNativeName().equals("magic")) {
            return POTION;
        }
        else if (source.getNativeName().equals("starve")) {
            return STARVATION;
        }
        else if (source.getNativeName().equals("inWall")) {
            return SUFFOCATION;
        }
        else if (source.getNativeName().equals("thrown")) {
            return THROWN;
        }
        else if (source.getNativeName().equals("player")) {
            return PLAYER;
        }
        else if (source.getNativeName().equals("outOfWorld")) {
            return VOID;
        }
        else if (source.getNativeName().equals("drown")) {
            return WATER;
        }
        else if (source.getNativeName().equals("wither")) {
            return WITHER;
        }
        else if (source.getNativeName().equals("thorns")) {
            return THORNS;
        }
        else {
            return null; // Not a valid DamageSource
        }
    }
}
