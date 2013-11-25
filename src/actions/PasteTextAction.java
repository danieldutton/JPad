package actions;

import gui.components.TextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteTextAction extends ApplicationAction {

    private static final ImageIcon pasteEditIcon = new ImageIcon("pasteFile.png");
    private JTextArea ta = TextArea.getDefaultGuiTextArea();

    public PasteTextAction() {
        super("Paste", pasteEditIcon);
    }

    public void actionPerformed(ActionEvent e) {
        ta.paste();
    }
}