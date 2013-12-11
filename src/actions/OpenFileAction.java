package actions;

import input.readers.FileReader;
import input.readers.IFileReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OpenFileAction extends ApplicationAction
{
    public OpenFileAction()
    {
        super("Open File", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        IFileReader fileReader = new FileReader();
        JFileChooser chooser = new JFileChooser();

        int option = chooser.showOpenDialog(chooser);

        if (option == 0)
        {
            File selectedFile = chooser.getSelectedFile();

            String result = fileReader.readFile(selectedFile.getAbsolutePath());

            getTextArea().append(result);
        }

    }
}
