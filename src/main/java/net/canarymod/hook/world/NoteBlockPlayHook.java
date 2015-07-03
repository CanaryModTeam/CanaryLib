package net.canarymod.hook.world;

import net.canarymod.api.world.blocks.NoteBlock;
import net.canarymod.hook.CancelableHook;

/**
 * Called when a {@link net.canarymod.api.world.blocks.NoteBlock} is played
 *
 * @author Jason Jones (darkdiplomat)
 */
public final class NoteBlockPlayHook extends CancelableHook {
    private final NoteBlock noteBlock;

    /**
     * Constructs a new NoteBlockPlayHook
     *
     * @param noteBlock
     *         the {@link net.canarymod.api.world.blocks.NoteBlock} being played
     */
    public NoteBlockPlayHook(NoteBlock noteBlock) {
        this.noteBlock = noteBlock;
    }

    /**
     * Gets the {@link net.canarymod.api.world.blocks.NoteBlock} being played
     *
     * @return the playing NoteBlock
     */
    public final NoteBlock getNoteBlock() {
        return this.noteBlock;
    }

    /**
     * {@inheritDoc}
     */
    public final String toString() {
        return String.format("%s[NoteBlock=%s]", this.getHookName(), this.noteBlock);
    }
}
