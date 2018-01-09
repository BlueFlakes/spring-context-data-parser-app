package scc.services.document;

import scc.dao.DataLoader;
import scc.exception.DAOException;

import java.util.List;

public class DocumentWithHeaders implements DocumentCreator {
    private DataLoader dataLoader;

    public DocumentWithHeaders(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public Document createDocument( ) throws DAOException {
        List<String[]> loadedData = dataLoader.getResourceContent();

        int rowsAmount = loadedData.size();

        if (rowsAmount >= 1) {
            String[] headers = getHeaders(loadedData);
            loadedData.remove(0);

            return new Document(loadedData, headers);
        }

        return new Document(loadedData, new String[] {});
    }

    private String[] getHeaders(List<String[]> loadedData) {
        return loadedData.get(0);
    }
}
