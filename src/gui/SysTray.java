package gui;


import java.awt.*;
import java.io.FileNotFoundException;

public class SysTray
{
  private SysTrayMenu popup = new SysTrayMenu("http://www.danieldutton.org.uk");
  private String trayImage;

  public SysTray()
  {
  }

  public SysTray(String trayImage)
  {
    this.trayImage = trayImage;
  }

  public SysTray(String trayImage, String URI)
  {
    this(trayImage);
  }

  public void startTray()
    throws NullPointerException, FileNotFoundException
  {
    Runnable runner = new Runnable()
    {
      public void run()
      {
        if (SystemTray.isSupported())
        {
          SystemTray tray = SystemTray.getSystemTray();

          Image image = Toolkit.getDefaultToolkit().getImage(SysTray.this.trayImage);

          TrayIcon trayIcon = new TrayIcon(image, "J-Pad ver 1.0", SysTray.this.popup.getSysTrayMenu());
          try
          {
            tray.add(trayIcon);
          }
          catch (AWTException e) {
            System.err.println("Can't add to tray");
          }
        }
        else {
          System.err.println("Tray unavailable");
        }
      }
    };
    EventQueue.invokeLater(runner);
  }
}
