package net.canarymod.api.entity.living.monster;

/**
 * Slime wrapper
 *
 * @author Jason (darkdiplomat)
 */
public interface Slime extends EntityMob {

    enum Size {
        // sizes 1, 2, and 4 spawn naturally -- according to CanaryWiki
        TINY((byte)1),
        SMALL((byte)2),
        BIG((byte)4);
        private byte size;

        Size(byte size) {
            this.size = size;
        }

        /**
         * Get the byte number for this Size.
         *
         * @return size
         */
        public byte getByte() {
            return size;
        }

        /**
         * Get size type for this byte. Returns TINY on invalid numbers
         *
         * @param size
         *         the byte size
         *
         * @return {@link Size}
         */
        public static Size fromByte(byte size) {
            switch (size) {
                case 1:
                    return TINY;

                case 2:
                    return SMALL;

                case 4:
                    return BIG;

                default:
                    return TINY;
            }
        }
    }

    /**
     * Gets the size of the slime
     *
     * @return size
     */
    Size getSize();

    /**
     * Sets the size of the slime
     *
     * @param size
     *         the {@link Size} to set
     */
    void setSize(Size size);
}
