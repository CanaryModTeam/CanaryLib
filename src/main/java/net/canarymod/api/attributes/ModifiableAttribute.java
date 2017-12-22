package net.canarymod.api.attributes;

import com.google.common.annotations.Beta;

import java.util.UUID;

/**
 * An instance of an {@link Attribute} that can be modified.
 *
 * @author Jason (darkdiplomat)
 * @author Jamie Mansfield (jamierocks)
 */
@Beta
public interface ModifiableAttribute {

    Attribute getAttribute();

    double getBaseValue();

    void setBaseValue(double value);

    AttributeModifier getModifier(UUID uuid);

    void apply(AttributeModifier attributeModifier);

    void remove(AttributeModifier attributeModifier);

    double getValue();
}
