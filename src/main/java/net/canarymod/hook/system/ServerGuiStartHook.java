package net.canarymod.hook.system;

import net.canarymod.api.gui.GUIControl;
import net.canarymod.hook.Hook;

/**
 * Called when a GUI is started
 *
 * @author Larry (Larry1123)
 */
public class ServerGuiStartHook extends Hook {

    private GUIControl gui;

    public ServerGuiStartHook(GUIControl gui) {
        this.setGui(gui);
    }

    public GUIControl getGui() {
        return gui;
    }

    public void setGui(GUIControl gui) {
        this.gui = gui;
    }

    public final String toString() {
        return String.format("%s[GUI=%s]", getHookName(), gui);
    }
}
