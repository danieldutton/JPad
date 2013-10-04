package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutEditAction extends AbstractAction
{
  private static final ImageIcon cutEditIcon = new ImageIcon("cutFile.png");

  public CutEditAction()
  {
    super("Cut", cutEditIcon);
  }

  public void actionPerformed(ActionEvent e)
  {
    JTextArea gui = GuiTextArea.getDefaultGuiTextArea();
    String str = gui.getText();
    gui.setText("");
  }
}
