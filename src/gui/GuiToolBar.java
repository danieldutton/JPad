package gui;

import javax.swing.*;
import java.awt.*;

public class GuiToolBar
{
  private JToolBar toolBar;
  NewFileAction newFileAction = new NewFileAction();
  SaveFileAction saveAction = new SaveFileAction();
  PrintFileAction printAction = new PrintFileAction();
  CutEditAction cutAction = new CutEditAction();
  CopyEditAction copyAction = new CopyEditAction();
  PasteEditAction pasteAction = new PasteEditAction();
  public boolean visibilityStatus = true;
  private JButton saveFile;
  private JButton printFile;
  private JButton cutFile;
  private JButton copyFile;
  private JButton pasteFile;

  public GuiToolBar()
  {
    this.toolBar = new JToolBar();
  }

  public JToolBar GetGuiToolBar()
  {
    this.saveFile = new JButton(this.saveAction);
    this.printFile = new JButton(this.printAction);
    this.cutFile = new JButton(this.cutAction);
    this.copyFile = new JButton(this.copyAction);
    this.pasteFile = new JButton(this.pasteAction);

    this.saveFile.setText(null);
    this.printFile.setText(null);
    this.cutFile.setText(null);
    this.copyFile.setText(null);
    this.pasteFile.setText(null);

    this.toolBar.add(this.saveFile);
    this.toolBar.add(this.printFile);
    this.toolBar.add(this.cutFile);
    this.toolBar.add(this.copyFile);
    this.toolBar.add(this.pasteFile);
    this.toolBar.setFloatable(false);

    this.saveFile.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
    this.printFile.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 10));
    this.cutFile.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
    this.copyFile.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
    this.pasteFile.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
    this.toolBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

    this.saveFile.setToolTipText("Save");
    this.printFile.setToolTipText("Print");
    this.cutFile.setToolTipText("Cut");
    this.copyFile.setToolTipText("Copy");
    this.pasteFile.setToolTipText("Paste");
    this.toolBar.setVisible(this.visibilityStatus);

    return this.toolBar;
  }
}
