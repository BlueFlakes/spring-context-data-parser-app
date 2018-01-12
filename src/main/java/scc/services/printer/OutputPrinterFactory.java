package scc.services.printer;

import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.ArgsInterpreter;

public class OutputPrinterFactory {
    private static final Class<PrinterType> printerTypeClass = PrinterType.class;

    public OutputPrinter getOutputPrinter(ArgsInterpreter argsInterpreter)
            throws ImproperArgumentException, ImproperStateException {

        boolean wasUsedAdvancedOption = argsInterpreter.getSearcher(printerTypeClass).isEnumWithGivenOptionAvailable();

        if (wasUsedAdvancedOption) {
            return getChosenOutputPrinter(argsInterpreter);
        }

        return new ConsolePrinter();
    }

    private OutputPrinter getChosenOutputPrinter(ArgsInterpreter argsInterpreter) throws ImproperStateException {
        PrinterType printerType = argsInterpreter.getSearcher(printerTypeClass).findEnumByFlag();

        switch (printerType) {
            case PRINT_TO_FILE:
                return new FilePrinter(argsInterpreter);

            default:
                throw new ImproperStateException("Probably app state is broken inside OutputPrinterFactory");
        }
    }
}
