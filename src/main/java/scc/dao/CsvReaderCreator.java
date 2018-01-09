package scc.dao;

public class CsvReaderCreator implements ReaderSettingsHandler {
    private String[] args;

    public CsvReaderCreator(String[] args) {
        this.args = args;
    }

    @Override
    public DataLoader getInstanceWithSettledProperties( ) {
        String defaultDelimiter = ",";
        FileReader fileReader = new FileReader();
        return new CsvReader(fileReader, getPath(), defaultDelimiter);
    }

    private String getPath() {
        return this.args.length >= 2 ? this.args[1] : this.args[0];
    }
}
