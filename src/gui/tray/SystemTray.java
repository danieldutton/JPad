package gui.tray;

import java.awt.*;

public class SystemTray {

    private SystemTrayMenu popup = new SystemTrayMenu("http://www.dannydutton.co.uk");

    private String trayImage;

    public SystemTray(String trayImage) {
        this.trayImage = trayImage;
    }

    public void loadSystemTray() {

        Runnable runner = new Runnable() {
            public void run() {
                if (java.awt.SystemTray.isSupported()) {
                    java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();

                    Image image = Toolkit.getDefaultToolkit().getImage(SystemTray.this.trayImage);

                    TrayIcon trayIcon = new TrayIcon(image, "J-Pad", SystemTray.this.popup.getSysTrayMenu());
                    try {
                        tray.add(trayIcon);
                    } catch (AWTException e) {
                        System.err.println("System Tray cannot be added");
                    }
                } else {
                    return;
                }
            }
        };
        EventQueue.invokeLater(runner);
    }
}
