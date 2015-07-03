package net.canarymod.api.entity;

import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.world.position.Rotations;

/**
 * ArmorStand wrapper
 *
 * @author Jason Jones (darkdiplomat)
 */
public interface ArmorStand extends LivingBase {

    /**
     * The Equipment slots
     */
    enum Slot {
        /**
         * Held Item slot
         */
        HOLDING,
        /**
         * Feet (Boots) slot
         */
        FEET,
        /**
         * Legs (Leggings) slot
         */
        LEGS,
        /**
         * Body (Chestplate) slot
         */
        BODY,
        /**
         * Head (Helmet/Skull) slot
         */
        HEAD
    }

    /**
     * Disablitity flags for the Slots
     */
    enum Disability {
        /**
         * Flags for removing equipment
         */
        REMOVE(new int[]{ 1, 2, 4, 8, 16 }),
        /**
         * Flags for replacing equipment
         */
        REPLACE(new int[]{ 256, 512, 1024, 2048, 4096 }),
        /**
         * Flags for placing equipment
         */
        PLACE(new int[]{ 65536, 131072, 262144, 524288, 1048576 });

        /**
         * Overall bitwise offsets
         */
        public final int bitOffset = ordinal() * 8;
        /**
         * Slot offsets are ordered by slot id
         */
        public final int[] slotOffsets;

        private Disability(int[] slotOffsets) {
            this.slotOffsets = slotOffsets;
        }
    }

    /**
     * The rotatable parts
     */
    enum RotatablePart {
        HEAD,
        BODY,
        LEFTARM,
        RIGHTARM,
        LEFTLEG,
        RIGHTLEG
    }

    /**
     * Gets an array of {@link net.canarymod.api.inventory.Item} equal in length to the number of Slots
     * NOTE: Some Items may be null
     *
     * @return all equipment
     */
    Item[] getAllEquipment();

    /**
     * Sets all the equipment
     *
     * @param item
     *         the array of {@link net.canarymod.api.inventory.Item}(s), should be length of 5
     */
    void setAllEquipment(Item[] item);

    /**
     * Gets the equipment in the specified slot
     *
     * @param slot
     *         the {@link net.canarymod.api.entity.ArmorStand.Slot} to get equipment in
     *
     * @return the equipment in a given slot or {@code null} if no equipment
     */
    Item getEquipment(Slot slot);

    /**
     * @param slot
     * @param item
     */
    void setEquipment(Slot slot, Item item);

    /**
     * Gets if the stand is small
     *
     * @return {@code true} if small; {@code false} if not
     */
    boolean isSmall();

    /**
     * Sets if the stand is small
     *
     * @param small
     *         {@code true} for small; {@code false} for not
     */
    void setSmall(boolean small);

    /**
     * Gets if arms are shown
     *
     * @return {@code true} if shown; {@code false} if not shown
     */
    boolean showArms();

    /**
     * Sets if arms are shown or not
     *
     * @param set
     *         {@code true} for shown; {@code false} for not shown
     */
    void setShowArms(boolean set);

    /**
     * Checks if a slot can be manipulated or not
     *
     * @param slot
     *         the {@link net.canarymod.api.entity.ArmorStand.Slot} to check
     * @param disability
     *         the {@link net.canarymod.api.entity.ArmorStand.Disability} to check for
     *
     * @return {@code true} if disabled; {@code false} if not
     */
    boolean isSlotDiabled(Slot slot, Disability disability);

    /**
     * Sets a {@link net.canarymod.api.entity.ArmorStand.Disability} on a {@link net.canarymod.api.entity.ArmorStand.Slot}
     *
     * @param slot
     *         the {@link net.canarymod.api.entity.ArmorStand.Slot} to give a {@link net.canarymod.api.entity.ArmorStand.Disability} to
     * @param disability
     *         the {@link net.canarymod.api.entity.ArmorStand.Disability} to give
     */
    void disableSlot(Slot slot, Disability disability);

    /**
     * Removes a {@link net.canarymod.api.entity.ArmorStand.Disability} on a {@link net.canarymod.api.entity.ArmorStand.Slot}
     *
     * @param slot
     *         the {@link net.canarymod.api.entity.ArmorStand.Slot} to remove a disability from
     * @param disability
     *         the {@link net.canarymod.api.entity.ArmorStand.Disability} to remove
     */
    void enableSlot(Slot slot, Disability disability);

    /**
     * Checks if the base plate is shown
     *
     * @return {@code true} if shown; {@code false} if not
     */
    boolean hasBasePlate();

    /**
     * Sets if the base plate is shown
     *
     * @param basePlate
     *         {@code true} to show the base plate; {@code false} to not show the base plate
     */
    void setBasePlate(boolean basePlate);

    /**
     * Gets if gravity is applied
     *
     * @return {@code true} if applied; {@code false} if not
     */
    boolean gravity();

    /**
     * Sets if gravity is applied
     *
     * @param gravity
     *         {@code true} to apply gravity; {@code false} to not apply gravity
     */
    void setGravity(boolean gravity);

    /**
     * Gets the {@link net.canarymod.api.world.position.Rotations} for a given {@link net.canarymod.api.entity.ArmorStand.RotatablePart}
     *
     * @param part
     *         the {@link net.canarymod.api.entity.ArmorStand.RotatablePart} to get {@link net.canarymod.api.world.position.Rotations} of
     *
     * @return the {@link net.canarymod.api.world.position.Rotations} of the given {@link net.canarymod.api.entity.ArmorStand.RotatablePart}
     */
    Rotations getPartPose(RotatablePart part);

    /**
     * Sets the {@link net.canarymod.api.world.position.Rotations} of a given {@link net.canarymod.api.entity.ArmorStand.RotatablePart}
     *
     * @param part
     *         the {@link net.canarymod.api.entity.ArmorStand.RotatablePart} to apply {@link net.canarymod.api.world.position.Rotations} to
     * @param rotation
     *         the {@link net.canarymod.api.world.position.Rotations} to apply
     */
    void setPartPose(RotatablePart part, Rotations rotation);
}
