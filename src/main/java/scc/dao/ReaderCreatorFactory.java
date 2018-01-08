package scc.dao;

public class ReaderCreatorFactory {
    public SettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, String[] args) {
        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(args);

            default:
                throw new IllegalArgumentException();
        }
    }
}
