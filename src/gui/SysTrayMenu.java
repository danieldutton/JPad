package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SysTrayMenu
{
  private MenuItem closeItem;
  private MenuItem homePageItem;
  private PopupMenu popup;
  private Desktop desktop;
  private String helpURI;

  public SysTrayMenu()
  {
    this.closeItem = new MenuItem("Close");
    this.homePageItem = new MenuItem("Visit JPad.com");
    this.popup = new PopupMenu();
    this.desktop = null;
  }

  public SysTrayMenu(String helpURI)
  {
    this();
    this.helpURI = helpURI;
  }

  public PopupMenu getSysTrayMenu()
  {
    this.homePageItem.setEnabled(false);
    this.popup.add(this.closeItem);
    this.popup.add(this.homePageItem);

    this.homePageItem.addActionListener(new SysTrayMenu.VisitHomePage());
    this.closeItem.addActionListener(new SysTrayMenu.ClosePad());

    if (Desktop.isDesktopSupported())
    {
      this.desktop = Desktop.getDesktop();
      enableOptions();
    }

    return this.popup;
  }

  private void enableOptions()
  {
    this.homePageItem.setEnabled(true);
  }

  private class VisitHomePage
    implements ActionListener
  {
    private VisitHomePage()
    {
    }

    public void actionPerformed(ActionEvent c)
    {
      if (c.getSource() == SysTrayMenu.this.homePageItem)
      {
        if (Desktop.isDesktopSupported()) {
          try
          {
            Desktop.getDesktop().browse(new URI(SysTrayMenu.this.helpURI));
          }
          catch (IOException ex) {
            ex.printStackTrace();
          }
          catch (URISyntaxException ex)
          {
            ex.printStackTrace();
          }
        }
        else
          JOptionPane.showMessageDialog(null, "Default system browser not found.  Please manually navigate to http://www.danieldutton.org.uk/help ");
      }
    }
  }

  public class ClosePad
    implements ActionListener
  {
    public ClosePad()
    {
    }

    public void actionPerformed(ActionEvent c)
    {
      if (c.getSource() == SysTrayMenu.this.closeItem)
      {
        System.exit(0);
      }
    }
  }
}
