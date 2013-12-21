package gui.components;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;

public class TextArea
{
    private static JTextArea textArea = null;

    private static UndoManager undoManager = new UndoManager();

    private TextArea()
    {
    }

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

        textArea.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
          public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
          }
        });
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
                StatusBar.updateCursorPositionText(0, 0);
            }
            StatusBar.updateCursorPositionText(lineNum, columnnum);
        }
    }

    public static UndoManager getUndoManager()
    {
        return undoManager;
    }
}
