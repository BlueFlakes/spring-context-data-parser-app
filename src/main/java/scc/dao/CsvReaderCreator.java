package scc.dao;

public class CsvReaderCreator implements SettingsHandler {
    private String[] args;

    public CsvReaderCreator(String[] args) {
        this.args = args;
    }

    @Override
    public DataLoader getDataLoaderWithSettledProperties( ) {
        String defaultDelimiter = ",";
        FileReader fileReader = new FileReader();
        return new CsvReader(fileReader, getPath(), defaultDelimiter);
    }

    private String getPath() {
        return this.args.length >= 2 ? this.args[1] : this.args[0];
    }
}
