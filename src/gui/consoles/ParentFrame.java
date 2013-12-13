package gui.consoles;

import javax.swing.*;
import java.awt.*;

public class ParentFrame extends JFrame
{
    public ParentFrame(String title)
    {
        super(title);
    }

    public ParentFrame(String title, int consoleWidth, int consoleHeight)
    {
        this(title);
        setSize(consoleWidth, consoleHeight);
    }

    public void addCustomFrameIcon(String file)
    {
        Image frameIcon = Toolkit.getDefaultToolkit().getImage(file);
        setIconImage(frameIcon);
    }

    public Dimension centreConsoleRelativeToScreen()
    {
        Dimension centreDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((centreDimension.width - getSize().width) / 2, (centreDimension.height - getSize().height) / 2);

        return centreDimension;
    }
}
