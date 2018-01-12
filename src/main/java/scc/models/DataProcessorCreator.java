package scc.models;

import scc.exception.ImproperArgumentException;
import scc.exception.DataFormatException;
import scc.exception.ImproperStateException;
import scc.services.document.Document;
import scc.services.formatter.OutputFormat;
import scc.services.formatter.OutputFormatter;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinter;
import scc.services.printer.OutputPrinterFactory;
import scc.services.printer.PrinterType;

public class DataProcessorCreator {
    private OutputFormatterFactory formatterFactory;
    private OutputPrinterFactory printerFactory;

    public DataProcessorCreator(OutputFormatterFactory formatterFactory, OutputPrinterFactory printerFactory) {
        this.formatterFactory = formatterFactory;
        this.printerFactory = printerFactory;
    }

    public DataProcessorBuildingBlocks getDefaultDataProcessorBuildingBlocks()
            throws ImproperArgumentException {

        final OutputFormat defaultFormat = OutputFormat.TABLE;
        final PrinterType defaultPrinterType = PrinterType.PRINT_TO_CONSOLE;

        return new DataProcessorBuildingBlocks(defaultFormat, defaultPrinterType);
    }

    public DataProcessor createDataProcessor(ArgsInterpreter argsInterpreter)
            throws ImproperArgumentException,
                   ImproperStateException {

        OutputFormatter formatter = this.formatterFactory.createByFormat(argsInterpreter);
        OutputPrinter printer = this.printerFactory.getOutputPrinter(argsInterpreter);

        return new DataProcessor(formatter, printer);
    }

    public class DataProcessor {
        private final OutputFormatter formatter;
        private final OutputPrinter printer;

        private DataProcessor(OutputFormatter formatter, OutputPrinter printer) {
            this.formatter = formatter;
            this.printer = printer;
        }

        public void process(Document document) throws DataFormatException {
            String formattedData;

            // TODO delegate, too much similar code in one method

            try {
                formattedData = this.formatter.getFormattedData(document);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DataFormatException("Broken data format delivered. Expected valid Csv Format");
            }

            try {
                this.printer.print(formattedData);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("do something here...");
            }
        }
    }
}