package net.canarymod;

/**
 * A Bridge class to adapt the native translation of Minecraft into the Canary Translator.
 * An implementation should implement the bridge into their projects and bridge it to the Minecraft translator.
 * Plugineers should not implement or access this class directly.
 *
 * (The Rainbow)
 *
 * @author Jason (darkdiplomat)
 */
public abstract class NativeTranslateBridge {
    /**
     * Implementation accessor
     */
    protected static NativeTranslateBridge $;

    /**
     * Bridge method to access a natively translatable key
     *
     * @param key
     *         the key to be translated
     *
     * @return the translated key
     */
    protected abstract String nativeTranslate(String key);

    /**
     * Bridge method to access a natively translatable key
     *
     * @param key
     *         the key to be translated
     * @param args
     *         any object arguments to be added to the translation
     *
     * @return the translated key
     */
    protected abstract String nativeTranslate(String key, Object... args);

    /**
     * Bridge method to check if a given key is translatable
     *
     * @param key
     *         the key to verify
     *
     * @return {@code true} if can translate; {@code false} if can not translate
     */
    protected abstract boolean nativeCanTranslate(String key);
}
