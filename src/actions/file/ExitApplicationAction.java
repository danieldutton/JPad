package actions.file;

import actions.ApplicationAction;

import java.awt.event.ActionEvent;

public class ExitApplicationAction extends ApplicationAction
{
    public ExitApplicationAction()
    {
        super("Exit", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
