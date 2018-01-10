package scc.controller;

import scc.exception.DAOException;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;
import scc.services.daoInputHandlers.DaoInputHandler;
import scc.models.ArgsInterpreter;
import scc.models.DataProcessorCreator;
import scc.models.DataProcessorBuildingBlocks;
import scc.services.document.Document;

public class SimpleConverter {
    private final DaoInputHandler daoInputHandler;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DaoInputHandler daoInputHandler, DataProcessorCreator dataProcessorCreator) {
        this.daoInputHandler = daoInputHandler;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(ArgsInterpreter argsInterpreter, DataProcessorBuildingBlocks processorBuildingBlocks)
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        DataProcessorCreator.DataProcessor dataProcessor =
                this.dataProcessorCreator.createDataProcessor(processorBuildingBlocks);
        handleConversion(argsInterpreter, dataProcessor);
    }

    public void convert(ArgsInterpreter argsInterpreter)
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        DataProcessorCreator.DataProcessor dataProcessor = this.dataProcessorCreator.createDefaultDataProcessor();
        handleConversion(argsInterpreter, dataProcessor);
    }

    private void handleConversion(ArgsInterpreter argsInterpreter, DataProcessorCreator.DataProcessor dataProcessor) throws DAOException {
        Document document = this.daoInputHandler.prepareData(argsInterpreter);
        dataProcessor.process(document);
    }
}
