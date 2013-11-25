package gui.components;

import javax.swing.*;
import java.awt.*;

public class GuiStatusBar {
    private JTextArea statusBar;
    private String statusBarText;
    private int statusBarHeight;
    private int statusBarWidth;
    private static boolean VisibilityStatus = true;
    private Font statusFont;
    private int statusFontSize;
    private Color col = new Color(1, 4, 5, 8);

    public GuiStatusBar() {
        this.statusBar = new JTextArea(this.statusBarHeight, this.statusBarWidth);
    }

    public GuiStatusBar(String defaultText) {
        this();
        this.statusBarText = defaultText;
    }

    public JTextArea getStatusBar() {
        this.statusBar.setEditable(false);
        this.statusBar.setBackground(this.col);
        this.statusBar.setText(this.statusBarText);

        return this.statusBar;
    }

    public void hideStatusBar() {
        this.statusBar.setVisible(false);
    }

}
