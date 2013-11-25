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
        this.btnSave = new JButton(this.saveAction);
        this.btnPrint = new JButton(this.printAction);
        this.btnCut = new JButton(this.cutAction);
        this.btnCopy = new JButton(this.copyAction);
        this.btnPaste = new JButton(this.pasteAction);
    }

    private void setButtonBorders(){
        this.btnSave.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
        this.btnPrint.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 10));
        this.btnCut.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
        this.btnCopy.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
        this.btnPaste.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 10));
        this.toolBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    private void setButtonToolTips(){
        this.btnSave.setToolTipText("Save");
        this.btnPrint.setToolTipText("Print");
        this.btnCut.setToolTipText("Cut");
        this.btnCopy.setToolTipText("Copy");
        this.btnPaste.setToolTipText("Paste");
    }

    private void removeTextValues(){
        this.btnSave.setText(null);
        this.btnPrint.setText(null);
        this.btnCut.setText(null);
        this.btnCopy.setText(null);
        this.btnPaste.setText(null);
    }

    private void buildToolBar(){
        this.toolBar.add(this.btnSave);
        this.toolBar.add(this.btnPrint);
        this.toolBar.add(this.btnCut);
        this.toolBar.add(this.btnCopy);
        this.toolBar.add(this.btnPaste);
        this.toolBar.setFloatable(false);
    }
}
