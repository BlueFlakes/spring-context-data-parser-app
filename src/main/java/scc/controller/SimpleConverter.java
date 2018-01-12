package scc.controller;

import scc.exception.*;
import scc.services.daoInputHandlers.DaoHandler;
import scc.models.OrdersProvider;
import scc.models.DataProcessorCreator;
import scc.services.document.Document;

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
