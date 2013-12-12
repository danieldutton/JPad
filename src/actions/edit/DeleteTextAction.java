package actions.edit;

import actions.ApplicationAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteTextAction extends ApplicationAction
{
    public DeleteTextAction()
    {
        super("Delete", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextArea textArea = getTextArea();
        textArea.replaceSelection("");
    }
}
