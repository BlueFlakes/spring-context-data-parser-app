package scc.controller;

import scc.enums.OutputFormat;
import scc.exception.InvalidOutputFormatterException;
import scc.services.converterServices.formatter.OutputFormatter;
import scc.dao.FileReader;
import scc.exception.DAOException;
import scc.services.converterServices.formatter.OutputFormatterFactory;
import scc.services.converterServices.printer.OutputPrinterFactory;

import java.util.Iterator;

public class SimpleCsvConverter {
    private final FileReader fileReader;
    private final OutputFormatterFactory outputFormatterFactory;
    private final OutputPrinterFactory outputPrinterFactory;

    public SimpleCsvConverter(FileReader fileReader,
                              OutputFormatterFactory outputFormatterFactory,
                              OutputPrinterFactory outputPrinterFactory) {

        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
        this.outputPrinterFactory = outputPrinterFactory;
    }

    public void convert(String pathToFile, OutputFormat outputFormat) throws InvalidOutputFormatterException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);

    }

    public void convert(String pathToFile) throws DAOException, InvalidOutputFormatterException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.getDefaultOutputFormatter();
        Iterator<String> loadedData = this.fileReader.readData(pathToFile);

//        outputFormatter.getFormattedData()
    }
}
