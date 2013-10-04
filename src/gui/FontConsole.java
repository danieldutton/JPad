package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontConsole extends EditableConsole
{
  private JPanel panel;
  private JComboBox fontComboBox;
  private JButton okButton;
  private JButton cancelButton;
  private JLabel fontLabel;
  private JTextArea tArea = GuiTextArea.getDefaultGuiTextArea();

  public FontConsole()
  {
  }

  public FontConsole(String title)
  {
    super(title);
  }

  public void drawConsole()
  {
    frameBasics();
    consoleCentre();
    setSize(250, 200);
    this.panel = new JPanel();
    this.fontComboBox = new JComboBox();
    this.okButton = new JButton("OK");
    this.cancelButton = new JButton("Cancel");
    this.fontLabel = new JLabel("Sample");

    this.panel.setBorder(BorderFactory.createTitledBorder("Set Font"));

    this.fontComboBox.setBackground(Color.white);
    this.cancelButton.addActionListener(new FontConsole.CancelFontChange());

    this.panel.add(this.fontComboBox);
    this.panel.add(this.fontLabel);
    this.panel.add(this.okButton);
    this.panel.add(this.cancelButton);

    add(this.panel);

    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = e.getAllFonts();
    for (Font f : fonts)
      this.fontComboBox.addItem(f.getFontName());
  }

  public class CancelFontChange implements ActionListener
  {
    public CancelFontChange()
    {
    }

    public void actionPerformed(ActionEvent c)
    {
      if (c.getSource() == FontConsole.this.cancelButton)
      {
        FontConsole.this.dispose();
      }
    }
  }
}
