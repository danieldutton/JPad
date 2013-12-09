package gui.consoles;

import javax.swing.*;
import java.awt.*;

public class AboutDialog {
    private JDialog dialog;
    private JPanel panel;
    private String image;
    private String title;

    public AboutDialog(String title, String image) {
        this.dialog = new JDialog(this.dialog, true);
        this.panel = new JPanel();
        this.title = title;
        this.image = image;
    }

    public void drawConsole() {
        centreConsole();
        customiseFrameIcon();

        ImageIcon aboutIcon = new ImageIcon(this.image);
        this.panel.add(new JLabel(aboutIcon));
        this.dialog.add(this.panel);
        this.dialog.setSize(305, 280);
        this.dialog.setResizable(false);
        this.dialog.setDefaultCloseOperation(2);
        this.dialog.setTitle(this.title);
        this.dialog.setVisible(true);
    }


    private void centreConsole() {
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        this.dialog.setLocation((d1.width - this.dialog.getSize().width) / 2, (d1.height - this.dialog.getSize().height) / 2);
    }

    private void customiseFrameIcon() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/frameLogo.gif");

        this.dialog.setIconImage(img1);
    }
}
