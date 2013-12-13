package gui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar
{
    private static JPanel statusBar;

    private static JLabel lblRowColCount = new JLabel();

    private StatusBar()
    {
        lblRowColCount = new JLabel();
    }

    public static JPanel getStatusBar()
    {
        if (statusBar == null)
        {
            statusBar = new JPanel();

            initStatusBar();
            initRowColCountLabel();
        }
        return statusBar;
    }

    private static void initStatusBar()
    {
        statusBar.setOpaque(true);
        statusBar.setLayout(new GridLayout());
        statusBar.add(lblRowColCount);
        statusBar.setBorder(new EmptyBorder(2, 2, 2, 5));
    }

    private static void initRowColCountLabel()
    {
        lblRowColCount.setOpaque(true);
        lblRowColCount.setFont(new Font("", 0, 12));
        lblRowColCount.setText("Line: 0" + " Column: 0");
    }

    public static void updateCursorPositionText(int a, int b)
    {
        lblRowColCount.setText("Line: " + a + " Column: " + b);
    }
}
