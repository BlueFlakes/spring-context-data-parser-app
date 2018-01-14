package scc.controller;

import org.springframework.stereotype.Component;
import scc.exception.DAOException;
import scc.exception.DataFormatException;
import scc.exception.ImproperArgumentException;
import scc.exception.ImproperStateException;
import scc.models.DataProcessorCreator;
import scc.models.OrdersProvider;
import scc.services.daoInputHandlers.DaoHandler;
import scc.services.document.Document;

@Component
public class SimpleConverter {
    private final DaoHandler daoHandler;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DaoHandler daoHandler, DataProcessorCreator dataProcessorCreator) {
        this.daoHandler = daoHandler;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(OrdersProvider ordersProvider)
            throws DAOException, ImproperArgumentException, DataFormatException, ImproperStateException {

        DataProcessorCreator.DataProcessor dataProcessor =
                this.dataProcessorCreator.createDataProcessor(ordersProvider);

        Document document = this.daoHandler.prepareData(ordersProvider);
        dataProcessor.process(document);
    }
}
