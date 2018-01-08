package scc.models;

import scc.dao.CsvReader;
import scc.enums.OutputFormat;
import scc.enums.PrinterType;
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
        ConverterCreator.DataProcessor dataProcessor = createDefaultDataProcessor();
        Iterator<String[]> loadedData = this.csvReader.readData(pathToFile);


    }

    private ConverterCreator.DataProcessor createDefaultDataProcessor()
            throws InvalidOutputPrinterException, InvalidOutputFormatterException {

        final OutputFormat defaultFormat = OutputFormat.TABLE;
        final PrinterType defaultPrinterType = PrinterType.PRINT_TO_CONSOLE;

        ConverterCreator.ProcessorBuildingBlocks processorBuildingBlocks =
                new ConverterCreator.ProcessorBuildingBlocks(defaultFormat, defaultPrinterType);

        return this.converterCreator.createDataProcessor(processorBuildingBlocks);
    }
}
