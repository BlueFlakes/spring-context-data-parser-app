package scc.dao;

import scc.enums.DataLoaderType;

public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, String[] args) {
        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(args);

            default:
                throw new IllegalArgumentException();
        }
    }
}
