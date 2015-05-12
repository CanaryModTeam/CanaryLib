package net.canarymod;

/**
 * The Rainbow
 *
 * @author Jason (darkdiplomat)
 */
public abstract class NativeTranslateBridge {
    protected static NativeTranslateBridge $;

    abstract String nativeTranslate(String key);

    abstract String nativeTranslate(String key, Object... args);

    abstract boolean nativeCanTranslate(String key);
}
