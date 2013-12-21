package actions.edit;

import actions.ApplicationAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyTextAction extends ApplicationAction
{
    private static final ImageIcon copyTextIcon = new ImageIcon("images/copyFile.png");

    public CopyTextAction()
    {
        super("Copy", copyTextIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        getTextArea().copy();
    }
}
