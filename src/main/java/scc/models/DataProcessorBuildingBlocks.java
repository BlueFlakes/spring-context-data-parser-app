package scc.models;

import scc.services.formatter.OutputFormat;
import scc.services.printer.PrinterType;

public class DataProcessorBuildingBlocks {
    private OutputFormat outputFormat;
    private PrinterType printerType;

    public DataProcessorBuildingBlocks(OutputFormat outputFormat, PrinterType printerType) {
        this.outputFormat = outputFormat;
        this.printerType = printerType;
    }

    public OutputFormat getOutputFormat( ) {
        return outputFormat;
    }

    public PrinterType getPrinterType( ) {
        return printerType;
    }
}
