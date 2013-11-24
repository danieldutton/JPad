package gui.components;

import gui.AboutDialog;
import gui.FontConsole;
import gui.actions.*;
import input.FileReader;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenuBar extends JMenuBar {
    private SaveFileAction saveAction = new SaveFileAction();
    private NewFileAction newFileAction = new NewFileAction();
    private CutEditAction cutEditAction = new CutEditAction();
    private CopyEditAction copyEditAction = new CopyEditAction();
    private PasteEditAction pasteEditAction = new PasteEditAction();
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu formatMenu;
    private JMenu helpMenu;
    private JMenuItem file_New;
    private JMenuItem file_Open;
    private JMenuItem file_Save;
    private JMenuItem file_Exit;
    private JMenuItem edit_Cut;
    private JMenuItem edit_Copy;
    private JMenuItem edit_Paste;
    private JMenuItem edit_SelectAll;
    private JMenuItem format_Font;
    private JMenuItem help_Help;
    private JMenuItem help_About;

    public MenuBar() {
        this.menuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.formatMenu = new JMenu("Format");
        this.helpMenu = new JMenu("Help");

        this.file_New = new JMenuItem("New");
        this.file_Open = new JMenuItem("Open");
        this.file_Save = new JMenuItem(this.saveAction);

        this.file_Exit = new JMenuItem("Exit");

        this.edit_Cut = new JMenuItem(new DefaultEditorKit.CutAction());
        this.edit_Cut.setText("Cut");
        this.edit_Copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        this.edit_Copy.setText("Copy");
        this.edit_Paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        this.edit_Paste.setText("Paste");
        this.edit_SelectAll = new JMenuItem("select-all");
        this.edit_SelectAll.setText("Select All");

        this.format_Font = new JMenuItem("Font");

        this.help_Help = new JMenuItem("Help");
        this.help_About = new JMenuItem("About");
    }


    public JMenuBar getGuiMenuBar() {
        this.fileMenu.add(this.file_Open);
        this.fileMenu.add(this.file_New);

        this.fileMenu.add(this.file_Save);
        this.fileMenu.add(new JSeparator());
        this.fileMenu.add(this.file_Exit);

        this.file_New.setMnemonic('N');
        this.file_Open.setMnemonic('O');
        this.file_Save.setMnemonic('S');
        this.file_Exit.setMnemonic('E');

        this.file_New.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        this.file_Open.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        this.file_Save.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.file_Exit.setAccelerator(KeyStroke.getKeyStroke(69, 2));

        this.editMenu.add(new JSeparator(0));
        this.editMenu.add(this.cutEditAction);
        this.editMenu.add(this.copyEditAction);
        this.editMenu.add(this.pasteEditAction);
        this.editMenu.add(new JSeparator(0));
        this.editMenu.add(this.edit_SelectAll);

        this.edit_Cut.setMnemonic('V');
        this.edit_Copy.setMnemonic('C');
        this.edit_Paste.setMnemonic('P');
        this.edit_SelectAll.setMnemonic('S');

        this.edit_Cut.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        this.edit_Copy.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        this.edit_Paste.setAccelerator(KeyStroke.getKeyStroke(86, 2));
        this.edit_SelectAll.setAccelerator(KeyStroke.getKeyStroke(65, 2));

        this.formatMenu.add(this.format_Font);

        this.format_Font.setMnemonic('F');

        this.format_Font.setAccelerator(KeyStroke.getKeyStroke(70, 2));

        this.helpMenu.add(this.help_Help);
        this.helpMenu.add(new JSeparator());
        this.helpMenu.add(this.help_About);

        this.help_About.setMnemonic('A');
        this.help_Help.setMnemonic('H');

        this.help_Help.setAccelerator(KeyStroke.getKeyStroke(72, 2));

        this.menuBar.add(this.fileMenu);
        this.menuBar.add(this.editMenu);
        this.menuBar.add(this.formatMenu);
        this.menuBar.add(this.helpMenu);
        this.menuBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        this.file_New.addActionListener(new MenuBar.OpenNewDoc());
        this.file_Open.addActionListener(new MenuBar.OpenNewFile());
        this.file_Exit.addActionListener(new MenuBar.ExitPad());

        this.edit_Cut.addActionListener(new MenuBar.CutText());

        this.format_Font.addActionListener(new MenuBar.SetFont());

        this.help_About.addActionListener(new MenuBar.ShowAboutFrame());
        this.help_Help.addActionListener(new MenuBar.LaunchHelpMenu());

        this.fileMenu.setFont(new Font("Verdana", 0, 12));
        this.file_New.setFont(new Font("MS Sans Serif", 0, 12));
        this.file_Open.setFont(new Font("MS Sans Serif", 0, 12));
        this.file_Save.setFont(new Font("MS Sans Serif", 0, 12));
        this.file_Exit.setFont(new Font("MS Sans Serif", 0, 12));

        this.editMenu.setFont(new Font("Verdana", 0, 12));
        this.edit_Cut.setFont(new Font("MS Sans Serif", 0, 12));
        this.edit_Copy.setFont(new Font("MS Sans Serif", 0, 12));
        this.edit_Paste.setFont(new Font("MS Sans Serif", 0, 12));
        this.edit_SelectAll.setFont(new Font("MS Sans Serif", 0, 12));

        this.formatMenu.setFont(new Font("Verdana", 0, 12));
        this.format_Font.setFont(new Font("MS Sans Serif", 0, 12));

        this.helpMenu.setFont(new Font("Verdana", 0, 12));
        this.help_Help.setFont(new Font("MS Sans Serif", 0, 12));
        this.help_About.setFont(new Font("MS Sans Serif", 0, 12));

        this.file_New.setBackground(Color.white);
        this.file_Open.setBackground(Color.white);
        this.file_Save.setBackground(Color.white);
        this.file_Exit.setBackground(Color.white);

        this.edit_Cut.setBackground(Color.white);
        this.edit_Copy.setBackground(Color.white);
        this.edit_Paste.setBackground(Color.white);
        this.edit_SelectAll.setBackground(Color.white);

        this.format_Font.setBackground(Color.white);

        this.help_Help.setBackground(Color.white);
        this.help_About.setBackground(Color.white);

        this.file_New.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        this.menuBar.setVisible(true);
        return this.menuBar;
    }

    private class ShowAboutFrame implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.help_About) {
                AboutDialog aboutDialog = new AboutDialog("J-Pad", "aboutScreen.gif");
                aboutDialog.drawConsole();
            }
        }
    }

    private class LaunchHelpMenu implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.help_Help) {
                if (Desktop.isDesktopSupported())
                    try {
                        Desktop.getDesktop().browse(new URI("http://www.danieldutton.org.uk/userGuide1.html"));
                    } catch (IOException ex) {
                    } catch (URISyntaxException ex) {
                    }
                else
                    JOptionPane.showMessageDialog(null, "Default system browser not found.  Please manually navigate to ");
            }
        }
    }

    private class SetFont implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.format_Font) {
                FontConsole fontConsole = new FontConsole("J-Pad");
                fontConsole.drawConsole();
            }
        }
    }

    private class SelectAllText implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            JTextArea textArea;
            if (c.getSource() == MenuBar.this.edit_SelectAll) {
                textArea = GuiTextArea.getDefaultGuiTextArea();
            }
        }
    }

    private class ExitPad implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.file_Exit) {
                System.exit(0);
            }
        }
    }

    private class CutText implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Action cutAction;
            if (e.getSource() == MenuBar.this.edit_Cut) {
                cutAction = GuiTextArea.getDefaultGuiTextArea().getActionMap().get("cut-to-clipboard");
            }
        }
    }

    protected class OpenNewFile implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.file_Open) {
                JTextArea textArea1 = null;
                textArea1 = GuiTextArea.getDefaultGuiTextArea();
                GuiTextArea.actionPerformed(c);
            }
        }
    }

    private class OpenNewDoc implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            if (c.getSource() == MenuBar.this.file_New) {
                FileReader reader = new FileReader(true);
                reader.drawConsole();
            }
        }
    }
}