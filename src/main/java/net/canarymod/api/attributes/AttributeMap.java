package net.canarymod.api.attributes;

import com.google.common.annotations.Beta;
import com.google.common.collect.Multimap;

import java.util.Collection;

/**
 * @author Jason (darkdiplomat)
 * @author Jamie Mansfield (jamierocks)
 */
@Beta
public interface AttributeMap {

    ModifiableAttribute getAttribute(Attribute attribute);

    ModifiableAttribute getAttributeByName(String name);

    ModifiableAttribute register(Attribute attribute);

    /**
     * Gets an immutable view of all the registered {@link ModifiableAttribute}s.
     *
     * @return An immutable view of registered attributes
     */
    Collection<ModifiableAttribute> getAttributes();

    void addModifier(ModifiableAttribute attribute);

    void removeModifiers(Multimap<String, AttributeModifier> map);

    void applyModifiers(Multimap<String, AttributeModifier> map);

    /**
     * @deprecated Replaced by {@link #getAttribute(Attribute)}
     */
    @Deprecated
    ModifiedAttribute getModifiedAttribute(Attribute attribute);

    /**
     * @deprecated Replaced by {@link #getAttributeByName(String)}
     */
    @Deprecated
    ModifiedAttribute getModifiedAttributeByName(String name);

    /**
     * @deprecated Replaced by {@link #register(Attribute)}
     */
    @Deprecated
    ModifiedAttribute registerAttribute(Attribute attribute);

    /**
     * Gets an immutable view of all the registered {@link ModifiedAttribute}s.
     *
     * @return An immutable view of registered attributes
     * @deprecated Replaced by {@link #getAttributes()}
     */
    @Deprecated
    Collection<ModifiedAttribute> getAllAttributes();

    /**
     * @deprecated Replaced by {@link #addModifier(ModifiableAttribute)}
     */
    @Deprecated
    void addModifier(ModifiedAttribute attribute);
}
