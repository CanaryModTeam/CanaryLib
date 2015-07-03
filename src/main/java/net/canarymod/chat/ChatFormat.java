package net.canarymod.chat;

/**
 * Enum containing all chat styles and colors.
 *
 * @author Jason (darkdiplomat)
 */

public enum ChatFormat {

    /**
     * <b>MARKER §</b>
     */
    MARKER('\u00A7'),

    /**
     * <FONT COLOR=000000><b>BLACK</b></FONT>
     */
    BLACK('0'),

    /**
     * <font color="000066"><b>DARK_BLUE</b></font>
     */
    DARK_BLUE('1'),

    /**
     * <font color="006600"><b>DARK_GREEN</b></font>
     */
    DARK_GREEN('2'),

    /**
     * <font color="006666"><b>DARK_AQUA</b></font>
     */
    DARK_AQUA('3'),

    /**
     * <font color="990000"><b>DARK_RED</b></font>
     */
    DARK_RED('4'),

    /**
     * <font color="540054"><b>DARK_PURPLE</b></font>
     */
    DARK_PURPLE('5'),

    /**
     * <font color="FF9933"><b>GOLD</b></font>
     */
    GOLD('6'),

    /**
     * <font color="CCCCCC"><b>GRAY</b></font>
     */
    GRAY('7'),

    /**
     * <font color="333333"><b>DARK_GRAY</b></font>
     */
    DARK_GRAY('8'),

    /**
     * <font color="2A2A7F"><b>BLUE</b></font>
     */
    BLUE('9'),

    /**
     * <font color="33FF33"><b>GREEN</b></font>
     */
    GREEN('A'),

    /**
     * <font color="00FFFF"><b>AQUA</b></font>
     */
    AQUA('B'),

    /**
     * <font color="FF0022"><b>RED</b></font>
     */
    RED('C'),

    /**
     * <font color="FF00FF"><b>LIGHT_PURPLE</b></font>
     */
    LIGHT_PURPLE('D'),

    /**
     * <font color="FFFF00"><b>YELLOW</b></font>
     */
    YELLOW('E'),

    /**
     * <font color="000000"><b>WHITE</b></font>
     */
    WHITE('F'),

    /**
     * <b>OBFUSCATED</b>
     */
    OBFUSCATED('K'),

    /**
     * <b>BOLD</b>
     */
    BOLD('L'),

    /**
     * <s>STRIKED</s>
     */
    STRIKED('M'),

    /**
     * <u>UNDERLINED</u>
     */
    UNDERLINED('N'),

    /**
     * <i>ITALIC</i>
     */
    ITALIC('O'),

    /**
     * RESET
     */
    RESET('R');

    private final char code;

    private ChatFormat(char code) {
        this.code = code;
    }

    public final String concat(String str) {
        if (this == MARKER) {
            return stringValue().concat(str);
        }
        else {
            return toString().concat(str);
        }
    }

    public final String concat(ChatFormat format) {
        if (this == MARKER) {
            return stringValue().concat(format.toString());
        }
        else {
            return toString().concat(format.toString());
        }
    }

    /**
     * Returns the char value of the {@code ChatFormat}
     *
     * @return char value of the {@code ChatFormat}
     */
    public final char charValue() {
        return code;
    }

    /**
     * Returns the {@code ChatFormat} as a {@link String}
     *
     * @return String value of {@code ChatFormat}
     */
    public final String stringValue() {
        return String.valueOf(code);
    }

    /**
     * Returns a string of the {@code ChatFormat}<br>
     * If the {@code ChatFormat} is that other than {@code MARKER} then {@code MARKER} is appended to the front.
     *
     * @return {@code MARKER} or {@code MARKER} + code
     */
    public final String toString() {
        if (this == MARKER) {
            return String.valueOf(code);
        }
        else {
            return MARKER.concat(stringValue());
        }
    }

    /**
     * removes all color formatting from a line
     *
     * @param str
     *         the string to remove formatting from
     *
     * @return str with formatting removed
     */
    public static String removeFormatting(String str) {
        return str.replaceAll("(?i)\u00A7[a-fk-nr0-9]", "");
    }

    /**
     * Formats a given {@link String} by replacing the specified marker with the Section Symbol (§)
     *
     * @param str
     *         the {@link String} to format
     * @param marker
     *         the specified marker to replace
     *
     * @return the formatted {@link String}
     */
    public static String formatString(String str, String marker) {
        marker = marker.replaceAll("(\\$|\\^|\\.|\\*|\\?|\\+)", "\\\\$1");// Clean the string of anything that could disrupt the regex
        return str.replaceAll("(?i)" + marker + "([a-fk-nr0-9])", MARKER.concat("$1"));
    }

    /**
     * Replaces all Color formatting with an & symbol
     *
     * @param text
     *         the text to be formatted
     *
     * @return the formatted text
     */
    public static final String consoleFormat(String text) {
        return text.replaceAll("\u00A7([A-FK-NRa-fk-nr0-9])", "&$1");
    }
}