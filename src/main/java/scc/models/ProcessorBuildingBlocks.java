package scc.models;

import lombok.Getter;
import scc.enums.OutputFormat;
import scc.enums.PrinterType;

@Getter
public class ProcessorBuildingBlocks {
    private final OutputFormat outputFormat;
    private final PrinterType printerType;

    public ProcessorBuildingBlocks(OutputFormat outputFormat, PrinterType printerType) {
        this.outputFormat = outputFormat;
        this.printerType = printerType;
    }
}
