package actions.format;

import actions.ApplicationAction;
import gui.consoles.FontDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ChooseFontAction extends ApplicationAction
{
    public ChooseFontAction()
    {
        super("Font", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        FontDialog fontConsole = new FontDialog();
        fontConsole.drawConsole();
    }
}
