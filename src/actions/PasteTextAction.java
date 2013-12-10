package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteTextAction extends ApplicationAction
{
    private static final ImageIcon pasteEditIcon = new ImageIcon("images/pasteFile.png");

    public PasteTextAction()
    {
        super("Paste", pasteEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        getTextArea().paste();
    }
}