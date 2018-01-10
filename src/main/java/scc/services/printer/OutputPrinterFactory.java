package scc.services.printer;

import scc.exception.ImproperArgumentException;

public class OutputPrinterFactory {

    public OutputPrinter getOutputPrinter(PrinterType printerType) throws ImproperArgumentException {
        switch (printerType) {
            case PRINT_TO_CONSOLE:
                return new ConsolePrinter();

            default:
                throw new ImproperArgumentException("Expected OutputPrinter does not exist.");
        }
    }
}
