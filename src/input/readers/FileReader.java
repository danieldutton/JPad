package input.readers;

import javax.swing.*;
import java.io.*;

public class FileReader implements IFileReader
{
    public String readFile(String filePath)
    {
        String strLine = null;
        StringBuilder sb = null;
        try
            {
                FileInputStream in = new FileInputStream(filePath);

                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                sb = new StringBuilder();
                while ((strLine = br.readLine()) != null)
                {
                    sb.append(strLine + "\n");
                }
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error Reading From File");
            }

        return sb.toString();
    }
}
