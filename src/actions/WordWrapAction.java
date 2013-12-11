package actions;

import gui.components.TextArea;
import java.awt.event.ActionEvent;

public class WordWrapAction extends ApplicationAction
{
    private boolean isWrapped = true;

    public WordWrapAction()
    {
        super("Word Wrap", null);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(isWrapped)
            {
                TextArea.getDefaultGuiTextArea().setLineWrap(false);
                TextArea.getDefaultGuiTextArea().setWrapStyleWord(false);
                isWrapped = false;
            }
            else
            {
                TextArea.getDefaultGuiTextArea().setLineWrap(true);
                TextArea.getDefaultGuiTextArea().setWrapStyleWord(true);
                isWrapped = true;
            }
    }
}
