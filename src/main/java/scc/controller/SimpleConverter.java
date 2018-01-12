package scc.controller;

import scc.exception.*;
import scc.services.daoInputHandlers.DaoInputHandler;
import scc.models.OrdersInterpreter;
import scc.models.DataProcessorCreator;
import scc.services.document.Document;

public class SimpleConverter {
    private final DaoInputHandler daoInputHandler;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DaoInputHandler daoInputHandler, DataProcessorCreator dataProcessorCreator) {
        this.daoInputHandler = daoInputHandler;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(OrdersInterpreter ordersInterpreter)
            throws DAOException, ImproperArgumentException, DataFormatException, ImproperStateException {

        DataProcessorCreator.DataProcessor dataProcessor =
                this.dataProcessorCreator.createDataProcessor(ordersInterpreter);

        Document document = this.daoInputHandler.prepareData(ordersInterpreter);
        dataProcessor.process(document);
    }
}
