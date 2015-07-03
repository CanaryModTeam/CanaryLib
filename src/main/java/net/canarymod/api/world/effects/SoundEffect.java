package net.canarymod.api.world.effects;

/**
 * Sound Effects!
 *
 * @author Jason (darkdiplomat)
 */
public class SoundEffect {

    /**
     * The Sounds!
     *
     * @author Jason (darkdiplomat)
     */
    public enum Type {
        AMBIENCE_CAVE("ambient.cave.cave"),
        //
        AMBIENCE_RAIN("ambient.weather.rain"),
        //
        AMBIENCE_THUNDER("ambient.weather.thunder"),
        //
        ANVIL_BREAK("random.anvil_break"),
        //
        ANVIL_LAND("random.anvil_land"),
        //
        ANVIL_USE("random.anvil_use"),
        //
        BOW("random.bow"),
        //
        BOW_HIT("random.bowhit"),
        //
        BREATH("random.breath"),
        //
        BURP("random.burp"),
        //
        CHEST_CLOSED("random.chestclosed"),
        //
        CHEST_OPEN("random.chestopen"),
        //
        CLICK("random.click"),
        //
        DOOR_CLOSE("random.door_close"),
        //
        DOOR_OPEN("random.door_open"),
        //
        DRINK("random.drink"),
        //
        EAT("random.eat"),
        //
        EXPLODE("random.explode"),
        //
        FALL_BIG("damage.fallbig"),
        //
        FALL_SMALL("damage.fallsmall"),
        //
        FIRE("fire.fire"),
        //
        FIRE_IGNITE("fire.ignite"),
        //
        FIZZ("random.fizz"),
        //
        FUSE("random.fuse"),
        //
        GLASS("random.glass"),
        //
        HURT("random.classic_hurt"),
        //
        HURT_FLESH("damage.hit"),
        //
        ITEM_BREAK("random.break"),
        //
        ITEM_PICKUP("random.pop"),
        //
        LAVA("liquid.lava"),
        //
        LAVA_POP("liquid.lavapop"),
        //
        LEVEL_UP("random.levelup"),
        //
        LIQUID_SPLASH("liquid.splash"),
        //
        MINECART_BASE("minecart.base"),
        //
        MINECART_INSIDE("minecart.inside"),
        //
        NOTE_BASS("note.bass"),
        //
        NOTE_PIANO("note.harp"),
        //
        NOTE_BASS_DRUM("note.bd"),
        //
        NOTE_HAT("note.hat"),
        //
        NOTE_BASS_ATTACK("note.bassattack"),
        //
        NOTE_SNARE("note.snare"),
        //
        NOTE_PLING("note.pling"),
        //
        ORB("random.orb"),
        //
        PISTON_OUT("tile.piston.out"),
        //
        PISTON_IN("tile.piston.in"),
        //
        PORTAL("portal.portal"),
        //
        PORTAL_TRAVEL("portal.travel"),
        //
        PORTAL_TRIGGER("portal.trigger"),
        //
        SPLASH("random.splash"),
        //
        STEP_GRASS("step.grass"),
        //
        STEP_GRAVEL("step.gravel"),
        //
        STEP_LADDER("step.ladder"),
        //
        STEP_SAND("step.sand"),
        //
        STEP_SNOW("step.snow"),
        //
        STEP_STONE("step.stone"),
        //
        STEP_WOOD("step.wood"),
        //
        STEP_WOOL("step.cloth"),
        //
        SWIM("liquid.swim"),
        //
        WATER("liquid.water"),
        //
        WOOD_CLICK("random.wood click"),
        //
        // Das Mob sounds
        BAT_DEATH("mob.bat.death"),
        //
        BAT_HURT("mob.bat.hurt"),
        //
        BAT_IDLE("mob.bat.idle"),
        //
        BAT_LOOP("mob.bat.loop"),
        //
        BAT_TAKEOFF("mob.bat.takeoff"),
        //
        BLAZE_BREATH("mob.blaze.breath"),
        //
        BLAZE_DEATH("mob.blaze.death"),
        //
        BLAZE_HIT("mob.blaze.hit"),
        //
        CAT_HISS("mob.cat.hiss"),
        //
        CAT_HIT("mob.cat.hitt"),
        //
        CAT_MEOW("mob.cat.meow"),
        //
        CAT_PURR("mob.cat.purr"),
        //
        CAT_PURREOW("mob.cat.purreow"),
        //
        CHICKEN_HURT("mob.chicken.hurt"),
        //
        CHICKEN_PLOP("mob.chicken.plop"),
        //
        CHICKEN_SAY("mob.chicken.say"),
        //
        CHICKEN_STEP("mob.chicken.step"),
        //
        COW_SAY("mob.cow.say"),
        //
        COW_HURT("mob.cow.hurt"),
        //
        COW_STEP("mob.cow.step"),
        //
        CREEPER_DEATH("mob.creeper.death"),
        //
        CREEPER_SAY("mob.creeper.say"),
        //
        ENDERDRAGON_END("mob.enderdragon.end"),
        //
        ENDERDRAGON_GROWL("mob.enderdragon.growl"),
        //
        ENDERDRAGON_HIT("mob.enderdragon.hit"),
        //
        ENDERDRAGON_WINGS("mob.enderdragon.wings"),
        //
        ENDERMAN_DEATH("mob.endermen.death"),
        //
        ENDERMAN_HIT("mob.endermen.hit"),
        //
        ENDERMAN_IDLE("mob.endermen.idle"),
        //
        ENDERMAN_PORTAL("mob.endermen.portal"),
        //
        ENDERMAN_SCREAM("mob.endermen.scream"),
        //
        ENDERMAN_STARE("mob.endermen.stare"),
        //
        GHAST_SCREAM("mob.ghast.scream"),
        //
        GHAST_AFFECTIONATE_SCREAM("mob.ghast.affectionate scream"),
        //
        GHAST_CHARGE("mob.ghast.charge"),
        //
        GHAST_DEATH("mob.ghast.death"),
        //
        GHAST_FIREBALL("mob.ghast.fireball"),
        //
        GHAST_MOAN("mob.ghast.moan"),
        //
        IRONGOLEM_DEATH("mob.irongolem.death"),
        //
        IRONGOLEM_HIT("mob.irongolem.hit"),
        //
        IRONGOLEM_THROW("mob.irongolem.throw"),
        //
        IRONGOLEM_WALK("mob.irongolem.walk"),
        //
        MAGMACUBE_BIG("mob.magmacube.big"),
        //
        MAGMACUBE_JUMP("mob.magmacube.jump"),
        //
        MAGMACUBE_SMALL("mob.magmacube.small"),
        //
        PIG_DEATH("mob.pig.death"),
        //
        PIG_SAY("mob.pig.say"),
        //
        PIG_STEP("mob.pig.step"),
        //
        SHEEP_SAY("mob.sheep.say"),
        //
        SHEEP_SHEAR("mob.sheep.shear"),
        //
        SHEEP_STEP("mob.sheep.step"),
        //
        SILVERFISH_HIT("mob.silverfish.hit"),
        //
        SILVERFISH_KIL("mob.silverfish.kill"),
        //
        SILVERFISH_SAY("mob.silverfish.say"),
        //
        SILVERFISH_STEP("mob.silverfish.step"),
        //
        SKELETON_DEATH("mob.skeleton.death"),
        //
        SKELETON_HURT("mob.skeleton.hurt"),
        //
        SKELETON_SAY("mob.skeleton.say"),
        //
        SKELETON_STEP("mob.skeleton.step"),
        //
        SLIME_ATTACK("mob.slime.attack"),
        //
        SLIME_BIG("mob.slime.big"),
        //
        SLIME_SMALL("mob.slime.small"),
        //
        SPIDER_DEATH("mob.spider.death"),
        //
        SPIDER_SAY("mob.spider.say"),
        //
        SPIDER_STEP("mob.spider.step"),
        //
        WITHER_DEATH("mob.wither.death"),
        //
        WITHER_HURT("mob.wither.hurt"),
        //
        WITHER_IDLE("mob.wither.idle"),
        //
        WITHER_SHOOT("mob.wither.shoot"),
        //
        WITHER_SPAWN("mob.wither.spawn"),
        //
        WOLF_BARK("mob.wolf.bark"),
        //
        WOLF_DEATH("mob.wolf.death"),
        //
        WOLF_GROWL("mob.wolf.growl"),
        //
        WOLF_HOWL("mob.wolf.howl"),
        //
        WOLF_HURT("mob.wolf.hurt"),
        //
        WOLF_PANT("mob.wolf.panting"),
        //
        WOLF_SHAKE("mob.wolf.shake"),
        //
        WOLF_STEP("mob.wolf.step"),
        //
        WOLF_WHINE("mob.wolf.whine"),
        //
        ZOMBIE_METAL("mob.zombie.metal"),
        //
        ZOMBIE_WOOD("mob.zombie.wood"),
        //
        ZOMBIE_WOODBREAK("mob.zombie.woodbreak"),
        //
        ZOMBIE_SAY("mob.zombie.say"),
        //
        ZOMBIE_DEATH("mob.zombie.death"),
        //
        ZOMBIE_HURT("mob.zombie.hurt"),
        //
        ZOMBIE_INFECT("mob.zombie.infect"),
        //
        ZOMBIE_UNFECT("mob.zombie.unfect"),
        //
        ZOMBIE_REMEDY("mob.zombie.remedy"),
        //
        ZOMBIE_PIG_IDLE("mob.zombiepig.zpig"),
        //
        ZOMBIE_PIG_ANGRY("mob.zombiepig.zpigangry"),
        //
        ZOMBIE_PIG_DEATH("mob.zombiepig.zpigdeath"),
        //
        ZOMBIE_PIG_HURT("mob.zombiepig.zpighurt"),
        //
        // Digging Sounds
        DIG_CLOTH("dig.cloth"),
        //
        DIG_GRASS("dig.grass"),
        //
        DIG_GRAVEL("dig.gravel"),
        //
        DIG_SAND("dig.sand"),
        //
        DIG_SNOW("dig.snow"),
        //
        DIG_STONE("dig.stone"),
        //
        DIG_WOOD("dig.wood"),
        //
        ;

        private String mcName;

        Type(String name) {
            mcName = name;
        }

        public String getMcName() {
            return mcName;
        }
    }

    public Type type;
    public double x, y, z;
    public float volume, pitch;

    /**
     * Constructs a new SoundEffect
     *
     * @param type
     *         the SoundEffect Type
     * @param x
     *         the x coordinate
     * @param y
     *         the y coordinate
     * @param z
     *         the z coordinate
     * @param volume
     *         the volume of the sound (between 0.0 and 1.0)
     * @param pitch
     *         the frequency of the sound (between 0.0 and 1.0)
     */
    public SoundEffect(Type type, double x, double y, double z, float volume, float pitch) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.volume = volume;
        this.pitch = pitch;
    }
}
