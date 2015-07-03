package net.canarymod.api.entity.hanging;

/**
 * Painting warpper
 *
 * @author Jason (darkdiplomat)
 */
public interface Painting extends HangingEntity {

    // This enum should mirror that of EnumArt DO NOT REORGINIZE!
    enum ArtType {
        Kebab,
        //
        Aztec,
        //
        Alban,
        //
        Aztec2,
        //
        Bomb,
        //
        Plant,
        //
        Wasteland,
        //
        Pool,
        //
        Courbet,
        //
        Sea,
        //
        Sunset,
        //
        Creebet,
        //
        Wanderer,
        //
        Graham,
        //
        Match,
        //
        Bust,
        //
        Stage,
        //
        Void,
        //
        SkullAndRoses,
        //
        Wither,
        //
        Fighters,
        //
        Pointer,
        //
        Pigscene,
        //
        BurningSkull,
        //
        Skeleton,
        //
        DonkeyKong;
    }

    /**
     * Gets the type of Art this painting is
     *
     * @return type
     */
    ArtType getArtType();

    /**
     * Sets the type of art this painting is
     *
     * @param type
     *         the {@link ArtType}
     */
    void setArtType(ArtType type);

    /**
     * Gets the x-wise size of this painting
     *
     * @return sizex
     */
    int getSizeX();

    /**
     * Gets the y-wise size of this painting
     *
     * @return sizey
     */
    int getSizeY();

    /**
     * Gets the x-wise offset of this painting
     *
     * @return offsetx
     */
    int getOffsetX();

    /**
     * Gets the y-wise offset of this painting
     *
     * @return offsety
     */
    int getOffsetY();
}
