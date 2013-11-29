package gui.components;

import javax.swing.*;
import java.awt.*;

public class StatusBar {
    private static JTextArea statusBar;
    private String statusBarText;
    private int statusBarHeight;
    private int statusBarWidth;
    private static boolean VisibilityStatus = true;
    private Font statusFont;
    private int statusFontSize;

    private StatusBar() {
        this.statusBar = new JTextArea(this.statusBarHeight, this.statusBarWidth);
    }

    public static JTextArea getStatusBar() {
        if (statusBar == null) {
            statusBar = new JTextArea();
            statusBar.setEditable(false);
            statusBar.setBackground(new Color(1, 4, 5, 8));
            statusBar.setText("status bar");
        }
        return statusBar;
    }

    public void hideStatusBar() {
        statusBar.setVisible(false);
    }

    public void showStatusBar(){
        statusBar.setVisible(true);
    }
}
