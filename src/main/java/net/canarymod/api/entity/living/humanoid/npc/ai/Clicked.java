package net.canarymod.api.entity.living.humanoid.npc.ai;

import net.canarymod.api.entity.living.humanoid.Player;

/**
 * AI container for Clicked NPC
 *
 * @author Jason (darkdiplomat)
 */
public final class Clicked extends NPCAI {
    private final Player clicker;

    /**
     * Constructs a new Clicked AI Container
     *
     * @param clicker
     */
    public Clicked(Player clicker) {
        this.clicker = clicker;
    }

    /**
     * Gets the {@link net.canarymod.api.entity.living.humanoid.Player} that has clicked the NPC
     *
     * @return clicker
     */
    public final Player getClicker() {
        return this.clicker;
    }

    /**
     * {@inheritDoc}
     */
    public final String toString() {
        return String.format("NPCAI.Clicked[Clicker=%s]", clicker);
    }
}
