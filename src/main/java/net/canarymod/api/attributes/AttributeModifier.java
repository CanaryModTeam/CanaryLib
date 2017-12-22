package net.canarymod.api.attributes;

import com.google.common.annotations.Beta;

import java.util.UUID;

/**
 * A modifier that can alter the value of an {@link Attribute}.
 *
 * @author Jason (darkdiplomat)
 * @author Jamie Mansfield (jamierocks)
 */
@Beta
public interface AttributeModifier {

    /**
     * Gets the identifier of the modifier.
     *
     * @return The identifier
     */
    UUID getId();

    String getName();

    int getOperation();

    /**
     * Gets the value of the modifier.
     *
     * @return The modifier's value
     */
    double getValue();

    /**
     * Gets whether the modifier should be saved to file.
     *
     * @return {@code true} if the modifier should be saved to file,
     *         {@code false} otherwise
     */
    boolean getShouldSave();

    /**
     * Sets whether the modifier should be saved to file.
     *
     * @param saved {@code true} if the modifier should be saved to file,
     *              {@code false} otherwise
     * @return {@code this} for chaining
     */
    AttributeModifier setShouldSave(boolean saved);

    /**
     * Gets the identifier of the modifier.
     *
     * @return The identifier
     * @deprecated Replaced by {@link #getId()}
     */
    @Deprecated
    UUID getUUID();

    /**
     * Gets the value of the modifier.
     *
     * @return The modifier's value
     * @deprecated Replaced by {@link #getValue()}
     */
    @Deprecated
    double getAmount();

    /**
     * Gets whether the modifier should be saved to file.
     *
     * @return {@code true} if the modifier should be saved to file,
     *         {@code false} otherwise
     * @deprecated Replaced by {@link #getShouldSave()}
     */
    @Deprecated
    boolean isSaved();

    /**
     * Sets whether the modifier should be saved to file.
     *
     * @param saved {@code true} if the modifier should be saved to file,
     *              {@code false} otherwise
     * @return {@code this} for chaining
     * @deprecated Replaced by {@link #setShouldSave(boolean)}
     */
    @Deprecated
    AttributeModifier setSaved(boolean saved);
}
