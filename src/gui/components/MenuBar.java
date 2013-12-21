package gui.components;

import actions.edit.CopyTextAction;
import actions.edit.CutTextAction;
import actions.edit.DeleteTextAction;
import actions.edit.PasteTextAction;
import actions.file.*;
import actions.format.FontSelectAction;
import actions.format.WordWrapAction;
import actions.help.OpenAboutDialogAction;
import actions.view.ToggleStatusBarAction;
import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar
{
    //actions
    private NewFileAction actionNewFile;
    private OpenFileAction actionOpenFile;
    private SaveFileAction actionSave;
    private SaveFileAsAction actionSaveAs;

    //edit
    private CutTextAction actionCut;
    private CopyTextAction actionCopy;
    private PasteTextAction actionPaste;
    private DeleteTextAction actionDelete;
    private WordWrapAction actionWordWrap;
    private OpenAboutDialogAction actionAboutDialog;
    private SelectAllTextAction actionSelectAllText;
    private FontSelectAction actionSelectFont;
    private ToggleStatusBarAction actionToggleStatusBar;
    private ExitApplicationAction actionExitApplication;

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
    private JMenuItem menuItemUndo;
    private JMenuItem menuItemRedo;
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

    }

    public void init(){
        menuBar = new JMenuBar();
        initFileMenuActions();
        initMenus();
        initMenuItems();
        addMenuItemsToMenu();
        setMenuItemMnemonics();
        setMenuItemAccelerators();
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
        actionNewFile = new NewFileAction();
        actionOpenFile = new OpenFileAction();
        actionCut = new CutTextAction();
        actionCopy = new CopyTextAction();
        actionPaste = new PasteTextAction();
        actionDelete = new DeleteTextAction();
        actionWordWrap = new WordWrapAction();
        actionAboutDialog = new OpenAboutDialogAction();
        actionSelectAllText = new SelectAllTextAction();
        actionSelectFont = new FontSelectAction();
        actionToggleStatusBar = new ToggleStatusBarAction();
        actionExitApplication = new ExitApplicationAction();
    }

    private void initMenuItems()
    {
        //file
        menuItemNew = new JMenuItem(actionNewFile);
        menuItemOpen = new JMenuItem(actionOpenFile);
        menuItemSave = new JMenuItem(actionSave);
        menuItemSaveAs = new JMenuItem(actionSaveAs);
        menuItemExit = new JMenuItem(actionExitApplication);

        //edit
        menuItemUndo = new JMenuItem("Undo");
        menuItemRedo = new JMenuItem("Redo");
        menuItemCut = new JMenuItem(actionCut);
        menuItemCopy = new JMenuItem(actionCopy);
        menuItemPaste = new JMenuItem(actionPaste);
        menuItemDelete = new JMenuItem(actionDelete);
        menuItemSelectAll = new JMenuItem(actionSelectAllText);

        //format
        menuItemFont = new JMenuItem(actionSelectFont);
        menuItemWordWrap = new JMenuItem(actionWordWrap);

        //view
        menuItemStatusBar = new JMenuItem(actionToggleStatusBar);

        //help
        menuItemAbout = new JMenuItem(actionAboutDialog);
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
        menuEdit.add(menuItemUndo);
        menuEdit.add(menuItemRedo);
        menuEdit.add(menuItemCut);
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemPaste);
        menuEdit.add(menuItemDelete);
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
        menuItemCut.setMnemonic('C');
        menuItemCopy.setMnemonic('C');
        menuItemPaste.setMnemonic('P');
        menuItemSelectAll.setMnemonic('S');

        //format
        menuItemFont.setMnemonic('F');
    }

    private void setMenuItemAccelerators()
    {
        //file
        menuItemNew.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        menuItemExit.setAccelerator(KeyStroke.getKeyStroke(69, 2));

        //edit
        menuItemUndo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        menuItemRedo.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        menuItemCut.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(86, 2));
        menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(65, 2));

        //format
        menuItemFont.setAccelerator(KeyStroke.getKeyStroke(70, 2));
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
        final String Font = "Ms Sans Serif";
        final int FontStyle = 0;
        final int FontSize = 12;

        Font itemFont = new Font(Font, FontStyle, FontSize);

        menuBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        menuItemNew.setFont(itemFont);
        menuItemOpen.setFont(itemFont);
        menuItemSave.setFont(itemFont);
        menuItemSaveAs.setFont(itemFont);
        menuItemExit.setFont(itemFont);

        menuItemUndo.setFont(itemFont);
        menuItemRedo.setFont(itemFont);
        menuItemCut.setFont(itemFont);
        menuItemCopy.setFont(itemFont);
        menuItemPaste.setFont(itemFont);
        menuItemDelete.setFont(itemFont);
        menuItemSelectAll.setFont(itemFont);

        menuItemFont.setFont(itemFont);
        menuItemWordWrap.setFont(itemFont);

        menuItemStatusBar.setFont(itemFont);
        menuItemAbout.setFont(itemFont);

        menuItemNew.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        styleMenuText();
    }

    private void styleMenuText()
    {
        final String Font = "Verdana";
        final int FontStyle = 0;
        final int FontSize = 12;

        menuFile.setFont(new Font(Font, FontStyle, FontSize));
        menuEdit.setFont(new Font(Font, FontStyle, FontSize));
        menuFormat.setFont(new Font(Font, FontStyle, FontSize));
        menuView.setFont(new Font(Font, FontStyle, FontSize));
        menuHelp.setFont(new Font(Font, FontStyle, FontSize));
    }

    public void setSaveFileAction(SaveFileAction action)
    {
        actionSave = action;
    }

    public void setSaveFileAsAction(SaveFileAsAction action)
    {
        actionSaveAs = action;
    }

    public JMenuBar getGuiMenuBar()
    {
        return this.menuBar;
    }
}