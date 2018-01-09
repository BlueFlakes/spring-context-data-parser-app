package scc.services.document;

import scc.dao.DataLoader;
import scc.models.ArgsInterpreter;

public class DocumentCreatorFactory {
    public DocumentCreator getDocumentCreatorBySettings(ArgsInterpreter argsInterpreter, DataLoader dataLoader) {
        boolean withHeaders = argsInterpreter.getSearcher(DocumentSpecies.class).isEnumWithGivenOptionAvailable();

        if (withHeaders) {
            return new DocumentWithHeaders(dataLoader);
        } else {
            return new DocumentWithDefaultHeaders(dataLoader);
        }
    }
}
