package gui;

public class NonEditableConsole extends Console
{
  private static final boolean EDIT_STATUS = false;

  public NonEditableConsole()
  {
  }

  public NonEditableConsole(String title)
  {
    super(title);
  }

  public NonEditableConsole(String title, int consoleWidth, int consoleHeight)
  {
    super(title, consoleWidth, consoleHeight);
  }

  public void drawConsole()
  {
    frameBasics();
  }

  public void frameBasics()
  {
    super.frameBasics();
    setResizable(false);
    setDefaultCloseOperation(2);
  }
}
