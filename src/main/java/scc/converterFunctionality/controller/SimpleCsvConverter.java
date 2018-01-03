package scc.converterFunctionality.controller;

import scc.converterFunctionality.OutputFormat;
import scc.converterFunctionality.services.OutputFormatter;
import scc.converterFunctionality.services.OutputFormatterFactory;
import scc.utils.dao.FileReader;

public class SimpleCsvConverter {
    private final FileReader fileReader;
    private final OutputFormatterFactory outputFormatterFactory;

    public SimpleCsvConverter(FileReader fileReader, OutputFormatterFactory outputFormatterFactory) {
        this.fileReader = fileReader;
        this.outputFormatterFactory = outputFormatterFactory;
    }

    public void convert(String pathToFile, OutputFormat outputFormat) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(outputFormat);
        System.out.println(" i convert csv to specified output format");
    }

    public void convert(String pathToFile) {
        OutputFormatter outputFormatter = this.outputFormatterFactory.createByFormat(OutputFormat.TABLE);
        System.out.println("I convert CSV to Output format(DEFAULT == TABLE FORMAT)");
    }
}
