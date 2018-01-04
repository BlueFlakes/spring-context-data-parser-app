package scc.utils.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileReader {

    private Scanner openFile(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename));
    }

    public Iterator<String> readData(String path) {
        System.out.println("read data from file");

        return null;
    }


}
