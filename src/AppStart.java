import gui.components.TextArea;
import gui.consoles.CustomConsole;
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
    JTextArea statusBar = StatusBar.getStatusBar();

    mainPanel.setLayout(new BorderLayout());
    headerPanel.setLayout(new BorderLayout());

    CustomConsole mainGui = new CustomConsole("J-Pad", 850, 700);

    mainGui.add(mainPanel);
    headerPanel.add("North", menuBar.getGuiMenuBar());
    headerPanel.add("Center", toolBar.GetGuiToolBar());
    mainPanel.add("North", headerPanel);

    tabbedPane.add(TextArea.getDefaultGuiTextArea());
    mainPanel.add("Center", tabbedPane);
    mainPanel.add("South", statusBar);

    mainGui.drawConsole();

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
