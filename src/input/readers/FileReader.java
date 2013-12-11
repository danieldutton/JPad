package input.readers;

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
                //Dialog display here
            }

        return sb.toString();
    }
}
