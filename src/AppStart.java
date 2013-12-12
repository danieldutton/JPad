import gui.components.TextArea;
import gui.consoles.AbstractConsole;
import gui.systemTray.SystemTray;
import gui.components.*;
import gui.components.MenuBar;

import javax.swing.*;
import java.awt.*;

public class AppStart {

    public static void main(String[] args)
  {
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    MenuBar menuBar = new gui.components.MenuBar();
    ToolBar toolBar = new ToolBar();
    JScrollPane scrollPane = new JScrollPane();
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel statusBar = StatusBar.getStatusBar();

    mainPanel.setLayout(new BorderLayout());
    headerPanel.setLayout(new BorderLayout());

    AbstractConsole mainGui = new AbstractConsole("J-Pad", 850, 700);


    headerPanel.add(BorderLayout.CENTER, menuBar.getGuiMenuBar());
    headerPanel.add(BorderLayout.SOUTH, toolBar.GetGuiToolBar());
    mainPanel.add(BorderLayout.NORTH, headerPanel);

    tabbedPane.addTab("new.txt",TextArea.getTextArea());

    mainPanel.add(BorderLayout.CENTER, tabbedPane);
    mainPanel.add(BorderLayout.SOUTH, statusBar);
    mainGui.add(mainPanel);
    mainGui.setVisible(true);

    mainGui.customiseFrameIcon("images/frameLogo.gif");

    mainGui.consoleCentre();

    SystemTray systemTray = new gui.systemTray.SystemTray("images/trayImage.gif");
    try {
      systemTray.loadSystemTray();
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    }
  }
}
