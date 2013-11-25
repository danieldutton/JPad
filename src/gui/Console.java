package gui;

import javax.swing.*;
import java.awt.*;

public abstract class Console extends JFrame {

    private int consoleWidth;

    private int consoleHeight;


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

    public void initConsoleBasics() {
        setSize(this.consoleWidth, this.consoleHeight);
    }

    public void customiseFrameIcon(String file) {
        Image frameIcon = Toolkit.getDefaultToolkit().getImage(file);
        setIconImage(frameIcon);
    }

    public Dimension consoleCentre() {
        Dimension centreDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((centreDimension.width - getSize().width) / 2, (centreDimension.height - getSize().height) / 2);

        return centreDimension;
    }
}
