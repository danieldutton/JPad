package actions.file;

import actions.ApplicationAction;

import java.awt.event.ActionEvent;

public class SaveFileAsAction extends ApplicationAction
{
    public SaveFileAsAction()
    {
        super("Save As", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        new SaveFileAction().actionPerformed(e);

    }
}
