package actions.edit;

import actions.ApplicationAction;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutTextAction extends ApplicationAction
{
    private static final ImageIcon cutTextIcon = new ImageIcon("images/cutFile.png");

    public CutTextAction()
    {
        super("Cut", cutTextIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextArea textArea = getTextArea();
        textArea.copy();
        textArea.replaceSelection("");
    }
}
