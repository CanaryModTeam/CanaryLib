package net.canarymod.api.factory;

import com.google.common.annotations.Beta;
import net.canarymod.api.attributes.Attribute;
import net.canarymod.api.attributes.AttributeModifier;

import java.util.UUID;

/**
 * @author Jason (darkdiplomat)
 */
@Beta
public interface AttributeFactory {

    /**
     * Gets a Generic Attribute, as seen in SharedMonsterAttributes
     * <p/>
     * Names can be seen in {@link net.canarymod.api.attributes.GenericAttribute}
     *
     * @param nativeName
     *         the name of the generic attribute
     *
     * @return generic Attribute
     */
    Attribute getGenericAttribute(String nativeName);

    /**
     * Creates an {@link AttributeModifier} of the given properties.
     *
     * @param name The name of the modifier
     * @param value The value of the modifier
     * @param operation The operation the modifier performs
     * @return The created modifier
     */
    AttributeModifier createModifier(String name, double value, int operation);

    /**
     * Creates an {@link AttributeModifier} of the given properties.
     *
     * @param id The identifier of the modifier
     * @param name The name of the modifier
     * @param value The value of the modifier
     * @param operation The operation the modifier performs
     * @return The created modifier
     */
    AttributeModifier createModifier(UUID id, String name, double value, int operation);
}
