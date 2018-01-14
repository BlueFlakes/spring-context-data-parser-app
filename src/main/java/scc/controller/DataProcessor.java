package scc.controller;

import scc.exception.DataFormatException;
import scc.exception.PrinterFailureException;
import scc.services.document.Document;
import scc.services.formatter.OutputFormatter;
import scc.services.printer.OutputPrinter;

public class DataProcessor {
    private final OutputFormatter formatter;
    private final OutputPrinter printer;

    public DataProcessor(OutputFormatter formatter, OutputPrinter printer) {
        this.formatter = formatter;
        this.printer = printer;
    }

    public void process(Document document) throws DataFormatException, PrinterFailureException {
        String formattedData = getFormatterResult(document);
        runPrinter(formattedData);
    }

    private String getFormatterResult(Document document) throws DataFormatException {
        try {
            return this.formatter.getFormattedData(document);
        } catch (Exception e) {
            throw new DataFormatException("Broken data format delivered. Expected valid Csv Format");
        }
    }

    private void runPrinter(String formattedData) throws PrinterFailureException {
        try {
            this.printer.print(formattedData);
        } catch (Exception e) {
            throw new PrinterFailureException("Printer failed.");
        }
    }
}
