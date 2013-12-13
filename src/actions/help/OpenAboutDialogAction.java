package actions.help;

import actions.ApplicationAction;
import gui.consoles.AboutDialog;
import java.awt.event.ActionEvent;

public class OpenAboutDialogAction extends ApplicationAction
{
    public OpenAboutDialogAction()
    {
        super("About", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        AboutDialog aboutDialog = new AboutDialog("J-Pad", "images/aboutScreen.gif");
        aboutDialog.drawConsole();
    }
}
