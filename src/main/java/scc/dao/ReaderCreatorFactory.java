package scc.dao;

import scc.exception.ImproperArgumentException;
import scc.models.ArgsInterpreter;
import scc.models.BasicArgsInterpreter;

public class ReaderCreatorFactory {
    public ReaderSettingsHandler getReaderCreatorByDataSource(DataLoaderType loaderType, ArgsInterpreter argsInterpreter)
            throws ImproperArgumentException {

        switch (loaderType) {
            case CSV_READER:
                return new CsvReaderCreator(new BasicArgsInterpreter(argsInterpreter));

            default:
                throw new ImproperArgumentException("Delivered value does not match any \"ReaderSettingsCreator\"");
        }
    }
}
