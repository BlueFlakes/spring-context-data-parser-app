package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersInterpreter;
import scc.models.OrdersProvider;

@Component
class AdvancedOutputPrinterFactory extends PrinterAbstractFactory {

    @Override
    OutputPrinter getOutputPrinterWithUserInputs(PrinterType printerType,
                                                 OrdersProvider ordersProvider) throws ImproperArgumentException {
        switch (printerType) {
            case PRINT_TO_FILE:
                return new FilePrinter(ordersProvider.getInterpreter());

            default:
                throw new ImproperArgumentException("Probably app state is broken inside OutputPrinterFactory");
        }
    }

    @Override
    OutputPrinter getOutputPrinterWithSettledState(PrinterType printerType) throws ImproperArgumentException {
        return null;
    }
}
