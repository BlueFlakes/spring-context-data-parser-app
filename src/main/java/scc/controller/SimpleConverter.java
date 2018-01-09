package scc.controller;

import scc.exception.DAOException;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;
import scc.models.DataProcessorCreator;
import scc.models.ProcessorBuildingBlocks;
import scc.services.document.Document;

import java.util.List;

public class SimpleConverter {
    private final Document document;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleConverter(Document document, DataProcessorCreator dataProcessorCreator) {
        this.document = document;
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
        dataProcessor.process(this.document);
    }
}
