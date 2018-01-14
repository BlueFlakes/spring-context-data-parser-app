package scc.models;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.DataFormatException;
import scc.exception.ImproperStateException;
import scc.exception.PrinterFailureException;
import scc.services.document.Document;
import scc.services.formatter.OutputFormatter;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.*;

@Component
public class DataProcessorCreator {
    private OutputFormatterFactory formatterFactory;
    private PrinterCreator printerCreator;
    private InOutInputsAnalyser inOutInputsAnalyser;

    public DataProcessorCreator(OutputFormatterFactory formatterFactory,
                                PrinterCreator printerCreator,
                                InOutInputsAnalyser inOutInputsAnalyser) {

        this.formatterFactory = formatterFactory;
        this.printerCreator = printerCreator;
        this.inOutInputsAnalyser = inOutInputsAnalyser;
    }

    public DataProcessor createDataProcessor(OrdersProvider ordersProvider)
            throws ImproperArgumentException, ImproperStateException {

        DataProcessorBuildingBlocks buildingBlocks =
                this.inOutInputsAnalyser.getDataProcessorBuildingBlocks(ordersProvider);

        OutputFormatter formatter = this.formatterFactory.createByFormat(buildingBlocks.getOutputFormat());
        OutputPrinter printer = this.printerCreator.createOutputPrinter(ordersProvider, buildingBlocks.getPrinterType());

        return new DataProcessor(formatter, printer);
    }

    public class DataProcessor {
        private final OutputFormatter formatter;
        private final OutputPrinter printer;

        private DataProcessor(OutputFormatter formatter, OutputPrinter printer) {
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
}