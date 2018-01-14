package scc.dao;

import scc.exception.InvalidArgumentCombinationException;
import scc.models.OrdersInterpreter;

public class CsvReaderCreator implements ReaderSettingsHandler {
    private static final String defaultDelimiter = ",";
    private OrdersInterpreter ordersInterpreter;

    public CsvReaderCreator(OrdersInterpreter ordersInterpreter) {
        this.ordersInterpreter = ordersInterpreter;
    }

    @Override
    public DataLoader getInstanceWithSettledProperties( ) {
        String defaultDelimiter = getDelimiter();
        FileReader fileReader = new FileReader();
        String path = this.ordersInterpreter.getPath();
        return new CsvReader(fileReader, path, defaultDelimiter);
    }

    private String lookForDelimiterInsideAdditionalSettings() throws InvalidArgumentCombinationException {
        final String keyPrefix = "d=";
        return this.ordersInterpreter.getPrefixValueFromAdditionalInputs(keyPrefix);
    }

    private String getDelimiter() {
        try {
            return lookForDelimiterInsideAdditionalSettings();
        } catch (InvalidArgumentCombinationException e) {
            return defaultDelimiter;
        }
    }
}
