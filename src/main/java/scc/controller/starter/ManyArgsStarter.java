package scc.controller.starter;

import scc.controller.SimpleConverter;
import scc.dao.ReaderCreatorFactory;
import scc.services.formatter.OutputFormat;
import scc.services.printer.PrinterType;
import scc.models.ArgsInterpreter;
import scc.models.CsvArgsInterpreter;
import scc.models.DataProcessorBuildingBlocks;
import scc.models.DataProcessorCreator;
import scc.services.daoInputHandlers.DaoInputHandler;
import scc.services.daoInputHandlers.DefaultPipelineSourceReader;
import scc.services.document.DocumentCreatorFactory;
import scc.services.formatter.OutputFormatterFactory;
import scc.services.printer.OutputPrinterFactory;

public class ManyArgsStarter implements ConverterStarter {
    private ArgsInterpreter argsInterpreter;

    public ManyArgsStarter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    @Override
    public void start( ) throws Exception {
        DocumentCreatorFactory documentCreatorFactory = new DocumentCreatorFactory();
        ReaderCreatorFactory readerCreatorFactory = new ReaderCreatorFactory();
        DaoInputHandler daoInputHandler = new DefaultPipelineSourceReader(readerCreatorFactory, documentCreatorFactory);

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleConverter simpleConverter = new SimpleConverter(daoInputHandler, dataProcessorCreator);
        CsvArgsInterpreter csvArgsInterpreter = new CsvArgsInterpreter(this.argsInterpreter);
        OutputFormat outputFormat = csvArgsInterpreter.getOutputFormat();
        simpleConverter.convert(argsInterpreter, new DataProcessorBuildingBlocks(outputFormat, PrinterType.PRINT_TO_FILE));
    }
}
