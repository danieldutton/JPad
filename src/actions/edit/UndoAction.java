package actions.edit;

import actions.ApplicationAction;
import gui.components.TextArea;

import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;

public class UndoAction extends ApplicationAction
{
    public UndoAction()
    {
        super("Undo", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
          TextArea.getUndoManager().undo();
        }
        catch (CannotUndoException cre)
        {

        }
    }
}
