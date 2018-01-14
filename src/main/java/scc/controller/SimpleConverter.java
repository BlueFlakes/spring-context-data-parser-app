package scc.controller;

import org.springframework.stereotype.Controller;
import scc.services.DataProcessorCreator;
import scc.models.OrdersProvider;
import scc.services.daoInputHandlers.DaoHandler;
import scc.services.document.Document;

@Controller
public class SimpleConverter {
    private final DaoHandler daoHandler;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DaoHandler daoHandler, DataProcessorCreator dataProcessorCreator) {
        this.daoHandler = daoHandler;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(OrdersProvider ordersProvider) throws Exception {
        DataProcessor dataProcessor = this.dataProcessorCreator.createDataProcessor(ordersProvider);
        Document document = this.daoHandler.prepareData(ordersProvider);
        dataProcessor.process(document);
    }
}
