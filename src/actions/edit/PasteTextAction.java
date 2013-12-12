package actions.edit;

import actions.ApplicationAction;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteTextAction extends ApplicationAction
{
    private static final ImageIcon pasteTextAction = new ImageIcon("images/pasteFile.png");

    public PasteTextAction()
    {
        super("Paste", pasteTextAction);
    }

    public void actionPerformed(ActionEvent e)
    {
        getTextArea().paste();
    }
}