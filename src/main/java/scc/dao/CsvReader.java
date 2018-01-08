package scc.dao;

import scc.exception.DAOException;

import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements DataLoader {
    private final FileReader fileReader;
    private String path;
    private String delimiter;

    public CsvReader(FileReader fileReader, String path, String delimiter) {
        this.fileReader = fileReader;
        this.path = path;
        this.delimiter = delimiter;
    }

    @Override
    public List<String[]> getResourceContent() throws DAOException {
        List<String> retrievedData = this.fileReader.readData(this.path);
        return parseData(retrievedData);
    }

    private List<String[]> parseData(List<String> deliveredData) {
        return deliveredData.stream()
                            .map(sentence -> sentence.split(this.delimiter))
                            .collect(Collectors.toList());
    }
}
