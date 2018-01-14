package scc.services;

import org.springframework.stereotype.Component;
import scc.controller.DataProcessor;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.DataProcessorBuildingBlocks;
import scc.models.OrdersProvider;
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

}