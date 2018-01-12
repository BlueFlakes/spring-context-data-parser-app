package scc.services.printer;

import scc.exception.InvalidArgumentCombinationException;
import scc.models.OrdersInterpreter;
import scc.models.OrdersProvider;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.function.Supplier;

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
    }

    private String getFileName() throws InvalidArgumentCombinationException {
        final String keyPrefix = "name=";
        return this.ordersInterpreter.getPrefixValueFromArgsCombination(keyPrefix);
    }
}
