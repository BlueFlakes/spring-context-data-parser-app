package scc.models;

import lombok.Getter;
import scc.enums.OutputFormat;
import scc.enums.PrinterType;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;
import scc.services.converterServices.formatter.OutputFormatter;
import scc.services.converterServices.formatter.OutputFormatterFactory;
import scc.services.converterServices.printer.OutputPrinter;
import scc.services.converterServices.printer.OutputPrinterFactory;

public class DataProcessorCreator {
    private OutputFormatterFactory formatterFactory;
    private OutputPrinterFactory printerFactory;

    public DataProcessorCreator(OutputFormatterFactory formatterFactory, OutputPrinterFactory printerFactory) {
        this.formatterFactory = formatterFactory;
        this.printerFactory = printerFactory;
    }

    @Getter
    public static class ProcessorBuildingBlocks {
        private final OutputFormat outputFormat;
        private final PrinterType printerType;

        public ProcessorBuildingBlocks(OutputFormat outputFormat, PrinterType printerType) {
            this.outputFormat = outputFormat;
            this.printerType = printerType;
        }
    }

    public class DataProcessor {
        private final OutputFormatter formatter;
        private final OutputPrinter printer;

        private DataProcessor(OutputFormatter formatter, OutputPrinter printer) {
            this.formatter = formatter;
            this.printer = printer;
        }

        public void process() {
            System.out.println("Processing data....");
        }
    }

    public DataProcessor createDefaultDataProcessor()
            throws InvalidOutputPrinterException, InvalidOutputFormatterException {

        final OutputFormat defaultFormat = OutputFormat.TABLE;
        final PrinterType defaultPrinterType = PrinterType.PRINT_TO_CONSOLE;

        DataProcessorCreator.ProcessorBuildingBlocks processorBuildingBlocks =
                new DataProcessorCreator.ProcessorBuildingBlocks(defaultFormat, defaultPrinterType);

        return createDataProcessor(processorBuildingBlocks);
    }

    public DataProcessor createDataProcessor(ProcessorBuildingBlocks buildingBlocks)
            throws InvalidOutputPrinterException, InvalidOutputFormatterException {
        OutputFormat outputFormat = buildingBlocks.getOutputFormat();
        OutputFormatter formatter = this.formatterFactory.createByFormat(outputFormat);

        PrinterType printerType = buildingBlocks.getPrinterType();
        OutputPrinter printer = this.printerFactory.getOutputPrinter(printerType);

        return new DataProcessor(formatter, printer);
    }
}