package net.canarymod.hook.world;

import net.canarymod.api.inventory.Hopper;
import net.canarymod.api.inventory.Item;
import net.canarymod.hook.CancelableHook;

/**
 * Hook parameter for when Hoppers Transfer Items
 *
 * @author Somners
 */
public final class HopperTransferHook extends CancelableHook {

    private Hopper hopper = null;
    private boolean inputting;
    private Item itemTransfered = null;

    public HopperTransferHook(Hopper hopper, Item itemTransferred, boolean inputting) {
        this.hopper = hopper;
        this.inputting = inputting;
        this.itemTransfered = itemTransferred;
    }

    /**
     * Gets the hopper involved with this transfer.
     * Use instanceof to Check if it is a HopperBlock or HopperMincart.
     *
     * @return The Hopper.
     *
     * @see net.canarymod.api.entity.vehicle.HopperMinecart
     * @see net.canarymod.api.world.blocks.HopperBlock
     */
    public Hopper getHopper() {
        return this.hopper;
    }

    /**
     * Is the transfer inputting into the Hopper?
     *
     * @return True if the item is being transferred into the hopper.
     */
    public boolean isInputting() {
        return this.inputting;
    }

    /**
     * Is the transfer outputting into the Hopper?
     *
     * @return True if the item is being transferred out of hopper.
     */
    public boolean isOutputting() {
        return !this.inputting;
    }

    /**
     * Gets the item being transferred in this event.
     *
     * @return The Item.
     */
    public Item getItemTransferred() {
        return this.itemTransfered;
    }

    @Override
    public final String toString() {
        return String.format("%s[Hopper=%s, Item=%s, Is Transferred In=%s]", getHookName(), hopper, itemTransfered, inputting);
    }
}
