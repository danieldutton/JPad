package actions.format;

import actions.ApplicationAction;
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
        if (isWrapped)
        {
            TextArea.getTextArea().setLineWrap(false);
            TextArea.getTextArea().setWrapStyleWord(false);
            isWrapped = false;
        } else
        {
            TextArea.getTextArea().setLineWrap(true);
            TextArea.getTextArea().setWrapStyleWord(true);
            isWrapped = true;
        }
    }
}
