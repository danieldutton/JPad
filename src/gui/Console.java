package gui;

import javax.swing.*;
import java.awt.*;

public abstract class Console extends JFrame {
    private int consoleWidth;
    private int consoleHeight;
    private boolean consoleVisibility = true;

    public Console() {
    }

    public Console(String title) {
        super(title);
    }

    public Console(String title, int consoleWidth, int consoleHeight) {
        this(title);
        this.consoleWidth = consoleWidth;
        this.consoleHeight = consoleHeight;
    }

    public abstract void drawConsole();

    public void frameBasics() {
        setSize(this.consoleWidth, this.consoleHeight);
        setVisible(this.consoleVisibility);
    }

    public Image customiseFrameIcon(String file) {
        Image img1 = Toolkit.getDefaultToolkit().getImage(file);

        setIconImage(img1);
        validateFrameIconSize(img1);
        return img1;
    }

    private void validateFrameIconSize(Image img) {
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 1);
        try {
            tracker.waitForID(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int w = img.getWidth(null);
        int h = img.getHeight(null);

        if (((w <= 25) && (h <= 25)) || (w > 25) || (h > 25)) {
            setIconImage(img);
        } else {
            System.out.println("Frame Icon size is incorrect. Set x & y to 25px or less");
        }
    }

    public Dimension consoleCentre() {
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d1.width - getSize().width) / 2, (d1.height - getSize().height) / 2);

        return d1;
    }


}
