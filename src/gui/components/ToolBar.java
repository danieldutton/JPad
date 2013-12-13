package gui.components;

import actions.edit.CopyTextAction;
import actions.edit.CutTextAction;
import actions.edit.PasteTextAction;
import actions.file.PrintFileAction;
import actions.file.SaveFileAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar
{
    private JToolBar toolBar;
    private SaveFileAction actionSave;
    private PrintFileAction actionPrint;
    private CutTextAction actionCut;
    private CopyTextAction actionCopy;
    private PasteTextAction actionPaste;

    private JButton btnSave;
    private JButton btnPrint;
    private JButton btnCut;
    private JButton btnCopy;
    private JButton btnPaste;

    private JComboBox<Integer> comboBoxFontSize;

    public ToolBar()
    {

    }

    public void init()
    {
        toolBar = new JToolBar();

        initActions();
        initButtons();
        setButtonBorders();
        setButtonToolTips();
        removeButtonFocus();
        styleToolBar();
        removeTextValues();
        buildToolBar();
        Integer[] comboArray = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        comboBoxFontSize = new JComboBox<Integer>(comboArray);
        comboBoxFontSize.setMinimumSize(new Dimension(40, 20));
        comboBoxFontSize.setMaximumSize(new Dimension(40, 20));
        comboBoxFontSize.setSelectedIndex(5);
        toolBar.add(comboBoxFontSize);
        final Font currentFont = TextArea.getTextArea().getFont();

        comboBoxFontSize.addActionListener (new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        TextArea.getTextArea().setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), (Integer)cb.getSelectedItem() ));
    }
});
    }

    public JToolBar GetGuiToolBar()
    {
        return toolBar;
    }

    private void initActions()
    {
        actionPrint = new PrintFileAction();
        actionCut = new CutTextAction();
        actionCopy = new CopyTextAction();
        actionPaste = new PasteTextAction();
    }

    private void initButtons()
    {
        btnSave = new JButton(actionSave);
        btnPrint = new JButton(actionPrint);
        btnCut = new JButton(actionCut);
        btnCopy = new JButton(actionCopy);
        btnPaste = new JButton(actionPaste);
    }

    private void setButtonBorders()
    {
        btnSave.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnPrint.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 10));
        btnCut.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnCopy.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnPaste.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        toolBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    private void setButtonToolTips()
    {
        btnSave.setToolTipText("Save");
        btnPrint.setToolTipText("Print");
        btnCut.setToolTipText("Cut");
        btnCopy.setToolTipText("Copy");
        btnPaste.setToolTipText("Paste");
    }

    private void removeButtonFocus()
    {
        btnSave.setFocusPainted(false);
        btnPrint.setFocusPainted(false);
        btnCut.setFocusPainted(false);
        btnCopy.setFocusPainted(false);
        btnPaste.setFocusPainted(false);

        btnSave.setContentAreaFilled(false);
        btnPrint.setContentAreaFilled(false);
        btnCut.setContentAreaFilled(false);
        btnCopy.setContentAreaFilled(false);
        btnPaste.setContentAreaFilled(false);
    }

    private void styleToolBar()
    {
        toolBar.setBackground(new Color(238, 238, 238));
    }

    private void removeTextValues()
    {
        btnSave.setText(null);
        btnPrint.setText(null);
        btnCut.setText(null);
        btnCopy.setText(null);
        btnPaste.setText(null);
    }

    private void buildToolBar()
    {
        toolBar.add(btnSave);
        toolBar.add(btnPrint);
        toolBar.add(btnCut);
        toolBar.add(btnCopy);
        toolBar.add(btnPaste);
        toolBar.setFloatable(false);
    }

    public void setSaveFileAction(SaveFileAction action)
    {
        actionSave = action;
    }
}
