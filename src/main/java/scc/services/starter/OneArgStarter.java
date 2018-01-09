package scc.services.starter;

import scc.controller.SimpleConverter;
import scc.dao.DataLoader;
import scc.dao.ReaderCreatorFactory;
import scc.enums.DataLoaderType;
import scc.dao.ReaderSettingsHandler;
import scc.enums.OutputFormat;
import scc.enums.PrinterType;
import scc.models.ArgsInterpreter;
import scc.models.DataProcessorCreator;
import scc.models.ProcessorBuildingBlocks;
import scc.services.document.Document;
import scc.services.document.DocumentCreator;
import scc.services.document.DocumentCreatorFactory;
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

        DocumentCreatorFactory documentCreatorFactory = new DocumentCreatorFactory();
        DocumentCreator documentCreator =
                documentCreatorFactory.getDocumentCreatorBySettings(this.argsInterpreter, dataLoader);
        Document document = documentCreator.createDocument();

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleConverter simpleConverter = new SimpleConverter(document, dataProcessorCreator);
        simpleConverter.convert();
    }
}