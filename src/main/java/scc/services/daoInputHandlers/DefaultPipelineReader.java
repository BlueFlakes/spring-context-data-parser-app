package scc.services.daoInputHandlers;

import org.springframework.stereotype.Component;
import scc.dao.DataLoader;
import scc.dao.ReaderCreatorFactory;
import scc.dao.DataLoaderType;
import scc.exception.DAOException;
import scc.dao.ReaderSettingsHandler;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.services.document.Document;
import scc.services.document.DocumentCreator;
import scc.services.document.DocumentCreatorFactory;

@Component
public class DefaultPipelineReader implements DaoHandler {
    private final DataLoaderType dataLoaderType = DataLoaderType.CSV_READER;
    private ReaderCreatorFactory readerCreatorFactory;
    private DocumentCreatorFactory documentCreatorFactory;

    public DefaultPipelineReader(ReaderCreatorFactory readerCreatorFactory,
                                 DocumentCreatorFactory documentCreatorFactory) {

        this.readerCreatorFactory = readerCreatorFactory;
        this.documentCreatorFactory = documentCreatorFactory;
    }

    @Override
    public Document prepareData(OrdersProvider ordersProvider) throws DAOException, ImproperArgumentException {
        ReaderSettingsHandler readerSettingsHandler =
                readerCreatorFactory.getReaderCreatorByDataSource(this.dataLoaderType, ordersProvider);

        DataLoader dataLoader = readerSettingsHandler.getInstanceWithSettledProperties();

        DocumentCreator documentCreator =
                documentCreatorFactory.getDocumentCreatorBySettings(ordersProvider, dataLoader);

        return documentCreator.createDocument();
    }
}
