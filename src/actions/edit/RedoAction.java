package actions.edit;

import actions.ApplicationAction;
import gui.components.TextArea;
import javax.swing.undo.CannotRedoException;
import java.awt.event.ActionEvent;

public class RedoAction extends ApplicationAction
{
    public RedoAction()
    {
        super("Redo", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            TextArea.getUndoManager().redo();
        } catch (CannotRedoException cre)
        {
            cre.printStackTrace();
        }
    }
}
