package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersProvider;

@Component
public abstract class PrinterAbstractFactory {
    abstract OutputPrinter getOutputPrinterWithSettledState(PrinterType printerType)
            throws ImproperArgumentException;

    abstract OutputPrinter getOutputPrinterWithUserInputs(PrinterType printerType,
                                                          OrdersProvider ordersProvider)
            throws ImproperArgumentException;
}
