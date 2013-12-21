package actions;

import gui.components.TextArea;
import javax.swing.*;

public abstract class ApplicationAction extends AbstractAction
{
    private JTextArea textArea = TextArea.getTextArea();

    public ApplicationAction(String name, ImageIcon icon)
    {
        super(name, icon);
    }

    protected JTextArea getTextArea()
    {
        return textArea;
    }
}
