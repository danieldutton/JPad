package gui;

public class EditableConsole extends Console {
    public EditableConsole() {
    }

    public EditableConsole(String title) {
        super(title);
    }

    public EditableConsole(String title, int consoleWidth, int consoleHeight) {
        super(title, consoleWidth, consoleHeight);
    }

    public void drawConsole() {
        frameBasics();
        setDefaultCloseOperation(3);
        setVisible(true);
    }
}