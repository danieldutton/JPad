package gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TextArea {

    private static JTextArea textArea = null;

    private TextArea() {
    }

    public static JTextArea getDefaultGuiTextArea() {
        if (textArea == null) {
              textArea = new JTextArea();
        }
        return textArea;
    }

    public static void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();

        int option = chooser.showOpenDialog(chooser);
        if (option == 0) {
            File[] sf = chooser.getSelectedFiles();
            String filelist = "";
            if (sf.length > 0) filelist = sf[0].getName();
            for (int i = 1; i < sf.length; i++) {
                filelist = filelist + ", " + sf[i].getName();
            }

            try {
                File selectedFile = chooser.getSelectedFile();
                FileInputStream in = new FileInputStream(selectedFile);

                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    textArea.append(strLine + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
