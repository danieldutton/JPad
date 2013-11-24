package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class TextFileFilter extends FileFilter
{
  public boolean accept(File file)
  {
    if (file.isDirectory())
    {
      return true;
    }String name = file.getName();

    return name.matches(".*\\.txt");
  }

  public String getDescription()
  {
    return "Text files (*.text)";
  }
}
