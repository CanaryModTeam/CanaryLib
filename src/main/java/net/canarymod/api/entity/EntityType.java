package net.canarymod.api.entity;

/**
 * EntityType enum
 *
 * @author Jason (darkdiplomat)
 */
public enum EntityType {
    /* GENERIC TYPING */
    GENERIC_ENTITY(0, null),
    GENERIC_THROWABLE(0, GENERIC_ENTITY),
    GENERIC_VEHICLE(0, GENERIC_ENTITY),
    GENERIC_LIVING(49, GENERIC_ENTITY),
    GENERIC_ANIMAL(49, GENERIC_LIVING),
    GENERIC_MOB(48, GENERIC_LIVING),
    GENERIC_HANGING(0, GENERIC_ENTITY),
    GENERIC_EFFECT(0, GENERIC_ENTITY),

    ARMORSTAND(30, GENERIC_ENTITY),
    ARROW(10, GENERIC_THROWABLE),
    BAT(65, GENERIC_ANIMAL),
    BLACKSMITH(120, GENERIC_LIVING),
    BLAZE(61, GENERIC_MOB),
    BUTCHER(120, GENERIC_LIVING),
    BOAT(41, GENERIC_VEHICLE),
    CAVESPIDER(59, GENERIC_MOB),
    CHESTMINECART(43, GENERIC_VEHICLE),
    CHICKEN(93, GENERIC_ANIMAL),
    CHICKENEGG(0, GENERIC_THROWABLE),
    COMMANDBLOCKMINECART(40, GENERIC_VEHICLE),
    COW(92, GENERIC_ANIMAL),
    CREEPER(50, GENERIC_MOB),
    DONKEY(100, GENERIC_ANIMAL),
    EMPTYMINECART(42, GENERIC_VEHICLE),
    ENDERCRYSTAL(200, GENERIC_ENTITY),
    ENDERDRAGON(63, GENERIC_MOB),
    ENDEREYE(15, GENERIC_ENTITY),
    ENDERMAN(58, GENERIC_MOB),
    ENDERMITE(67, GENERIC_MOB),
    ENDERPEARL(14, GENERIC_THROWABLE),
    ENTITYITEM(1, GENERIC_ENTITY),
    ENTITYPOTION(16, GENERIC_THROWABLE),
    FALLINGBLOCK(21, GENERIC_ENTITY),
    FARMER(120, GENERIC_LIVING),
    FIREWORKROCKET(22, GENERIC_ENTITY),
    // FishHook has no ID, weird...
    FISHHOOK(0, GENERIC_ENTITY),
    FURNACEMINECART(44, GENERIC_VEHICLE),
    GUARDIAN(68, GENERIC_MOB),
    GHAST(56, GENERIC_MOB),
    GIANTZOMBIE(53, GENERIC_MOB),
    HOPPERMINECART(46, GENERIC_VEHICLE),
    HORSE(100, GENERIC_ANIMAL),
    IRONGOLEM(99, GENERIC_LIVING),
    ITEMFRAME(18, GENERIC_HANGING),
    LARGEFIREBALL(12, GENERIC_ENTITY),
    LEASHKNOT(8, GENERIC_HANGING),
    LIBRARIAN(120, GENERIC_LIVING),
    LIGHTNINGBOLT(0, GENERIC_EFFECT),
    MAGMACUBE(62, GENERIC_MOB),
    MOBSPAWNERMINECART(47, GENERIC_VEHICLE),
    MOOSHROOM(96, GENERIC_ANIMAL),
    MULE(100, GENERIC_ANIMAL),
    NPC(48, GENERIC_LIVING),
    NONPLAYABLECHARACTER(48, GENERIC_LIVING),
    OCELOT(98, GENERIC_ANIMAL),
    PAINTING(9, GENERIC_HANGING),
    PIG(90, GENERIC_ANIMAL),
    PIGZOMBIE(57, GENERIC_MOB),
    PLAYER(48, GENERIC_LIVING),
    POTION(16, GENERIC_THROWABLE),
    PRIEST(120, GENERIC_LIVING),
    SHEEP(91, GENERIC_ANIMAL),
    SILVERFISH(60, GENERIC_MOB),
    SKELETON(51, GENERIC_MOB),
    SKELETONHORSE(100, GENERIC_ANIMAL),
    SLIME(55, GENERIC_MOB),
    SMALLFIREBALL(13, GENERIC_ENTITY),
    SNOWBALL(11, GENERIC_THROWABLE),
    SNOWMAN(97, GENERIC_LIVING),
    SPIDER(52, GENERIC_MOB),
    SQUID(94, GENERIC_ANIMAL),
    RABBIT(101, GENERIC_ANIMAL),
    TNTMINECART(45, GENERIC_VEHICLE),
    TNTPRIMED(20, GENERIC_ENTITY),
    VILLAGER(120, GENERIC_LIVING),
    WITCH(66, GENERIC_MOB),
    WITHER(64, GENERIC_MOB),
    WITHERSKELETON(51, GENERIC_MOB),
    WITHERSKULL(19, GENERIC_ENTITY),
    WOLF(95, GENERIC_ANIMAL),
    XPBOTTLE(17, GENERIC_THROWABLE),
    XPORB(2, GENERIC_ENTITY),
    ZOMBIE(54, GENERIC_MOB),
    ZOMBIEHORSE(100, GENERIC_ANIMAL);

