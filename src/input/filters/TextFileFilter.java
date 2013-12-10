package input.filters;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class TextFileFilter extends FileFilter
{
    public boolean accept(File file)
    {
        return file.isDirectory()||file.getName().toLowerCase().endsWith("txt");
    }

    public String getDescription()
    {
        return "Text files (*.text)";
    }
}
