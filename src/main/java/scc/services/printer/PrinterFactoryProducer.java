package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;

@Component
public class PrinterFactoryProducer {

    public PrinterAbstractFactory getPrinterFactory(PrinterFactories printerFactories) throws ImproperArgumentException {

        if (printerFactories == PrinterFactories.ADVANCED) {
            return new AdvancedOutputPrinterFactory();
        }

        if (printerFactories == PrinterFactories.DEFAULT) {
            return new DefaultOutputPrinterFactory();
        }

        throw new ImproperArgumentException("Invalid argument provided: " + printerFactories);
    }
}
