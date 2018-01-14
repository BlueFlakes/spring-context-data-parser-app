package scc.dao;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.models.OrdersInterpreter;

@Component
public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType,
                                                              OrdersProvider ordersProvider)
            throws ImproperArgumentException {

        if (loaderType == DataLoaderType.CSV_READER) {
            return new CsvReaderCreator(ordersProvider.getInterpreter());
        }

        throw new ImproperArgumentException("Incorrect value delivered: " + loaderType);
    }
}
