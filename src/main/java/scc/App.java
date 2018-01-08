package scc;


import scc.controller.ConverterStarterFactory;
import scc.exception.InvalidArgsAmountException;
import scc.controller.ConverterStarter;

public class App {
    public static void main(String[] args) {

        try {
            ConverterStarter starter = new ConverterStarterFactory().getProperStarter(args);
            starter.start();

        } catch (InvalidArgsAmountException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
