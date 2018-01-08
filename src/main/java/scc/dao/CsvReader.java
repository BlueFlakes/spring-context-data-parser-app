package scc.dao;

import scc.exception.DAOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvReader {
    private final FileReader fileReader;
    private String delimiter;

    public CsvReader(FileReader fileReader, String delimiter) {
        this.fileReader = fileReader;
        this.delimiter = delimiter;
    }

    public Iterator<String[]> readData(String path) throws DAOException {
        Iterator<String> retrievedData = this.fileReader.readData(path);
        return parseData(retrievedData);
    }

    private Iterator<String[]> parseData(Iterator<String> deliveredData) {
        List<String[]> tempContainerForParsedData = new ArrayList<>();

        while (deliveredData.hasNext()) {
            String row = deliveredData.next();
            String[] parsedRow = row.split(this.delimiter);

            tempContainerForParsedData.add(parsedRow);
        }

        return tempContainerForParsedData.iterator();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
