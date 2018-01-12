package scc.dao;

import scc.models.BasicArgsInterpreter;

public class CsvReaderCreator implements ReaderSettingsHandler {
    private BasicArgsInterpreter basicArgsInterpreter;

    public CsvReaderCreator(BasicArgsInterpreter basicArgsInterpreter) {
        this.basicArgsInterpreter = basicArgsInterpreter;
    }

    @Override
    public DataLoader getInstanceWithSettledProperties( ) {
        String defaultDelimiter = ",";
        FileReader fileReader = new FileReader();
        String path = this.basicArgsInterpreter.getPath();
        return new CsvReader(fileReader, path, defaultDelimiter);
    }
}
