package scc.dao;

import scc.exception.ImproperArgumentException;
import scc.models.OrdersInterpreter;
import scc.models.BasicArgsInterpreter;

public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, OrdersInterpreter ordersInterpreter)
            throws ImproperArgumentException {

        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(new BasicArgsInterpreter(ordersInterpreter));

            default:
                throw new ImproperArgumentException("Delivered value does not match any \"ReaderSettingsCreator\"");
        }
    }
}
