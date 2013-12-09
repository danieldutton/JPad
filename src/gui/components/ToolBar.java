package gui.components;

import actions.*;
import javax.swing.*;
import java.awt.*;

public class ToolBar {

    private JToolBar toolBar;
    private NewFileAction newFileAction;
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

    public ToolBar() {
        this.toolBar = new JToolBar();

        initActions();
        initButtons();
        setButtonBorders();
        setButtonToolTips();
        styleToolBar();
        removeTextValues();
        buildToolBar();
    }

    public JToolBar GetGuiToolBar() {
        return this.toolBar;
    }

    private void initActions(){
        newFileAction = new NewFileAction();
        saveAction = new SaveFileAction();
        printAction = new PrintFileAction();
        cutAction = new CutTextAction();
        copyAction = new CopyTextAction();
        pasteAction = new PasteTextAction();
    }

    private void initButtons(){
        btnSave = new JButton(this.saveAction);
        btnPrint = new JButton(this.printAction);
        btnCut = new JButton(this.cutAction);
        btnCopy = new JButton(this.copyAction);
        btnPaste = new JButton(this.pasteAction);
    }

    private void setButtonBorders(){
        btnSave.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnPrint.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 10));
        btnCut.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnCopy.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        btnPaste.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 10));
        toolBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    private void setButtonToolTips(){
        btnSave.setToolTipText("Save");
        btnPrint.setToolTipText("Print");
        btnCut.setToolTipText("Cut");
        btnCopy.setToolTipText("Copy");
        btnPaste.setToolTipText("Paste");
    }

    private void styleToolBar(){
        toolBar.setBackground(new Color(238, 238, 238));
    }

    private void removeTextValues(){
        btnSave.setText(null);
        btnPrint.setText(null);
        btnCut.setText(null);
        btnCopy.setText(null);
        btnPaste.setText(null);
    }

    private void buildToolBar(){
        toolBar.add(this.btnSave);
        toolBar.add(this.btnPrint);
        toolBar.add(this.btnCut);
        toolBar.add(this.btnCopy);
        toolBar.add(this.btnPaste);
        toolBar.setFloatable(false);
    }
}
