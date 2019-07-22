package net.canarymod.api.attributes;

import com.google.common.annotations.Beta;
import net.canarymod.Canary;

/**
 * @author Jason (darkdiplomat)
 */
@Beta
public enum GenericAttribute {

    MAXHEALTH("generic.maxHealth"),
    FOLLOWRANGE("generic.followRange"),
    MOVEMENTSPEED("generic.movementSpeed"),
    ATTACKDAMAGE("generic.attackDamage"),
    KNOCKBACKRESIST("generic.knockbackResistance"),
    ARMOR("generic.armor"),
    ATTACKSPEED("generic.attackSpeed"),
    LUCK("generic.luck"),
    ;

    private final String nmsName;

    GenericAttribute(String nmsName) {
        this.nmsName = nmsName;
    }

    public Attribute getAttribute() {
        return Canary.factory().getAttributeFactory().getGenericAttribute(this.nmsName);
    }

    public String getNativeName() {
        return this.nmsName;
    }
}
