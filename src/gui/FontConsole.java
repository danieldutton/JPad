package gui;

import gui.components.GuiTextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontConsole extends EditableConsole {

    private JPanel panelMain;
    private JPanel samplePanel;
    private JComboBox comboBoxFont;
    private JButton btnOk;
    private JButton btnCancel;
    private JLabel lblFont;
    private JTextArea textArea = GuiTextArea.getDefaultGuiTextArea();


    public FontConsole(String title) {
        super(title);

        InitConsole();
        AddActionListeners();
    }

    private void InitConsole() {
        panelMain = new JPanel();
        samplePanel = new JPanel();
        comboBoxFont = new JComboBox();
        btnOk = new JButton("OK");
        btnCancel = new JButton("Cancel");
        lblFont = new JLabel("Sample");
        BuildConsole();
        add(panelMain);
    }

    private void AddActionListeners(){
        comboBoxFont.addItemListener(new ItemChangeListener());
        btnCancel.addActionListener(new FontConsole.CancelFontChange());
        btnOk.addActionListener(new FontConsole.ConfirmFontChange());
    }

    private void BuildConsole(){

        panelMain.setBorder(BorderFactory.createTitledBorder("Set Font"));
        frameBasics();
        consoleCentre();
        setSize(250, 200);
        setResizable(false);
        comboBoxFont.setBackground(Color.white);
        panelMain.add(comboBoxFont);
        panelMain.add(lblFont);
        panelMain.add(btnOk);
        panelMain.add(btnCancel);
    }

    public void drawConsole() {

        Runnable runner = new Runnable() {
            public void run() {
                GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
                Font[] fonts = e.getAllFonts();
                for (Font f : fonts)
                    comboBoxFont.addItem(f.getFontName());
            }
        };
        EventQueue.invokeLater(runner);
    }

    public class ItemChangeListener implements ItemListener {

    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
          String chosenFont = (String)event.getItem();
          lblFont.setFont(new Font(chosenFont, Font.BOLD, 30));
       }
    }
}

    public class ConfirmFontChange implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == FontConsole.this.btnOk) {
                textArea.setFont(new Font((String) comboBoxFont.getSelectedItem(), Font.PLAIN, 30));
                FontConsole.this.dispose();
            }
        }
    }

    public class CancelFontChange implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == FontConsole.this.btnCancel) {
                FontConsole.this.dispose();
            }
        }
    }
}