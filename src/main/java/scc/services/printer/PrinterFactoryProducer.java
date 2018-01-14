package scc.services.printer;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;

@Component
public class PrinterFactoryProducer {

    public PrinterAbstractFactory getPrinterFactory(PrinterFactories printerFactories) throws ImproperArgumentException {
        switch (printerFactories) {
            case ADVANCED:
                return new AdvancedOutputPrinterFactory();
            case DEFAULT:
                return new DefaultOutputPrinterFactory();

            default:
                throw new ImproperArgumentException("PrinterFactories value shouldn't be null!");
        }
    }
}
