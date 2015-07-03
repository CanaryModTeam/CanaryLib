package net.canarymod.api.inventory;

/**
 * Thrown when trying to create an invalid ItemType
 *
 * @author Chris (damagefilter)
 */
public class ItemTypeException extends RuntimeException {

    private static final long serialVersionUID = -7320498855475606423L;

    public ItemTypeException(String str) {
        super(str);
    }
}
