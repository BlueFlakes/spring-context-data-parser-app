package scc.controller;

import scc.exception.*;
import scc.services.daoInputHandlers.DaoInputHandler;
import scc.models.OrdersProvider;
import scc.models.DataProcessorCreator;
import scc.services.document.Document;

public class SimpleConverter {
    private final DaoInputHandler daoInputHandler;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DaoInputHandler daoInputHandler, DataProcessorCreator dataProcessorCreator) {
        this.daoInputHandler = daoInputHandler;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(OrdersProvider ordersProvider)
            throws DAOException, ImproperArgumentException, DataFormatException, ImproperStateException {

        DataProcessorCreator.DataProcessor dataProcessor =
                this.dataProcessorCreator.createDataProcessor(ordersProvider);

        Document document = this.daoInputHandler.prepareData(ordersProvider);
        dataProcessor.process(document);
    }
}
