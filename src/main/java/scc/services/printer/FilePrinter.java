package scc.services.printer;

import scc.models.ArgsInterpreter;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FilePrinter implements OutputPrinter {
    private ArgsInterpreter argsInterpreter;
    private static final String defaultFileName = "defaultNameForFile.txt";

    public FilePrinter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    @Override
    public void print(String deliveredData) throws Exception {
        String fileName = getFileName();
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(deliveredData);
        printWriter.close();
    }

    private String getFileName() {
        final String keyPrefix = "name=";

        return this.argsInterpreter.getAdditionalSettings().stream()
                                                           .filter(s -> s.startsWith(keyPrefix))
                                                           .filter(s -> s.length() > keyPrefix.length())
                                                           .map(s -> s.substring(keyPrefix.length(), s.length()))
                                                           .findFirst()
                                                           .orElse(defaultFileName);
    }
}
