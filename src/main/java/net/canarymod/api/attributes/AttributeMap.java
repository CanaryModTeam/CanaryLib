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

    /**
     * Retrieves the modifiable attribute instance from the {@link Attribute}.
     *
     * @param attribute The attribute
     * @return The modifiable attribute instance
     */
    ModifiableAttribute getAttribute(Attribute attribute);

    /**
     * Retrieves the modifiable attribute instance from the attribute's name.
     *
     * @param name The attribute's name
     * @return The modifiable attribute instance
     */
    ModifiableAttribute getAttributeByName(String name);

    /**
     * Registers the given {@link Attribute} to the attribute map, providing
     * a modifiable attribute instance.
     *
     * @param attribute The attribute to register
     * @return The modifiable attribute instance
     */
    ModifiableAttribute register(Attribute attribute);

    /**
     * Gets an immutable view of all the registered {@link ModifiableAttribute}s.
     *
     * @return An immutable view of registered attributes
     */
    Collection<ModifiableAttribute> getAttributes();

    /**
     * Adds the attribute instance to the map.
     *
     * @param attribute The attribute instance
     */
    void addModifier(ModifiableAttribute attribute);

    /**
     * Removes the given modifiers, from the attribute instance of the given name.
     *
     * @param map A {@link Multimap} of attribute instance name -> modifiers
     */
    void removeModifiers(Multimap<String, AttributeModifier> map);

    /**
     * Applies the given modifiers, from the attribute instance of the given name.
     *
     * @param map A {@link Multimap} of attribute instance name -> modifiers
     */
    void applyModifiers(Multimap<String, AttributeModifier> map);

    /**
     * Retrieves the modifiable attribute instance from the {@link Attribute}.
     *
     * @param attribute The attribute
     * @return The modifiable attribute instance
     * @deprecated Replaced by {@link #getAttribute(Attribute)}
     */
    @Deprecated
    ModifiedAttribute getModifiedAttribute(Attribute attribute);

    /**
     * Retrieves the modifiable attribute instance from the attribute's name.
     *
     * @param name The attribute's name
     * @return The modifiable attribute instance
     * @deprecated Replaced by {@link #getAttributeByName(String)}
     */
    @Deprecated
    ModifiedAttribute getModifiedAttributeByName(String name);

    /**
     * Registers the given {@link Attribute} to the attribute map, providing
     * a modifiable attribute instance.
     *
     * @param attribute The attribute to register
     * @return The modifiable attribute instance
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
     * Adds the attribute instance to the map.
     *
     * @param attribute The attribute instance
     * @deprecated Replaced by {@link #addModifier(ModifiableAttribute)}
     */
    @Deprecated
    void addModifier(ModifiedAttribute attribute);
}
