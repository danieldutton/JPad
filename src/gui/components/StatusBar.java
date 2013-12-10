package gui.components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class StatusBar {

    private static JPanel statusBar;

    private static JLabel label = new JLabel();

    private StatusBar() {
    }

    public static JPanel getStatusBar() {
        if (statusBar == null) {
            statusBar = new JPanel();
            statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
            statusBar.setOpaque(true);

            label.setHorizontalAlignment(SwingConstants.LEFT);
            label.setOpaque(true);

            statusBar.add(label);
   }
        return statusBar;
    }

    public static void updateStatus(int a, int b){
        label.setText("Line: " + a + " Column: " + b);
    }
}
