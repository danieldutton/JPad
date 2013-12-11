package gui.components;

import actions.*;

import javax.swing.*;
import java.awt.*;

public class ToolBar
{
    private JToolBar toolBar;
    private SaveFileAction saveAction;
    private PrintFileAction printAction;
    private CutTextAction cutAction;
    private CopyTextAction copyAction;
    private PasteTextAction pasteAction;

    private JButton btnSave;
    private JButton btnPrint;
    private JButton btnCut;
    private JButton btnCopy;
    private JButton btnPaste;

    public ToolBar()
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
    }

    public JToolBar GetGuiToolBar()
    {
        return toolBar;
    }

    private void initActions()
    {
        saveAction = new SaveFileAction();
        printAction = new PrintFileAction();
        cutAction = new CutTextAction();
        copyAction = new CopyTextAction();
        pasteAction = new PasteTextAction();
    }

    private void initButtons()
    {
        btnSave = new JButton(saveAction);
        btnPrint = new JButton(printAction);
        btnCut = new JButton(cutAction);
        btnCopy = new JButton(copyAction);
        btnPaste = new JButton(pasteAction);
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
}
