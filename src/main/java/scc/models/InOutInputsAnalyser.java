package scc.models;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.services.formatter.OutputFormat;
import scc.services.printer.PrinterType;
@Component
public class InOutInputsAnalyser {
    private static final Class<PrinterType> classOfPrinterTypes = PrinterType.class;
    private static final PrinterType defaultPrinterType = PrinterType.PRINT_TO_CONSOLE;
    private static final String defaultOutputFormatName = "TABLE";
    private OrdersProvider ordersProvider;


    public DataProcessorBuildingBlocks getDataProcessorBuildingBlocks(OrdersProvider ordersProvider)
            throws ImproperArgumentException {
        this.ordersProvider = ordersProvider;

        return new DataProcessorBuildingBlocks(getOutputFormat(), getPrinterType());
    }

    private OutputFormat getOutputFormat() throws ImproperArgumentException {
        OrdersInterpreter ordersInterpreter = ordersProvider.getInterpreter();

        String outputFormatName = ordersInterpreter.getGivenOutputFormatName()
                                                   .map(String::toUpperCase)
                                                   .orElse(defaultOutputFormatName);

        return OutputFormat.getByName(outputFormatName);
    }

    private PrinterType getPrinterType() {
        boolean wasUsedAdvancedOption = ordersProvider.getSearcher(classOfPrinterTypes).isEnumWithGivenOptionAvailable();

        if (wasUsedAdvancedOption) {
            return ordersProvider.getSearcher(classOfPrinterTypes).findEnumByFlag();
        } else {
            return defaultPrinterType;
        }
    }
}
