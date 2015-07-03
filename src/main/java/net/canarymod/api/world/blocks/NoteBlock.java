package net.canarymod.api.world.blocks;

/**
 * Wrap a TileEntityNote etc
 *
 * @author Chris (damagefilter)
 */
public interface NoteBlock extends TileEntity {

    /**
     * Get the current note pitch
     *
     * @return note pitch
     */
    byte getNote();

    /**
     * Set the note pitch
     *
     * @param note
     *         the note pitch
     */
    void setNote(byte note);

    /**
     * Emit a sound from this note block
     */
    void play();

    /**
     * Returns the instrument for this note block as byte value<br>
     * Wood based blocks = 4 (Bass Guitar)<br>
     * Sand/Gravel blocks = 2 (Snare Drum)<br>
     * Glass blocks = 3 (Clicks / Rimshots))<br>
     * Stone/rocks based blocks = 1 (Bassdrum)<br>
     * all other blocks = 0 (Piano)
     *
     * @return instrument byte
     */
    byte getInstrument();
}
