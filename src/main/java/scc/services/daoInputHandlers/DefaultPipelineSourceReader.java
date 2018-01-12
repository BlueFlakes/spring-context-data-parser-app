package scc.services.daoInputHandlers;

import scc.dao.DataLoader;
import scc.dao.ReaderCreatorFactory;
import scc.dao.DataLoaderType;
import scc.exception.DAOException;
import scc.dao.ReaderSettingsHandler;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersInterpreter;
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
    public Document prepareData(OrdersInterpreter ordersInterpreter) throws DAOException, ImproperArgumentException {
        ReaderSettingsHandler readerSettingsHandler =
                readerCreatorFactory.getReaderCreatorByDataSource(this.dataLoaderType, ordersInterpreter);

        DataLoader dataLoader = readerSettingsHandler.getInstanceWithSettledProperties();

        DocumentCreator documentCreator =
                documentCreatorFactory.getDocumentCreatorBySettings(ordersInterpreter, dataLoader);

        return documentCreator.createDocument();
    }
}
