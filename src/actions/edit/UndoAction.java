package actions.edit;

import actions.ApplicationAction;
import gui.components.TextArea;

import java.awt.event.ActionEvent;

public class UndoAction extends ApplicationAction
{
    public UndoAction()
    {
        super("Undo", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(TextArea.getUndoManager().canUndo())
            TextArea.getUndoManager().undo();
    }
}
