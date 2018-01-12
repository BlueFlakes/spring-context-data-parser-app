package scc.services.printer;

import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersProvider;

public class OutputPrinterFactory {
    private static final Class<PrinterType> printerTypeClass = PrinterType.class;

    public OutputPrinter getOutputPrinter(OrdersProvider ordersProvider)
            throws ImproperArgumentException, ImproperStateException {

        boolean wasUsedAdvancedOption = ordersProvider.getSearcher(printerTypeClass).isEnumWithGivenOptionAvailable();

        if (wasUsedAdvancedOption) {
            return getChosenOutputPrinter(ordersProvider);
        }

        return new ConsolePrinter();
    }

    private OutputPrinter getChosenOutputPrinter(OrdersProvider ordersProvider) throws ImproperStateException {
        PrinterType printerType = ordersProvider.getSearcher(printerTypeClass).findEnumByFlag();

        switch (printerType) {
            case PRINT_TO_FILE:
                return new FilePrinter(ordersProvider);

            default:
                throw new ImproperStateException("Probably app state is broken inside OutputPrinterFactory");
        }
    }
}
