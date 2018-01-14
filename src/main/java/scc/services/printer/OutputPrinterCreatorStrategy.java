package scc.services.printer;

import org.springframework.stereotype.Service;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.OrdersProvider;

@Service
public class OutputPrinterCreatorStrategy implements PrinterCreator {
    private PrinterFactoryProducer factoryProducer;

    public OutputPrinterCreatorStrategy(PrinterFactoryProducer factoryProducer) {
        this.factoryProducer = factoryProducer;
    }

    public OutputPrinter createOutputPrinter(OrdersProvider ordersProvider, PrinterType printerType)
            throws ImproperArgumentException, ImproperStateException {

        PrinterFactories chosenFactory = PrinterFactories.getTypeByOrders(ordersProvider);
        PrinterAbstractFactory printerAbstractFactory = this.factoryProducer.getPrinterFactory(chosenFactory);

        if (chosenFactory == PrinterFactories.ADVANCED) {
            return printerAbstractFactory.getOutputPrinterWithUserInputs(printerType, ordersProvider);

        } else if (chosenFactory == PrinterFactories.DEFAULT) {
            return printerAbstractFactory.getOutputPrinterWithSettledState(printerType);

        } else {
            throw new ImproperArgumentException("Invalid value delivered");
        }
    }
}
