package scc.models;

import scc.dao.CsvReader;
import scc.exception.DAOException;
import scc.exception.InvalidOutputFormatterException;
import scc.exception.InvalidOutputPrinterException;

import java.util.Iterator;

public class SimpleCsvConverter {
    private final CsvReader csvReader;
    private final ConverterCreator converterCreator;

    public SimpleCsvConverter(CsvReader csvReader, ConverterCreator converterCreator) {
        this.csvReader = csvReader;
        this.converterCreator = converterCreator;
    }

    public void convert(String pathToFile, ConverterCreator.ProcessorBuildingBlocks processorBuildingBlocks)
            throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {

        ConverterCreator.DataProcessor dataProcessor = this.converterCreator.createDataProcessor(processorBuildingBlocks);
        Iterator<String[]> loadedData = this.csvReader.readData(pathToFile);

    }

    public void convert(String pathToFile) throws DAOException, InvalidOutputFormatterException, InvalidOutputPrinterException {
        ConverterCreator.DataProcessor dataProcessor = this.converterCreator.createDefaultDataProcessor();
        Iterator<String[]> loadedData = this.csvReader.readData(pathToFile);
    }
}
