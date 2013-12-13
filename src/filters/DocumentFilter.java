package filters;

import java.io.File;

public class DocumentFilter extends javax.swing.filechooser.FileFilter{

    public boolean accept(File f){

    return f.isDirectory()||(f.isFile()&&f.getName().toLowerCase().endsWith(".txt"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".css"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".html"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".htm"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".xml"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".cs"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".java"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".vb"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".js"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".php"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".asp"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".aspx"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".cfm"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".jsp"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".xhtml"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".c"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".py"))
            ||(f.isFile()&&f.getName().toLowerCase().endsWith(".pl"));
    }

    public String getDescription(){

        return "avail files";
    }
}
