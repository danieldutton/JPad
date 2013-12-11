package input.readers;

import java.io.*;

public class FileReader implements IFileReader
{
    public String readFile(String filePath)
    {
        String strLine = null;

        try
            {
                FileInputStream in = new FileInputStream(filePath);

                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();
                while ((strLine = br.readLine()) != null)
                {
                    sb.append(strLine);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        return strLine.toString();
    }
}
