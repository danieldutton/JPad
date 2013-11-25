package actions;

import gui.components.GuiTextArea;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutEditAction extends AbstractAction {

    private static final ImageIcon cutEditIcon = new ImageIcon("cutFile.png");

    private JTextArea ta = GuiTextArea.getDefaultGuiTextArea();

    public CutEditAction() {
        super("Cut", cutEditIcon);
    }

    public void actionPerformed(ActionEvent e) {
        ta.copy();
        ta.replaceSelection("");
    }
}
