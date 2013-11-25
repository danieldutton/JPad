package actions;

import gui.components.GuiTextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteEditAction extends AbstractAction {

    private static final ImageIcon pasteEditIcon = new ImageIcon("pasteFile.png");
    private JTextArea ta = GuiTextArea.getDefaultGuiTextArea();

    public PasteEditAction() {
        super("Paste", pasteEditIcon);
    }

    public void actionPerformed(ActionEvent e) {
        ta.paste();
    }
}