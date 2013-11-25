import gui.consoles.EditableConsole;
import gui.tray.SystemTray;
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
    GuiToolBar toolBar = new GuiToolBar();
    JScrollPane scrollPane = new JScrollPane();
    JTabbedPane tabbedPane = new JTabbedPane();
    GuiStatusBar statusBar = new GuiStatusBar("");

    mainPanel.setLayout(new BorderLayout());
    headerPanel.setLayout(new BorderLayout());

    EditableConsole mainGui = new EditableConsole("J-Pad", 850, 700);

    mainGui.add(mainPanel);
    headerPanel.add("North", menuBar.getGuiMenuBar());
    headerPanel.add("Center", toolBar.GetGuiToolBar());
    mainPanel.add("North", headerPanel);

    tabbedPane.add(GuiTextArea.getDefaultGuiTextArea());
    mainPanel.add("Center", tabbedPane);
    mainPanel.add("South", statusBar.getStatusBar());

    mainGui.drawConsole();

    mainGui.customiseFrameIcon("frameLogo.gif");

    mainGui.consoleCentre();

    SystemTray systemTray = new gui.tray.SystemTray("trayImage.gif");
    try {
      systemTray.startTray();
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    }
  }
}
