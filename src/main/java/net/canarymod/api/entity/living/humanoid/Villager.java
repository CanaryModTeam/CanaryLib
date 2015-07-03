package net.canarymod.api.entity.living.humanoid;

import net.canarymod.api.VillagerTrade;
import net.canarymod.api.entity.living.Ageable;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.world.Village;

/**
 * Villager interface.
 *
 * @author Chris (damagefilter)
 * @author Jason (darkdiplomat)
 */
public interface Villager extends EntityLiving, Ageable {
    enum Profession {
        FARMER(0),
        //
        LIBRARIAN(1),
        //
        PRIEST(2),
        //
        BLACKSMITH(3),
        //
        BUTCHER(4),
        //
        /**
         * This has no effect and is actually never used in game
         */
        VILLAGER(5);

        int id;

        Profession(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static Profession fromId(int id) {
            switch (id) {
                case 0:
                    return FARMER;

                case 1:
                    return LIBRARIAN;

                case 2:
                    return PRIEST;

                case 3:
                    return BLACKSMITH;

                case 4:
                    return BUTCHER;

                default:
                    return VILLAGER;
            }
        }
    }

    /**
     * Get the profession of this villager
     *
     * @return {@link Profession}
     */
    Profession getProfession();

    /**
     * Manually set this villagers profession
     *
     * @param profession
     *         the {@link Profession} to set
     */
    void setProfession(Profession profession);

    /**
     * Check if this villager is mating ...
     *
     * @return {@code true} if mating; {@code false} if not
     */
    boolean isMating();

    /**
     * Set the villager mating or not mating ...
     *
     * @param isMating
     *         {@code true} for mating; {@code false} for not
     */
    void setMating(boolean isMating);

    /**
     * Set the entity that shall be the target of this villagers revenge.
     * Reduces Reputation of a {@link Player} or causes the Villager to hide. (Verification Needed)
     * <p/>
     * {@inheritDoc}
     */
    void setRevengeTarget(LivingBase targetEntity);

    /**
     * Gets the customer if there is one
     *
     * @return the {@link Player} customer if there is one; {@code null} if not
     */
    Player getCustomer();

    /**
     * Checks if the Villager has a customer
     *
     * @return {@code true} if has customer; {@code false} if not
     */
    boolean hasCustomer();

    /**
     * Forces the {@link Player} as a customer of the Villager
     *
     * @param player
     *         the {@link Player} to make the customer
     */
    void setCustomer(Player player);

    /**
     * Returns an immutable array of this villager's trades
     *
     * @return an array of {@link VillagerTrade}
     */
    VillagerTrade[] getTrades();

    /**
     * Adds a trade to this villager
     *
     * @param trade
     *         the {@link VillagerTrade} to be added
     */
    void addTrade(VillagerTrade trade);

    /**
     * Removes a trade from this villager
     *
     * @param index
     *         the index of the trade to remove
     */
    void removeTrade(int index);

    /**
     * Gets if the Villager is playing
     *
     * @return {@code true} if playing; {@code false} if not
     */
    boolean isPlaying();

    /**
     * Sets if the Villager is playing
     *
     * @param playing
     *         {@code true} for playing; {@code false} for not
     */
    void setPlaying(boolean playing);

    /**
     * Gets the {@link Village} the Villager belongs to
     *
     * @return village
     */
    Village getVillage();

    /**
     * Sets the {@link Village} the Villager belongs to
     *
     * @param village
     *         the {@link Village} to have the Villager belong to
     */
    void setVillage(Village village);
}
