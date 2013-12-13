package gui.consoles;

import javax.swing.*;
import java.awt.*;

public class AboutDialog
{
    private JDialog dialog;
    private JPanel panel;
    private String image;
    private String title;

    public AboutDialog(String title, String image)
    {
        dialog = new JDialog(this.dialog, true);
        panel = new JPanel();
        this.title = title;
        this.image = image;
    }

    public void drawConsole()
    {
        centreConsole();
        customiseFrameIcon();

        ImageIcon aboutIcon = new ImageIcon(image);
        panel.add(new JLabel(aboutIcon));
        dialog.add(panel);
        dialog.setSize(305, 280);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(2);
        dialog.setTitle(title);
        dialog.setVisible(true);
    }


    private void centreConsole()
    {
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((d1.width - dialog.getSize().width) / 2, (d1.height - dialog.getSize().height) / 2);
    }

    private void customiseFrameIcon()
    {
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/frameLogo.gif");

        dialog.setIconImage(img1);
    }
}
