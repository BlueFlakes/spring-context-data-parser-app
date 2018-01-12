package scc.services.document;

import scc.dao.DataLoader;
import scc.models.OrdersProvider;

public class DocumentCreatorFactory {
    public DocumentCreator getDocumentCreatorBySettings(OrdersProvider ordersProvider, DataLoader dataLoader) {
        boolean withHeaders = ordersProvider.getSearcher(DocumentSpecies.class).isEnumWithGivenOptionAvailable();

        if (withHeaders) {
            return new DocumentWithHeaders(dataLoader);
        } else {
            return new DocumentWithDefaultHeaders(dataLoader);
        }
    }
}
