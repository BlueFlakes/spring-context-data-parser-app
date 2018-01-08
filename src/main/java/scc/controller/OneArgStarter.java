package scc.controller;

import scc.dao.CsvReader;
import scc.dao.FileReader;
import scc.models.DataProcessorCreator;
import scc.models.SimpleCsvConverter;
import scc.services.converterServices.formatter.OutputFormatterFactory;
import scc.services.converterServices.printer.OutputPrinterFactory;

public class OneArgStarter implements ConverterStarter {
    private String pathToFile;

    public OneArgStarter(String[] args) {
        this.pathToFile = args[0];
    }

    @Override
    public void start( ) throws Exception {
        FileReader fileReader = new FileReader();
        String defaultDelimiter = ",";
        CsvReader csvReader = new CsvReader(fileReader, defaultDelimiter);

        OutputFormatterFactory formatterFactory = new OutputFormatterFactory();
        OutputPrinterFactory printerFactory = new OutputPrinterFactory();
        DataProcessorCreator dataProcessorCreator = new DataProcessorCreator(formatterFactory, printerFactory);

        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(csvReader, dataProcessorCreator);

        simpleCsvConverter.convert(this.pathToFile);
    }
}