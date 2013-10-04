package gui.components;


import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GuiTextArea
{
  private static String chosenFont;
  private String defaultFont;
  private Color defaultTextColour;
  private int defaultFontSize;
  private static UndoManager manager = new UndoManager();
  private static JTextArea textArea = null;

  private GuiTextArea()
  {
    this.defaultFont = "Arial";
    this.defaultTextColour = new Color(0);
    this.defaultFontSize = 14;
  }

  public static JTextArea getDefaultGuiTextArea()
  {
    if (textArea == null)
    {
      textArea = new JTextArea();

      textArea.setEditable(true);
      textArea.setCaretColor(Color.LIGHT_GRAY);
      textArea.setSelectedTextColor(Color.white);
    }

    return textArea;
  }

  public static void actionPerformed(ActionEvent ae)
  {
    JFileChooser chooser = new JFileChooser();
    chooser.setMultiSelectionEnabled(true);
    int option = chooser.showOpenDialog(chooser);
    if (option == 0) {
      File[] sf = chooser.getSelectedFiles();
      String filelist = "";
      if (sf.length > 0) filelist = sf[0].getName();
      for (int i = 1; i < sf.length; i++) {
        filelist = filelist + ", " + sf[i].getName();
      }

      try
      {
        File selectedFile = chooser.getSelectedFile();
        FileInputStream in = new FileInputStream(selectedFile);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)
        {
          textArea.append(strLine + "\n");
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void setFont(String defaultFont)
  {
    chosenFont = defaultFont;
  }
}
