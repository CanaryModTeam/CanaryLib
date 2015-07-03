package net.canarymod.api.inventory.helper;

import net.canarymod.Canary;
import net.canarymod.MathHelp;
import net.canarymod.ToolBox;
import net.canarymod.api.DyeColor;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;
import net.canarymod.api.nbt.BaseTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.nbt.ListTag;

import java.util.ArrayList;
import java.util.Iterator;

import static net.canarymod.api.nbt.NBTTagType.COMPOUND;

public final class FireworkHelper extends ItemHelper {
    private static final Item fireworkStarBase = Canary.factory().getItemFactory().newItem(ItemType.FireworkStar, 0, 1);
    private static final ListTag<CompoundTag> explosTag = NBT_FACTO.newListTag();

    /**
     * The FireworkStar Explosion Types
     *
     * @author Jason (darkdiplomat)
     */
    public enum ExplosionType {
        /**
         * No explosion data set
         */
        NONE(-1),
        //
        /**
         * Unknown Explosion (possible a new explosion)
         */
        UNKNOWN(-1),
        //
        /**
         * Small Explosion
         */
        SMALL(0),
        //
        /**
         * Large Explosion
         */
        LARGE(1),
        //
        /**
         * Star-Shaped Explosion
         */
        STAR(2),
        //
        /**
         * Creeper-Face Explosion
         */
        CREEPER(3),
        //
        /**
         * Burst Explosion
         */
        BURST(4),
        //
        ;

        private final byte id;

        private ExplosionType(int id) {
            this.id = (byte)id;
        }

        /**
         * Gets the Explosion ID
         *
         * @return the Explosion ID
         */
        public byte explosionId() {
            return id;
        }

        /**
         * Gets an ExplosionType from the Type ID
         *
         * @param id
         *         the ExplosionType ID
         *
         * @return the ExplosionType
         */
        public static ExplosionType fromId(byte id) {
            switch (id) {
                case 0:
                    return ExplosionType.SMALL;
                case 1:
                    return ExplosionType.LARGE;
                case 2:
                    return ExplosionType.STAR;
                case 3:
                    return ExplosionType.CREEPER;
                case 4:
                    return ExplosionType.BURST;
                default:
                    return ExplosionType.UNKNOWN;
            }
        }
    }

