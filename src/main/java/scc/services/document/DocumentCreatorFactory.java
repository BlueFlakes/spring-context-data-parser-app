package scc.services.document;

import scc.dao.DataLoader;
import scc.models.OrdersInterpreter;

public class DocumentCreatorFactory {
    public DocumentCreator getDocumentCreatorBySettings(OrdersInterpreter ordersInterpreter, DataLoader dataLoader) {
        boolean withHeaders = ordersInterpreter.getSearcher(DocumentSpecies.class).isEnumWithGivenOptionAvailable();

        if (withHeaders) {
            return new DocumentWithHeaders(dataLoader);
        } else {
            return new DocumentWithDefaultHeaders(dataLoader);
        }
    }
}
