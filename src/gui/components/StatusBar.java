package gui.components;

import javax.swing.*;
import java.awt.*;

public class StatusBar {

    private static JPanel statusBar;

    private static JLabel lblRowColCount = new JLabel();

    private StatusBar()
    {
        lblRowColCount = new JLabel();
    }

    public static JPanel getStatusBar()
    {
        if (statusBar == null) {
            statusBar = new JPanel();

            initStatusBar();
            initRowColCountLabel();
        }
        return statusBar;
    }

     private static void initStatusBar(){
        statusBar.setOpaque(true);
        statusBar.add(lblRowColCount);
     }

    private static void initRowColCountLabel()
    {
        lblRowColCount.setHorizontalAlignment(SwingConstants.LEFT);
        lblRowColCount.setOpaque(true);
        lblRowColCount.setFont(new Font("", 0, 10));
        lblRowColCount.setText("Line: 0" + " Column: 0");
    }

    public static void updateStatus(int a, int b)
    {
        lblRowColCount.setText("Line: " + a + " Column: " + b);
    }
}
