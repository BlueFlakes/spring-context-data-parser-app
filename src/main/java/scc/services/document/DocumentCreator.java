package scc.services.document;

import scc.exception.DAOException;

public interface DocumentCreator {
    Document createDocument() throws DAOException;
}
