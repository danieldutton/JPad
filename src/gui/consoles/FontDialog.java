package gui.consoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontDialog
{
    private JDialog fontDialog;
    private JPanel panelMain;
    private JPanel panelSample;
    private JComboBox comboBoxFont;
    private JButton btnOk;
    private JButton btnCancel;
    private JLabel lblFont;
    private JTextArea textArea = gui.components.TextArea.getTextArea();
    private String title = "";

    public FontDialog(String title)
    {
        this.title = title;
        InitConsole();
    }

    private void InitConsole()
    {
        fontDialog = new JDialog();
        fontDialog.setTitle(title);
        panelMain = new JPanel();
        panelSample = new JPanel();
        comboBoxFont = new JComboBox();
        btnOk = new JButton("OK");
        btnCancel = new JButton("Cancel");
        lblFont = new JLabel("Sample");
        BuildConsole();
    }

    private void AddActionListeners()
    {
        comboBoxFont.addItemListener(new ItemChangeListener());
        btnCancel.addActionListener(new FontDialog.CancelFontChange());
        btnOk.addActionListener(new FontDialog.ConfirmFontChange());
    }

    private void BuildConsole()
    {

        panelSample.add(lblFont);
        panelMain.add(BorderLayout.SOUTH, panelSample);
        panelMain.setBorder(BorderFactory.createTitledBorder("Set Font"));
        fontDialog.setSize(250, 200);
        fontDialog.setResizable(false);
        comboBoxFont.setBackground(Color.white);
        panelMain.add(comboBoxFont);
        panelMain.add(btnOk);
        panelMain.add(btnCancel);
        panelMain.add(lblFont);
        fontDialog.setVisible(true);
        fontDialog.add(panelMain);

        fontDialog.setModal(true);
        AddActionListeners();
        centreConsole();
        customiseFrameIcon();

    }

    private void centreConsole()
    {
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        fontDialog.setLocation((d1.width - this.fontDialog.getSize().width) / 2, (d1.height - this.fontDialog.getSize().height) / 2);
    }

    private void customiseFrameIcon()
    {
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/frameLogo.gif");

        fontDialog.setIconImage(img1);
    }

    public void drawConsole()
    {

        Runnable runner = new Runnable()
        {
            public void run()
            {
                GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Font[] fonts = e.getAllFonts();
                for (Font f : fonts)
                    comboBoxFont.addItem(f.getFontName());
            }
        };
        EventQueue.invokeLater(runner);
    }

    public class ItemChangeListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            if (event.getStateChange() == ItemEvent.SELECTED)
            {
                String chosenFont = (String) event.getItem();
                lblFont.setFont(new Font(chosenFont, Font.BOLD, 40));
            }
        }
    }

    public class ConfirmFontChange implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == FontDialog.this.btnOk)
            {
                textArea.setFont(new Font((String) comboBoxFont.getSelectedItem(), Font.PLAIN, 30));

            }
        }
    }

    public class CancelFontChange implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == FontDialog.this.btnCancel)
            {

            }
        }
    }
}