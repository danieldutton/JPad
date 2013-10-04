package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyEditAction extends AbstractAction
{
  private static final ImageIcon copyEditIcon = new ImageIcon("copyFile.png");

  public CopyEditAction()
  {
    super("Copy", copyEditIcon);
  }

  public void actionPerformed(ActionEvent e)
  {
  }
}
