package scc.models;


import scc.enums.OutputFormat;
import scc.enums.PrinterType;


public class DataProcessorBuildingBlocks {
    private final OutputFormat outputFormat;
    private final PrinterType printerType;

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
