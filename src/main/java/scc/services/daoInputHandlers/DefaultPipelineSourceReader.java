package scc.services.daoInputHandlers;

import scc.dao.DataLoader;
import scc.dao.ReaderCreatorFactory;
import scc.dao.DataLoaderType;
import scc.exception.DAOException;
import scc.interfaces.ReaderSettingsHandler;
import scc.models.ArgsInterpreter;
import scc.services.document.Document;
import scc.services.document.DocumentCreator;
import scc.services.document.DocumentCreatorFactory;

public class DefaultPipelineSourceReader implements DaoInputHandler {
    private final DataLoaderType dataLoaderType = DataLoaderType.CSV_READER;
    private ReaderCreatorFactory readerCreatorFactory;
    private DocumentCreatorFactory documentCreatorFactory;

    public DefaultPipelineSourceReader(ReaderCreatorFactory readerCreatorFactory,
                                       DocumentCreatorFactory documentCreatorFactory) {

        this.readerCreatorFactory = readerCreatorFactory;
        this.documentCreatorFactory = documentCreatorFactory;
    }

    @Override
    public Document prepareData(ArgsInterpreter argsInterpreter) throws DAOException {
        ReaderSettingsHandler readerSettingsHandler =
                readerCreatorFactory.getReaderCreatorByDataSource(this.dataLoaderType, argsInterpreter);

        DataLoader dataLoader = readerSettingsHandler.getInstanceWithSettledProperties();

        DocumentCreator documentCreator =
                documentCreatorFactory.getDocumentCreatorBySettings(argsInterpreter, dataLoader);

        return documentCreator.createDocument();
    }
}
