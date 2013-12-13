package actions.file;

import actions.ApplicationAction;
import filters.DocumentFilter;
import gui.components.TabbedPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenFileAction extends ApplicationAction
{
    private String lastFilePathChosen;

    public OpenFileAction()
    {
        super("Open", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        FileReader reader = null;
        JFileChooser chooser = new JFileChooser();
        DocumentFilter docFilter = new DocumentFilter();
        chooser.setFileFilter(docFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        if (lastFilePathChosen != null)
            chooser.setCurrentDirectory(new File(lastFilePathChosen));
        int option = chooser.showOpenDialog(chooser);

        if (option == 0)
        {
            String selectedFile = chooser.getSelectedFile().getAbsolutePath();
            lastFilePathChosen = selectedFile;
            String fileName = chooser.getSelectedFile().getName();
            TabbedPane.setTabText(fileName);
            try
            {
                reader = new FileReader(selectedFile);
                getTextArea().read(reader, "/r/n");
                reader.close();
            } catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        //ToDo - Tidy up
    }
}
