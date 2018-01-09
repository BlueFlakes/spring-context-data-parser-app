package scc.services.starter;

import scc.controller.SimpleConverter;
import scc.dao.DataLoader;
import scc.dao.ReaderCreatorFactory;
import scc.enums.DataLoaderType;
import scc.dao.ReaderSettingsHandler;
import scc.models.ArgsInterpreter;
import scc.models.DataProcessorCreator;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinterFactory;

public class OneArgStarter implements ConverterStarter {
    private ArgsInterpreter argsInterpreter;
    private ReaderCreatorFactory readerCreatorFactory;

    public OneArgStarter(ArgsInterpreter argsInterpreter, ReaderCreatorFactory readerCreatorFactory) {
        this.argsInterpreter = argsInterpreter;
        this.readerCreatorFactory = readerCreatorFactory;
    }

    @Override
    public void start( ) throws Exception {
        ReaderSettingsHandler readerSettingsHandler =
                this.readerCreatorFactory.getReaderCreatorByDataSource(DataLoaderType.CSV_READER, this.argsInterpreter);
        DataLoader dataLoader = readerSettingsHandler.getInstanceWithSettledProperties();

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleConverter simpleConverter = new SimpleConverter(dataLoader, dataProcessorCreator);
        simpleConverter.convert();
    }
}