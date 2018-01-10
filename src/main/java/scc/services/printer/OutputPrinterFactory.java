package scc.services.printer;

import scc.exception.CustomInvalidArgumentException;

public class OutputPrinterFactory {

    public OutputPrinter getOutputPrinter(PrinterType printerType) throws CustomInvalidArgumentException {
        switch (printerType) {
            case PRINT_TO_CONSOLE:
                return new ConsolePrinter();

            default:
                throw new CustomInvalidArgumentException("Expected OutputPrinter does not exist.");
        }
    }
}
