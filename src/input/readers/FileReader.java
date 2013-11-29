package input.readers;

import gui.consoles.CustomConsole;
import input.filters.TextFileFilter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileReader extends CustomConsole
{
  private JFileChooser fileChooser = new JFileChooser();
  private boolean nativeLookAndFeel = true;
  private File file;
  private String filePath;

  public FileReader(boolean nativeLookAndFeel)
  {
    this.nativeLookAndFeel = nativeLookAndFeel;
  }

  public final void drawConsole()
  {
    consoleCentre();

    int result = this.fileChooser.showOpenDialog(null);
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", ".txt", ".gif", ".jpeg", ".dll");

    this.fileChooser.setDialogTitle("J-Pad - Open");
    this.file = null;

    int result1 = 0;
    this.fileChooser.addChoosableFileFilter(new TextFileFilter());

    if (result == 0)
    {
      this.filePath = this.fileChooser.getSelectedFile().getPath();
    }try {
      FileInputStream fr = new FileInputStream(this.filePath);
      InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
      BufferedReader reader = new BufferedReader(isr);
      StringBuffer buffer = new StringBuffer();

      String line = null;
      while ((line = reader.readLine()) != null) {
        buffer.append(line);
      }

      reader.close();
      System.out.println(line);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
