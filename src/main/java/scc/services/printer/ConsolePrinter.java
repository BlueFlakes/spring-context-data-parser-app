package scc.services.printer;

public class ConsolePrinter implements OutputPrinter {
    @Override
    public void print(String deliveredData) {
        System.out.println(deliveredData);
    }
}