package gui.systemTray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SystemTrayMenu
{
    private MenuItem closeItem;

    private MenuItem homePageItem;

    private PopupMenu popup;

    private String helpURI;


    public SystemTrayMenu()
    {
        this.closeItem = new MenuItem("Close");
        this.homePageItem = new MenuItem("Visit JPad.com");
        this.popup = new PopupMenu();
    }

    public SystemTrayMenu(String helpURI)
    {
        this();
        this.helpURI = helpURI;
    }

    public PopupMenu getSysTrayMenu()
    {
        this.homePageItem.setEnabled(false);
        this.popup.add(this.closeItem);
        this.popup.add(this.homePageItem);

        this.homePageItem.addActionListener(new WebLinklistener());
        this.closeItem.addActionListener(new ExitApplicationListener());

        if (Desktop.isDesktopSupported())
        {
            enableOptions();
        }
        return this.popup;
    }

    private void enableOptions()
    {
        this.homePageItem.setEnabled(true);
    }

    private class WebLinklistener implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == SystemTrayMenu.this.homePageItem)
            {
                if (Desktop.isDesktopSupported())
                {
                    try
                    {
                        Desktop.getDesktop().browse(new URI(SystemTrayMenu.this.helpURI));
                    } catch (IOException ex)
                    {
                        ex.printStackTrace();
                    } catch (URISyntaxException ex)
                    {
                        ex.printStackTrace();
                    }
                } else
                    JOptionPane.showMessageDialog(null,
                            "Default system browser not found.  Please manually navigate to http://www.danieldutton.org.uk/help ");
            }
        }
    }

    public class ExitApplicationListener implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == SystemTrayMenu.this.closeItem)
                System.exit(0);
        }
    }
}