    /**
     * Sets the {@link ExplosionType} type of the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param explosion_type
     *         the {@link ExplosionType} type
     */
    public static void setStarExplosionType(Item fireworkStar, ExplosionType explosion_type) {
        if (fireworkStar == null ||
                fireworkStar.getType() != ItemType.FireworkStar ||
                explosion_type == null ||
                explosion_type == ExplosionType.UNKNOWN ||
                explosion_type == ExplosionType.NONE) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            getExplosionTag(fireworkStar).put("Type", explosion_type.explosionId());
        }
    }

    /**
     * Gets the {@link ExplosionType} of the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return the {@link ExplosionType} of the FireworkStar
     */
    public static ExplosionType getStarExplosionType(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return null;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return ExplosionType.NONE;
        }
        if (getExplosionTag(fireworkStar).containsKey("Type")) {
            return ExplosionType.fromId(getExplosionTag(fireworkStar).getByte("Type"));
        }
        return ExplosionType.NONE;
    }

    /**
     * Gets whether the FireworkStar leaves a trail
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return {@code true} if trails; {@code false} if not
     */
    public static boolean doesTrail(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return false;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return false;
        }
        if (getExplosionTag(fireworkStar).containsKey("Trail")) { // Test for tag
            return getExplosionTag(fireworkStar).getBoolean("Trail"); // Get value
        }
        getExplosionTag(fireworkStar).put("Trail", false); // Initialize tag for later use
        return false;
    }

    /**
     * Sets whether the FireworkStar leaves a trail
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param trail
     *         {@code true} for trails; {@code false} for not
     */
    public static void setDoesTrail(Item fireworkStar, boolean trail) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            getExplosionTag(fireworkStar).put("Trail", trail);
        }
    }

    /**
     * Gets whether the FireworkStar does flicker
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return {@code true} if does flicker; {@code false} if not
     */
    public static boolean doesFlicker(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return false;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return false;
        }
        if (getExplosionTag(fireworkStar).containsKey("Flicker")) { // Test for tag
            return getExplosionTag(fireworkStar).getBoolean("Flicker"); // Get value
        }
        getExplosionTag(fireworkStar).put("Flicker", false); // Initialize tag for later use
        return false;
    }

    /**
     * Sets whether the FireworkStar does flicker
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param flicker
     *         {@code true} for flickering; {@code false} for not
     */
    public static void setDoesFlicker(Item fireworkStar, boolean flicker) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            getExplosionTag(fireworkStar).put("Flicker", flicker);
        }
    }

    /**
     * Gets the colors of the FireworkStar as a {@link DyeColor} array
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return a {@link DyeColor} array if there are colors; {@code null} if no colors
     */
    public static DyeColor[] getStarColors(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return null;
        }
        int[] colors = getStarColorsRaw(fireworkStar);
        if (colors != null) {
            DyeColor[] dyeColors = new DyeColor[colors.length];
            for (int index = 0; index < colors.length; index++) {
                dyeColors[index] = DyeColor.fromDecimalCode(colors[index]);
            }
            return dyeColors;
        }
        return null;
    }

    /**
     * Gets the raw decimal colors of the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return a {@code int[]} of colors or empty
     */
    public static int[] getStarColorsRaw(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return new int[0];
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return new int[0];
        }
        if (getExplosionTag(fireworkStar).containsKey("Colors")) {
            return getExplosionTag(fireworkStar).getIntArray("Colors");
        }
        return new int[0];
    }

    /**
     * Sets the colors of the FireworkStar based on the given {@link DyeColor}s<br>
     * Giving {@link DyeColor#CUSTOM} will result it the color being ignored.<br>
     * For custom colors use {@link #setStarColorsRaw}
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor}(s) to set to the FireworkStar
     */
    public static void setStarColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            setStarColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Sets the colors of the FireworkStar based on raw integers
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@code int}(s) colors
     *
     * @see <a href="http://www.mathsisfun.com/hexadecimal-decimal-colors.html">http://www.mathsisfun.com/hexadecimal-decimal-colors.html</a>
     */
    public static void setStarColorsRaw(Item fireworkStar, int... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            for (int index = 0; index < colors.length; index++) {
                colors[index] = MathHelp.setInRange(colors[index], 0, 0xFFFFFF); // if the color is greater than hex:FFFFFF (dec: 16777215) or less than 0, its invalid and needs adjusted
            }
            getExplosionTag(fireworkStar).put("Colors", colors);
        }
    }

    /**
     * Adds a color to the FireworkStar based on {@link DyeColor}<br>
     * NOTE: If the {@link DyeColor} is {@link DyeColor#CUSTOM}, no action will be taken
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor}(s) to be added
     */
    public static void addStarColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            addStarColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Adds color(s) to the FireworkStar based on raw integers
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the raw colors
     *
     * @see <a href="http://www.mathsisfun.com/hexadecimal-decimal-colors.html">http://www.mathsisfun.com/hexadecimal-decimal-colors.html</a>
     */
    public static void addStarColorsRaw(Item fireworkStar, int... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            for (int index = 0; index < colors.length; index++) {
                colors[index] = MathHelp.setInRange(colors[index], 0, 0xFFFFFF); // if the color is greater than hex:FFFFFF (dec: 16777215) or less than 0, its invalid and needs adjusted
            }
            int[] rawColors = getExplosionTag(fireworkStar).containsKey("Colors") ? getExplosionTag(fireworkStar).getIntArray("Colors") : null;
            if (rawColors != null) {
                getExplosionTag(fireworkStar).put("Colors", ToolBox.arrayMerge(rawColors, colors));
            }
            else {
                getExplosionTag(fireworkStar).put("Colors", colors);
            }
        }
    }

    /**
     * Removes a color from the FireworkStar<br>
     * NOTE: if the {@link DyeColor} is {@link DyeColor#CUSTOM} no actions will be performed
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor} to remove
     */
    public static void removeStarColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            removeStarColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Removes a color from the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param rawColors
     *         the raw color to be removed
     */
    public static void removeStarColorsRaw(Item fireworkStar, int... rawColors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (rawColors == null || rawColors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            int[] setColors = getExplosionTag(fireworkStar).containsKey("Colors") ? getExplosionTag(fireworkStar).getIntArray("Colors") : null;
            if (setColors != null) {
                ArrayList<Integer> colors = new ArrayList<Integer>();
                for (int setColor : setColors) {
                    colors.add(setColor);
                }
                for (int rawColor : rawColors) {
                    colors.remove(Integer.valueOf(rawColor));
                }
                int[] newColors = new int[colors.size()];
                for (int index = 0; index < colors.size(); index++) {
                    newColors[index] = colors.get(index);
                }
                getExplosionTag(fireworkStar).put("Colors", newColors);
            }
        }
    }

    /**
     * Removes all the colors from the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     */
    public static void removeAllColors(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return;
        }
        if (getExplosionTag(fireworkStar).containsKey("Colors")) {
            getExplosionTag(fireworkStar).remove("Colors");
        }
    }

    /**
     * Gets the colors of the FireworkStar as a {@link DyeColor} array
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return a {@link DyeColor} array if there are colors; {@code null} if no colors
     */
    public static DyeColor[] getStarFadeColors(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return null;
        }
        int[] colors = getStarFadeColorsRaw(fireworkStar);
        if (colors != null) {
            DyeColor[] dyeColors = new DyeColor[colors.length];
            for (int index = 0; index < colors.length; index++) {
                dyeColors[index] = DyeColor.fromDecimalCode(colors[index]);
            }
            return dyeColors;
        }
        return null;
    }

    /**
     * Gets the raw decimal fade colors of the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return a {@code int[]} if there are colors; {@code null} if no colors
     */
    public static int[] getStarFadeColorsRaw(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return null;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return null;
        }
        if (getExplosionTag(fireworkStar).containsKey("FadeColors")) {
            return getExplosionTag(fireworkStar).getIntArray("FadeColors");
        }
        return null;
    }

    /**
     * Sets the fade color(s) of the FireworkStar based on the given {@link DyeColor}s<br>
     * Giving {@link DyeColor#CUSTOM} will result it the color being ignored.<br>
     * For custom colors use {@link #setStarFadeColorsRaw}
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor}(s) to set to the FireworkStar
     */
    public static void setStarFadeColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            setStarFadeColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Sets the colors of the FireworkStar based on raw integers
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@code int}(s) colors
     *
     * @see <a href="http://www.mathsisfun.com/hexadecimal-decimal-colors.html">http://www.mathsisfun.com/hexadecimal-decimal-colors.html</a>
     */
    public static void setStarFadeColorsRaw(Item fireworkStar, int... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            for (int index = 0; index < colors.length; index++) {
                colors[index] = MathHelp.setInRange(colors[index], 0, 0xFFFFFF); // if the color is greater than hex:FFFFFF (dec: 16777215) or less than 0, its invalid and needs adjusted
            }
            getExplosionTag(fireworkStar).put("FadeColors", colors);
        }
    }

    /**
     * Adds a color to the FireworkStar based on {@link DyeColor}<br>
     * NOTE: If the {@link DyeColor} is {@link DyeColor#CUSTOM}, no action will be taken
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor}(s) to be added
     */
    public static void addStarFadeColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            addStarFadeColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Adds fade color(s) to the FireworkStar based on raw integers
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the raw colors
     *
     * @see <a href="http://www.mathsisfun.com/hexadecimal-decimal-colors.html">http://www.mathsisfun.com/hexadecimal-decimal-colors.html</a>
     */
    public static void addStarFadeColorsRaw(Item fireworkStar, int... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, true)) {
            for (int index = 0; index < colors.length; index++) {
                colors[index] = MathHelp.setInRange(colors[index], 0, 0xFFFFFF); // if the color is greater than hex:FFFFFF (dec: 16777215) or less than 0, its invalid and needs adjusted
            }
            int[] rawColors = getExplosionTag(fireworkStar).containsKey("FadeColors") ? getExplosionTag(fireworkStar).getIntArray("FadeColors") : null;
            if (rawColors != null) {
                getExplosionTag(fireworkStar).put("FadeColors", ToolBox.arrayMerge(rawColors, colors));
            }
            else {
                getExplosionTag(fireworkStar).put("FadeColors", colors);
            }
        }
    }

    /**
     * Removes fade color(s) from the FireworkStar<br>
     * NOTE: if the {@link DyeColor} is {@link DyeColor#CUSTOM} no actions will be performed
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param colors
     *         the {@link DyeColor}(s) to remove
     */
    public static void removeStarFadeColors(Item fireworkStar, DyeColor... colors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (colors == null || colors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            ArrayList<Integer> rawColors = new ArrayList<Integer>();
            for (int index = 0; index < colors.length; index++) {
                if (colors[index] == null || colors[index] == DyeColor.CUSTOM) {
                    continue;
                }
                rawColors.add(colors[index].getDecimalCode());
            }
            int[] rawColorsArray = new int[rawColors.size()];
            for (int index = 0; index < rawColors.size(); index++) {
                rawColorsArray[index] = rawColors.get(index);
            }
            removeStarFadeColorsRaw(fireworkStar, rawColorsArray);
        }
    }

    /**
     * Removes fase color(s) from the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     * @param rawColors
     *         the raw color to be removed
     */
    public static void removeStarFadeColorsRaw(Item fireworkStar, int... rawColors) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (rawColors == null || rawColors.length < 1) {
            return;
        }
        if (verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            int[] setColors = getExplosionTag(fireworkStar).containsKey("FadeColors") ? getExplosionTag(fireworkStar).getIntArray("FadeColors") : null;
            if (setColors != null) {
                ArrayList<Integer> colors = new ArrayList<Integer>();
                for (int setColor : setColors) {
                    colors.add(setColor);
                }
                for (int rawColor : rawColors) {
                    colors.remove(Integer.valueOf(rawColor));
                }
                int[] newColors = new int[colors.size()];
                for (int index = 0; index < colors.size(); index++) {
                    newColors[index] = colors.get(index);
                }
                getExplosionTag(fireworkStar).put("FadeColors", newColors);
            }
        }
    }

    /**
     * Removes all the fade colors from the FireworkStar
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     */
    public static void removeAllFadeColors(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return;
        }
        if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
            return;
        }
        if (getExplosionTag(fireworkStar).containsKey("FadeColors")) {
            getExplosionTag(fireworkStar).remove("FadeColors");
        }
    }

    /**
     * Checks if the FireworkRocket has flight data
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     *
     * @return {@code true} if has data; {@code false} if not
     */
    public static boolean hasFlightData(Item fireworkRocket) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return false;
        }
        if (!verifyTags(fireworkRocket, "Fireworks", COMPOUND, false)) {
            return false;
        }
        return fireworkRocket.getDataTag().getCompoundTag("Fireworks").containsKey("Flight");
    }

    /**
     * Gets the Flight Duration of the FireworkRocket<br>
     * Flight Duration is normally a byte between 1 and 3
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     *
     * @return flight duration byte or {@code 0} if flight duration was not initialized
     */
    public static byte getFlightDuration(Item fireworkRocket) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return -1;
        }
        if (hasFlightData(fireworkRocket)) {
            return fireworkRocket.getDataTag().getCompoundTag("Fireworks").getByte("Flight");
        }
        return 0;
    }

    /**
     * Gets the Flight Duration of the FireworkRocket<br>
     * Flight Duration is normally a byte between 1 and 3<br>
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     * @param duration
     *         the flight duration byte; if duration is less than 1 it is set to 1 or if duration is greater than 3 it is set to 3
     */
    public static void setFlightDuration(Item fireworkRocket, byte duration) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return;
        }
        if (verifyTags(fireworkRocket, "Fireworks", COMPOUND, true)) {
            fireworkRocket.getDataTag().getCompoundTag("Fireworks").put("Flight", (byte)MathHelp.setInRange(duration, 0, 3));
        }
    }

    /**
     * Gets all the FireworkStar {@link Item}(s) attached to the FireworkRocket.<br>
     * Manipulation of the stars should work without the need to re-attach.<br>
     * Further use of the FireworkStar(s) will affect the FireworkRock.
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     *
     * @return the FireworkStar {@link Item} array
     */
    public static Item[] getAttachedFireworkStars(Item fireworkRocket) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return null;
        }
        if (!verifyTags(fireworkRocket, "Fireworks", COMPOUND, false)) {
            return null;
        }
        if (!fireworkRocket.getDataTag().getCompoundTag("Fireworks").containsKey("Explosions")) {
            return null;
        }
        ListTag<BaseTag> explosions = fireworkRocket.getDataTag().getCompoundTag("Fireworks").getListTag("Explosions");
        if (!explosions.isEmpty()) {
            ArrayList<Item> stars = new ArrayList<Item>();
            for (BaseTag explosion : explosions) {
                if (explosion instanceof CompoundTag) {
                    Item fireworkStar = fireworkStarBase.clone();
                    fireworkStar.getDataTag().put("Explosion", explosion);
                    stars.add(fireworkStar);
                }
            }
            return stars.toArray(new Item[stars.size()]);
        }
        return null;
    }

    /**
     * Attaches the Explosion tag from the FireworkStar {@link Item}(s)<br>
     * The Explosion Tag is copied from the FireworkStar.<br>
     * Further manipulation on the explosion tag in the FireworkStar will have no effect on the rocket.
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     * @param fireworkStars
     *         the FireworkStar {@link Item}(s)
     */
    public static void attachFireworkStars(Item fireworkRocket, Item... fireworkStars) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return;
        }
        if (verifyTags(fireworkRocket, "Fireworks", COMPOUND, true)) {
            if (!fireworkRocket.getDataTag().getCompoundTag("Fireworks").containsKey("Explosions")) {
                fireworkRocket.getDataTag().getCompoundTag("Fireworks").put("Explosions", explosTag.copy());
            }
            for (Item fireworkStar : fireworkStars) {
                if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
                    continue;
                }
                if (!verifyTags(fireworkStar, "Explosion", COMPOUND, false)) {
                    continue;
                }
                fireworkRocket.getDataTag().getCompoundTag("Fireworks").getListTag("Explosions").add(fireworkStar.getDataTag().getCompoundTag("Explosion").copy());
            }
        }
    }

    /**
     * Attempts to remove FireworkStar {@link Item}(s) information from the FireworkRocket<br>
     * Some Tags may be removed even if there is a failure to remove a tag.<br>
     * For best results, use the FireworkStar object retrieved from the {@link #getAttachedFireworkStars} method.
     *
     * @param fireworkRocket
     *         the FireworkRocket {@link Item}
     * @param fireworkStars
     *         the FireworkStar {@link Item}(s) to have removed
     *
     * @return {@code true} if successfully removed all FireworkStars; {@code false} if one or more FireworkStars weren't removed
     */
    public static boolean removeFireworkStars(Item fireworkRocket, Item... fireworkStars) {
        if (fireworkRocket == null || fireworkRocket.getType() != ItemType.FireworkRocket) {
            return false;
        }
        if (!verifyTags(fireworkRocket, "Fireworks", COMPOUND, false)) {
            return false;
        }
        if (!fireworkRocket.getDataTag().getCompoundTag("Fireworks").containsKey("Explosions")) {
            return false;
        }
        boolean toRet = true;
        for (Item fireworkStar : fireworkStars) {
            if (!fireworkRocket.getDataTag().getCompoundTag("Fireworks").getListTag("Explosions").remove(fireworkStar.getDataTag().getCompoundTag("Explosion"))) {
                // We need to do some magic
                ListTag<CompoundTag> explosions = fireworkRocket.getDataTag().getCompoundTag("Fireworks").getListTag("Explosions");
                Iterator<CompoundTag> expItr = explosions.iterator();
                boolean found = false;
                while (expItr.hasNext()) {
                    if (fireworkStar.getDataTag().getCompoundTag("Explosion").equals(expItr.next())) {
                        expItr.remove();
                        found = true;
                        break;
                    }
                }
                toRet &= found;
            }
        }
        return toRet;
    }

    /**
     * Gets the Explosion tag of a Firework Star
     *
     * @param fireworkStar
     *         the FireworkStar {@link Item}
     *
     * @return the {@link CompoundTag} named Explosion
     */
    public static CompoundTag getExplosionTag(Item fireworkStar) {
        if (fireworkStar == null || fireworkStar.getType() != ItemType.FireworkStar) {
            return null;
        }
        return fireworkStar.getDataTag().getCompoundTag("Explosion");
    }
}
