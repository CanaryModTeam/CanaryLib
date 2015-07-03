package net.canarymod.api.world.blocks.properties.helpers;

/**
 * Intermediary for Wood variants
 *
 * @author Jason Jones (darkdiplomat)
 */
public interface WoodProperties {

    /**
     * Wood variants
     *
     * @author Jason Jones (darkdiplomat)
     */
    enum Variant {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK;

        public static Variant valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IllegalArgumentException();
            }
            return values()[ordinal];
        }
    }
}
