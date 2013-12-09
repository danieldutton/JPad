package gui.components;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TextArea {

    private static JTextArea textArea = null;

    private static JPanel  sb = StatusBar.getStatusBar();

    private TextArea() {
    }

    public static JTextArea getDefaultGuiTextArea() {
        if (textArea == null) {
              textArea = new JTextArea();
            textArea.setLineWrap(true);
            //textArea.addCaretListener(new Thing());
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

    public static class Thing implements CaretListener{

        public void caretUpdate(CaretEvent e) {
            int linenum = 1;
                int columnnum = 1;

                try {
                    // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
                    // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
                    // what position that line starts on.
                    int caretpos = textArea.getCaretPosition();
                    linenum = textArea.getLineOfOffset(caretpos);

                    // We subtract the offset of where our line starts from the overall caret position.
                    // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
                    // we know that we must be on column 6 of line 5.
                    columnnum = caretpos - textArea.getLineStartOffset(linenum);

                    // We have to add one here because line numbers start at 0 for getLineOfOffset and we want it to start at 1 for display.
                    linenum += 1;
                }
                catch(Exception ex) { }

                // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
                StatusBar.updateStatus(linenum, columnnum);
        }
    }
}
