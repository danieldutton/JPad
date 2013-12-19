package gui.components;

import javax.swing.*;

public class TabbedPane
{
    private static JTabbedPane tabbedPane = null;

    private TabbedPane()
    {
        initDefaultTab();
    }

    public static JTabbedPane getTabbedPane()
    {
        if(tabbedPane == null)
        {
            tabbedPane = new JTabbedPane();
            initDefaultTab();
        }
        return tabbedPane;
    }

    private static void initDefaultTab()
    {
        tabbedPane.addTab("new.txt", TextArea.getTextArea());
    }

    public static void setTabText(String text)
    {
        tabbedPane.setTitleAt(0, text);
    }

}
