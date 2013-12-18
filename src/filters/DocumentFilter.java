package filters;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DocumentFilter
{
    private FileFilter text = new FileNameExtensionFilter("Normal text file", "txt");
    private FileFilter flashActionScript = new FileNameExtensionFilter("Flash Action script file", "as", ".mx");
    private FileFilter ada = new FileNameExtensionFilter("Ada file", "ada", "ads", "adb");
    private FileFilter assemblyLanguage = new FileNameExtensionFilter("Assembly language source file", "asm");
    private FileFilter activeServerPages = new FileNameExtensionFilter("Active Server Pages", "asp");
    private FileFilter unixScriptFile = new FileNameExtensionFilter("Unix Script File", "sh", "bsh");
    private FileFilter cSourceFile = new FileNameExtensionFilter("C source file", "c");
    private FileFilter cPlusPlusSourceFile = new FileNameExtensionFilter("C++ source file", "h", "hpp", "hxx", "cpp", "cxx", "cc");
    private FileFilter cSharpSourceFile = new FileNameExtensionFilter("C# source file", "cs");
    private FileFilter cascadingStyleSheetFile = new FileNameExtensionFilter("Cascade Style Sheets file", "css");
    private FileFilter dProgrammingLanguage = new FileNameExtensionFilter("D programming language", "d");
    private FileFilter fortranSourceFile = new FileNameExtensionFilter("Fortran source file", "f", "for", "f90", "f95", "f2k");
    private FileFilter haskellSourceFile = new FileNameExtensionFilter("Haskell", "hs", "lhs", "as", "las");
    private FileFilter hyperTextMarkupFile = new FileNameExtensionFilter("Hyper Text Markup file", "html", "htm", "shtml", "shtm", "xhtml", "hta");
    private FileFilter javaSourceFile = new FileNameExtensionFilter("Java source file", "java");
    private FileFilter javaScriptSourceFile = new FileNameExtensionFilter("JavaScript file", "js");
    private FileFilter javaServerPagesScriptFile = new FileNameExtensionFilter("JavaServer Pages", "jsp");
    private FileFilter luaSourceFile = new FileNameExtensionFilter("Lua source file", "lua");
    private FileFilter pascalSourceFile = new FileNameExtensionFilter("Pascal source file", "pas", "inc");
    private FileFilter perlSourceFile = new FileNameExtensionFilter("Perl source file", "pl", "pm", "plx");
    private FileFilter phpSourceFile = new FileNameExtensionFilter("PHP file", "php", "php3", "phtml");
    private FileFilter postScriptFile = new FileNameExtensionFilter("PostScript file", "ps");
    private FileFilter pythonFile = new FileNameExtensionFilter("Python file", "py", "pyw");
    private FileFilter rubyFile = new FileNameExtensionFilter("Ruby file", "rb", "rbw");
    private FileFilter smallTalkFile = new FileNameExtensionFilter("SmallTalk", "st");
    private FileFilter sqlFile = new FileNameExtensionFilter("Structured Query Language", "sql", "htm", "xhtml");
    private FileFilter visualBasicFile = new FileNameExtensionFilter("Visual Basic File", "vb", "vbs");
    private FileFilter extensibleMarkupLanguage = new FileNameExtensionFilter("eXtensible Markup Language file", "xml", "xsml", "xsd", "kml", "wsdl", "xsl", "xliff");


    public void filter(JFileChooser chooser)
    {
        chooser.setAcceptAllFileFilterUsed(false);

        chooser.addChoosableFileFilter(text);
        chooser.addChoosableFileFilter(flashActionScript);
        chooser.addChoosableFileFilter(ada);
        chooser.addChoosableFileFilter(assemblyLanguage);
        chooser.addChoosableFileFilter(activeServerPages);
        chooser.addChoosableFileFilter(unixScriptFile);
        chooser.addChoosableFileFilter(cSourceFile);
        chooser.addChoosableFileFilter(cPlusPlusSourceFile);
        chooser.addChoosableFileFilter(cSharpSourceFile);
        chooser.addChoosableFileFilter(cascadingStyleSheetFile);
        chooser.addChoosableFileFilter(dProgrammingLanguage);
        chooser.addChoosableFileFilter(fortranSourceFile);
        chooser.addChoosableFileFilter(haskellSourceFile);
        chooser.addChoosableFileFilter(hyperTextMarkupFile);
        chooser.addChoosableFileFilter(javaSourceFile);
        chooser.addChoosableFileFilter(javaScriptSourceFile);
        chooser.addChoosableFileFilter(javaServerPagesScriptFile);
        chooser.addChoosableFileFilter(luaSourceFile);
        chooser.addChoosableFileFilter(pascalSourceFile);
        chooser.addChoosableFileFilter(perlSourceFile);
        chooser.addChoosableFileFilter(phpSourceFile);
        chooser.addChoosableFileFilter(postScriptFile);
        chooser.addChoosableFileFilter(pythonFile);
        chooser.addChoosableFileFilter(rubyFile);
        chooser.addChoosableFileFilter(smallTalkFile);
        chooser.addChoosableFileFilter(sqlFile);
        chooser.addChoosableFileFilter(visualBasicFile);
        chooser.addChoosableFileFilter(extensibleMarkupLanguage);
    }

}
