package scc.models;

import scc.enums.OutputFormat;
import scc.enums.PrinterType;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;
import scc.services.document.Document;
import scc.services.formatter.OutputFormatter;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinter;
import scc.services.printer.OutputPrinterFactory;

import java.util.List;

public class DataProcessorCreator {
    private OutputFormatterFactory formatterFactory;
    private OutputPrinterFactory printerFactory;

    public DataProcessorCreator(OutputFormatterFactory formatterFactory, OutputPrinterFactory printerFactory) {
        this.formatterFactory = formatterFactory;
        this.printerFactory = printerFactory;
    }

    public DataProcessor createDefaultDataProcessor()
            throws InvalidOutputPrinterException, InvalidOutputFormatterException {

        final OutputFormat defaultFormat = OutputFormat.TABLE;
        final PrinterType defaultPrinterType = PrinterType.PRINT_TO_CONSOLE;

        ProcessorBuildingBlocks processorBuildingBlocks =
                new ProcessorBuildingBlocks(defaultFormat, defaultPrinterType);

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

    public class DataProcessor {
        private final OutputFormatter formatter;
        private final OutputPrinter printer;

        private DataProcessor(OutputFormatter formatter, OutputPrinter printer) {
            this.formatter = formatter;
            this.printer = printer;
        }

        public void process(Document document) {
            String formattedData = this.formatter.getFormattedData(document);
            this.printer.print(formattedData);
        }
    }
}