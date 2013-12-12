package actions.edit;

import actions.ApplicationAction;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutTextAction extends ApplicationAction
{
    private static final ImageIcon cutEditIcon = new ImageIcon("images/cutFile.png");

    public CutTextAction()
    {
        super("Cut", cutEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextArea textArea = getTextArea();
        textArea.copy();
        textArea.replaceSelection("");
    }
}
