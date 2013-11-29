package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteTextAction extends ApplicationAction {

    private static final ImageIcon cutEditIcon = new ImageIcon("cutFile.png");

    public DeleteTextAction() {
        super("Delete", null);
    }

    public void actionPerformed(ActionEvent e) {
        JTextArea textArea = getTextArea();
        textArea.replaceSelection("");
    }
}
