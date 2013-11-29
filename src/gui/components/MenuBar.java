package gui.components;

import gui.consoles.AboutDialog;
import gui.consoles.FontDialog;
import actions.*;
import input.readers.FileReader;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenuBar extends JMenuBar {

    //actions
    private SaveFileAction actionSave;
    private CutTextAction actionCut;
    private CopyTextAction actionCopy;
    private PasteTextAction actionPaste;
    private DeleteTextAction actionDelete;

    private JMenuBar menuBar;

    //menu titles
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuFormat;
    private JMenu menuView;
    private JMenu menuHelp;

    //menu items
    private JMenuItem menuItemNew;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemSaveAs;
    private JMenuItem menuItemExit;
    private JMenuItem menuItemCut;
    private JMenuItem menuItemCopy;
    private JMenuItem menuItemPaste;
    private JMenuItem menuItemDelete;
    private JMenuItem menuItemSelectAll;
    private JMenuItem menuItemFont;
    private JMenuItem menuItemWordWrap;
    private JMenuItem menuItemStatusBar;
    private JMenuItem menuItemAbout;


    public MenuBar()
    {
        menuBar = new JMenuBar();
        initFileMenuActions();
        initMenus();
        initMenuItems();
        addMenuItemsToMenu();
        setMenuItemMnemonics();
        setMenuItemAccelerators();
        addActionListeners();
        buildMenuBar();
        styleMenuBar();
        menuBar.setVisible(true);
    }

    private void initMenus()
    {
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuView = new JMenu("View");
        menuHelp = new JMenu("Help");
    }

    private void initFileMenuActions()
    {
        actionSave = new SaveFileAction();
        actionCut = new CutTextAction();
        actionCopy = new CopyTextAction();
        actionPaste = new PasteTextAction();
        actionDelete = new DeleteTextAction();
    }

    private void initMenuItems()
    {
        //file
        menuItemNew = new JMenuItem("New");
        menuItemOpen = new JMenuItem("Open");
        menuItemSave = new JMenuItem(actionSave);
        menuItemSaveAs = new JMenuItem(actionSave);
        menuItemExit = new JMenuItem("Exit");

        //edit
        menuItemCut = new JMenuItem(new CutTextAction());
        menuItemCut.setText("Cut");
        menuItemCopy = new JMenuItem(new CopyTextAction());
        menuItemCopy.setText("Copy");
        menuItemPaste = new JMenuItem(new PasteTextAction());
        menuItemPaste.setText("Paste");
        menuItemDelete = new JMenuItem("Delete");
        menuItemSelectAll = new JMenuItem("Select-All");
        menuItemSelectAll.setText("Select All");

        //format
        menuItemFont = new JMenuItem("Font");
        menuItemWordWrap = new JMenuItem("Word Wrap");

        //view
        menuItemStatusBar = new JMenuItem("Status Bar");

        //help
        menuItemAbout = new JMenuItem("About");
    }

    private void addMenuItemsToMenu()
    {
        //file
        menuFile.add(menuItemNew);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemSaveAs);
        menuFile.add(new JSeparator());
        menuFile.add(menuItemExit);

        //edit
        menuEdit.add(new JSeparator(0));
        menuEdit.add(actionCut);
        menuEdit.add(actionCopy);
        menuEdit.add(actionPaste);
        menuEdit.add(actionDelete);
        menuEdit.add(new JSeparator(0));
        menuEdit.add(menuItemSelectAll);

        //format
        menuFormat.add(menuItemFont);
        menuFormat.add(menuItemWordWrap);

        //view
        menuView.add(menuItemStatusBar);
        //help
        menuHelp.add(menuItemAbout);
    }

    private void setMenuItemMnemonics()
    {
        //file
        menuItemNew.setMnemonic('N');
        menuItemOpen.setMnemonic('O');
        menuItemSave.setMnemonic('S');
        menuItemExit.setMnemonic('E');

        //edit
        menuItemCut.setMnemonic('V');
        menuItemCopy.setMnemonic('C');
        menuItemPaste.setMnemonic('P');
        menuItemSelectAll.setMnemonic('S');

        //format
        menuItemFont.setMnemonic('F');

        //view

        //help
        menuItemAbout.setMnemonic('A');
    }

    private void setMenuItemAccelerators()
    {
        //file
        menuItemNew.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(69, 2));

        //edit
        menuItemCut.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(86, 2));
        menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(65, 2));

        //format
        menuItemFont.setAccelerator(KeyStroke.getKeyStroke(70, 2));

        //view
        menuView.add(this, menuItemStatusBar);

        //help
    }

    private void addActionListeners()
    {
        //file
        menuItemNew.addActionListener(new MenuBar.OpenNewDoc());
        menuItemOpen.addActionListener(new MenuBar.OpenNewFile());
        menuItemExit.addActionListener(new MenuBar.ExitPad());

        //edit
        menuItemSelectAll.addActionListener(new SelectAllText());

        //format
        menuItemFont.addActionListener(new MenuBar.SetFont());
        menuItemWordWrap.addActionListener(new MenuBar.ToggleWordWrap());

        //view
        menuItemStatusBar.addActionListener(new ToggleStatusBar());

        //help
        menuItemAbout.addActionListener(new MenuBar.ShowAboutFrame());
    }

    private void buildMenuBar()
    {
        menuBar.add(this.menuFile);
        menuBar.add(this.menuEdit);
        menuBar.add(this.menuFormat);
        menuBar.add(this.menuView);
        menuBar.add(this.menuHelp);
    }

    private void styleMenuBar()
    {
        menuBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        menuFile.setFont(new Font("Verdana", 0, 12));
        menuItemNew.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemOpen.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemSave.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemExit.setFont(new Font("MS Sans Serif", 0, 12));

        menuEdit.setFont(new Font("Verdana", 0, 12));
        menuItemCut.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemCopy.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemPaste.setFont(new Font("MS Sans Serif", 0, 12));
        menuItemSelectAll.setFont(new Font("MS Sans Serif", 0, 12));

        menuFormat.setFont(new Font("Verdana", 0, 12));
        menuItemFont.setFont(new Font("MS Sans Serif", 0, 12));

        menuView.setFont(new Font("Verdana", 0, 12));
        menuItemStatusBar.setFont(new Font("MS Sans Serif", 0, 12));

        menuHelp.setFont(new Font("Verdana", 0, 12));
        menuItemAbout.setFont(new Font("MS Sans Serif", 0, 12));

        menuItemNew.setBackground(Color.white);
        menuItemOpen.setBackground(Color.white);
        menuItemSave.setBackground(Color.white);
        menuItemExit.setBackground(Color.white);

        menuItemCut.setBackground(Color.white);
        menuItemCopy.setBackground(Color.white);
        menuItemPaste.setBackground(Color.white);
        menuItemSelectAll.setBackground(Color.white);

        menuItemFont.setBackground(Color.white);

        menuItemAbout.setBackground(Color.white);

        menuItemNew.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }

    public JMenuBar getGuiMenuBar()
    {
        return this.menuBar;
    }

    private class ShowAboutFrame implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == MenuBar.this.menuItemAbout)
            {
                AboutDialog aboutDialog = new AboutDialog("J-Pad", "images/aboutScreen.gif");
                aboutDialog.drawConsole();
            }
        }
    }

    private class SetFont implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == MenuBar.this.menuItemFont)
            {
                FontDialog fontConsole = new FontDialog("J-Pad");
                fontConsole.drawConsole();
            }
        }
    }

    private class SelectAllText implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            JTextArea textArea;
            if (c.getSource() == MenuBar.this.menuItemSelectAll)
            {
                textArea = TextArea.getDefaultGuiTextArea();
                textArea.selectAll();
            }
        }
    }

    private class ExitPad implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == MenuBar.this.menuItemExit)
            {
                System.exit(0);
            }
        }
    }



    protected class OpenNewFile implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == MenuBar.this.menuItemOpen)
            {
                JTextArea textArea1 = null;
                textArea1 = TextArea.getDefaultGuiTextArea();
                TextArea.actionPerformed(c);
            }
        }
    }

    private class OpenNewDoc implements ActionListener
    {
        public void actionPerformed(ActionEvent c)
        {
            if (c.getSource() == MenuBar.this.menuItemNew)
            {
                FileReader reader = new FileReader(true);
                reader.drawConsole();
            }
        }
    }

    private class ToggleWordWrap implements ActionListener
    {
        private boolean isWrapped = false;

        public void actionPerformed(ActionEvent e)
        {
            if(isWrapped)
            {
                TextArea.getDefaultGuiTextArea().setLineWrap(false);
                TextArea.getDefaultGuiTextArea().setWrapStyleWord(false);
                isWrapped = false;
            }
            else
            {
                TextArea.getDefaultGuiTextArea().setLineWrap(true);
                TextArea.getDefaultGuiTextArea().setWrapStyleWord(true);
                isWrapped = true;
            }
        }
    }

    private class ToggleStatusBar implements ActionListener{

        private boolean isVisible = true;

        public void actionPerformed(ActionEvent e)
        {
            if(isVisible)
            {
                StatusBar.getStatusBar().setVisible(false);
                isVisible = false;
            }
            else{
                StatusBar.getStatusBar().setVisible(true);
                isVisible = true;
            }
        }
    }
}