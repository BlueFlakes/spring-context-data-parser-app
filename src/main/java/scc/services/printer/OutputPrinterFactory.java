package scc.services.printer;

import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersInterpreter;

public class OutputPrinterFactory {
    private static final Class<PrinterType> printerTypeClass = PrinterType.class;

    public OutputPrinter getOutputPrinter(OrdersInterpreter ordersInterpreter)
            throws ImproperArgumentException, ImproperStateException {

        boolean wasUsedAdvancedOption = ordersInterpreter.getSearcher(printerTypeClass).isEnumWithGivenOptionAvailable();

        if (wasUsedAdvancedOption) {
            return getChosenOutputPrinter(ordersInterpreter);
        }

        return new ConsolePrinter();
    }

    private OutputPrinter getChosenOutputPrinter(OrdersInterpreter ordersInterpreter) throws ImproperStateException {
        PrinterType printerType = ordersInterpreter.getSearcher(printerTypeClass).findEnumByFlag();

        switch (printerType) {
            case PRINT_TO_FILE:
                return new FilePrinter(ordersInterpreter);

            default:
                throw new ImproperStateException("Probably app state is broken inside OutputPrinterFactory");
        }
    }
}
