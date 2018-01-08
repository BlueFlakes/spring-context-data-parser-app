package scc.models;

import scc.dao.CsvReader;
import scc.exception.DAOException;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;

import java.util.Iterator;

public class SimpleCsvConverter {
    private final CsvReader csvReader;
    private final DataProcessorCreator dataProcessorCreator;

    public SimpleCsvConverter(CsvReader csvReader, DataProcessorCreator dataProcessorCreator) {
        this.csvReader = csvReader;
        this.dataProcessorCreator = dataProcessorCreator;
    }

    public void convert(String pathToFile, DataProcessorCreator.ProcessorBuildingBlocks processorBuildingBlocks)
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        DataProcessorCreator.DataProcessor dataProcessor = this.dataProcessorCreator.createDataProcessor(processorBuildingBlocks);
        Iterator<String[]> loadedData = this.csvReader.readData(pathToFile);
    }

    public void convert(String pathToFile) throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {
        DataProcessorCreator.DataProcessor dataProcessor = this.dataProcessorCreator.createDefaultDataProcessor();
        Iterator<String[]> loadedData = this.csvReader.readData(pathToFile);
    }
}
