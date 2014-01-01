package actions.other;

import actions.ApplicationAction;
import gui.components.TextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FontSizeChangeAction extends ApplicationAction
{
    public FontSizeChangeAction()
    {
        super(null, null);
    }

    public void actionPerformed(ActionEvent e)
    {
        final Font currentFont = TextArea.getTextArea().getFont();

        JComboBox cb = (JComboBox) e.getSource();

        TextArea.getTextArea().setFont(new Font(currentFont.getFontName(),
                currentFont.getStyle(), (Integer)cb.getSelectedItem() ));
    }
}
