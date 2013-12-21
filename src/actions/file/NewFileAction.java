package actions.file;

import actions.ApplicationAction;
import gui.components.TabbedPane;
import gui.components.TextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewFileAction extends ApplicationAction
{
    public NewFileAction()
    {
        super("New", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        int result = wishesToSave();

        if (result == JOptionPane.YES_OPTION)
        {
            new SaveFileAsAction().actionPerformed(e);
            setupNewDocument();
        }

        if (result == JOptionPane.NO_OPTION)
            setupNewDocument();
    }

    private int wishesToSave()
    {
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Do you wish to save the current file",
                "Choose",
                JOptionPane.YES_NO_CANCEL_OPTION);

        return selectedOption;
    }

    private void setupNewDocument()
    {
        TextArea.getTextArea().setText("");
        TabbedPane.setTabText("new");
    }
}
