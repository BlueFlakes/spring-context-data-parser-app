package scc.controller;

import scc.dao.DataLoader;
import scc.exception.DAOException;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;
import scc.models.DataProcessorCreator;
import scc.models.ProcessorBuildingBlocks;

import java.util.List;

public class SimpleConverter {
    private final DataLoader dataLoader;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(DataLoader dataLoader, DataProcessorCreator dataProcessorCreator) {
        this.dataLoader = dataLoader;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(ProcessorBuildingBlocks processorBuildingBlocks)
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        DataProcessorCreator.DataProcessor dataProcessor =
                this.dataProcessorCreator.createDataProcessor(processorBuildingBlocks);
        handleConversion(dataProcessor);
    }

    public void convert()
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        DataProcessorCreator.DataProcessor dataProcessor = this.dataProcessorCreator.createDefaultDataProcessor();
        handleConversion(dataProcessor);
    }

    private void handleConversion(DataProcessorCreator.DataProcessor dataProcessor) throws DAOException {
        List<String[]> loadedData = this.dataLoader.getResourceContent();
        dataProcessor.process(loadedData);
    }
}
