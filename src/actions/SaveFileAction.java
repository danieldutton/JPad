package actions;

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
        int result = saveChooser.showSaveDialog(null);
        saveChooser.setDialogTitle("J-Pad Save");

        if (result == 0)
        {
            try
            {
                File file = saveChooser.getSelectedFile();

                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                bw.write(textArea.getText());

                bw.close();
                closeStream(bw);
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
