package gui.consoles;

public class CustomConsole extends AbstractConsole {
    public CustomConsole() {
    }

    public CustomConsole(String title) {
        super(title);
    }

    public CustomConsole(String title, int consoleWidth, int consoleHeight) {
        super(title, consoleWidth, consoleHeight);
    }

    public void drawConsole() {
        initConsoleBasics();
        setDefaultCloseOperation(3);
        setVisible(true);

    }
}