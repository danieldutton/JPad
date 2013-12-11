package gui.components;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TextArea
{
    private static JTextArea textArea = null;


    public static JTextArea getTextArea()
    {
        if (textArea == null)
        {
            textArea = new JTextArea();
            initTextArea();
        }
        return textArea;
    }

    private static void initTextArea()
    {
        textArea.setLineWrap(true);
        textArea.addCaretListener(new TextTypeListener());
    }

    //ToDo - SRP - move to another class
    public static void actionPerformed(ActionEvent ae)
    {
        JFileChooser chooser = new JFileChooser();

        int option = chooser.showOpenDialog(chooser);
        if (option == 0)
        {
            try
            {
                File selectedFile = chooser.getSelectedFile();
                FileInputStream in = new FileInputStream(selectedFile);

                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                while ((strLine = br.readLine()) != null)
                {
                    textArea.append(strLine + "\n");
                }
            } catch (Exception e)
            {
                //show error dialog
            }
        }
    }

    public static class TextTypeListener implements CaretListener
    {
        public void caretUpdate(CaretEvent e)
        {
            int lineNum = 1;
            int columnnum = 1;

            try
            {
                int caretpos = textArea.getCaretPosition();
                lineNum = textArea.getLineOfOffset(caretpos);

                columnnum = caretpos - textArea.getLineStartOffset(lineNum);

                lineNum += 1;
            } catch (Exception ex)
            {
                StatusBar.updateStatus(0, 0);
            }
            StatusBar.updateStatus(lineNum, columnnum);
        }
    }
}
