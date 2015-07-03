package net.canarymod.api.inventory.helper;

import net.canarymod.api.DyeColor;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.nbt.NBTTagType;

import static net.canarymod.api.DyeColor.rawColorFromRGB;

/**
 * Colored Item helper
 *
 * @author Jason (darkdiplomat)
 */
final class ColoredItemHelper extends ItemHelper {
    private ColoredItemHelper() {
    } // This class should never be constructed

    /**
     * Checks if the {@link Item} has color
     *
     * @param item
     *         the {@link Item} to be checked
     *
     * @return {@code true} if colored; {@code false} if not
     */
    static boolean isColored(Item item) {
        if (!verifyTags(item, "display", NBTTagType.COMPOUND, false)) {
            return false;
        }
        return item.getDataTag().getCompoundTag("display").containsKey("color");
    }

    /**
     * Gets the color of the {@link Item}
     *
     * @param item
     *         the {@link Item} to get color of
     *
     * @return the color of the {@link Item} or -1 if there is no color
     */
    static int getColor(Item item) {
        if (!verifyTags(item, "display", NBTTagType.COMPOUND, false)) {
            return -1;
        }
        if (!item.getDataTag().getCompoundTag("display").containsKey("color")) {
            return -1;
        }
        return item.getDataTag().getCompoundTag("display").getInt("color");
    }

    /**
     * Sets the color of the {@link Item} based on an RGB value
     *
     * @param item
     *         the {@link Item} to set color of
     * @param rgb
     *         the RGB color value to set
     *
     * @see DyeColor#rawColorFromRGB(int, int, int)
     */
    static void setColor(Item item, int rgb) {
        verifyTags(item, "display", NBTTagType.COMPOUND, true);
        item.getDataTag().getCompoundTag("display").put("color", Math.max(Math.min(0xFFFFFF, rgb), 0));
    }

    /**
     * Sets the color of the {@link Item} with specified red, green, and blue color values
     *
     * @param item
     *         the {@link Item} to set color of
     * @param red
     *         the red color value
     * @param green
     *         the green color value
     * @param blue
     *         the blue color value
     */
    static void setColor(Item item, int red, int green, int blue) {
        setColor(item, rawColorFromRGB(red, green, blue));
    }
}
