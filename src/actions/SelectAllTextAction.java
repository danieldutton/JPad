package actions;


import java.awt.event.ActionEvent;

public class SelectAllTextAction extends ApplicationAction
{
    public SelectAllTextAction()
    {
        super("Select All", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        getTextArea().selectAll();
    }
}
