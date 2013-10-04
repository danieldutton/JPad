import gui.EditableConsole;
import gui.SysTray;
import gui.components.GuiMenuBar;
import gui.components.GuiStatusBar;
import gui.components.GuiTextArea;
import gui.components.GuiToolBar;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AppStart {

    public static void main(String[] args)
  {
    JPanel mainPanel = new JPanel();
    JPanel headerPanel = new JPanel();
    GuiMenuBar menuBar = new GuiMenuBar();
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

    SysTray systemTray = new SysTray("trayImage.gif");
    try {
      systemTray.startTray();
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }
}
