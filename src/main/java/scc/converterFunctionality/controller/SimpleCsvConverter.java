package scc.converterFunctionality.controller;

import scc.converterFunctionality.OutputFormat;
import scc.converterFunctionality.services.OutputFormatter;
import scc.converterFunctionality.services.OutputFormatterFactory;
import scc.dao.FileReader;
import scc.exception.DAOException;

public class SimpleCsvConverter {
    private final FileReader fileReader;
    private final OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(String pathToFile, OutputFormat outputFormat) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);

    }

    public void convert(String pathToFile) throws DAOException {
        OutputFormatter outputFormatter = this.outputFormatterFactory.getDefaultOutputFormatter();
        this.fileReader.readData(pathToFile);
        System.out.println("I convert CSV to Output format(DEFAULT == TABLE FORMAT)");
    }
}
