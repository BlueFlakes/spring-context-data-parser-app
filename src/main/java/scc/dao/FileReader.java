package scc.dao;

import scc.exception.DAOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

    public Iterator<String[]> readData(String path, String delimiter) throws DAOException {

        try (Scanner file = openFile(path)) {
            List<String[]> retrievedData = readFile(file, delimiter);
            return retrievedData.iterator();

        } catch (FileNotFoundException e) {
            throw new DAOException("FileReader couldn't find expected file in given path.");
        }
    }

    private Scanner openFile(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename));
    }

    private List<String[]> readFile(Scanner file, String delimiter) {
        List<String[]> tempDataContainer = new ArrayList<>();

        while (file.hasNextLine()) {
            String line = file.nextLine();
            tempDataContainer.add(line.split(delimiter));
        }

        return tempDataContainer;
    }
}
