package net.canarymod.api.world.effects;

/**
 * A particle that can be spawned in the world.
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public class Particle {
    public enum Type {
        EXPLOSION_NORMAL("explode"),
        EXPLOSION_LARGE("largeexplode"),
        EXPLOSION_HUGE("hugeexplosion"),
        FIREWORKS_SPARK("fireworksSpark"),
        WATER_BUBBLE("bubble"),
        WATER_SPLASH("splash"),
        WATER_WAKE("wake"),
        SUSPENDED("suspended"),
        SUSPENDED_DEPTH("depthsuspend"),
        CRIT("crit"),
        CRIT_MAGIC("magicCrit"),
        SMOKE_NORMAL("smoke"),
        SMOKE_LARGE("largesmoke"),
        SPELL("spell"),
        SPELL_INSTANT("instantSpell"),
        SPELL_MOB("mobSpell"),
        SPELL_MOB_AMBIENT("mobSpellAmbient"),
        SPELL_WITCH("witchMagic"),
        DRIP_WATER("dripWater"),
        DRIP_LAVA("dripLava"),
        VILLAGER_ANGRY("angryVillager"),
        VILLAGER_HAPPY("happyVillager"),
        TOWN_AURA("townaura"),
        NOTE("note"),
        PORTAL("portal"),
        ENCHANTMENT_TABLE("enchantmenttable"),
        FLAME("flame"),
        LAVA("lava"),
        FOOTSTEP("footstep"),
        CLOUD("cloud"),
        REDSTONE("reddust"),
        SNOWBALL("snowballpoof"),
        SNOW_SHOVEL("snowshovel"),
        SLIME("slime"),
        HEART("heart"),
        BARRIER("barrier"),
        ITEM_CRACK("iconcrack_"),
        BLOCK_CRACK("blockcrack_"),
        BLOCK_DUST("blockdust_"),
        WATER_DROP("droplet"),
        ITEM_TAKE("take"),
        MOB_APPEARANCE("mobappearance"),
        SWEEP_ATTACK("sweepAttack"),
        DRAGON_BREATH("dragonBreath"),
        END_ROD("endRod"),
        DAMAGE_INDICATOR("damageIndicator");

        private String mcName;

        Type(String name) {
            mcName = name;
        }

        public String getMcName() {
            return mcName;
        }

        public static Type fromName(String name) {
            for (Type t : values()) {
                if (t.mcName.equals(name)) {
                    return t;
                }
            }
            return null;
        }
    }

    public Type type;
    public double x, y, z, velocityX, velocityY, velocityZ;
    public float speed;
    public int quantity;

    public Particle(double x, double y, double z, Type type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        velocityX = velocityZ = 0;
        velocityY = 0.5;
    }

    public Particle(double x, double y, double z, double velocityX, double velocityY, double velocityZ, Type type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.speed = 0.5F;
        this.quantity = 10;
    }

    public Particle(double x, double y, double z, double velocityX, double velocityY, double velocityZ, float speed, int quantity, Type type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.speed = speed;
        this.quantity = quantity;
    }
}
