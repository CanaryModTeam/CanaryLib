package net.canarymod.api.world.blocks.properties.helpers;

import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.properties.BlockBooleanProperty;
import net.visualillusionsent.utils.Verify;

import static net.canarymod.api.world.blocks.BlockType.DetectorRail;
import static net.canarymod.api.world.blocks.BlockType.PoweredRail;

/**
 * Rail powered properties helper<br/>
 * Applies to:<br/>
 * <ul>Activator Rail</ul>
 * <ul>Detector Rail</ul>
 * <ul>Powered Rail</ul>
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class RailPoweredProperties extends RailProperties {

    /**
     * Powered and Activator Rail powered property, Values: true, false
     */
    public static final BlockBooleanProperty poweredPoweredRail = getInstanceFor(PoweredRail, "powered");

    /**
     * Detector Rail powered property, Values: true, false
     */
    public static final BlockBooleanProperty poweredDectectorRail = getInstanceFor(DetectorRail, "powered");

    /**
     * Applies whether the {@code Rail} is powered or not
     *
     * @param block
     *         the {@link net.canarymod.api.world.blocks.Block} to be modified
     * @param value
     *         the {@code boolean} value to apply
     *
     * @return the Block with adjusted state (NOTE: Original Block object is also modified, using the return is unnecessary)
     *
     * @throws java.lang.NullPointerException
     *         Should {@code block} or {@code value} be null
     * @throws java.lang.IllegalArgumentException
     *         Should an invalid property be applied
     */
    public static Block applyPowered(Block block, boolean value) {
        Verify.notNull(block, "Block block");
        if (block.getType().equals(DetectorRail)) {
            return apply(block, poweredDectectorRail, value);
        }
        else {
            return apply(block, poweredPoweredRail, value);
        }
    }
}
