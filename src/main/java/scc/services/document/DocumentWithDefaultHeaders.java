package scc.services.document;

import scc.dao.DataLoader;
import scc.exception.DAOException;

import java.util.List;
import java.util.stream.IntStream;

public class DocumentWithDefaultHeaders implements DocumentCreator {
    private DataLoader dataLoader;

    public DocumentWithDefaultHeaders(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public Document createDocument( ) throws DAOException {
        List<String[]> loadedData = dataLoader.getResourceContent();
        int columnsAmountPerRow = getExpectedAmountOfHeaders(loadedData);

        return new Document(loadedData, generateHeaders(columnsAmountPerRow));
    }

    private int getExpectedAmountOfHeaders(List<String[]> loadedData) {
        if (loadedData.size() > 0) {
            String[] firstRow = loadedData.get(0);

            return firstRow.length;
        }

        return 0;
    }

    private String[] generateHeaders(int columnsAmount) {
        final String defaultName = "property";

        return IntStream.rangeClosed(1, columnsAmount)
                .mapToObj(idx -> defaultName + idx)
                .toArray(String[]::new);
    }
}
