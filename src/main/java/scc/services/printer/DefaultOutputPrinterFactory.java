package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersProvider;

@Component
class DefaultOutputPrinterFactory extends PrinterAbstractFactory {

    @Override
    OutputPrinter getOutputPrinterWithSettledState(PrinterType printerType) throws ImproperArgumentException {

        if (printerType == PrinterType.PRINT_TO_CONSOLE) {
            return new ConsolePrinter();
        }

        throw new ImproperArgumentException("Incorrect argument, given OutputPrinter does not exist.");
    }

    @Override
    OutputPrinter getOutputPrinterWithUserInputs(PrinterType printerType,
                                                 OrdersProvider ordersProvider) throws ImproperArgumentException {
        return null;
    }
}
