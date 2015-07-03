package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.animal.Chicken;
import net.canarymod.api.inventory.Item;
import net.canarymod.hook.CancelableHook;

/**
 * Chicken lay egg hook, called when a chicken lay an egg.
 *
 * @author Ehud (EhudB)
 */
public class ChickenLayEggHook extends CancelableHook {

    private Chicken chicken;
    private Item egg;
    private int nextEggIn;

    /**
     * Creates a new ChickenLayEggHook
     *
     * @param chicken
     *         the chicken that laid the egg
     * @param egg
     *         the egg that has been laid
     * @param nextEggIn
     *         the time until next egg will be laid
     */
    public ChickenLayEggHook(Chicken chicken, Item egg, int nextEggIn) {
        this.chicken = chicken;
        this.egg = egg;
        this.nextEggIn = nextEggIn;
    }

    /**
     * Get the {@link Chicken} the laid the egg
     *
     * @return the chicken that laid the egg
     */
    public Chicken getChicken() {
        return this.chicken;
    }

    /**
     * Get the egg that was laid
     *
     * @return the egg that was laid
     */
    public Item getEgg() {
        return this.egg.clone();
    }

    /**
     * Change the egg that should be laid
     *
     * @param egg
     *         the egg that should be laid
     */
    public void setEgg(Item egg) {
        this.egg = egg;
    }

    /**
     * Get the time until the next egg will be laid for the chicken that laid the egg
     *
     * @return time until next egg will be laid from the current chicken
     */
    public int getNextEggIn() {
        return this.nextEggIn;
    }

    /**
     * Set the time until next egg will be laid from the chicken that laid the egg
     *
     * @param nextEggIn
     *         time until next egg will be laid
     */
    public void setNextEggIn(int nextEggIn) {
        this.nextEggIn = nextEggIn;
    }

    @Override
    public String toString() {
        return String.format("%s[Chicken=%s, Egg=%s, Time Until Next Egg=%s", getHookName(), chicken, egg, nextEggIn);
    }
}
