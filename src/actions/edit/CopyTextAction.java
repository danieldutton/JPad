package actions.edit;

import actions.ApplicationAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyTextAction extends ApplicationAction
{
    private static final ImageIcon copyEditIcon = new ImageIcon("images/copyFile.png");

    public CopyTextAction()
    {
        super("Copy", copyEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        getTextArea().copy();
    }
}
