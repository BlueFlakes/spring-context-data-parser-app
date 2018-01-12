package scc.dao;

import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.models.BasicArgsInterpreter;

public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, OrdersProvider ordersProvider)
            throws ImproperArgumentException {

        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(new BasicArgsInterpreter(ordersProvider));

            default:
                throw new ImproperArgumentException("Delivered value does not match any \"ReaderSettingsCreator\"");
        }
    }
}
