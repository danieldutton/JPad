package actions.edit;

import actions.ApplicationAction;
import gui.components.TextArea;

import java.awt.event.ActionEvent;

public class RedoAction extends ApplicationAction
{
    public RedoAction()
    {
        super("Redo", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (TextArea.getUndoManager().canRedo())
            TextArea.getUndoManager().redo();


    }
}
