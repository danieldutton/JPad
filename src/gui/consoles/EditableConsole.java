package gui.consoles;

public class EditableConsole extends AbstractConsole {
    public EditableConsole() {
    }

    public EditableConsole(String title) {
        super(title);
    }

    public EditableConsole(String title, int consoleWidth, int consoleHeight) {
        super(title, consoleWidth, consoleHeight);
    }

    public void drawConsole() {
        initConsoleBasics();
        setDefaultCloseOperation(3);
        setVisible(true);
    }
}