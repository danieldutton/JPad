package actions.file;

import actions.ApplicationAction;
import gui.components.TabbedPane;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenFileAction extends ApplicationAction
{
    public OpenFileAction()
    {
        super("Open File", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        FileReader reader = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text Files", "txt", "text");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int option = chooser.showOpenDialog(chooser);

        if (option == 0)
        {
            String selectedFile = chooser.getSelectedFile().getAbsolutePath();
            String fileName = chooser.getSelectedFile().getName();
             TabbedPane.setTabText(fileName);
            try
            {
                reader = new FileReader(selectedFile);
                getTextArea().read(reader, null);
                reader.close();
            } catch (FileNotFoundException e1)
            {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e1)
            {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

       //ToDo - Tidy up
    }
}
