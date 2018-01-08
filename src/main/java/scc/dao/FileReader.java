package scc.dao;

import scc.exception.DAOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readData(String path) throws DAOException {

        try (Scanner file = openFile(path)) {
            return readFile(file);

        } catch (FileNotFoundException e) {
            throw new DAOException("FileReader couldn't find expected file in given path.");
        }
    }

    private Scanner openFile(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename));
    }

    private List<String> readFile(Scanner file) {
        List<String> tempDataContainer = new ArrayList<>();

        while (file.hasNext()) {
            String line = file.nextLine();
            tempDataContainer.add(line);
        }

        return tempDataContainer;
    }
}
