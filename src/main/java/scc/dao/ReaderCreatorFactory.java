package scc.dao;

import scc.enums.DataLoaderType;
import scc.models.ArgsInterpreter;
import scc.models.CsvArgsInterpreter;

public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, ArgsInterpreter argsInterpreter) {
        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(new CsvArgsInterpreter(argsInterpreter));

            default:
                throw new IllegalArgumentException();
        }
    }
}