    private final short id;
    private EntityType subtype;

    private EntityType(int id, EntityType subtype) {
        this.id = (short)id;
        this.subtype = subtype;
    }

    public short getEntityID() {
        return id;
    }

    /**
     * Checks if the EntityType is that of a Throwable
     *
     * @return {@code true} if throwable; {@code false} if not
     */
    public boolean isThrowable() {
        return this == GENERIC_THROWABLE || this.isOf(GENERIC_THROWABLE);
    }

    /**
     * Checks if the EntityType is that of a Vehicle
     *
     * @return {@code true} if vehicle; {@code false} if not
     */
    public boolean isVehicle() {
        return this == GENERIC_VEHICLE || this.isOf(GENERIC_VEHICLE);
    }

    /**
     * Checks if the EntityType is that of a EntityLiving
     *
     * @return {@code true} if living; {@code false} if not
     */
    public boolean isLiving() {
        return this == GENERIC_LIVING || this.isOf(GENERIC_LIVING);
    }

    /**
     * Checks if the EntityType is that of an Animal
     *
     * @return {@code true} if animal; {@code false} if not
     */
    public boolean isAnimal() {
        return this == GENERIC_ANIMAL || this.isOf(GENERIC_ANIMAL);
    }

    /**
     * Checks if the EntityType is that of a Mob
     *
     * @return {@code true} if mob; {@code false} if not
     */
    public boolean isMob() {
        return this == GENERIC_MOB || this.isOf(GENERIC_MOB);
    }

    /**
     * Checks if the EntityType is that of a HangingEntity
     *
     * @return {@code true} if hanging; {@code false} if not
     */
    public boolean isHanging() {
        return this == GENERIC_HANGING || this.isOf(GENERIC_HANGING);
    }

    /**
     * Checks if the EntityType is that of a Effect (ie: LightningBolt)
     *
     * @return {@code true} if effect; {@code false} if not
     */
    public boolean isEffect() {
        return this == GENERIC_EFFECT || this.isOf(GENERIC_EFFECT);
    }

    /**
     * Checks if the EntityType is of a given type
     *
     * @param type
     *         the type to check for
     *
     * @return {@code true} if equal to or a subtype of; {@code false} if no relation
     */
    public boolean isOf(EntityType type) {
        if (this.subtype != null) {
            if (this.subtype.equals(type)) {
                return true;
            }
            // Else recurse
            return subtype.isOf(type);
        }
        return type.equals(this); // GENERIC_ENTITY final test
    }
}
