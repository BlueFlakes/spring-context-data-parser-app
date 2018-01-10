package scc.dao;

import scc.models.CsvArgsInterpreter;

public class CsvReaderCreator implements ReaderSettingsHandler {
    private CsvArgsInterpreter csvArgsInterpreter;

    public CsvReaderCreator(CsvArgsInterpreter csvArgsInterpreter) {
        this.csvArgsInterpreter = csvArgsInterpreter;
    }

    @Override
    public DataLoader getInstanceWithSettledProperties( ) {
        String defaultDelimiter = ",";
        FileReader fileReader = new FileReader();
        String path = this.csvArgsInterpreter.getPath();
        return new CsvReader(fileReader, path, defaultDelimiter);
    }
}
