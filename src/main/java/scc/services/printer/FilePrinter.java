package scc.services.printer;

import scc.exception.InvalidArgumentCombinationException;
import scc.models.OrdersInterpreter;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FilePrinter implements OutputPrinter {
    private OrdersInterpreter ordersInterpreter;

    public FilePrinter(OrdersInterpreter ordersInterpreter) {
        this.ordersInterpreter = ordersInterpreter;
    }

    @Override
    public void print(String deliveredData) throws Exception {
        String fileName = getFileName();
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(deliveredData);
        printWriter.close();

        System.out.println("Successfully created file.");
    }

    private String getFileName() throws InvalidArgumentCombinationException {
        final String keyPrefix = "name=";
        return this.ordersInterpreter.getPrefixValueFromAdditionalInputs(keyPrefix);
    }
}
