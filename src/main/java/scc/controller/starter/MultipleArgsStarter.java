package scc.controller.starter;

import scc.controller.SimpleConverter;
import scc.dao.ReaderCreatorFactory;
import scc.models.OrdersProvider;
import scc.models.DataProcessorCreator;
import scc.services.daoInputHandlers.DaoHandler;
import scc.services.daoInputHandlers.DefaultPipelineReader;
import scc.services.document.DocumentCreatorFactory;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinterFactory;

public class MultipleArgsStarter implements ConverterStarter {
    private OrdersProvider ordersProvider;

    public MultipleArgsStarter(OrdersProvider ordersProvider) {
        this.ordersProvider = ordersProvider;
    }

    @Override
    public void start( ) throws Exception {
        DocumentCreatorFactory documentCreatorFactory = new DocumentCreatorFactory();
        ReaderCreatorFactory readerCreatorFactory = new ReaderCreatorFactory();
        DaoHandler daoHandler = new DefaultPipelineReader(readerCreatorFactory, documentCreatorFactory);

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleConverter simpleConverter = new SimpleConverter(daoHandler, dataProcessorCreator);
        simpleConverter.convert(this.ordersProvider);
    }
}
