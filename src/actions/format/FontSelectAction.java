package actions.format;

import actions.ApplicationAction;
import gui.consoles.FontDialog;

import java.awt.event.ActionEvent;

public class FontSelectAction extends ApplicationAction
{
    public FontSelectAction()
    {
        super("Font", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        FontDialog fontDialog = new FontDialog("Choose Font");
        fontDialog.drawConsole();
    }
}
