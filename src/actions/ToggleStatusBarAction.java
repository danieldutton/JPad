package actions;

import gui.components.StatusBar;

import java.awt.event.ActionEvent;

public class ToggleStatusBarAction extends ApplicationAction
{
    private boolean isVisible = true;

    public ToggleStatusBarAction()
    {
        super("Status Bar", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (isVisible)
        {
            StatusBar.getStatusBar().setVisible(false);
            isVisible = false;
        } else
        {
            StatusBar.getStatusBar().setVisible(true);
            isVisible = true;
        }
    }
}
