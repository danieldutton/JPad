import actions.file.SaveFileAsAction;
import actions.file.SaveFileAction;
import gui.components.TextArea;
import gui.consoles.ParentFrame;
import gui.systemTray.SystemTray;
import gui.components.*;
import gui.components.MenuBar;
import javax.swing.*;
import java.awt.*;

public class AppStart
{
    public static void main(String[] args)
    {
        //The containers
        ParentFrame mainGui = new ParentFrame("J-Pad", 850, 700);

        JPanel mainPanel = new JPanel();
        JPanel headerPanel = new JPanel();

        //set the layouts
        mainPanel.setLayout(new BorderLayout());
        headerPanel.setLayout(new BorderLayout());

        //The text pad components
        MenuBar menuBar = new MenuBar();
        ToolBar toolBar = new ToolBar();
        JTabbedPane tabbedPane = TabbedPane.getTabbedPane();
        JPanel statusBar = StatusBar.getStatusBar();
        JTextArea textArea = TextArea.getTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        //setup shared actions
        SaveFileAction sfa = new SaveFileAction();

        menuBar.setSaveFileAction(sfa);
        menuBar.setSaveFileAsAction(new SaveFileAsAction());
        menuBar.init();

        toolBar.setSaveFileAction(sfa);
        toolBar.init();

        //piece everything together
        headerPanel.add(BorderLayout.CENTER, menuBar.getGuiMenuBar());
        headerPanel.add(BorderLayout.SOUTH, toolBar.GetGuiToolBar());
        mainPanel.add(BorderLayout.NORTH, headerPanel);
        tabbedPane.addTab("new.txt", scrollPane);
        mainPanel.add(BorderLayout.CENTER, tabbedPane);
        mainPanel.add(BorderLayout.SOUTH, statusBar);
        mainGui.add(mainPanel);
        mainGui.setVisible(true);

        mainGui.addCustomFrameIcon("images/frameLogo.gif");

        mainGui.centreConsoleRelativeToScreen();

        SystemTray systemTray = new gui.systemTray.SystemTray("images/trayImage.gif");

        try
        {
            systemTray.loadSystemTray();
        } catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }
}
