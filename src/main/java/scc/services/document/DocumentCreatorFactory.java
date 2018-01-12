package scc.services.document;

import org.springframework.stereotype.Component;
import scc.dao.DataLoader;
import scc.models.OrdersProvider;

@Component
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
