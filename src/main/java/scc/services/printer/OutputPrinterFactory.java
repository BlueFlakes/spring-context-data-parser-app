package scc.services.printer;

import scc.exception.InvalidOutputPrinterException;

public class OutputPrinterFactory {

    public OutputPrinter getOutputPrinter(PrinterType printerType) throws InvalidOutputPrinterException {
        switch (printerType) {
            case PRINT_TO_CONSOLE:
                return new ConsolePrinter();

            default:
                throw new InvalidOutputPrinterException("Expected OutputPrinter does not exist.");
        }
    }
}
