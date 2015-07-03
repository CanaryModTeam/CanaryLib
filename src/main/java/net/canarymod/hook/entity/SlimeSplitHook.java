package net.canarymod.hook.entity;

import net.canarymod.api.entity.living.monster.Slime;
import net.canarymod.hook.Hook;

import java.util.List;

/**
 * Slime split hook, Contains information about a slime split.
 *
 * @author Ehud (EhudB)
 */
public class SlimeSplitHook extends Hook {

    private Slime originalSlime;
    private List<Slime> childSlimes;

    /**
     * Constructs a new SlimeSplitHook
     *
     * @param originalSlime
     *         the original {@link Slime} that died
     * @param childSlimes
     *         the {@link Slime}s that should spawn
     */
    public SlimeSplitHook(Slime originalSlime, List<Slime> childSlimes) {
        this.originalSlime = originalSlime;
        this.childSlimes = childSlimes;
    }

    /**
     * Get the original {@link Slime} that died
     *
     * @return the {@link Slime} that died
     */
    public Slime getOriginalSlime() {
        return this.originalSlime;
    }

    /**
     * Get the {@link Slime}s that should be spawned
     *
     * @return a list of {@link Slime}s that will spawn
     */
    public List<Slime> getChildSlimes() {
        return this.childSlimes;
    }

    @Override
    public String toString() {
        return String.format("%s[Original Slime=%s, Child Slimes=%s", getHookName(), originalSlime, childSlimes);
    }
}
