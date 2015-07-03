package net.canarymod.api.gui;

/**
 * GUI Control intereface
 *
 * @author Larry (Larry1123)
 */
public interface GUIControl {

    /**
     * Used when the GUI is to be replaced.
     * Should be used to Close your GUI with out stopping the server
     */
    void closeWindow();

    /**
     * Called to start the GUI
     */
    void start();

    /**
     * The name of the GUI
     *
     * @return GUI name
     */
    String getName();
}
