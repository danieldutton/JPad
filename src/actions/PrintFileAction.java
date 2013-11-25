package actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintFileAction extends AbstractAction {
    private static final ImageIcon printFileIcon = new ImageIcon("images/printFile.png");

    public PrintFileAction() {
        super("Print", printFileIcon);
    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printJob.pageDialog(printJob.defaultPage());

        if (printJob.printDialog()) try {
            printJob.print();
        } catch (PrinterException exc) {
            System.out.println(exc);
        }
    }
}
