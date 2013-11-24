package gui.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasteEditAction extends AbstractAction
{
  private static final ImageIcon pasteEditIcon = new ImageIcon("pasteFile.png");

  public PasteEditAction()
  {
    super("Paste", pasteEditIcon);
  }

  public void actionPerformed(ActionEvent e)
  {
    System.out.println("Yes I Work");
  }
}