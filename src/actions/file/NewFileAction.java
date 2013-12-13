package actions.file;


import actions.ApplicationAction;
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
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Do you wish to save the current file",
                "Choose",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION)
        {
            new SaveFileAsAction().actionPerformed(e);
        }
             TextArea.getTextArea().setText("");
    }
}
