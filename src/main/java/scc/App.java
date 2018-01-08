package scc;


import scc.services.starters.ConverterStarterFactory;
import scc.exception.InvalidArgsAmountException;
import scc.services.starters.ConverterStarter;

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
