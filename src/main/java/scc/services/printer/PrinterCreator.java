package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersProvider;

@Component
public interface PrinterCreator {
    OutputPrinter createOutputPrinter(OrdersProvider ordersProvider, PrinterType printerType)
            throws ImproperArgumentException, ImproperStateException;
}
