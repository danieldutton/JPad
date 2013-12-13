package actions.file;

import actions.ApplicationAction;

import java.awt.event.ActionEvent;

public class SaveAsFileAction extends ApplicationAction
{
    public SaveAsFileAction()
    {
        super("Save As", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        new SaveFileAction().actionPerformed(e);

    }
}
