package gui.components;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;

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
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
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
