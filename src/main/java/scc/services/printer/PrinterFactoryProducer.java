package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;

@Component
public class PrinterFactoryProducer {

    public PrinterAbstractFactory getPrinterFactory(PrinterFactories printerFactories) throws ImproperStateException {

        if (printerFactories == PrinterFactories.ADVANCED) {
            return new AdvancedOutputPrinterFactory();
        }

        if (printerFactories == PrinterFactories.DEFAULT) {
            return new DefaultOutputPrinterFactory();
        }

        throw new ImproperStateException("WARNING: This case should never appear.");
    }
}
