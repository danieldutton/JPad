import gui.components.TextArea;
import gui.consoles.ParentFrame;
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

    JTabbedPane tabbedPane = TabbedPane.getTabbedPane();
    JPanel statusBar = StatusBar.getStatusBar();

    mainPanel.setLayout(new BorderLayout());
    headerPanel.setLayout(new BorderLayout());

    ParentFrame mainGui = new ParentFrame("J-Pad", 850, 700);

    headerPanel.add(BorderLayout.CENTER, menuBar.getGuiMenuBar());
    headerPanel.add(BorderLayout.SOUTH, toolBar.GetGuiToolBar());
    mainPanel.add(BorderLayout.NORTH, headerPanel);

    JTextArea ta = TextArea.getTextArea();
      JScrollPane scrollPane = new JScrollPane(ta);
     tabbedPane.addTab("new.txt", scrollPane);
    ta.setFont(new Font("Times New Roman", Font.PLAIN, 16));

    mainPanel.add(BorderLayout.CENTER, tabbedPane);
    mainPanel.add(BorderLayout.SOUTH, statusBar);
    mainGui.add(mainPanel);
    mainGui.setVisible(true);

    mainGui.addCustomFrameIcon("images/frameLogo.gif");

    mainGui.centreConsoleToScreen();

    SystemTray systemTray = new gui.systemTray.SystemTray("images/trayImage.gif");
    try {
      systemTray.loadSystemTray();
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    }
  }
}
