package actions.file;

import actions.ApplicationAction;

import javax.swing.*;
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

    public SaveFileAction()
    {
        super("Save", saveEditIcon);
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextArea textArea = getTextArea();

        JFileChooser saveChooser = new JFileChooser();
        saveChooser.setSelectedFile(new File("new.txt"));
        int result = saveChooser.showSaveDialog(null);
        saveChooser.setDialogTitle("J-Pad Save");

        if (result == 0)
        {
            try
            {
                File file = saveChooser.getSelectedFile();
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

            } catch (IOException d)
            {
                d.printStackTrace();
            }
        }
    }

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
