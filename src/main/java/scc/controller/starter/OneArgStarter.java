package scc.controller.starter;

import scc.controller.SimpleConverter;
import scc.dao.ReaderCreatorFactory;
import scc.services.daoInputHandlers.DaoInputHandler;
import scc.models.ArgsInterpreter;
import scc.models.DataProcessorCreator;
import scc.services.daoInputHandlers.OneInputHandler;
import scc.services.document.DocumentCreatorFactory;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinterFactory;

public class OneArgStarter implements ConverterStarter {
    private ArgsInterpreter argsInterpreter;

    public OneArgStarter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    @Override
    public void start( ) throws Exception {

        DocumentCreatorFactory documentCreatorFactory = new DocumentCreatorFactory();
        ReaderCreatorFactory readerCreatorFactory = new ReaderCreatorFactory();
        DaoInputHandler inputHandler = new OneInputHandler(readerCreatorFactory, documentCreatorFactory);

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleConverter simpleConverter = new SimpleConverter(inputHandler, dataProcessorCreator);
        simpleConverter.convert(argsInterpreter);
    }
}