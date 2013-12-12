package actions.file;

import actions.ApplicationAction;
import gui.components.TabbedPane;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveFileAction extends ApplicationAction
{
    private static final ImageIcon saveEditIcon = new ImageIcon("images/saveFile.png");

    private JFileChooser saveChooser;

    public SaveFileAction()
    {
        super("Save", saveEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextArea textArea = getTextArea();

        saveChooser = new JFileChooser();

        saveChooser.setDialogTitle("J-Pad Save");
        saveChooser.setSelectedFile(new File("new.txt"));

        if (saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = new File(saveChooser.getSelectedFile() + ".txt");
                String fileName = saveChooser.getSelectedFile().getName();
                TabbedPane.setTabText(fileName);
                if(file.exists()){
                    int selectedOption = JOptionPane.showConfirmDialog(null,
                                  "File already Exists, Are you sure you wish to overwrite?",
                                  "Choose",
                                  JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(textArea.getText());
                    closeStream(bw);
                }
                }
                else{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(textArea.getText());
                    closeStream(bw);
                }

            } catch (IOException d)
            {
                d.printStackTrace();
            }
        }
    }

    //ToDo Get rid of duplicate code

    public void closeStream(BufferedWriter buff)
    {
        try
        {
            buff.close();
        } catch (IOException ex)
        {
            Logger.getLogger(SaveFileAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
