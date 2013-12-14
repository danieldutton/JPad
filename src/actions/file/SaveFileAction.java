package actions.file;

import actions.ApplicationAction;
import gui.components.TabbedPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveFileAction extends ApplicationAction
{
    private static final ImageIcon saveEditIcon = new ImageIcon("images/saveFile.png");

    private File lastSavedFile;

    private boolean wasPrevSaved = false;

    private JFileChooser saveChooser;


    public SaveFileAction()
    {
        super("Save", saveEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (!wasPrevSaved)
        {
            initFileChooser();

            if (saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(saveChooser.getSelectedFile() + ".txt");
                String fileName = saveChooser.getSelectedFile().getName();
                lastSavedFile = file;
                TabbedPane.setTabText(fileName);

                if (file.exists())
                    displayFileOverwriteOptionDialog(file);
                else
                    saveToFile(file);
            }
        } else
            saveToFile(lastSavedFile);
    }

    private void initFileChooser()
    {
        saveChooser = new JFileChooser();

        if (lastSavedFile != null)
            saveChooser.setCurrentDirectory(lastSavedFile);

        saveChooser.setDialogTitle("J-Pad Save");
        saveChooser.setSelectedFile(new File("new"));
    }

    private void displayFileOverwriteOptionDialog(File file)
    {
        int selectedOption = JOptionPane.showConfirmDialog(null,
                "File already Exists, Are you sure you wish to overwrite?",
                "Choose",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION)
        {
            saveToFile(file);
        }
    }

    private void saveToFile(File file)
    {
        BufferedWriter bw;

        try
        {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(getTextArea().getText());
            bw.close();
            wasPrevSaved = true;
        } catch (IOException e)
        {
            //add try again warning
        }
    }
}
