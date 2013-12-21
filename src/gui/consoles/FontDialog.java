package gui.consoles;

import gui.components.TextArea;

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
        fontDialog = new JDialog(fontDialog, true);
        fontDialog.setTitle(title);
        panelMain = new JPanel();
        panelSample = new JPanel();
        comboBoxFont = new JComboBox();
        btnOk = new JButton("Select");
        btnCancel = new JButton("Cancel");
        lblFont = new JLabel("Sample");
        BuildConsole();
        AddActionListeners();
        centreConsole();
        customiseFrameIcon();
    }

    private void BuildConsole()
    {
        panelSample.add(lblFont);
        panelMain.add(BorderLayout.SOUTH, panelSample);
        fontDialog.setSize(225, 155);
        fontDialog.setResizable(false);
        comboBoxFont.setBackground(Color.white);
        comboBoxFont.setPrototypeDisplayValue("***********************************");
        panelMain.add(comboBoxFont);
        panelMain.add(btnOk);
        panelMain.add(btnCancel);
        panelMain.add(lblFont);
        panelMain.setVisible(false);
        fontDialog.add(panelMain);

        fontDialog.setModal(true);
    }

    private void AddActionListeners()
    {
        comboBoxFont.addItemListener(new FontSelectedListener());
        btnCancel.addActionListener(new FontDialog.CancelFontChange());
        btnOk.addActionListener(new FontDialog.ConfirmFontChange());
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
                String[] fonts = e.getAvailableFontFamilyNames();
                for (String f : fonts)
                    comboBoxFont.addItem(f);
            }
        };
        EventQueue.invokeLater(runner);

        panelMain.setVisible(true);
        fontDialog.setVisible(true);
        fontDialog.pack();
    }

    public class FontSelectedListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            if (event.getStateChange() == ItemEvent.SELECTED)
            {
                String chosenFont = (String) event.getItem();
                lblFont.setFont(new Font(chosenFont, Font.BOLD, 32));
            }
        }
    }

    public class ConfirmFontChange implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == FontDialog.this.btnOk)
            {
                Font f = TextArea.getTextArea().getFont();
                textArea.setFont(new Font(comboBoxFont.getSelectedItem().toString(), f.getStyle(), f.getSize()));
                fontDialog.dispose();
            }
        }
    }

    public class CancelFontChange implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == FontDialog.this.btnCancel)
            {
                fontDialog.dispose();
            }
        }
    }
}