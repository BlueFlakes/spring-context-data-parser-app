package scc.dao;

import scc.models.OrdersInterpreter;

public class CsvReaderCreator implements ReaderSettingsHandler {
    private OrdersInterpreter ordersInterpreter;

    public CsvReaderCreator(OrdersInterpreter ordersInterpreter) {
        this.ordersInterpreter = ordersInterpreter;
    }

    @Override
    public DataLoader getInstanceWithSettledProperties( ) {
        String defaultDelimiter = ",";
        FileReader fileReader = new FileReader();
        String path = this.ordersInterpreter.getPath();
        return new CsvReader(fileReader, path, defaultDelimiter);
    }
}
