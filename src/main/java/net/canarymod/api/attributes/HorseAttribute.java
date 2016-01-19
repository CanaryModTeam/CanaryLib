package net.canarymod.api.attributes;

import com.google.common.annotations.Beta;
import net.canarymod.Canary;

/**
 * @author Jamie Mansfield (jamierocks)
 */
@Beta
public enum HorseAttribute {

    JUMPSTRENGTH("horse.jumpStrength");

    private final String nmsName;

    HorseAttribute(String nmsName) {
        this.nmsName = nmsName;
    }

    public Attribute getAttribute() {
        return Canary.factory().getAttributeFactory().getGenericAttribute(this.nmsName);
    }

    public String getNativeName() {
        return this.nmsName;
    }
}
